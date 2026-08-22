# The Corners Renewed: 1:1 Reference Porting & Verification Specification (1.21.1 / NeoForge)

> **CORE DIRECTIVE: 1:1 FIDELITY WITH ORIGINAL REFERENCE MODS (ZERO INVENTED FEATURES).**
> Other than the two new dimensions (The Abyss & Crystal Fractal), this project is a strict 1-to-1 modern port of the original reference codebases to NeoForge 1.21.1 / Java 21 / GeckoLib 4.7.7.

---

## 1. Primary Reference Lineage

### 1.1 The Corners (Original Fabric 1.18.2 by LudoCrypt)
Path: `reference_sources/the_corners_original/`
- **Blocks & Items**: 
  - Gaia Wood Set: logs, stripped logs, wood, planks, stairs, slab, fence, fence gate, door, trapdoor, pressure plate, button, carved planks, leaves, sapling, signs, hanging signs, boats, chest boats.
  - Architectural: Stone Pillar, Thin Pillar, Drywall, Nylon Fiber (block, stairs, slab), Snowy Glass (block, pane, slab with cutout transparency), Dark Railing, Deep Bookshelf.
  - Radios: Wooden Radio, Tuned Radio, Broken Radio, Grown Radio with frequency tuning (46.0 MHz - 108.0 MHz), podcasts, static audio, and music tracks.
- **Original Dimensions**:
  - `communal_corridors` (Backrooms-esque infinite hallways).
  - `hoary_crossroads` (Snowy infinite crossroads).
  - `yearning_canal` (Atmospheric flooded channels).
- **Dimensional Paintings & Portals**:
  - Painting Variants: Cascade, Goat Mountain, Shoreline, Hoary Crossroads, Communal Corridors, Yearning Canal.
- **Advancements**:
  - "The Corners", "Forgetting the FAQ", "I Change My Mind", "Tears of Void", "Backrooms-esque", "Unabridged Road".

### 1.2 Born in Chaos & The Undead Revamped
Path: `reference_sources/born_in_chaos/` & `reference_sources/the_undead_revamped/`
- **All 47 Horror & Undead Mobs + Corvus**:
  - Port exact base attributes (health, attack damage, speed, follow range, armor).
  - Port exact GeckoLib 3D models (`.geo.json`), textures (`.png`), and animations (`.animation.json`).
  - Port attack goals, sound mappings, and loot tables.
  - `CorvusEntity` retains full 3D aerial navigation, flying move control, and flight AI.
  - Every mob has a registered `DeferredSpawnEggItem` with original primary/secondary colors and translation names.

---

## 2. The Two New Custom Dimensions

### 2.1 The Abyss (`corners:the_abyss`)
- **Specification**: A pure Overworld enclosed cave world spanning Y = -64 to Y = 320.
- **Generation**: Custom Overworld noise router (`corners:the_abyss`) using stone/deepslate layers, aquifers, ore veins, and cave cheese.
- **Biomes**: Multi-noise distribution with `corners:abyssal_chasm`, `minecraft:lush_caves`, `minecraft:dripstone_caves`, `minecraft:deep_dark`.
- **Underground Structures**: Spawns underground vanilla structures (`minecraft:mineshaft`, `minecraft:ancient_city`, `minecraft:trial_chambers`, `minecraft:stronghold`).
- **Sound**: Subtle ambient atmosphere (no harsh repeating cave rumble loops).
- **Safe Arrival**: Painting platform carving in `CornerPaintings.java` ensuring players never spawn in solid blocks or void.

### 2.2 Crystal Fractal (`corners:crystal_fractal`)
- **Specification**: 1:1 infinite procedural 3D amethyst fractal lattice (ported from the standalone crystal fractal datapack).
- **Generation**: Native `minecraft:noise` chunk generator with `corners:final_density` and 5 ported octave density functions (`octave_macro`, `octave_micro`, `octave_subframe`, `octave_combined`).
- **Bounds**: `min_y: 0`, `height: 384`, `logical_height: 384`, `effects: "minecraft:the_end"`.
- **Surface Rules**: Generates stone foundation base, calcite, budding amethyst, and amethyst blocks.
- **Mob Spawns**: Crystalline Guardian removed; void is clean.

---

## 3. Strict 1:1 Porting Quality Gate
1. **Zero Divergence**: Every ported class must match the logic, mathematical equations, and behavior of the reference codebase.
2. **Zero Errors**: Build must pass with `./gradlew compileJava --no-daemon` with exit code 0.
3. **Registry & Resource Integrity**: Zero missing textures, zero missing language translations, zero missing sound events.
4. **Automated Verification**: Automated headless GameTest server tests verifying block interaction, dimension hopping, and mob AI.
