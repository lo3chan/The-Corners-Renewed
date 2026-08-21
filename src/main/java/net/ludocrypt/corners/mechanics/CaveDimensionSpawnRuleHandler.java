package net.ludocrypt.corners.mechanics;

import net.ludocrypt.corners.init.CornerEntities;
import net.ludocrypt.corners.init.CornerWorlds;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;

import java.util.List;
import java.util.function.Supplier;

@EventBusSubscriber(modid = "corners")
public class CaveDimensionSpawnRuleHandler {

    private static final List<Supplier<? extends EntityType<?>>> MODDED_CAVE_MOBS = List.of(
            CornerEntities.THE_SWARMER,
            CornerEntities.THE_LURKER,
            CornerEntities.THE_HEAVY,
            CornerEntities.THE_SPITTER,
            CornerEntities.THE_SPECTRE,
            CornerEntities.THE_HUNTER,
            CornerEntities.THE_HORRORS,
            CornerEntities.THE_UNDEAD_WOLF,
            CornerEntities.THE_ROD,
            CornerEntities.THE_CLOGGER,
            CornerEntities.THE_PREGNANT,
            CornerEntities.THE_WHEEZER,
            CornerEntities.THE_LUMBER,
            CornerEntities.THE_SUCKER,
            CornerEntities.THE_BIG_SUCKER,
            CornerEntities.THE_FIRE_DUST,
            CornerEntities.RESTLESS_SPIRIT,
            CornerEntities.DECREPIT_SKELETON,
            CornerEntities.DECAYING_ZOMBIE,
            CornerEntities.SKELETON_DEMOMAN,
            CornerEntities.SKELETON_THRASHER,
            CornerEntities.DARK_VORTEX,
            CornerEntities.BONE_IMP,
            CornerEntities.NIGHTMARE_STALKER,
            CornerEntities.FALLEN_CHAOS_KNIGHT,
            CornerEntities.MISSIONER,
            CornerEntities.SEARED_SPIRIT,
            CornerEntities.PHANTOM_CREEPER,
            CornerEntities.CORPSE_FISH,
            CornerEntities.MAGGOT,
            CornerEntities.THORNSHELL_CRAB,
            CornerEntities.DIRE_HOUND_LEADER
    );

    public static EntityType<?> getRandomModdedCaveMob(RandomSource random) {
        int idx = random.nextInt(MODDED_CAVE_MOBS.size());
        return MODDED_CAVE_MOBS.get(idx).get();
    }

    public static boolean isCornersModdedMob(Entity entity) {
        return entity.getClass().getPackageName().startsWith("net.ludocrypt.corners.entity.undead");
    }

    @SubscribeEvent
    public static void onEntityJoinLevel(EntityJoinLevelEvent event) {
        if (event.getLevel() == null || event.getEntity() == null) {
            return;
        }

        Level level = event.getLevel();
        boolean isCaveDimension = level.dimension().equals(CornerWorlds.THE_ABYSS_KEY);
        Entity entity = event.getEntity();
        boolean isModded = isCornersModdedMob(entity);

        // 1. In the Cave Dimension, block all bats unconditionally
        if (isCaveDimension && entity instanceof Bat) {
            event.setCanceled(true);
            return;
        }

        // 2. In the Cave Dimension, convert standard vanilla monsters into modded cave mobs
        if (isCaveDimension) {
            if (entity instanceof Mob mob && mob.getType().getCategory() == net.minecraft.world.entity.MobCategory.MONSTER) {
                if (!(entity instanceof Spider || entity instanceof CaveSpider || isModded)) {
                    event.setCanceled(true);

                    // If on server level, replace with random modded mob
                    if (!level.isClientSide) {
                        EntityType<?> replacementType = getRandomModdedCaveMob(level.getRandom());
                        Entity replacement = replacementType.create(level);
                        if (replacement != null) {
                            replacement.moveTo(entity.getX(), entity.getY(), entity.getZ(), entity.getYRot(), entity.getXRot());
                            level.addFreshEntity(replacement);
                        }
                    }
                }
            }
        }
    }
}
