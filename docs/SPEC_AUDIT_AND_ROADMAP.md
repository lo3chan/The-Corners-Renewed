# The Corners Renewed: Master Migration Specification & Verification Roadmap (1.21.1 / NeoForge)

## 1. Project Overview & Architecture Target
The Corners Renewed is a modern port and enhancement of the iconic liminal dimensions mod targeting **Minecraft 1.21.1 / NeoForge (21.1.248+) / Java 21**.

---

## 2. Core Subsystems

### 2.1 Dimensional Systems
1. **The Abyss (`corners:the_abyss`)**:
   - **Specification**: A pure Overworld enclosed cave dimension spanning Y = -64 to Y = 320 (total depth 384 blocks).
   - **Generation**: Utilizes custom noise router `corners:the_abyss` based on stone and deepslate vertical gradients with aquifers, ore veins, and cave cheese noise.
   - **Biomes**: Multi-noise distribution containing `corners:abyssal_chasm`, `minecraft:lush_caves`, `minecraft:dripstone_caves`, and `minecraft:deep_dark`.
   - **Underground Structures**: Spawns underground vanilla structures (`minecraft:mineshaft`, `minecraft:ancient_city`, `minecraft:trial_chambers`, `minecraft:stronghold`).
   - **Ambient Sound**: No harsh looping cave noises; ambient sound is clean and atmosphere-appropriate.
   - **Dimension Type**: `effects: "minecraft:overworld"`, `bed_works: true`, `has_skylight: false`, `has_ceiling: true`.

2. **Crystal Fractal (`corners:crystal_fractal`)**:
   - **Specification**: Infinite 3D procedural amethyst fractal lattice.
   - **Generation**: Native `minecraft:noise` chunk generator pointing to density function `corners:final_density` and sub-octave noise graphs (`octave_macro`, `octave_micro`, `octave_subframe`, `octave_combined`).
   - **Bounds**: `min_y: 0`, `height: 384`, `logical_height: 384`, `effects: "minecraft:the_end"`.
   - **Surface Rules**: Generates stone foundations, calcite thresholds, budding amethyst accents, and amethyst blocks.
   - **Mob Spawns**: Crystalline Guardian is fully removed; bat and monster spawns are suppressed in the void.

3. **Communal Corridors, Hoary Crossroads, Yearning Canal**:
   - Fully functional dimensional paintings (`CornerPaintings.java`) providing seamless portal transitions.

---

### 2.2 Mob Systems & GeckoLib 3D Models
- All 48 horror and undead entities use GeckoLib `4.7.7` with `GenericGeoRenderer` dynamically linking each mob to its authentic `.geo.json` model, `.png` texture, and `.animation.json` sequences.
- `CorvusEntity` has full 3D flight pathfinding, `FlyingMoveControl`, and `FlyingPathNavigation`.
- Every mob has a registered `DeferredSpawnEggItem` with distinct primary/secondary colors, full `en_us.json` translation keys, template JSON item models, and registered client color handlers (`RegisterColorHandlersEvent.Item`).

---

### 2.3 Audio, Radios & Shaders
- `RadioBlock.java`, `RadioBlockEntity.java`, `RadioMenu.java`, `RadioScreen.java` handle radio tuning frequencies, audio streaming packets, and static channel filtering.
- Shaders and post-processing filters (`TheCornersShaders.java`) safely hook into NeoForge client render pipelines.

---

## 3. Autonomous Verification Suite
1. **Compilation Floor**: `./gradlew compileJava --no-daemon` must exit with code 0 and 0 errors.
2. **Resource Validation**: Data packs, dimension JSONs, biomes, density functions, item models, and sound events must load without `IllegalStateException` or missing registry keys.
3. **Headless Server Testing**: `./gradlew runGameTestServer` and headless execution must load all 5 dimensions without crashing.
