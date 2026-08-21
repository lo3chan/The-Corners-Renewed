package net.ludocrypt.corners;

import net.ludocrypt.corners.world.feature.GaiaTreeFeature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.ludocrypt.corners.config.CornerConfig;
import net.ludocrypt.corners.init.CornerBiomes;
import net.ludocrypt.corners.init.CornerBlocks;
import net.ludocrypt.corners.init.CornerEntities;
import net.ludocrypt.corners.init.CornerPaintings;
import net.ludocrypt.corners.init.CornerRadioRegistry;
import net.ludocrypt.corners.init.CornerSoundEvents;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.ludocrypt.corners.entity.undead.*;

@Mod("corners")
public class TheCorners {

    public static final Logger LOGGER = LogManager.getLogger("The Corners");

    public CornerConfig config;

    public TheCorners(IEventBus modEventBus) {
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::registerEntityAttributes);

        CornerBlocks.BLOCKS.register(modEventBus);
        CornerBlocks.ITEMS.register(modEventBus);
        CornerEntities.ENTITY_TYPES.register(modEventBus);
        CornerPaintings.PAINTING_VARIANTS.register(modEventBus);
        CornerSoundEvents.SOUND_EVENTS.register(modEventBus);
        CornerRadioRegistry.RADIOS.register(modEventBus);
        CornerBiomes.register(modEventBus);

        AutoConfig.register(CornerConfig.class, GsonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(CornerConfig.class).getConfig();
    }

    private void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(CornerEntities.UNDEAD_GHOUL.get(), UndeadGhoulEntity.createAttributes().build());
        event.put(CornerEntities.UNDEAD_KNIGHT.get(), UndeadKnightEntity.createAttributes().build());
        event.put(CornerEntities.CRAWLING_UNDEAD.get(), CrawlingUndeadEntity.createAttributes().build());
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            CornerBlocks.registerDispenserBehaviors();
            CornerBlocks.registerStrippables();
            CornerBlocks.registerFlammables();
            Registry.register(BuiltInRegistries.FEATURE, CornerBiomes.GAIA_TREE_FEATURE, new GaiaTreeFeature(NoneFeatureConfiguration.CODEC));
        });
    }

    public static ResourceLocation id(String id) {
        return ResourceLocation.fromNamespaceAndPath("corners", id);
    }
}


