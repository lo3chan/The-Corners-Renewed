package net.ludocrypt.corners.init;

import net.ludocrypt.corners.TheCorners;
import net.ludocrypt.corners.block.*;
import net.ludocrypt.corners.entity.CornerBoatDispensorBehavior;
import net.ludocrypt.corners.entity.CornerBoatEntity.CornerBoat;
import net.ludocrypt.corners.mixin.SignTypeAccessor;
import net.ludocrypt.corners.world.feature.GaiaSaplingGenerator;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import java.util.function.Supplier;

@EventBusSubscriber(modid = "corners", bus = EventBusSubscriber.Bus.MOD)
public class CornerBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks("corners");
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems("corners");
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "corners");

    public static final DeferredBlock<Block> STONE_PILLAR = BLOCKS.register("stone_pillar", () -> new ThinPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredItem<BlockItem> STONE_PILLAR_ITEM = ITEMS.registerSimpleBlockItem("stone_pillar", STONE_PILLAR);

    public static final DeferredBlock<RadioBlock> GROWN_RADIO = BLOCKS.register("grown_radio", () -> new RadioBlock(null, null, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredItem<BlockItem> GROWN_RADIO_ITEM = ITEMS.registerSimpleBlockItem("grown_radio", GROWN_RADIO);

    public static final DeferredBlock<RadioBlock> BROKEN_RADIO = BLOCKS.register("broken_radio", () -> new RadioBlock(null, GROWN_RADIO.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredItem<BlockItem> BROKEN_RADIO_ITEM = ITEMS.registerSimpleBlockItem("broken_radio", BROKEN_RADIO);

    public static final DeferredBlock<RadioBlock> WOODEN_RADIO = BLOCKS.register("wooden_radio", () -> new RadioBlock(Items.GOLD_INGOT, BROKEN_RADIO.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredItem<BlockItem> WOODEN_RADIO_ITEM = ITEMS.registerSimpleBlockItem("wooden_radio", WOODEN_RADIO);

    public static final DeferredBlock<RadioBlock> TUNED_RADIO = BLOCKS.register("tuned_radio", () -> new RadioBlock(Items.AMETHYST_SHARD, BROKEN_RADIO.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredItem<BlockItem> TUNED_RADIO_ITEM = ITEMS.registerSimpleBlockItem("tuned_radio", TUNED_RADIO);

    public static final DeferredBlock<Block> DRYWALL = BLOCKS.register("drywall", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredItem<BlockItem> DRYWALL_ITEM = ITEMS.registerSimpleBlockItem("drywall", DRYWALL);

    public static final DeferredBlock<Block> NYLON_FIBER_BLOCK = BLOCKS.register("nylon_fiber_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredItem<BlockItem> NYLON_FIBER_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("nylon_fiber_block", NYLON_FIBER_BLOCK);

    public static final DeferredBlock<Block> NYLON_FIBER_STAIRS = BLOCKS.register("nylon_fiber_stairs", () -> new CornerStairsBlock(NYLON_FIBER_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredItem<BlockItem> NYLON_FIBER_STAIRS_ITEM = ITEMS.registerSimpleBlockItem("nylon_fiber_stairs", NYLON_FIBER_STAIRS);

    public static final DeferredBlock<Block> NYLON_FIBER_SLAB = BLOCKS.register("nylon_fiber_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredItem<BlockItem> NYLON_FIBER_SLAB_ITEM = ITEMS.registerSimpleBlockItem("nylon_fiber_slab", NYLON_FIBER_SLAB);

    public static final DeferredBlock<Block> SNOWY_GLASS = BLOCKS.register("snowy_glass", () -> new SkyboxGlassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).lightLevel(state -> 3)));
    public static final DeferredItem<BlockItem> SNOWY_GLASS_ITEM = ITEMS.registerSimpleBlockItem("snowy_glass", SNOWY_GLASS);

    public static final DeferredBlock<Block> SNOWY_GLASS_PANE = BLOCKS.register("snowy_glass_pane", () -> new SkyboxGlassPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).lightLevel(state -> 3)));
    public static final DeferredItem<BlockItem> SNOWY_GLASS_PANE_ITEM = ITEMS.registerSimpleBlockItem("snowy_glass_pane", SNOWY_GLASS_PANE);

    public static final DeferredBlock<Block> SNOWY_GLASS_SLAB = BLOCKS.register("snowy_glass_slab", () -> new SkyboxGlassSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).lightLevel(state -> 3)));
    public static final DeferredItem<BlockItem> SNOWY_GLASS_SLAB_ITEM = ITEMS.registerSimpleBlockItem("snowy_glass_slab", SNOWY_GLASS_SLAB);

    public static final DeferredBlock<Block> DARK_RAILING = BLOCKS.register("dark_railing", () -> new RailingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredItem<BlockItem> DARK_RAILING_ITEM = ITEMS.registerSimpleBlockItem("dark_railing", DARK_RAILING);

    public static final DeferredBlock<Block> DEEP_BOOKSHELF = BLOCKS.register("deep_bookshelf", () -> new ChiseledBookShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredItem<BlockItem> DEEP_BOOKSHELF_ITEM = ITEMS.registerSimpleBlockItem("deep_bookshelf", DEEP_BOOKSHELF);

    // Gaia
    public static final BlockSetType GAIA_SET_TYPE = BlockSetType.register(new BlockSetType("corners:gaia"));
    public static final WoodType GAIA_SIGN_TYPE = WoodType.register(new WoodType("corners:gaia", GAIA_SET_TYPE));

    public static final DeferredBlock<Block> GAIA_PLANKS = BLOCKS.register("gaia_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredItem<BlockItem> GAIA_PLANKS_ITEM = ITEMS.registerSimpleBlockItem("gaia_planks", GAIA_PLANKS);

    public static final DeferredBlock<Block> CARVED_GAIA = BLOCKS.register("carved_gaia", () -> new OrientableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredItem<BlockItem> CARVED_GAIA_ITEM = ITEMS.registerSimpleBlockItem("carved_gaia", CARVED_GAIA);

    public static final DeferredBlock<Block> GAIA_SAPLING = BLOCKS.register("gaia_sapling", () -> new SaplingBlock(GaiaSaplingGenerator.GAIA, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_SAPLING).mapColor(MapColor.GOLD)));
    public static final DeferredItem<BlockItem> GAIA_SAPLING_ITEM = ITEMS.registerSimpleBlockItem("gaia_sapling", GAIA_SAPLING);

    public static final DeferredBlock<Block> GAIA_LOG = BLOCKS.register("gaia_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LOG).mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.PODZOL : MapColor.GOLD)));
    public static final DeferredItem<BlockItem> GAIA_LOG_ITEM = ITEMS.registerSimpleBlockItem("gaia_log", GAIA_LOG);

    public static final DeferredBlock<Block> STRIPPED_GAIA_LOG = BLOCKS.register("stripped_gaia_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_SPRUCE_LOG).mapColor(MapColor.PODZOL)));
    public static final DeferredItem<BlockItem> STRIPPED_GAIA_LOG_ITEM = ITEMS.registerSimpleBlockItem("stripped_gaia_log", STRIPPED_GAIA_LOG);

    public static final DeferredBlock<Block> GAIA_WOOD = BLOCKS.register("gaia_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_WOOD).mapColor(MapColor.GOLD)));
    public static final DeferredItem<BlockItem> GAIA_WOOD_ITEM = ITEMS.registerSimpleBlockItem("gaia_wood", GAIA_WOOD);

    public static final DeferredBlock<Block> STRIPPED_GAIA_WOOD = BLOCKS.register("stripped_gaia_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_SPRUCE_WOOD)));
    public static final DeferredItem<BlockItem> STRIPPED_GAIA_WOOD_ITEM = ITEMS.registerSimpleBlockItem("stripped_gaia_wood", STRIPPED_GAIA_WOOD);

    public static final DeferredBlock<Block> GAIA_LEAVES = BLOCKS.register("gaia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredItem<BlockItem> GAIA_LEAVES_ITEM = ITEMS.registerSimpleBlockItem("gaia_leaves", GAIA_LEAVES);

    public static final DeferredBlock<Block> GAIA_SIGN = BLOCKS.register("gaia_sign", () -> new StandingSignBlock(GAIA_SIGN_TYPE, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_SIGN)));
    public static final DeferredBlock<Block> GAIA_WALL_SIGN = BLOCKS.register("gaia_wall_sign", () -> new WallSignBlock(GAIA_SIGN_TYPE, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_WALL_SIGN).dropsLike(GAIA_SIGN.get())));

    public static final DeferredBlock<Block> GAIA_HANGING_SIGN = BLOCKS.register("gaia_hanging_sign", () -> new CeilingHangingSignBlock(GAIA_SIGN_TYPE, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_HANGING_SIGN)));
    public static final DeferredBlock<Block> GAIA_WALL_HANGING_SIGN = BLOCKS.register("gaia_wall_hanging_sign", () -> new WallHangingSignBlock(GAIA_SIGN_TYPE, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_WALL_HANGING_SIGN).dropsLike(GAIA_HANGING_SIGN.get())));

    public static final DeferredBlock<Block> GAIA_PRESSURE_PLATE = BLOCKS.register("gaia_pressure_plate", () -> new PressurePlateBlock(GAIA_SET_TYPE, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PRESSURE_PLATE)));
    public static final DeferredItem<BlockItem> GAIA_PRESSURE_PLATE_ITEM = ITEMS.registerSimpleBlockItem("gaia_pressure_plate", GAIA_PRESSURE_PLATE);

    public static final DeferredBlock<Block> GAIA_TRAPDOOR = BLOCKS.register("gaia_trapdoor", () -> new TrapDoorBlock(GAIA_SET_TYPE, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_TRAPDOOR)));
    public static final DeferredItem<BlockItem> GAIA_TRAPDOOR_ITEM = ITEMS.registerSimpleBlockItem("gaia_trapdoor", GAIA_TRAPDOOR);

    public static final DeferredBlock<Block> POTTED_GAIA_SAPLING = BLOCKS.register("potted_gaia_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, GAIA_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING)));

    public static final DeferredBlock<Block> GAIA_BUTTON = BLOCKS.register("gaia_button", () -> new ButtonBlock(GAIA_SET_TYPE, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));
    public static final DeferredItem<BlockItem> GAIA_BUTTON_ITEM = ITEMS.registerSimpleBlockItem("gaia_button", GAIA_BUTTON);

    public static final DeferredBlock<Block> GAIA_STAIRS = BLOCKS.register("gaia_stairs", () -> new StairBlock(GAIA_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(GAIA_PLANKS.get())));
    public static final DeferredItem<BlockItem> GAIA_STAIRS_ITEM = ITEMS.registerSimpleBlockItem("gaia_stairs", GAIA_STAIRS);

    public static final DeferredBlock<Block> GAIA_SLAB = BLOCKS.register("gaia_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_SLAB)));
    public static final DeferredItem<BlockItem> GAIA_SLAB_ITEM = ITEMS.registerSimpleBlockItem("gaia_slab", GAIA_SLAB);

    public static final DeferredBlock<Block> GAIA_FENCE_GATE = BLOCKS.register("gaia_fence_gate", () -> new FenceGateBlock(GAIA_SIGN_TYPE, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_FENCE_GATE)));
    public static final DeferredItem<BlockItem> GAIA_FENCE_GATE_ITEM = ITEMS.registerSimpleBlockItem("gaia_fence_gate", GAIA_FENCE_GATE);

    public static final DeferredBlock<Block> GAIA_FENCE = BLOCKS.register("gaia_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_FENCE)));
    public static final DeferredItem<BlockItem> GAIA_FENCE_ITEM = ITEMS.registerSimpleBlockItem("gaia_fence", GAIA_FENCE);

    public static final DeferredBlock<Block> GAIA_DOOR = BLOCKS.register("gaia_door", () -> new DoorBlock(GAIA_SET_TYPE, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_DOOR)));
    public static final DeferredItem<Item> GAIA_DOOR_ITEM = ITEMS.register("gaia_door", () -> new DoubleHighBlockItem(GAIA_DOOR.get(), new Item.Properties()));

    public static final DeferredItem<Item> GAIA_BOAT = ITEMS.register("gaia_boat", () -> new CornerBoatItem(false, CornerBoat.GAIA, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> GAIA_CHEST_BOAT = ITEMS.register("gaia_chest_boat", () -> new CornerBoatItem(true, CornerBoat.GAIA, new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> GAIA_SIGN_ITEM = ITEMS.register("gaia_sign", () -> new SignItem(new Item.Properties().stacksTo(16), GAIA_SIGN.get(), GAIA_WALL_SIGN.get()));
    public static final DeferredItem<Item> GAIA_HANGING_SIGN_ITEM = ITEMS.register("gaia_hanging_sign", () -> new HangingSignItem(GAIA_HANGING_SIGN.get(), GAIA_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> CRYSTALLINE_GUARDIAN_SPAWN_EGG = ITEMS.register("crystalline_guardian_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(CornerEntities.CRYSTALLINE_GUARDIAN, 0x9c59d1, 0xdf84ff, new Item.Properties()));
    public static final DeferredItem<Item> CORVUS_SPAWN_EGG = ITEMS.register("corvus_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(CornerEntities.CORVUS, 0x1f1f23, 0x5a5a68, new Item.Properties()));

    public static final Supplier<CreativeModeTab> CORNERS_TAB = CREATIVE_MODE_TABS.register("corners_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(CornerBlocks.TUNED_RADIO.get()))
            .title(Component.translatable("itemGroup.corners.corners_tab"))
            .displayItems((parameters, output) -> {
                output.accept(STONE_PILLAR_ITEM.get());
                output.accept(DRYWALL_ITEM.get());
                output.accept(NYLON_FIBER_BLOCK_ITEM.get());
                output.accept(NYLON_FIBER_STAIRS_ITEM.get());
                output.accept(NYLON_FIBER_SLAB_ITEM.get());
                output.accept(SNOWY_GLASS_ITEM.get());
                output.accept(SNOWY_GLASS_PANE_ITEM.get());
                output.accept(SNOWY_GLASS_SLAB_ITEM.get());
                output.accept(DARK_RAILING_ITEM.get());
                output.accept(DEEP_BOOKSHELF_ITEM.get());
                output.accept(GROWN_RADIO_ITEM.get());
                output.accept(BROKEN_RADIO_ITEM.get());
                output.accept(WOODEN_RADIO_ITEM.get());
                output.accept(TUNED_RADIO_ITEM.get());

                output.accept(GAIA_LOG_ITEM.get());
                output.accept(STRIPPED_GAIA_LOG_ITEM.get());
                output.accept(GAIA_WOOD_ITEM.get());
                output.accept(STRIPPED_GAIA_WOOD_ITEM.get());
                output.accept(GAIA_PLANKS_ITEM.get());
                output.accept(CARVED_GAIA_ITEM.get());
                output.accept(GAIA_STAIRS_ITEM.get());
                output.accept(GAIA_SLAB_ITEM.get());
                output.accept(GAIA_FENCE_ITEM.get());
                output.accept(GAIA_FENCE_GATE_ITEM.get());
                output.accept(GAIA_DOOR_ITEM.get());
                output.accept(GAIA_TRAPDOOR_ITEM.get());
                output.accept(GAIA_PRESSURE_PLATE_ITEM.get());
                output.accept(GAIA_BUTTON_ITEM.get());
                output.accept(GAIA_LEAVES_ITEM.get());
                output.accept(GAIA_SAPLING_ITEM.get());
                output.accept(GAIA_SIGN_ITEM.get());
                output.accept(GAIA_HANGING_SIGN_ITEM.get());
                output.accept(GAIA_BOAT.get());
                output.accept(GAIA_CHEST_BOAT.get());

                output.accept(CRYSTALLINE_GUARDIAN_SPAWN_EGG.get());
                output.accept(CORVUS_SPAWN_EGG.get());

                // Populate paintings with specific variant components
                parameters.holders().lookup(Registries.PAINTING_VARIANT).ifPresent(lookup -> {
                    net.minecraft.resources.RegistryOps<net.minecraft.nbt.Tag> registryOps = parameters.holders().createSerializationContext(net.minecraft.nbt.NbtOps.INSTANCE);
                    lookup.listElements().forEach(variantHolder -> {
                        if (variantHolder.key().location().getNamespace().equals("corners")) {
                            net.minecraft.world.item.component.CustomData customData = ((net.minecraft.world.item.component.CustomData) net.minecraft.world.item.component.CustomData.EMPTY.update(registryOps, net.minecraft.world.entity.decoration.Painting.VARIANT_MAP_CODEC, variantHolder).getOrThrow()).update((compoundTag) -> compoundTag.putString("id", "minecraft:painting"));
                            ItemStack paintingItem = new ItemStack(Items.PAINTING);
                            paintingItem.set(net.minecraft.core.component.DataComponents.ENTITY_DATA, customData);
                            output.accept(paintingItem);
                        }
                    });
                });
            })
            .build());

    public static void registerDispenserBehaviors() {
        DispenserBlock.registerBehavior(GAIA_BOAT.get(), new CornerBoatDispensorBehavior(CornerBoat.GAIA, false));
        DispenserBlock.registerBehavior(GAIA_CHEST_BOAT.get(), new CornerBoatDispensorBehavior(CornerBoat.GAIA, true));
    }

    public static void registerFlammables() {
        FireBlock fireblock = (FireBlock) Blocks.FIRE;
        fireblock.setFlammable(NYLON_FIBER_BLOCK.get(), 30, 60);
        fireblock.setFlammable(NYLON_FIBER_STAIRS.get(), 30, 60);
        fireblock.setFlammable(NYLON_FIBER_SLAB.get(), 30, 60);
        fireblock.setFlammable(DRYWALL.get(), 5, 20);
        fireblock.setFlammable(WOODEN_RADIO.get(), 10, 20);
        fireblock.setFlammable(TUNED_RADIO.get(), 10, 20);
        fireblock.setFlammable(BROKEN_RADIO.get(), 10, 20);
        fireblock.setFlammable(GROWN_RADIO.get(), 10, 20);
        fireblock.setFlammable(STRIPPED_GAIA_LOG.get(), 5, 5);
        fireblock.setFlammable(STRIPPED_GAIA_WOOD.get(), 5, 5);
        fireblock.setFlammable(GAIA_LOG.get(), 5, 5);
        fireblock.setFlammable(GAIA_WOOD.get(), 5, 5);
        fireblock.setFlammable(GAIA_STAIRS.get(), 5, 20);
        fireblock.setFlammable(GAIA_SLAB.get(), 5, 20);
        fireblock.setFlammable(GAIA_PLANKS.get(), 5, 20);
        fireblock.setFlammable(CARVED_GAIA.get(), 5, 20);
        fireblock.setFlammable(GAIA_FENCE.get(), 5, 20);
        fireblock.setFlammable(GAIA_FENCE_GATE.get(), 5, 20);
        fireblock.setFlammable(GAIA_LEAVES.get(), 30, 60);
    }

    public static void registerStrippables() {
    }

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(STONE_PILLAR_ITEM);
            event.accept(DARK_RAILING_ITEM);
            event.accept(DRYWALL_ITEM);
            event.accept(NYLON_FIBER_BLOCK_ITEM);
            event.accept(NYLON_FIBER_STAIRS_ITEM);
            event.accept(NYLON_FIBER_SLAB_ITEM);
            event.accept(CARVED_GAIA_ITEM);
            event.accept(GAIA_LOG_ITEM);
            event.accept(GAIA_WOOD_ITEM);
            event.accept(STRIPPED_GAIA_LOG_ITEM);
            event.accept(STRIPPED_GAIA_WOOD_ITEM);
            event.accept(GAIA_PLANKS_ITEM);
            event.accept(GAIA_STAIRS_ITEM);
            event.accept(GAIA_SLAB_ITEM);
            event.accept(GAIA_FENCE_ITEM);
            event.accept(GAIA_FENCE_GATE_ITEM);
            event.accept(GAIA_DOOR_ITEM);
            event.accept(GAIA_TRAPDOOR_ITEM);
            event.accept(GAIA_PRESSURE_PLATE_ITEM);
            event.accept(GAIA_BUTTON_ITEM);
        }
        if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
            event.accept(SNOWY_GLASS_ITEM);
            event.accept(SNOWY_GLASS_PANE_ITEM);
            event.accept(SNOWY_GLASS_SLAB_ITEM);
        }
        if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            event.accept(DEEP_BOOKSHELF_ITEM);
            event.accept(WOODEN_RADIO_ITEM);
            event.accept(TUNED_RADIO_ITEM);
            event.accept(BROKEN_RADIO_ITEM);
            event.accept(GROWN_RADIO_ITEM);
        }
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(GAIA_LOG_ITEM);
            event.accept(GAIA_LEAVES_ITEM);
            event.accept(GAIA_SAPLING_ITEM);
        }
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(GAIA_SIGN_ITEM);
            event.accept(GAIA_HANGING_SIGN_ITEM);
            event.accept(DEEP_BOOKSHELF_ITEM);
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(GAIA_BOAT);
            event.accept(GAIA_CHEST_BOAT);
        }
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(CRYSTALLINE_GUARDIAN_SPAWN_EGG);
            event.accept(CORVUS_SPAWN_EGG);
        }
    }
}
