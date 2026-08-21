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
        event.put(CornerEntities.THE_SWARMER.get(), TheSwarmerEntity.createAttributes().build());
        event.put(CornerEntities.THE_LURKER.get(), TheLurkerEntity.createAttributes().build());
        event.put(CornerEntities.THE_HEAVY.get(), TheHeavyEntity.createAttributes().build());
        event.put(CornerEntities.THE_SPITTER.get(), TheSpitterEntity.createAttributes().build());
        event.put(CornerEntities.THE_SPECTRE.get(), TheSpectreEntity.createAttributes().build());
        event.put(CornerEntities.THE_HUNTER.get(), TheHunterEntity.createAttributes().build());
        event.put(CornerEntities.THE_HORRORS.get(), TheHorrorsEntity.createAttributes().build());
        event.put(CornerEntities.THE_UNDEAD_WOLF.get(), TheUndeadWolfEntity.createAttributes().build());
        event.put(CornerEntities.THE_ROD.get(), TheRodEntity.createAttributes().build());
        event.put(CornerEntities.THE_CLOGGER.get(), TheCloggerEntity.createAttributes().build());
        event.put(CornerEntities.THE_PREGNANT.get(), ThePregnantEntity.createAttributes().build());
        event.put(CornerEntities.THE_WHEEZER.get(), TheWheezerEntity.createAttributes().build());
        event.put(CornerEntities.THE_LUMBER.get(), TheLumberEntity.createAttributes().build());
        event.put(CornerEntities.THE_SUCKER.get(), TheSuckerEntity.createAttributes().build());
        event.put(CornerEntities.THE_BIG_SUCKER.get(), TheBigSuckerEntity.createAttributes().build());
        event.put(CornerEntities.THE_FIRE_DUST.get(), TheFireDustEntity.createAttributes().build());
        event.put(CornerEntities.DEAD_CLOGGER.get(), DeadCloggerEntity.createAttributes().build());
        event.put(CornerEntities.SLAVEMAN.get(), SlavemanEntity.createAttributes().build());
        event.put(CornerEntities.THE_MOONFLOWER.get(), TheMoonflowerEntity.createAttributes().build());
        event.put(CornerEntities.THE_BEARTAMER.get(), TheBeartamerEntity.createAttributes().build());
        event.put(CornerEntities.THE_BIDY.get(), TheBidyEntity.createAttributes().build());
        event.put(CornerEntities.THE_BIDY_UPSIDE.get(), TheBidyUpsideEntity.createAttributes().build());
        event.put(CornerEntities.THE_DUNGEON.get(), TheDungeonEntity.createAttributes().build());
        event.put(CornerEntities.THE_GLITER.get(), TheGliterEntity.createAttributes().build());
        event.put(CornerEntities.THE_IMMORTAL.get(), TheImmortalEntity.createAttributes().build());
        event.put(CornerEntities.THE_ORDURE.get(), TheOrdureEntity.createAttributes().build());
        event.put(CornerEntities.THE_POSESSIVE.get(), ThePosessiveEntity.createAttributes().build());
        event.put(CornerEntities.THE_RABIDUS.get(), TheRabidusEntity.createAttributes().build());
        event.put(CornerEntities.THE_SKEEPER.get(), TheSkeeperEntity.createAttributes().build());
        event.put(CornerEntities.THE_SMOKER.get(), TheSmokerEntity.createAttributes().build());
        event.put(CornerEntities.THE_SOMNOLENCE.get(), TheSomnolenceEntity.createAttributes().build());
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


