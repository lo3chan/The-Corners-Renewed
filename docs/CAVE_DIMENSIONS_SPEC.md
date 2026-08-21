# The Abyss Dimension Specification (Pass 3 Focus)

## 1. Scope Restriction
> [!IMPORTANT]
> **DO NOT TOUCH ORIGINAL CORNERS DIMENSIONS.**
> The original dimensions (`communal_corridors`, `hoary_crossroads`, `yearning_canal`) must remain exactly as originally designed.
> **ONLY `corners:the_abyss` is targeted for custom cave generation and horror tuning in Pass 3.**

---

## 2. The Abyss Architecture (`corners:the_abyss`)
- **Biome**: `corners:abyssal_chasm` (`data/corners/worldgen/biome/abyssal_chasm.json`).
- **Atmospheric Design**:
  - Pitch black subterranean abyss with dense dark fog, oppressive acoustic reverb, and heavy monster presence.
  - Natural habitat for deep horrors: *Nightmare Stalker*, *The Horrors*, *The Clogger*, *The Heavy*, *Skeleton Thrasher*, *The Rod*, *The Spectre*, *Dark Vortex*, *Corpse Fish*.
- **World Generation**:
  - `AmplifiedCaveChunkGenerator` (`net.ludocrypt.corners.world.chunk.AmplifiedCaveChunkGenerator`).
  - Jagged void chasms, massive abyssal stone pillars, steep drop-offs, and subterranean basalt shelves.
  - Guaranteed safe air landing pocket on dimensional painting entry.
- **Spawn Rules**:
  - Custom spawn tables and density rules via `CaveDimensionSpawnRuleHandler`.
