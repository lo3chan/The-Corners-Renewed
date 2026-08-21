# Cave & Liminal Dimensions Specification (Pass 3 Guidance)

## 1. Overview of Cave Dimensions
The cave and liminal dimensions form the atmospheric core of *The Corners: Renewed*:

### 1. The Abyss (`corners:the_abyss`)
- **Biome**: `corners:abyssal_chasm`
- **Atmosphere**: Pitch black, subterranean chasms with deep fog, eerie ambient acoustics, and dense spawns of Born in Chaos and Undead Revamped horrors (*Nightmare Stalkers*, *The Horrors*, *The Clogger*, *The Heavy*, *Skeleton Thrashers*).
- **Chunk Generation**: `AmplifiedCaveChunkGenerator` with dense basalt formations, abyssal stone pillars, and jagged void chasms.

### 2. Communal Corridors (`corners:communal_corridors`)
- **Biome**: `corners:communal_corridors`
- **Atmosphere**: Endless liminal maze corridors composed of plaster drywall, fluorescent ceiling fixtures, carpeted flooring, and subtle hum ambient audio.
- **Mechanics**: Directional disorientation, looping corridors, and rare encounter rooms.

### 3. Hoary Crossroads (`corners:hoary_crossroads`)
- **Biome**: `corners:hoary_crossroads`
- **Atmosphere**: Frozen subterranean junction with snowy glass, frozen stone pillars, dark metal railings, and sub-zero blizzard particles.

### 4. Yearning Canal (`corners:yearning_canal`)
- **Biome**: `corners:yearning_canal`
- **Atmosphere**: Submerged arched aqueducts, dark reflective waterways, damp brickwork, and underwater hazards (*The Spitter*, *Corpse Fish*).

---

## 2. Technical Standards
- **Chunk Population**: Synchronous deterministic chunk generation with zero-error bounds checking.
- **Portals**: Clean integration with `DimensionalPaintingEntity` and `LimlibTravelling.travelTo()`.
- **Spawn Rules**: Controlled monster density managed by `CaveDimensionSpawnRuleHandler`.
