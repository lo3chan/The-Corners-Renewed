package net.ludocrypt.corners.mechanics;

import net.ludocrypt.corners.init.CornerWorlds;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber(modid = "corners")
public class CrystalDimensionHandler {

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        Level level = player.level();

        if (level.isClientSide() || !level.dimension().equals(CornerWorlds.CRYSTAL_FRACTAL_KEY) || player.isSpectator()) {
            return;
        }

        // Low gravity and Jump Boost physics in the Crystal Realm
        player.addEffect(new MobEffectInstance(MobEffects.JUMP, 60, 1, false, false, false));
        player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 60, 0, false, false, false));
    }

    @SubscribeEvent
    public static void onEntityJoinLevel(EntityJoinLevelEvent event) {
        if (event.getLevel() == null || event.getEntity() == null) {
            return;
        }

        Level level = event.getLevel();
        if (!level.dimension().equals(CornerWorlds.CRYSTAL_FRACTAL_KEY)) {
            return;
        }

        Entity entity = event.getEntity();
        if (entity instanceof Player) {
            return;
        }

        // Block bats and vanilla monsters from cluttering the crystal fractal void
        if (entity instanceof Bat || entity instanceof Monster) {
            event.setCanceled(true);
        }
    }
}
