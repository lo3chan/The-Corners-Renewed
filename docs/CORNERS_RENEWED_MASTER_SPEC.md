# The Corners: Renewed — Master 1.21.1 NeoForge Architecture & Consolidation Specification

## 1. Overview & Objective
**The Corners: Renewed** is a full 1.21.1 NeoForge modern port and expansion of Ludocrypt's *The Corners*, consolidated with custom dimensions (*The Abyss*, *Crystal Realm / Crystal Fractal*), Limlib dimensional transition portals, and extensive creature suites sourced from *Born in Chaos* and *The Undead Revamped*.

---

## 2. Reference Sources (`reference_sources/`)
The repository contains 3 reference folders:
1. `reference_sources/the_corners_original/`: The complete original Fabric/Quilt Java source code and assets by Ludocrypt.
2. `reference_sources/born_in_chaos/extracted/`: Full 1.21.1 NeoForge models, animations, textures, sounds, and loot tables for:
   - Skeleton Thrasher, Skeleton Demoman, Decrepit Skeleton, Decaying Zombie, Dark Vortex, Bone Imp, Nightmare Stalker, Fallen Chaos Knight, Missioner, Seared Spirit, Phantom Creeper, Corpse Fish, Maggot, Thornshell Crab, Dire Hound Leader.
3. `reference_sources/the_undead_revamped/extracted/`: Full textures, models, sound events, and attributes for:
   - The Swarmer, The Lurker, The Heavy, The Spitter, The Spectre, The Hunter, The Horrors, The Undead Wolf, The Rod, The Clogger, The Pregnant, The Wheezer, The Lumber, The Sucker, The Big Sucker, The Fire Dust, Dead Clogger, Slaveman, The Moonflower, The Beartamer, The Bidy, The Bidy Upside, The Dungeon, The Gliter, The Immortal, The Ordure, The Posessive, The Rabidus, The Skeeper, The Smoker, The Somnolence.

---

## 3. Core Architectural Subsystems

### 3.1 Dimensions & Chunk Generation
- **5 Total Dimensions**:
  1. `corners:communal_corridors`: Infinite liminal maze corridor generation.
  2. `corners:hoary_crossroads`: Cold liminal snow maze with snowy glass and dark railings.
  3. `corners:yearning_canal`: Flooded aqueduct labyrinth with deep water channels.
  4. `corners:the_abyss`: Deep, atmospheric chasm world inhabited by terrifying undead entities.
  5. `corners:crystal_fractal`: Fast voxel-indexed crystal cave system containing Crystalline Guardians and amethyst structures.

### 3.2 Dimensional Paintings & Portals
- **Painting Variants**: Registered in `data/corners/painting_variant/` and `#minecraft:painting_variant/placeable`.
- **Activation**: Placing a painting with a `corners:*` variant and right-clicking it with `Items.FLINT_AND_STEEL` converts it to a `DimensionalPaintingEntity`.
- **Teleportation**: Stepping through the painting transitions the player via `LimlibTravelling.travelTo()`.

### 3.3 Creative Mode Tab
- Dedicated Creative Tab registered as `corners:corners_tab` containing all blocks, items, boats, spawn eggs, and pre-configured painting items (`DataComponents.ENTITY_DATA`).

### 3.4 Entity Models, Textures, & Behaviors
- Full entity models, animations, textures, sounds, and custom AI goals ported from `reference_sources/born_in_chaos/` and `reference_sources/the_undead_revamped/`.
- Native NeoForge 1.21.1 entity registration, attribute creation, and client model layer baking.

---

## 4. Build & Verification Standards
- **Framework**: NeoForge 1.21.1 (`21.1.219+`).
- **Build Floor**: Clean compilation with 0 errors via `./gradlew build` / `./gradlew jar`.
- **Strict Prohibition**: Never stub, delete, or comment out core game systems (chunk generators, dimensional transitions, AI goals, custom models) to bypass errors.
