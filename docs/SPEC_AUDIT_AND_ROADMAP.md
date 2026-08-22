# The Corners Renewed: Verification, Deep Hardening & Analysis Specification (1.21.1 / NeoForge)

> **CORE DIRECTIVE: ZERO NEW FEATURES.**
> Focus 100% on verifying, hardening, stress-testing, and deeply analyzing the exact user-specified systems against reference sources.

---

## 1. Scope Boundaries (Strictly Defined Systems Only)

### 1.1 Dimensional Systems
1. **The Abyss (`corners:the_abyss`)**:
   - Pure Overworld enclosed cave dimension spanning Y = -64 to Y = 320.
   - Noise generation: Custom Overworld noise router `corners:the_abyss` with stone/deepslate, aquifers, ore veins, and cave cheese.
   - Multi-noise distribution: `corners:abyssal_chasm`, `minecraft:lush_caves`, `minecraft:dripstone_caves`, `minecraft:deep_dark`.
   - Underground structures: `minecraft:mineshaft`, `minecraft:ancient_city`, `minecraft:trial_chambers`, `minecraft:stronghold`.
   - Ambient sound: No harsh repetitive cave sound loops.
   - Safe arrival: Platform carving in `CornerPaintings.java` ensuring players never spawn inside solid blocks or void.

2. **Crystal Fractal (`corners:crystal_fractal`)**:
   - 1:1 procedural 3D amethyst fractal lattice using native `minecraft:noise` chunk generator with `corners:final_density` and ported octave density functions (`octave_macro`, `octave_micro`, `octave_subframe`, `octave_combined`).
   - Bounds: `min_y: 0`, `height: 384`, `logical_height: 384`, `effects: "minecraft:the_end"`.
   - Surface rules: Stone foundations, calcite, budding amethyst, and amethyst blocks.
   - Complete removal of Crystalline Guardian; suppress vanilla monster and bat clutter in the void.

3. **Communal Corridors, Hoary Crossroads, Yearning Canal**:
   - Verify dimensional painting interactions, portal traversal, and ambient atmosphere.

---

### 1.2 Mobs & Visual Presentation
- All 48 horror and undead mobs use GeckoLib 4.7.7 `GenericGeoRenderer` resolving each entity to its authentic 3D model, texture, and animation.
- `CorvusEntity` has full 3D flight pathfinding, `FlyingMoveControl`, and `FlyingPathNavigation`.
- All 48 mobs have a registered `DeferredSpawnEggItem` with primary/secondary colors, full translation keys in `en_us.json`, and registered color handlers (`RegisterColorHandlersEvent.Item`).

---

### 1.3 Radios & Audio Systems
- `RadioBlock.java`, `RadioBlockEntity.java`, `RadioMenu.java`, `RadioScreen.java` handle frequency tuning, custom payload packets, and stream playback.
- `sounds.json` audio event mapping verification without memory leaks or sound engine missing sound warnings.

---

## 2. Deep Analysis & Continuous Verification Protocol
1. **Compilation Floor**: Zero compilation errors (`./gradlew compileJava --no-daemon`).
2. **Registry & Codec Integrity**: Zero missing registry keys, zero `IllegalStateException` on data loading.
3. **Headless Server & GameTests**: Automated tests verifying all 5 dimensions load, chunks generate, radios place and tune, and paintings teleport safely without crash.
4. **Architectural Review**: Continuous failure-mode analysis and edge-case testing with Jules.
