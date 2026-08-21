package net.ludocrypt.corners.init;

import net.ludocrypt.corners.TheCorners;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.bus.api.IEventBus;
import java.util.function.Supplier;
import net.ludocrypt.corners.entity.DimensionalPaintingEntity;
import net.ludocrypt.corners.util.DimensionalPaintingTeleportLogic;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.Vec3;
import org.apache.commons.lang3.function.TriFunction;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CornerPaintings {

    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS = DeferredRegister.create(Registries.PAINTING_VARIANT, "corners");

	public static final TriFunction<ServerLevel, LivingEntity, DimensionalPaintingEntity, DimensionTransition> overworldPaintingTarget = (level, entity,
                                                                                                                                          painting) -> {
        if (entity instanceof ServerPlayer player) {
            BlockPos pos = player.getRespawnPosition();

            if (pos != null) {
				return player.findRespawnPositionAndUseSpawnBlock(false, entity1 -> {

                });
			}

		}

        return new DimensionTransition(level, entity, new DimensionTransition.PostDimensionTransition() {
            @Override
            public void onTransition(Entity entity) {

            }
        });

	};

    public static final Map<ResourceKey<PaintingVariant>, DimensionalPaintingTeleportLogic> LOGICS = new HashMap<>();

	public static final ResourceKey<PaintingVariant> OVERWORLD = get("overworld");
	public static final ResourceKey<PaintingVariant> OVERWORLD_THIN = get("overworld_thin");
	public static final ResourceKey<PaintingVariant> OVERWORLD_WIDE = get("overworld_wide");
	public static final ResourceKey<PaintingVariant> YEARNING_CANAL = get("yearning_canal");
	public static final ResourceKey<PaintingVariant> COMMUNAL_CORRIDORS = get("communal_corridors");
	public static final ResourceKey<PaintingVariant> HOARY_CROSSROADS = get("hoary_crossroads");
	public static final ResourceKey<PaintingVariant> THE_ABYSS = get("the_abyss");
	public static final ResourceKey<PaintingVariant> CRYSTAL_FRACTAL = get("crystal_fractal");

    public static final Supplier<PaintingVariant> OVERWORLD_VARIANT = PAINTING_VARIANTS.register("overworld", () -> new PaintingVariant(16, 16, TheCorners.id("overworld")));
    public static final Supplier<PaintingVariant> OVERWORLD_THIN_VARIANT = PAINTING_VARIANTS.register("overworld_thin", () -> new PaintingVariant(16, 32, TheCorners.id("overworld_thin")));
    public static final Supplier<PaintingVariant> OVERWORLD_WIDE_VARIANT = PAINTING_VARIANTS.register("overworld_wide", () -> new PaintingVariant(32, 16, TheCorners.id("overworld_wide")));
    public static final Supplier<PaintingVariant> YEARNING_CANAL_VARIANT = PAINTING_VARIANTS.register("yearning_canal", () -> new PaintingVariant(16, 16, TheCorners.id("yearning_canal")));
    public static final Supplier<PaintingVariant> COMMUNAL_CORRIDORS_VARIANT = PAINTING_VARIANTS.register("communal_corridors", () -> new PaintingVariant(16, 16, TheCorners.id("communal_corridors")));
    public static final Supplier<PaintingVariant> HOARY_CROSSROADS_VARIANT = PAINTING_VARIANTS.register("hoary_crossroads", () -> new PaintingVariant(32, 16, TheCorners.id("hoary_crossroads")));
    public static final Supplier<PaintingVariant> THE_ABYSS_VARIANT = PAINTING_VARIANTS.register("the_abyss", () -> new PaintingVariant(64, 48, TheCorners.id("the_abyss")));
    public static final Supplier<PaintingVariant> CRYSTAL_FRACTAL_VARIANT = PAINTING_VARIANTS.register("crystal_fractal", () -> new PaintingVariant(64, 48, TheCorners.id("crystal_fractal")));

	public static void init() {
        LOGICS.put(OVERWORLD, new DimensionalPaintingTeleportLogic(Level.OVERWORLD, overworldPaintingTarget));
        LOGICS.put(OVERWORLD_THIN, new DimensionalPaintingTeleportLogic(Level.OVERWORLD, overworldPaintingTarget));
        LOGICS.put(OVERWORLD_WIDE, new DimensionalPaintingTeleportLogic(Level.OVERWORLD, overworldPaintingTarget));
        LOGICS.put(YEARNING_CANAL, DimensionalPaintingTeleportLogic.create(CornerWorlds.YEARNING_CANAL_KEY, new Vec3(5.5D, 1.0D, 5.5D)));
        LOGICS.put(COMMUNAL_CORRIDORS, DimensionalPaintingTeleportLogic.create(CornerWorlds.COMMUNAL_CORRIDORS_KEY,
                                (player, painting) -> player
                                        .position()
                                        .subtract(new Vec3(player.getX() % 8.0D, player.getY(), player.getZ() % 8.0D))
                                        .add(2.0D, 2.0D, 2.0D)));
        LOGICS.put(HOARY_CROSSROADS, DimensionalPaintingTeleportLogic.create(CornerWorlds.HOARY_CROSSROADS_KEY,
                                (player, painting) -> player
                                        .position()
                                        .subtract(new Vec3(player.getX() % 512.0D, player.getY(), player.getZ() % 512.0D))
                                        .add(256.0D, 263.0D, 0.0D)
                                        .add(4.0D, 0, 4.0D)));
        LOGICS.put(THE_ABYSS, new DimensionalPaintingTeleportLogic(CornerWorlds.THE_ABYSS_KEY,
                (level, entity, painting) -> {
                    int targetX = (int) (entity.getX() * 7.0D);
                    int targetZ = (int) (entity.getZ() * 7.0D);
                    int safeY = 64;

                    BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(targetX, 32, targetZ);
                    for (int y = 32; y < 250; y++) {
                        pos.setY(y);
                        if (level.getBlockState(pos).isAir() && level.getBlockState(pos.above()).isAir() && !level.getBlockState(pos.below()).isAir()) {
                            safeY = y;
                            break;
                        }
                    }

                    Vec3 dest = new Vec3(targetX + 0.5D, safeY, targetZ + 0.5D);
                    return new DimensionTransition(level, dest, entity.getDeltaMovement(), entity.getYRot(), entity.getXRot(), e -> {});
                }));
        LOGICS.put(CRYSTAL_FRACTAL, new DimensionalPaintingTeleportLogic(CornerWorlds.CRYSTAL_FRACTAL_KEY,
                (level, entity, painting) -> {
                    int originX = (int) entity.getX();
                    int originZ = (int) entity.getZ();
                    int finalX = originX;
                    int finalZ = originZ;
                    int safeY = 64;
                    boolean found = false;

                    // Scan in expanding radial box (radius 0 to 16 blocks) for solid amethyst footing
                    BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
                    searchLoop:
                    for (int r = 0; r <= 16; r += (r == 0 ? 1 : 3)) {
                        for (int dx = -r; dx <= r; dx += (r == 0 ? 1 : Math.max(1, r))) {
                            for (int dz = -r; dz <= r; dz += (r == 0 ? 1 : Math.max(1, r))) {
                                int checkX = originX + dx;
                                int checkZ = originZ + dz;
                                for (int y = 300; y >= -300; y -= 2) {
                                    pos.set(checkX, y, checkZ);
                                    if (!level.getBlockState(pos).isAir() && level.getBlockState(pos.above()).isAir() && level.getBlockState(pos.above(2)).isAir()) {
                                        finalX = checkX;
                                        finalZ = checkZ;
                                        safeY = y + 1;
                                        found = true;
                                        break searchLoop;
                                    }
                                }
                            }
                        }
                    }

                    Vec3 dest = new Vec3(finalX + 0.5D, safeY, finalZ + 0.5D);
                    return new DimensionTransition(level, dest, entity.getDeltaMovement(), entity.getYRot(), entity.getXRot(), e -> {});
                }));
	}



	public static ResourceKey<PaintingVariant> get(String id) {
		return ResourceKey.create(Registries.PAINTING_VARIANT, TheCorners.id(id));
	}

}
