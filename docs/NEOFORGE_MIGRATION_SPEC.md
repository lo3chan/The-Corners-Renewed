# NeoForge Migration Specification: The Corners: Renewed

This document defines the specification and blueprint for migrating the Minecraft mod **The Corners: Renewed** from the Fabric loader to the **NeoForge** loader for Minecraft **1.21.1**.

---

## 1. Project Build Configuration

### settings.gradle
Replace `settings.gradle` to configure the ModDevGradle plugin and convention plugins:

```groovy
pluginManagement {
    repositories {
        maven {
            name = 'NeoForged'
            url = 'https://maven.neoforged.net/releases/'
        }
        gradlePluginPortal()
    }
}

plugins {
    id 'org.gradle.toolchains.foojay-resolver-convention' version '0.8.0'
}

rootProject.name = 'the_corners_renewed'
```

### gradle.properties
Update properties for NeoForge:
```properties
org.gradle.jvmargs=-Xmx3G
org.gradle.parallel=true

version=2.3.0
maven_group=net.ludocrypt
archives_base_name=the_corners_renewed
```

### build.gradle
Create a new `build.gradle` utilizing `net.neoforged.moddev` (ModDevGradle):

```groovy
plugins {
    id 'java'
    id 'eclipse'
    id 'idea'
    id 'maven-publish'
    id 'net.neoforged.moddev' version '2.0.78'
}

base.archivesName = project.archives_base_name
version = "${project.version}+1.21.1"
group = project.maven_group

neoForge {
    version = '21.1.65'

    parchment {
        mappingsVersion = '2023.09.03'
        minecraftVersion = '1.20.1'
    }

    runs {
        client {
            client()
            systemProperty 'neoforge.logging.console.level', 'debug'
        }
        server {
            server()
            programArgument '--nogui'
        }
        data {
            data()
            programArguments.addAll '--mod', 'corners', '--all', '--output', file('src/generated/resources/').getAbsolutePath(), '--existing', file('src/main/resources/').getAbsolutePath()
        }
    }

    mods {
        corners {
            sourceSet sourceSets.main
        }
    }
}

sourceSets.main.resources { srcDir 'src/generated/resources' }

repositories {
    mavenLocal()
    maven {
        name = "CurseMaven"
        url = "https://www.cursemaven.com"
        content {
            includeGroup "curse.maven"
        }
    }
    maven {
        url = 'https://jitpack.io'
    }
    maven {
        url = 'https://maven.shedaniel.me/'
    }
}

dependencies {
    // Cloth Config for NeoForge
    implementation "me.shedaniel.cloth:cloth-config-neoforge:15.0.140"

    // Liminal Library (LimLib) for NeoForge
    // CurseForge Project ID: 1646280.
    // NeoForge 1.21.1 release file ID should be retrieved.
    // If local jar is preferred, keep using flatDir but point to the NeoForge build:
    implementation fileTree(dir: 'libs', include: ['*.jar'])
}

tasks.withType(JavaCompile).configureEach {
    options.encoding = 'UTF-8'
    options.release = 21
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
    withSourcesJar()
}
```

---

## 2. Mod Metadata & Access Configuration

### Metadata
- **DELETE** `src/main/resources/fabric.mod.json`
- **NEW** `src/main/resources/META-INF/neoforge.mods.toml`:
```toml
modLoader="java"
loaderVersion="[21,)"
license="LGPL-3.0-or-later"

[[mods]]
modId="corners"
version="${file.jarVersion}"
displayName="The Corners: Renewed"
displayURL="https://www.curseforge.com/minecraft/mc-mods/the-corners"
logoFile="assets/corners/icon.png"
authors="LudoCrypt, Shai, KraCactus, Racoon Syndrome, Basement Spider, ImXR24, Waterpicker"
description='''
Explore the corners of the universe, where no man was meant to.
'''

[[dependencies.corners]]
modId="neoforge"
type="required"
versionRange="[21.1.65,)"
ordering="NONE"
side="BOTH"

[[dependencies.corners]]
modId="limlib"
type="required"
versionRange="*"
ordering="NONE"
side="BOTH"
```

### Access Transformers
- **DELETE** `src/main/resources/corners.accesswidener`
- **NEW** `src/main/resources/META-INF/accesstransformer.cfg`:
```text
# Access Transformer for The Corners: Renewed
public-f net.minecraft.world.level.block.CrossCollisionBlock shapeByIndex
public-f net.minecraft.client.renderer.entity.BoatRenderer boatResources
public net.minecraft.world.level.block.state.BlockBehaviour canSurvive(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/LevelReader;Lnet/minecraft/core/BlockPos;)Z
```

---

## 3. Java Code Migration

### 3.1 Main Mod Setup (`TheCorners.java`)
1. Remove `implements ModInitializer` and the `onInitialize()` method.
2. Annotate the class with `@Mod("corners")`.
3. In the constructor, register mod-specific event handlers on the mod event bus:
```java
@Mod("corners")
public class TheCorners {
    public static final Logger LOGGER = LogManager.getLogger("The Corners");

    public CornerConfig config;

    public TheCorners(IEventBus modEventBus) {
        modEventBus.addListener(this::commonSetup);
        
        // Register Deferred Registers
        CornerBlocks.BLOCKS.register(modEventBus);
        CornerBlocks.ITEMS.register(modEventBus);
        CornerEntities.ENTITY_TYPES.register(modEventBus);
        CornerPaintings.PAINTING_VARIANTS.register(modEventBus);
        CornerSoundEvents.SOUND_EVENTS.register(modEventBus);
        CornerRadioRegistry.RADIOS.register(modEventBus);
        
        AutoConfig.register(CornerConfig.class, GsonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(CornerConfig.class).getConfig();
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            CornerBlocks.registerDispenserBehaviors();
            CornerBlocks.registerStrippables();
            CornerBlocks.registerFlammables();
        });
    }

    public static ResourceLocation id(String id) {
        return ResourceLocation.fromNamespaceAndPath("corners", id);
    }
}
```

### 3.2 Registries Conversion
Migrate registry initialization from Fabric's `Registry.register` style to NeoForge's `DeferredRegister` style:

#### Example: `CornerBlocks.java`
```java
public class CornerBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks("corners");
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems("corners");

    public static final DeferredBlock<Block> STONE_PILLAR = BLOCKS.register("stone_pillar", 
        () -> new ThinPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));

    // For items associated with blocks
    public static final DeferredItem<Item> STONE_PILLAR_ITEM = ITEMS.registerSimpleBlockItem("stone_pillar", STONE_PILLAR);

    // Flammable block registry should be registered using FireBlock accessor during client setup or common setup
    public static void registerFlammables() {
        FireBlock fireblock = (FireBlock) Blocks.FIRE;
        fireblock.setFlammable(NYLON_FIBER_BLOCK.get(), 30, 60);
        // ...
    }
}
```

### 3.3 Client Setup (`TheCornersClient.java`)
Replace Fabric's `ClientModInitializer` with a client-only subscriber:
```java
@EventBusSubscriber(modid = "corners", bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TheCornersClient {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        // Shader setup, models, etc.
        TheCornersModelPlugin.init();
        TheCornersShaders.init();
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(CornerEntities.DIMENSIONAL_PAINTING_ENTITY.get(), PaintingRenderer::new);
        event.registerEntityRenderer(CornerEntities.GAIA_BOAT.get(), context -> new CornerBoatEntityRenderer(context, false, CornerBoat.GAIA));
        event.registerEntityRenderer(CornerEntities.GAIA_CHEST_BOAT.get(), context -> new CornerBoatEntityRenderer(context, true, CornerBoat.GAIA));
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CornerBoatEntityRenderer.getModelLayer(CornerBoat.GAIA, false), BoatModel::createBodyModel);
        event.registerLayerDefinition(CornerBoatEntityRenderer.getModelLayer(CornerBoat.GAIA, true), ChestBoatModel::createBodyModel);
    }
}
```

### 3.4 Packets Conversion
- Replace Fabric `PayloadTypeRegistry` and `ServerPlayNetworking`/`ClientPlayNetworking` with NeoForge Network Payloads:
- Register payloads under the `RegisterPayloadHandlersEvent` on the mod event bus.
- Create records implementing `CustomPacketPayload` and register handles using `IPayloadHandler`.

### 3.5 Datagen Conversion
- Replace Fabric data generation entrypoints in `datagen/CornersDatagen.java` with a listener for the `GatherDataEvent` on the mod event bus.
- Register providers to the `DataGenerator`.

### 3.6 Mixins Conversion
- Adjust `corners.mixins.json` compatibility level to Java 21 (`"compatibilityLevel": "JAVA_21"`).
- Delete `FabricDynamicRegistryProviderMixin.java` as it depends on Fabric-specific datagen internals.
