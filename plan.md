1. **Fix `CornerRadioRegistry` unchecked cast:**
   - Edit `src/main/java/net/ludocrypt/corners/util/RadioSoundTable.java` to change `Holder.Reference<SoundEvent>` to `Supplier<SoundEvent>` in its constructor and fields.

2. **Fix `CornerRadioRegistry` unchecked cast (Part 2):**
   - Edit `src/main/java/net/ludocrypt/corners/init/CornerRadioRegistry.java` to pass `CornerSoundEvents.RADIO_DEFAULT_STATIC`, etc., directly to the `RadioSoundTable` constructor, removing the `(net.minecraft.core.Holder.Reference<net.minecraft.sounds.SoundEvent>) (Object)` casts.

3. **Fix `CommunalCorridorsChunkGenerator` deprecation warning:**
   - Edit `src/main/java/net/ludocrypt/corners/world/chunk/CommunalCorridorsChunkGenerator.java`.
   - Add `@SuppressWarnings("deprecation")` directly to the `generateCommunalCorridorsPlatform` method definition.

4. **Create missing loot tables for `GAIA_WALL_SIGN` and `GAIA_WALL_HANGING_SIGN`:**
   - Run a Python script or shell commands to copy `src/main/resources/data/corners/loot_tables/blocks/gaia_sign.json` to `gaia_wall_sign.json` and `gaia_wall_hanging_sign.json` so the loot tables exist natively.

5. **Fix `CornerBlocks` dropsLike deprecation:**
   - Edit `src/main/java/net/ludocrypt/corners/init/CornerBlocks.java` to remove `.dropsLike(GAIA_SIGN.get())` and `.dropsLike(GAIA_HANGING_SIGN.get())` from the `BlockBehaviour.Properties.ofFullCopy(...)` builder for `GAIA_WALL_SIGN` and `GAIA_WALL_HANGING_SIGN`.

6. **Fix `TheCornersClient` setRenderLayer deprecation:**
   - Edit `src/main/java/net/ludocrypt/corners/client/TheCornersClient.java` and remove all `ItemBlockRenderTypes.setRenderLayer(...)` calls entirely.
   - We already updated the relevant block JSON files using a Python script, so this step only involves removing the Java calls.

7. **Fix `GenericGeoModel` deprecation:**
   - Edit `src/main/java/net/ludocrypt/corners/client/entity/undead/GenericGeoModel.java`. Add `@SuppressWarnings("deprecation")` to the `GenericGeoModel` class definition to suppress the `getTextureResource` and `getModelResource` warnings.

8. **Audit `@EventBusSubscriber` - Initialization:**
   - Read `src/main/java/net/ludocrypt/corners/init/CornerBlocks.java` and verify `bus = EventBusSubscriber.Bus.MOD`.
   - Read `src/main/java/net/ludocrypt/corners/datagen/CornersDatagen.java` and verify `bus = EventBusSubscriber.Bus.MOD`.
   - Read `src/main/java/net/ludocrypt/corners/client/TheCornersClient.java` and verify `bus = EventBusSubscriber.Bus.MOD`.

9. **Audit `@EventBusSubscriber` - Mechanics:**
   - Read `src/main/java/net/ludocrypt/corners/mechanics/EyesInTheDarknessClientHandler.java`.
   - Read `src/main/java/net/ludocrypt/corners/mechanics/CrystalDimensionHandler.java`.
   - Read `src/main/java/net/ludocrypt/corners/mechanics/EngulfingDarknessHandler.java`.
   - Read `src/main/java/net/ludocrypt/corners/mechanics/CaveDimensionSpawnRuleHandler.java`.
   - Read `src/main/java/net/ludocrypt/corners/packet/ServerToClientPackets.java`.
   - Verify these use `bus = EventBusSubscriber.Bus.GAME` (or default). If any are incorrect, update them.

10. **Verify mob renderers - Read entities:**
    - Read `src/main/java/net/ludocrypt/corners/init/CornerEntities.java` to extract the full list of 48 custom mobs.

11. **Verify mob renderers - Read client registrations:**
    - Read `src/main/java/net/ludocrypt/corners/client/TheCornersClient.java`.

12. **Verify mob renderers - Cross-reference:**
    - Cross-reference the 48 custom mobs from `CornerEntities.java` with the `RegisterRenderersEvent` block in `TheCornersClient.java` to ensure all 48 mobs have a registered `GenericGeoRenderer`.

13. **Verify spawn egg color handlers:**
    - Cross-reference the 48 custom mobs from `CornerEntities.java` with the `RegisterColorHandlersEvent.Item` block in `TheCornersClient.java` to ensure all 48 custom mob spawn eggs are registered.

14. **Verify layer definitions:**
    - Check the `RegisterLayerDefinitions` in `TheCornersClient.java` to ensure `CornerBoatEntityRenderer.getModelLayer(CornerBoat.GAIA, false)` and `(CornerBoat.GAIA, true)` are correctly registered, as well as Corvus.

15. **Compile codebase:**
    - Run `./gradlew clean compileJava -Xlint:unchecked -Xlint:deprecation` to confirm strict zero compilation warnings.

16. **Run game tests:**
    - Run `./gradlew test` and `./gradlew runGameTestServer` to verify game tests pass.

17. **Code health check:**
    - Ensure all changes are correct and zero warnings are present in the build log.

18. **Final Code Health Review:**
    - Reflect on all files changed.

19. **Pre-commit testing:**
    - Complete pre-commit steps to ensure proper testing, verification, review, and reflection are done.

20. **Submit:**
    - Submit the verified release candidate codebase.
