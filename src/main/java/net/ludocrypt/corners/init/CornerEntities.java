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
}
