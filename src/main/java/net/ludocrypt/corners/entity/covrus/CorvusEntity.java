package net.ludocrypt.corners.entity.covrus;

import net.ludocrypt.corners.entity.covrus.goal.CorvusIdlingGoal;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.level.Level;

public class CorvusEntity extends Mob implements FlyingAnimal {

	private static final EntityDataAccessor<Integer> CORVUS_POSE = SynchedEntityData.defineId(CorvusEntity.class, EntityDataSerializers.INT);
	public AnimationState restingAnimation = new AnimationState();

	public CorvusEntity(EntityType<? extends CorvusEntity> entityType, Level world) {
		super(entityType, world);
		this.goalSelector.addGoal(10, new CorvusIdlingGoal(this));
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
		return false;
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
