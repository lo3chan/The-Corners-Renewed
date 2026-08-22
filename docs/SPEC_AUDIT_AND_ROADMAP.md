# The Corners Renewed: 1:1 Reference Porting & Verification Specification (1.21.1 / NeoForge)

> **CORE DIRECTIVE: 1:1 FIDELITY WITH ORIGINAL REFERENCE CODEBASES (ZERO INVENTED MECHANICS / ZERO GUIS).**

---

## 1. Verified Original The Corners Reference Mechanics (`reference_sources/the_corners_original/`)

### 1.1 In-World Radio System (Zero GUI / Immersive Physical Interaction)
*Source: `net/ludocrypt/corners/block/RadioBlock.java` & `net/ludocrypt/corners/packet/ServerToClientPackets.java`*

- **Block Variants**:
  1. `grown_radio`: Grown via bone meal on Gaia sapling (`new RadioBlock(null, null, ...)`).
  2. `broken_radio`: Empty radio chassis (`new RadioBlock(null, GROWN_RADIO, ...)`).
  3. `wooden_radio`: Loaded with `Items.GOLD_INGOT` (`new RadioBlock(Items.GOLD_INGOT, BROKEN_RADIO, ...)`).
  4. `tuned_radio`: Loaded with `Items.AMETHYST_SHARD` (`new RadioBlock(Items.AMETHYST_SHARD, BROKEN_RADIO, ...)`).

- **In-World Player Interaction**:
  - **Core Insertion**: Right-clicking the front face of a Broken Radio with a `GOLD_INGOT` inserts the core and transforms it into a `WOODEN_RADIO`. Right-clicking with an `AMETHYST_SHARD` transforms it into a `TUNED_RADIO`.
  - **Core Extraction**: Right-clicking the front face of a Wooden or Tuned Radio with an empty hand pops the core item (`gold_ingot` or `amethyst_shard`) back into the player's inventory and resets the block to a `broken_radio`.
  - **Bone Meal**: Applying bone meal to a Broken Radio or Grown Radio interacts with Gaia sapling growth.
  - **Power / Playback**: Right-clicking or powering with redstone toggles the `POWERED` boolean property and broadcasts `PLAY_RADIO` packet to all tracking clients.

- **Client Sound Resolution & Painting Proximity**:
  - When `PLAY_RADIO` starts, client checks for the closest `PaintingEntity` within a 16-block radius possessing a `DimensionalPaintingVariant`.
  - The nearby painting determines the radio station channel (`Yearning Canal`, `Communal Corridors`, or `Hoary Crossroads`).
  - **Audio Channel Mapping**:
    - `broken_radio` / No Painting: Default static sound (`id.getStaticSound()`).
    - `wooden_radio`: Dimension podcast / voice transmission (`id.getRadioSound()`).
    - `tuned_radio`: Dimension ambient music track (`id.getMusicSound()`).
  - Uses `LoopingPositionedSoundInstance` on `SoundCategory.RECORDS` at `pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5`.

---

### 1.2 Original Blocks, Wood & Translucent Cutouts
- **Gaia Wood Set**: Logs, Stripped Logs, Wood, Planks, Stairs, Slab, Fence, Fence Gate, Door, Trapdoor, Pressure Plate, Button, Carved Planks, Leaves, Sapling, Sign, Hanging Sign, Boat, Chest Boat.
- **Architectural**: Stone Pillar, Thin Pillar, Drywall, Nylon Fiber (blocks, stairs, slabs), Dark Railing, Deep Bookshelf.
- **Snowy Glass**: Blocks, Panes, Slabs registered with `RenderType.cutout()` for alpha transparency.

### 1.3 Original Dimensions & Painting Portals
- **Dimensions**: `communal_corridors`, `hoary_crossroads`, `yearning_canal`.
- **Paintings**: Cascade, Goat Mountain, Shoreline, Hoary Crossroads, Communal Corridors, Yearning Canal.
- **Advancements**: "The Corners", "Forgetting the FAQ", "I Change My Mind", "Tears of Void", "Backrooms-esque", "Unabridged Road".

---

## 2. Verified Born in Chaos & The Undead Revamped Reference Mechanics
*Sources: `reference_sources/born_in_chaos/` & `reference_sources/the_undead_revamped/`*

- **47 Horror & Undead Mobs + Corvus**:
  - Exact base attributes (health, attack damage, speed, follow range, armor).
  - Exact GeckoLib 3D models (`.geo.json`), textures (`.png`), and animations (`.animation.json`).
  - `CorvusEntity` has full 3D aerial navigation, `FlyingMoveControl`, and `FlyingPathNavigation`.
  - All 48 mobs have a registered `DeferredSpawnEggItem` with primary/secondary colors and translation names.

---

## 3. The Two Custom Dimensions
1. **The Abyss (`corners:the_abyss`)**:
   - Pure Overworld enclosed cave world spanning Y = -64 to Y = 320.
   - Multi-noise biomes: `abyssal_chasm`, `lush_caves`, `dripstone_caves`, `deep_dark`.
   - Underground structures: `mineshaft`, `ancient_city`, `trial_chambers`, `stronghold`.
   - Safe arrival platform carving in `CornerPaintings.java`.
2. **Crystal Fractal (`corners:crystal_fractal`)**:
   - 1:1 procedural 3D amethyst fractal lattice using native `minecraft:noise` chunk generator with `corners:final_density` and ported octave density functions.
