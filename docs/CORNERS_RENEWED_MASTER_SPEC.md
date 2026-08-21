# The Corners: Renewed — Master 1.21.1 NeoForge Architecture & Consolidation Specification

## 1. Overview & Objective
**The Corners: Renewed** is a full 1.21.1 NeoForge modern port and expansion of Ludocrypt's *The Corners*, consolidated with custom dimensions (*The Abyss*, *Crystal Realm / Crystal Fractal*), Limlib dimensional transition portals, and extensive creature suites sourced from *Born in Chaos* and *The Undead Revamped*.

---

## 2. Strict Dimension Scope Directives
> [!IMPORTANT]
> **DO NOT MODIFY ANY ORIGINAL CORNERS DIMENSIONS.**
> - `corners:communal_corridors`, `corners:hoary_crossroads`, and `corners:yearning_canal` are complete and must remain untouched.
> - **ONLY TWO DIMENSIONS MAY BE MODIFIED OR TUNED**:
>   1. **`corners:crystal_fractal`** (The Crystal Realm / Crystal Dimension voxel map and Crystalline Guardian mechanics)
>   2. **`corners:the_abyss`** (The Abyss chasm world generation, atmospheric fog, and hostile horror entity spawns)

---

## 3. Reference Sources (`reference_sources/`)
The repository contains 4 reference folders:
1. `reference_sources/the_corners_original/`: The complete original Fabric/Quilt Java source code and assets by Ludocrypt.
2. `reference_sources/crystal_dimension_voxels/`: Full voxel coordinate maps, density functions, and 529 structure NBTs for the Crystal Fractal.
3. `reference_sources/born_in_chaos/extracted/`: Full 1.21.1 NeoForge models, animations, textures, sounds, and loot tables for Born in Chaos entities.
4. `reference_sources/the_undead_revamped/extracted/`: Full textures, models, sound events, and attributes for Undead Revamped entities.

---

## 4. Core Architectural Subsystems

### 4.1 Dimensions & Chunk Generation
- **Target Dimensions for Tuning**:
  - `corners:the_abyss`: Deep, atmospheric chasm world inhabited by terrifying undead entities.
  - `corners:crystal_fractal`: Fast voxel-indexed crystal cave system containing Crystalline Guardians and amethyst structures.
- **Preserved Original Dimensions (DO NOT CHANGE)**:
  - `corners:communal_corridors`
  - `corners:hoary_crossroads`
  - `corners:yearning_canal`

### 4.2 Dimensional Paintings & Portals
- **Painting Variants**: Registered in `data/corners/painting_variant/` and `#minecraft:painting_variant/placeable`.
- **Activation**: Placing a painting with a `corners:*` variant and right-clicking it with `Items.FLINT_AND_STEEL` converts it to a `DimensionalPaintingEntity`.
- **Teleportation**: Stepping through the painting transitions the player via `LimlibTravelling.travelTo()`.

### 4.3 Creative Mode Tab
- Dedicated Creative Tab registered as `corners:corners_tab` containing all blocks, items, boats, spawn eggs, and pre-configured painting items (`DataComponents.ENTITY_DATA`).

### 4.4 Entity Models, Textures, & Behaviors
- Full entity models, animations, textures, sounds, and custom AI goals ported from `reference_sources/born_in_chaos/` and `reference_sources/the_undead_revamped/`.
- Native NeoForge 1.21.1 entity registration, attribute creation, and client model layer baking.

---

## 5. Build & Verification Standards
- **Framework**: NeoForge 1.21.1 (`21.1.219+`).
- **Build Floor**: Clean compilation with 0 errors via `./gradlew build` / `./gradlew jar`.
- **Strict Prohibition**: Never stub, delete, or comment out core game systems (chunk generators, dimensional transitions, AI goals, custom models) to bypass errors.
