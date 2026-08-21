package net.ludocrypt.corners.init;

import com.mojang.serialization.MapCodec;
import net.ludocrypt.corners.TheCorners;
import net.ludocrypt.corners.world.chunk.CommunalCorridorsChunkGenerator;
import net.ludocrypt.corners.world.chunk.HoaryCrossroadsChunkGenerator;
import net.ludocrypt.corners.world.chunk.YearningCanalChunkGenerator;
import net.ludocrypt.corners.world.feature.GaiaTreeFeature;
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

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, "corners");
    public static final DeferredRegister<MapCodec<? extends ChunkGenerator>> CHUNK_GENERATORS = DeferredRegister.create(Registries.CHUNK_GENERATOR, "corners");

    public static final ResourceKey<Biome> YEARNING_CANAL_BIOME = ResourceKey
            .create(Registries.BIOME, TheCorners.id(CornerWorlds.YEARNING_CANAL));
    public static final ResourceKey<Biome> COMMUNAL_CORRIDORS_BIOME = ResourceKey
            .create(Registries.BIOME, TheCorners.id(CornerWorlds.COMMUNAL_CORRIDORS));
    public static final ResourceKey<Biome> HOARY_CROSSROADS_BIOME = ResourceKey
            .create(Registries.BIOME, TheCorners.id(CornerWorlds.HOARY_CROSSROADS));
    public static final ResourceKey<Biome> ABYSSAL_CHASM_BIOME = ResourceKey
            .create(Registries.BIOME, TheCorners.id("abyssal_chasm"));
    public static final ResourceKey<Biome> CRYSTAL_VOID_BIOME = ResourceKey
            .create(Registries.BIOME, TheCorners.id("crystal_void"));

    public static final ResourceKey<Feature<?>> GAIA_TREE_FEATURE = ResourceKey
            .create(Registries.FEATURE, TheCorners.id("gaia_tree"));
    public static final Supplier<GaiaTreeFeature> GAIA_TREE_FEATURE_SUPPLIER = FEATURES
            .register("gaia_tree", () -> new GaiaTreeFeature(net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration.CODEC));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_GAIA_TREE_FEATURE = ResourceKey
            .create(Registries.CONFIGURED_FEATURE, TheCorners.id("gaia_tree"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_SAPLING_GAIA_TREE_FEATURE = ResourceKey
            .create(Registries.CONFIGURED_FEATURE, TheCorners.id("gaia_sapling"));

    public static final Supplier<MapCodec<YearningCanalChunkGenerator>> YEARNING_CANAL_CHUNK_GENERATOR = CHUNK_GENERATORS.register("yearning_canal_chunk_generator", () -> YearningCanalChunkGenerator.CODEC);
    public static final Supplier<MapCodec<CommunalCorridorsChunkGenerator>> COMMUNAL_CORRIDORS_CHUNK_GENERATOR = CHUNK_GENERATORS.register("communal_corridors_chunk_generator", () -> CommunalCorridorsChunkGenerator.CODEC);
    public static final Supplier<MapCodec<HoaryCrossroadsChunkGenerator>> HOARY_CROSSROADS_CHUNK_GENERATOR = CHUNK_GENERATORS.register("hoary_crossroads_chunk_generator", () -> HoaryCrossroadsChunkGenerator.CODEC);
    public static final Supplier<MapCodec<net.ludocrypt.corners.world.chunk.AmplifiedCaveChunkGenerator>> AMPLIFIED_CAVE_CHUNK_GENERATOR = CHUNK_GENERATORS.register("amplified_cave_chunk_generator", () -> net.ludocrypt.corners.world.chunk.AmplifiedCaveChunkGenerator.CODEC);
    public static final Supplier<MapCodec<net.ludocrypt.corners.world.chunk.CrystalFractalChunkGenerator>> CRYSTAL_FRACTAL_CHUNK_GENERATOR = CHUNK_GENERATORS.register("crystal_fractal_chunk_generator", () -> net.ludocrypt.corners.world.chunk.CrystalFractalChunkGenerator.CODEC);

    public static void register(IEventBus bus) {
        FEATURES.register(bus);
        CHUNK_GENERATORS.register(bus);
    }
}


