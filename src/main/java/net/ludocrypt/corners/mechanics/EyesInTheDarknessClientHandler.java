package net.ludocrypt.corners.mechanics;

import net.ludocrypt.corners.init.CornerWorlds;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber(modid = "corners", value = Dist.CLIENT)
public class EyesInTheDarknessClientHandler {

    @SubscribeEvent
    public static void onClientPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        Level level = player.level();

        if (!level.isClientSide() || !level.dimension().equals(CornerWorlds.THE_ABYSS_KEY)) {
            return;
        }

        RandomSource random = level.getRandom();
        // Occasional chance to render glowing eyes watching from dark corners
        if (random.nextInt(30) == 0) {
            int dx = random.nextInt(24) - 12;
            int dy = random.nextInt(10) - 5;
            int dz = random.nextInt(24) - 12;

            double distSq = dx * dx + dz * dz;
            if (distSq > 36) { // Beyond 6 blocks away
                BlockPos targetPos = player.blockPosition().offset(dx, dy, dz);
                if (level.isEmptyBlock(targetPos) && level.getBrightness(LightLayer.BLOCK, targetPos) == 0) {
                    double px = targetPos.getX() + 0.5D;
                    double py = targetPos.getY() + 0.5D;
                    double pz = targetPos.getZ() + 0.5D;

                    level.addParticle(ParticleTypes.SOUL_FIRE_FLAME, px - 0.15, py, pz, 0, 0, 0);
                    level.addParticle(ParticleTypes.SOUL_FIRE_FLAME, px + 0.15, py, pz, 0, 0, 0);
                }
            }
        }
    }
}
