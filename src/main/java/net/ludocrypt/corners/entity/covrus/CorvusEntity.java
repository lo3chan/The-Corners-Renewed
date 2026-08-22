package net.ludocrypt.corners.entity.covrus;

import net.ludocrypt.corners.entity.covrus.goal.CorvusIdlingGoal;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomFlyingGoal;

public class CorvusEntity extends PathfinderMob implements FlyingAnimal {

	private static final EntityDataAccessor<Integer> CORVUS_POSE = SynchedEntityData.defineId(CorvusEntity.class, EntityDataSerializers.INT);
	public AnimationState restingAnimation = new AnimationState();

	public CorvusEntity(EntityType<? extends CorvusEntity> entityType, Level world) {
		super(entityType, world);
		this.moveControl = new FlyingMoveControl(this, 20, true);
		this.goalSelector.addGoal(1, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
		this.goalSelector.addGoal(10, new CorvusIdlingGoal(this));
	}

	@Override
	protected PathNavigation createNavigation(Level level) {
		FlyingPathNavigation flyingPathNavigation = new FlyingPathNavigation(this, level);
		flyingPathNavigation.setCanOpenDoors(false);
		flyingPathNavigation.setCanFloat(true);
		flyingPathNavigation.setCanPassDoors(true);
		return flyingPathNavigation;
	}

	public static AttributeSupplier.Builder createLivingAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 6.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.2D)
				.add(Attributes.FLYING_SPEED, 0.4D);
	}

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
		builder.define(CORVUS_POSE, CorvusPose.SITTING.ordinal());
	}

	@Override
	public boolean isFlying() {
		return !this.onGround();
	}

	@Override
	public boolean causeFallDamage(float fallDistance, float multiplier, net.minecraft.world.damagesource.DamageSource source) {
		return false;
	}

	@Override
	protected void checkFallDamage(double y, boolean onGround, net.minecraft.world.level.block.state.BlockState state, net.minecraft.core.BlockPos pos) {
	}

	public CorvusPose getCorvusPose() {
		int ordinal = this.entityData.get(CORVUS_POSE);
		CorvusPose[] poses = CorvusPose.values();
		if (ordinal >= 0 && ordinal < poses.length) {
			return poses[ordinal];
		}
		return CorvusPose.IDLING;
	}

	public void setCorvusPose(CorvusPose pose) {
		this.entityData.set(CORVUS_POSE, pose.ordinal());
	}

	@Override
	public void tick() {
		super.tick();

		if (this.tickCount % 60 == 0) {
			this.restingAnimation.start(this.tickCount);
		}
	}
}
