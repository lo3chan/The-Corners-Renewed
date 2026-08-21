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

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.UndeadGhoulEntity>> UNDEAD_GHOUL = ENTITY_TYPES.register("undead_ghoul",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.UndeadGhoulEntity::new, MobCategory.MONSTER)
            .sized(0.6F, 1.95F)
            .clientTrackingRange(8)
            .build("undead_ghoul"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.UndeadKnightEntity>> UNDEAD_KNIGHT = ENTITY_TYPES.register("undead_knight",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.UndeadKnightEntity::new, MobCategory.MONSTER)
            .sized(0.6F, 1.99F)
            .clientTrackingRange(8)
            .build("undead_knight"));

    public static final Supplier<EntityType<net.ludocrypt.corners.entity.undead.CrawlingUndeadEntity>> CRAWLING_UNDEAD = ENTITY_TYPES.register("crawling_undead",
        () -> EntityType.Builder.of(net.ludocrypt.corners.entity.undead.CrawlingUndeadEntity::new, MobCategory.MONSTER)
            .sized(0.8F, 0.6F)
            .clientTrackingRange(8)
            .build("crawling_undead"));
}

