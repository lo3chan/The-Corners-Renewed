package net.ludocrypt.corners.entity;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class CrystallineGuardianEntity extends Guardian {

    public CrystallineGuardianEntity(EntityType<? extends Guardian> entityType, Level level) {
        super(entityType, level);
        this.setNoGravity(true);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.ATTACK_DAMAGE, 6.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.5D)
                .add(Attributes.FOLLOW_RANGE, 32.0D)
                .add(Attributes.MAX_HEALTH, 30.0D);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.level().isClientSide && this.random.nextInt(3) == 0) {
            double px = this.getX() + (this.random.nextDouble() - 0.5D) * (double) this.getBbWidth();
            double py = this.getY() + this.random.nextDouble() * (double) this.getBbHeight();
            double pz = this.getZ() + (this.random.nextDouble() - 0.5D) * (double) this.getBbWidth();
            this.level().addParticle(ParticleTypes.END_ROD, px, py, pz, 0.0D, 0.02D, 0.0D);
        }
    }

    @Override
    public boolean causeFallDamage(float fallDistance, float multiplier, net.minecraft.world.damagesource.DamageSource source) {
        return false;
    }
}
