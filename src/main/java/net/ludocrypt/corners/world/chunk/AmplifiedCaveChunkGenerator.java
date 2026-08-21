package net.ludocrypt.corners.world.chunk;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.chunk.ChunkGeneratorStructureState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.minecraft.world.level.levelgen.synth.PerlinSimplexNoise;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class AmplifiedCaveChunkGenerator extends ChunkGenerator {

    public static final MapCodec<AmplifiedCaveChunkGenerator> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    BiomeSource.CODEC.fieldOf("biome_source").forGetter(ChunkGenerator::getBiomeSource)
            ).apply(instance, AmplifiedCaveChunkGenerator::new)
    );

    private static final BlockState BEDROCK = Blocks.BEDROCK.defaultBlockState();
    private static final BlockState DEEPSLATE = Blocks.DEEPSLATE.defaultBlockState();
    private static final BlockState STONE = Blocks.STONE.defaultBlockState();
    private static final BlockState WATER = Blocks.WATER.defaultBlockState();
    private static final BlockState AIR = Blocks.AIR.defaultBlockState();

    public AmplifiedCaveChunkGenerator(BiomeSource biomeSource) {
        super(biomeSource);
    }

    @Override
    protected MapCodec<? extends ChunkGenerator> codec() {
        return CODEC;
    }

    @Override
    public void buildSurface(WorldGenRegion region, StructureManager structureManager, RandomState randomState, ChunkAccess chunk) {
        // Surface decoration handled by biome features
    }

    @Override
    public void applyCarvers(WorldGenRegion region, long seed, RandomState randomState, BiomeManager biomeManager, StructureManager structureManager, ChunkAccess chunk, GenerationStep.Carving step) {
    }

    @Override
    public CompletableFuture<ChunkAccess> fillFromNoise(Blender blender, RandomState randomState, StructureManager structureManager, ChunkAccess chunk) {
        return CompletableFuture.supplyAsync(() -> {
            ChunkPos chunkPos = chunk.getPos();
            int startX = chunkPos.getMinBlockX();
            int startZ = chunkPos.getMinBlockZ();
            int minY = chunk.getMinBuildHeight();
            int maxY = chunk.getMaxBuildHeight();

            BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

            for (int x = 0; x < 16; x++) {
                for (int z = 0; z < 16; z++) {
                    int worldX = startX + x;
                    int worldZ = startZ + z;

                    // Bedrock floor (bottom 5 layers)
                    for (int y = minY; y < minY + 5; y++) {
                        if (y == minY || (y - minY < 4 && ((worldX * 31 + worldZ * 17 + y) % 3 != 0))) {
                            chunk.setBlockState(pos.set(x, y, z), BEDROCK, false);
                        } else {
                            chunk.setBlockState(pos.set(x, y, z), DEEPSLATE, false);
                        }
                    }

                    // Bedrock ceiling (top 5 layers)
                    for (int y = maxY - 5; y < maxY; y++) {
                        if (y == maxY - 1 || ((maxY - y) < 4 && ((worldX * 23 + worldZ * 29 + y) % 3 != 0))) {
                            chunk.setBlockState(pos.set(x, y, z), BEDROCK, false);
                        } else {
                            chunk.setBlockState(pos.set(x, y, z), STONE, false);
                        }
                    }

                    // Amplified 3D subterranean cave noise
                    for (int y = minY + 5; y < maxY - 5; y++) {
                        double nx = worldX * 0.015;
                        double ny = y * 0.02;
                        double nz = worldZ * 0.015;

                        // Swiss cheese 3D noise + massive vertical cavern chambers
                        double n1 = Math.sin(nx) * Math.cos(ny) * Math.sin(nz);
                        double n2 = Math.cos(nx * 2.1 + nz * 0.5) * Math.sin(ny * 1.8);
                        double density = n1 + n2 * 0.5;

                        // Density threshold for carving massive open chambers vs giant stone pillars
                        if (density > 0.25) {
                            BlockState state = y < 0 ? DEEPSLATE : STONE;
                            chunk.setBlockState(pos.set(x, y, z), state, false);
                        } else {
                            // Subterranean water basins at bottom layers
                            if (y < minY + 24) {
                                chunk.setBlockState(pos.set(x, y, z), WATER, false);
                            } else {
                                chunk.setBlockState(pos.set(x, y, z), AIR, false);
                            }
                        }
                    }
                }
            }

            return chunk;
        });
    }

    @Override
    public int getMinY() {
        return -64;
    }

    @Override
    public int getGenDepth() {
        return 384;
    }

    @Override
    public int getSeaLevel() {
        return -40;
    }

    @Override
    public int getBaseHeight(int x, int z, Heightmap.Types type, LevelHeightAccessor level, RandomState randomState) {
        return 64;
    }

    @Override
    public NoiseColumn getBaseColumn(int x, int z, LevelHeightAccessor level, RandomState randomState) {
        return new NoiseColumn(-64, new BlockState[384]);
    }

    @Override
    public void addDebugScreenInfo(List<String> info, RandomState randomState, BlockPos pos) {
        info.add("Amplified Caves Chunk Generator");
    }

    @Override
    public void spawnOriginalMobs(WorldGenRegion region) {
    }
}
