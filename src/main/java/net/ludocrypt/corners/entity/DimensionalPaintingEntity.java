package net.ludocrypt.corners.entity;

import net.ludocrypt.corners.TheCorners;
import net.ludocrypt.corners.init.CornerEntities;
import net.ludocrypt.corners.init.CornerPaintings;
import net.ludocrypt.corners.init.CornerSoundEvents;
import net.ludocrypt.corners.mixin.AbstractDecorationEntityAccessor;
import net.ludocrypt.corners.mixin.PaintingEntityAccessor;
import org.dimdev.limlib.api.LimlibTravelling;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.AABB;

public class DimensionalPaintingEntity extends Painting {

	public DimensionalPaintingEntity(EntityType<? extends DimensionalPaintingEntity> type, Level world) {
		super(type, world);
	}

	public static DimensionalPaintingEntity create(Level world, BlockPos pos) {
		DimensionalPaintingEntity entity = new DimensionalPaintingEntity(CornerEntities.DIMENSIONAL_PAINTING_ENTITY.get(), world);
		entity.pos = pos;
		return entity;
	}

	public static DimensionalPaintingEntity create(Level world, BlockPos pos, Direction direction, Holder<PaintingVariant> variant) {
		DimensionalPaintingEntity entity = create(world, pos);
		((PaintingEntityAccessor) entity).callSetVariant(variant);
		entity.setDirection(direction);
		return entity;
	}

	public static Painting createRegular(Level world, BlockPos pos, Direction direction, Holder<PaintingVariant> variant) {
		Painting entity = new Painting(EntityType.PAINTING, world);
		entity.setPos(pos.getX(), pos.getY(), pos.getZ());
		((PaintingEntityAccessor) entity).callSetVariant(variant);
		((AbstractDecorationEntityAccessor) entity).callSetDirection(direction);
		return entity;
	}

	public static Painting createFromMotive(Level world, BlockPos pos, Direction direction, Holder<PaintingVariant> variant) {
		boolean isDimensional = variant.unwrapKey().map(CornerPaintings.LOGICS::containsKey).orElse(false);
		if (isDimensional) {
			return create(world, pos, direction, variant);
		} else {
			return createRegular(world, pos, direction, variant);
		}
	}

	@Override
	public void playerTouch(Player player) {
		super.playerTouch(player);

		var variantKey = getVariant().unwrapKey().orElse(null);
		var logic = variantKey != null ? CornerPaintings.LOGICS.get(variantKey) : null;

		if (logic != null) {
			AABB box = this.getBoundingBox().inflate(0.2D);

			if (box.intersects(player.getBoundingBox())) {
				if (this.level() instanceof ServerLevel && player instanceof ServerPlayer spe) {
					ServerLevel world = spe.server.getLevel(logic.dimension().apply(spe, this));
					if (world != null) {
						DimensionTransition teleportTarget = logic.teleportTarget().apply(world, spe, this);
						LimlibTravelling
							.travelTo(spe, world, teleportTarget, CornerSoundEvents.PAINTING_PORTAL_TRAVEL.get(), 0.25F,
								world.getRandom().nextFloat() * 0.4F + 0.8F);
					}
				}
			}
		}
	}

}
