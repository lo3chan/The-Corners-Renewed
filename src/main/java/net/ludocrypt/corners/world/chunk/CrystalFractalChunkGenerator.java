package net.ludocrypt.corners.world.chunk;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.WorldGenRegion;
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
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.blending.Blender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class CrystalFractalChunkGenerator extends ChunkGenerator {

    private static final Logger LOGGER = LogManager.getLogger("The Corners (Crystal Realm)");

    public static final MapCodec<CrystalFractalChunkGenerator> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    BiomeSource.CODEC.fieldOf("biome_source").forGetter(ChunkGenerator::getBiomeSource)
            ).apply(instance, CrystalFractalChunkGenerator::new)
    );

    public static final int LATTICE_SIZE = 128;
    private static final Map<Integer, byte[]> MASTER_CHUNKS = new HashMap<>();
    private static boolean databaseLoaded = false;

    private static final BlockState AMETHYST_BLOCK = Blocks.AMETHYST_BLOCK.defaultBlockState();
    private static final BlockState BUDDING_AMETHYST = Blocks.BUDDING_AMETHYST.defaultBlockState();
    private static final BlockState AIR = Blocks.AIR.defaultBlockState();

    static {
        loadMasterVoxelDatabase();
    }

    public CrystalFractalChunkGenerator(BiomeSource biomeSource) {
        super(biomeSource);
    }

    private static synchronized void loadMasterVoxelDatabase() {
        if (databaseLoaded) return;
        try (InputStream in = CrystalFractalChunkGenerator.class.getResourceAsStream("/assets/corners/master_fractal_voxels.bin")) {
            if (in != null) {
                DataInputStream dis = new DataInputStream(in);
                int chunkCount = dis.readInt();
                for (int i = 0; i < chunkCount; i++) {
                    short cx = dis.readShort();
                    short cz = dis.readShort();
                    int numVoxels = dis.readInt();
                    byte[] data = new byte[numVoxels * 4];
                    dis.readFully(data);
                    int key = ((cx & 0xFFFF) << 16) | (cz & 0xFFFF);
                    MASTER_CHUNKS.put(key, data);
                }
                databaseLoaded = true;
                LOGGER.info("[Corners] Loaded {} master crystal fractal chunk slices into in-memory spatial index!", MASTER_CHUNKS.size());
            } else {
                LOGGER.warn("[Corners] Master voxel database /assets/corners/master_fractal_voxels.bin not found!");
            }
        } catch (Throwable e) {
            LOGGER.error("[Corners] Failed to load crystal fractal voxel database: {}", e.getMessage(), e);
        }
    }

    @Override
    protected MapCodec<? extends ChunkGenerator> codec() {
        return CODEC;
    }

    @Override
    public void buildSurface(WorldGenRegion region, StructureManager structureManager, RandomState randomState, ChunkAccess chunk) {
    }

    @Override
    public void applyCarvers(WorldGenRegion region, long seed, RandomState randomState, BiomeManager biomeManager, StructureManager structureManager, ChunkAccess chunk, GenerationStep.Carving step) {
    }

    @Override
    public CompletableFuture<ChunkAccess> fillFromNoise(Blender blender, RandomState randomState, StructureManager structureManager, ChunkAccess chunk) {
        ChunkPos chunkPos = chunk.getPos();
        int cx = chunkPos.x;
        int cz = chunkPos.z;

        // Infinite Modulo Tiling: Map ANY coordinate in the universe to master chunk [-64, 63]
        int masterCx = ((cx % LATTICE_SIZE) + LATTICE_SIZE) % LATTICE_SIZE - 64;
        int masterCz = ((cz % LATTICE_SIZE) + LATTICE_SIZE) % LATTICE_SIZE - 64;

        int key = ((masterCx & 0xFFFF) << 16) | (masterCz & 0xFFFF);
        byte[] voxelData = MASTER_CHUNKS.get(key);

        if (voxelData != null && voxelData.length > 0) {
            BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
            int count = voxelData.length / 4;
            for (int i = 0; i < count; i++) {
                int offset = i * 4;
                int relX = voxelData[offset] & 0xFF;
                int relZ = voxelData[offset + 1] & 0xFF;
                int rawH = ((voxelData[offset + 2] & 0xFF) << 8) | (voxelData[offset + 3] & 0xFF);
                int y = (rawH >> 3) - 1024;
                int blockType = rawH & 7;

                BlockState state = (blockType == 3) ? BUDDING_AMETHYST : AMETHYST_BLOCK;
                chunk.setBlockState(pos.set(relX, y, relZ), state, false);
            }
        }

        return CompletableFuture.completedFuture(chunk);
    }

    @Override
    public int getBaseHeight(int x, int z, Heightmap.Types heightmapType, LevelHeightAccessor level, RandomState randomState) {
        return level.getMinBuildHeight();
    }

    @Override
    public NoiseColumn getBaseColumn(int x, int z, LevelHeightAccessor level, RandomState randomState) {
        BlockState[] states = new BlockState[level.getHeight()];
        for (int i = 0; i < states.length; i++) {
            states[i] = AIR;
        }
        return new NoiseColumn(level.getMinBuildHeight(), states);
    }

    @Override
    public void addDebugScreenInfo(List<String> list, RandomState randomState, BlockPos pos) {
        list.add("Crystal Fractal ChunkGenerator (Pure In-Memory Symmetrical Modulo)");
    }

    @Override
    public int getGenDepth() {
        return 1536;
    }

    @Override
    public int getMinY() {
        return -1024;
    }

    @Override
    public int getSeaLevel() {
        return -1024;
    }

    @Override
    public void spawnOriginalMobs(WorldGenRegion region) {
    }
}
