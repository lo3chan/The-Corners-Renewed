package net.ludocrypt.corners.init;

import com.mojang.serialization.MapCodec;
import net.ludocrypt.corners.TheCorners;
import net.ludocrypt.corners.world.chunk.CommunalCorridorsChunkGenerator;
import net.ludocrypt.corners.world.chunk.HoaryCrossroadsChunkGenerator;
import net.ludocrypt.corners.world.chunk.YearningCanalChunkGenerator;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.function.Supplier;

public class CornerBiomes {

    public static final DeferredRegister<MapCodec<? extends ChunkGenerator>> CHUNK_GENERATORS = DeferredRegister.create(Registries.CHUNK_GENERATOR, "corners");

    public static final ResourceKey<Biome> YEARNING_CANAL_BIOME = ResourceKey
            .create(Registries.BIOME, TheCorners.id(CornerWorlds.YEARNING_CANAL));
    public static final ResourceKey<Biome> COMMUNAL_CORRIDORS_BIOME = ResourceKey
            .create(Registries.BIOME, TheCorners.id(CornerWorlds.COMMUNAL_CORRIDORS));
    public static final ResourceKey<Biome> HOARY_CROSSROADS_BIOME = ResourceKey
            .create(Registries.BIOME, TheCorners.id(CornerWorlds.HOARY_CROSSROADS));
    public static final ResourceKey<Feature<?>> GAIA_TREE_FEATURE = ResourceKey
            .create(Registries.FEATURE, TheCorners.id("gaia_tree"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_GAIA_TREE_FEATURE = ResourceKey
            .create(Registries.CONFIGURED_FEATURE, TheCorners.id("gaia_tree"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_SAPLING_GAIA_TREE_FEATURE = ResourceKey
            .create(Registries.CONFIGURED_FEATURE, TheCorners.id("gaia_sapling"));

    public static final Supplier<MapCodec<YearningCanalChunkGenerator>> YEARNING_CANAL_CHUNK_GENERATOR = CHUNK_GENERATORS.register("yearning_canal_chunk_generator", () -> YearningCanalChunkGenerator.CODEC);
    public static final Supplier<MapCodec<CommunalCorridorsChunkGenerator>> COMMUNAL_CORRIDORS_CHUNK_GENERATOR = CHUNK_GENERATORS.register("communal_corridors_chunk_generator", () -> CommunalCorridorsChunkGenerator.CODEC);
    public static final Supplier<MapCodec<HoaryCrossroadsChunkGenerator>> HOARY_CROSSROADS_CHUNK_GENERATOR = CHUNK_GENERATORS.register("hoary_crossroads_chunk_generator", () -> HoaryCrossroadsChunkGenerator.CODEC);

    public static void register(IEventBus bus) {
        CHUNK_GENERATORS.register(bus);
    }
}

