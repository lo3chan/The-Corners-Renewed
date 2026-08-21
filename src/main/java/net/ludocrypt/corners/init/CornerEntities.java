package net.ludocrypt.corners.init;

import net.ludocrypt.corners.entity.CornerBoatEntity.CornerBoat;
import net.ludocrypt.corners.entity.DimensionalPaintingEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.function.Supplier;

public class CornerEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, "corners");

    public static final Supplier<EntityType<DimensionalPaintingEntity>> DIMENSIONAL_PAINTING_ENTITY = ENTITY_TYPES.register("dimensional_painting",
        () -> EntityType.Builder.<DimensionalPaintingEntity>of(DimensionalPaintingEntity::new, MobCategory.MISC)
            .sized(0.5F, 0.5F)
            .clientTrackingRange(10)
            .updateInterval(Integer.MAX_VALUE)
            .build("dimensional_painting"));

    public static final Supplier<EntityType<net.minecraft.world.entity.vehicle.Boat>> GAIA_BOAT = ENTITY_TYPES.register("gaia_boat",
        () -> EntityType.Builder.<net.minecraft.world.entity.vehicle.Boat>of(CornerBoat.GAIA.factory(false), MobCategory.MISC)
            .sized(1.375f, 0.5625f)
            .clientTrackingRange(10)
            .build("gaia_boat"));

    public static final Supplier<EntityType<net.minecraft.world.entity.vehicle.Boat>> GAIA_CHEST_BOAT = ENTITY_TYPES.register("gaia_chest_boat",
        () -> EntityType.Builder.<net.minecraft.world.entity.vehicle.Boat>of(CornerBoat.GAIA.factory(true), MobCategory.MISC)
            .sized(1.375f, 0.5625f)
            .clientTrackingRange(10)
            .build("gaia_chest_boat"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.TheSwarmerEntity>> THE_SWARMER = ENTITY_TYPES.register("the_swarmer",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.TheSwarmerEntity::new, MobCategory.MONSTER)
            .sized(0.6F, 1.8F)
            .clientTrackingRange(8)
            .build("the_swarmer"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.TheLurkerEntity>> THE_LURKER = ENTITY_TYPES.register("the_lurker",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.TheLurkerEntity::new, MobCategory.MONSTER)
            .sized(0.6F, 1.95F)
            .clientTrackingRange(8)
            .build("the_lurker"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.TheHeavyEntity>> THE_HEAVY = ENTITY_TYPES.register("the_heavy",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.TheHeavyEntity::new, MobCategory.MONSTER)
            .sized(1.2F, 2.4F)
            .clientTrackingRange(10)
            .build("the_heavy"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.TheSpitterEntity>> THE_SPITTER = ENTITY_TYPES.register("the_spitter",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.TheSpitterEntity::new, MobCategory.MONSTER)
            .sized(0.7F, 1.9F)
            .clientTrackingRange(8)
            .build("the_spitter"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.TheSpectreEntity>> THE_SPECTRE = ENTITY_TYPES.register("the_spectre",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.TheSpectreEntity::new, MobCategory.MONSTER)
            .sized(0.6F, 1.95F)
            .clientTrackingRange(8)
            .build("the_spectre"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.TheHunterEntity>> THE_HUNTER = ENTITY_TYPES.register("the_hunter",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.TheHunterEntity::new, MobCategory.MONSTER)
            .sized(0.7F, 2.0F)
            .clientTrackingRange(10)
            .build("the_hunter"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.TheHorrorsEntity>> THE_HORRORS = ENTITY_TYPES.register("the_horrors",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.TheHorrorsEntity::new, MobCategory.MONSTER)
            .sized(1.4F, 2.8F)
            .clientTrackingRange(10)
            .build("the_horrors"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.TheUndeadWolfEntity>> THE_UNDEAD_WOLF = ENTITY_TYPES.register("the_undead_wolf",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.TheUndeadWolfEntity::new, MobCategory.MONSTER)
            .sized(0.8F, 0.85F)
            .clientTrackingRange(8)
            .build("the_undead_wolf"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.TheRodEntity>> THE_ROD = ENTITY_TYPES.register("the_rod",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.TheRodEntity::new, MobCategory.MONSTER)
            .sized(0.6F, 1.95F)
            .clientTrackingRange(8)
            .build("the_rod"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.TheCloggerEntity>> THE_CLOGGER = ENTITY_TYPES.register("the_clogger",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.TheCloggerEntity::new, MobCategory.MONSTER)
            .sized(0.8F, 1.9F)
            .clientTrackingRange(8)
            .build("the_clogger"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.ThePregnantEntity>> THE_PREGNANT = ENTITY_TYPES.register("the_pregnant",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.ThePregnantEntity::new, MobCategory.MONSTER)
            .sized(0.7F, 1.95F)
            .clientTrackingRange(8)
            .build("the_pregnant"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.TheWheezerEntity>> THE_WHEEZER = ENTITY_TYPES.register("the_wheezer",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.TheWheezerEntity::new, MobCategory.MONSTER)
            .sized(0.6F, 1.8F)
            .clientTrackingRange(8)
            .build("the_wheezer"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.TheLumberEntity>> THE_LUMBER = ENTITY_TYPES.register("the_lumber",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.TheLumberEntity::new, MobCategory.MONSTER)
            .sized(0.9F, 2.2F)
            .clientTrackingRange(8)
            .build("the_lumber"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.TheSuckerEntity>> THE_SUCKER = ENTITY_TYPES.register("the_sucker",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.TheSuckerEntity::new, MobCategory.MONSTER)
            .sized(0.5F, 1.5F)
            .clientTrackingRange(8)
            .build("the_sucker"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.TheBigSuckerEntity>> THE_BIG_SUCKER = ENTITY_TYPES.register("the_big_sucker",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.TheBigSuckerEntity::new, MobCategory.MONSTER)
            .sized(1.1F, 2.3F)
            .clientTrackingRange(10)
            .build("the_big_sucker"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.TheFireDustEntity>> THE_FIRE_DUST = ENTITY_TYPES.register("the_fire_dust",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.TheFireDustEntity::new, MobCategory.MONSTER)
            .sized(0.6F, 1.8F)
            .clientTrackingRange(8)
            .build("the_fire_dust"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.DeadCloggerEntity>> DEAD_CLOGGER = ENTITY_TYPES.register("dead_clogger",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.DeadCloggerEntity::new, MobCategory.MONSTER)
            .sized(0.8F, 1.9F)
            .clientTrackingRange(8)
            .build("dead_clogger"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.SlavemanEntity>> SLAVEMAN = ENTITY_TYPES.register("slaveman",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.SlavemanEntity::new, MobCategory.MONSTER)
            .sized(0.6F, 1.95F)
            .clientTrackingRange(8)
            .build("slaveman"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.TheMoonflowerEntity>> THE_MOONFLOWER = ENTITY_TYPES.register("the_moonflower",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.TheMoonflowerEntity::new, MobCategory.MONSTER)
            .sized(0.6F, 1.9F)
            .clientTrackingRange(8)
            .build("the_moonflower"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.TheBeartamerEntity>> THE_BEARTAMER = ENTITY_TYPES.register("the_beartamer",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.TheBeartamerEntity::new, MobCategory.MONSTER)
            .sized(0.8F, 2.0F)
            .clientTrackingRange(10)
            .build("the_beartamer"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.TheBidyEntity>> THE_BIDY = ENTITY_TYPES.register("the_bidy",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.TheBidyEntity::new, MobCategory.MONSTER)
            .sized(0.5F, 1.0F)
            .clientTrackingRange(8)
            .build("the_bidy"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.TheBidyUpsideEntity>> THE_BIDY_UPSIDE = ENTITY_TYPES.register("the_bidy_upside",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.TheBidyUpsideEntity::new, MobCategory.MONSTER)
            .sized(0.5F, 1.0F)
            .clientTrackingRange(8)
            .build("the_bidy_upside"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.TheDungeonEntity>> THE_DUNGEON = ENTITY_TYPES.register("the_dungeon",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.TheDungeonEntity::new, MobCategory.MONSTER)
            .sized(1.2F, 2.6F)
            .clientTrackingRange(10)
            .build("the_dungeon"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.TheGliterEntity>> THE_GLITER = ENTITY_TYPES.register("the_gliter",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.TheGliterEntity::new, MobCategory.MONSTER)
            .sized(0.6F, 1.95F)
            .clientTrackingRange(8)
            .build("the_gliter"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.TheImmortalEntity>> THE_IMMORTAL = ENTITY_TYPES.register("the_immortal",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.TheImmortalEntity::new, MobCategory.MONSTER)
            .sized(1.0F, 2.2F)
            .clientTrackingRange(12)
            .build("the_immortal"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.TheOrdureEntity>> THE_ORDURE = ENTITY_TYPES.register("the_ordure",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.TheOrdureEntity::new, MobCategory.MONSTER)
            .sized(0.7F, 1.9F)
            .clientTrackingRange(8)
            .build("the_ordure"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.ThePosessiveEntity>> THE_POSESSIVE = ENTITY_TYPES.register("the_posessive",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.ThePosessiveEntity::new, MobCategory.MONSTER)
            .sized(0.6F, 1.95F)
            .clientTrackingRange(10)
            .build("the_posessive"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.TheRabidusEntity>> THE_RABIDUS = ENTITY_TYPES.register("the_rabidus",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.TheRabidusEntity::new, MobCategory.MONSTER)
            .sized(0.7F, 1.95F)
            .clientTrackingRange(8)
            .build("the_rabidus"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.TheSkeeperEntity>> THE_SKEEPER = ENTITY_TYPES.register("the_skeeper",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.TheSkeeperEntity::new, MobCategory.MONSTER)
            .sized(0.6F, 1.95F)
            .clientTrackingRange(8)
            .build("the_skeeper"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.TheSmokerEntity>> THE_SMOKER = ENTITY_TYPES.register("the_smoker",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.TheSmokerEntity::new, MobCategory.MONSTER)
            .sized(0.6F, 1.8F)
            .clientTrackingRange(8)
            .build("the_smoker"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.TheSomnolenceEntity>> THE_SOMNOLENCE = ENTITY_TYPES.register("the_somnolence",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.TheSomnolenceEntity::new, MobCategory.MONSTER)
            .sized(0.8F, 2.0F)
            .clientTrackingRange(8)
            .build("the_somnolence"));
}




