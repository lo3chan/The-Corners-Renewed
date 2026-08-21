# Crystal Dimension (Crystal Fractal) Architecture & Voxel Engine Specification

## 1. Subsystem Overview
The **Crystal Fractal** dimension (`corners:crystal_fractal`) is a high-performance voxel-generated crystal labyrinth featuring endless geometric amethyst caverns, crystal clusters, and Crystalline Guardian encounters.

## 2. Voxel Data & References (`reference_sources/crystal_dimension_voxels/`)
- `reference_sources/crystal_dimension_voxels/export_fractal/`: Master voxel slice definitions and coordinate bounds.
- `reference_sources/crystal_dimension_voxels/structures_nbt/`: Pre-baked amethyst structure formations (`crystal_arch.nbt`, `crystal_pillar.nbt`, `crystal_spire.nbt`, etc.).
- `src/main/resources/assets/corners/master_fractal_voxels.bin`: Spatial index binary payload loaded at startup into `CrystalFractalChunkGenerator`.

## 3. World Generation Engine
- **Chunk Generator**: `CrystalFractalChunkGenerator.java` (`net.ludocrypt.corners.world.chunk.CrystalFractalChunkGenerator`).
- **Generation Logic**:
  - Direct voxel lookup into spatial index `master_fractal_voxels.bin`.
  - Populates solid amethyst blocks, budding amethyst, tinted glass, smooth basalt boundaries, and amethyst cluster crystal formations.
  - Generates ambient light levels and zero-sky light void physics.
- **Biomes**: `corners:crystal_void` (`data/corners/worldgen/biome/crystal_void.json`).
- **Dimension Definition**: `corners:crystal_fractal` (`data/corners/dimension/crystal_fractal.json`).

## 4. Inhabitants & Mechanics
- **Entity**: `CrystallineGuardianEntity` (`corners:crystalline_guardian`).
- **Drops**: Amethyst shards, amethyst clusters, and raw crystal resonance.
- **Atmosphere**: Liminal crystal ambient sounds and dimensional shaders via Limlib.
