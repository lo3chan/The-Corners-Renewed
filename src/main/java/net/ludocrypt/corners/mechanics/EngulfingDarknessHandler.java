package net.ludocrypt.corners.mechanics;

import net.ludocrypt.corners.init.CornerSoundEvents;
import net.ludocrypt.corners.init.CornerWorlds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@EventBusSubscriber(modid = "corners")
public class EngulfingDarknessHandler {

    private static final Map<UUID, Integer> DARKNESS_TICKS = new HashMap<>();

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        Level level = player.level();

        // Active ONLY in The Abyss / Cave Dimension
        if (level.isClientSide() || !level.dimension().equals(CornerWorlds.THE_ABYSS_KEY) || player.isCreative() || player.isSpectator()) {
            return;
        }

        UUID uuid = player.getUUID();
        BlockPos pos = player.blockPosition();
        int blockLight = level.getBrightness(LightLayer.BLOCK, pos);

        if (blockLight == 0 && !player.hasEffect(MobEffects.NIGHT_VISION)) {
            int ticks = DARKNESS_TICKS.getOrDefault(uuid, 0) + 1;
            DARKNESS_TICKS.put(uuid, ticks);

            // Audio cues at 5 seconds
            if (ticks == 100) {
                level.playSound(null, player.getX(), player.getY(), player.getZ(),
                        CornerSoundEvents.ENGULFING_DARKNESS_HEARTBEAT.get(), SoundSource.AMBIENT, 1.0F, 0.9F);
            } else if (ticks == 160) {
                level.playSound(null, player.getX(), player.getY(), player.getZ(),
                        CornerSoundEvents.ENGULFING_DARKNESS_WHISPER.get(), SoundSource.AMBIENT, 0.8F, 1.0F);
            }

            // Darkness & Slowness effects at 10 seconds
            if (ticks >= 200) {
                player.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 120, 0, false, false, true));
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1, false, false, true));
            }

            // Creeping void damage if lingering beyond 15 seconds
            if (ticks >= 300 && ticks % 40 == 0) {
                player.hurt(player.damageSources().fellOutOfWorld(), 2.0F);
            }
        } else {
            // Gradually recover when illuminated
            int current = DARKNESS_TICKS.getOrDefault(uuid, 0);
            if (current > 0) {
                DARKNESS_TICKS.put(uuid, Math.max(0, current - 5));
            }
        }
    }
}
