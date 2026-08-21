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
        modEventBus.addListener(this::registerSpawnPlacements);

        CornerBlocks.BLOCKS.register(modEventBus);
        CornerBlocks.ITEMS.register(modEventBus);
        CornerBlocks.CREATIVE_MODE_TABS.register(modEventBus);
        CornerEntities.ENTITY_TYPES.register(modEventBus);
        CornerPaintings.PAINTING_VARIANTS.register(modEventBus);
        CornerSoundEvents.SOUND_EVENTS.register(modEventBus);
        CornerRadioRegistry.RADIOS.register(modEventBus);
        CornerBiomes.register(modEventBus);

        CornerPaintings.init();

        AutoConfig.register(CornerConfig.class, GsonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(CornerConfig.class).getConfig();
    }

    private void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(CornerEntities.CORVUS.get(), net.ludocrypt.corners.entity.covrus.CorvusEntity.createLivingAttributes().build());
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
        event.put(CornerEntities.RESTLESS_SPIRIT.get(), RestlessSpiritEntity.createAttributes().build());
        event.put(CornerEntities.DECREPIT_SKELETON.get(), DecrepitSkeletonEntity.createAttributes().build());
        event.put(CornerEntities.DECAYING_ZOMBIE.get(), DecayingZombieEntity.createAttributes().build());
        event.put(CornerEntities.SKELETON_DEMOMAN.get(), SkeletonDemomanEntity.createAttributes().build());
        event.put(CornerEntities.SKELETON_THRASHER.get(), SkeletonThrasherEntity.createAttributes().build());
        event.put(CornerEntities.DARK_VORTEX.get(), DarkVortexEntity.createAttributes().build());
        event.put(CornerEntities.BONE_IMP.get(), BoneImpEntity.createAttributes().build());
        event.put(CornerEntities.NIGHTMARE_STALKER.get(), NightmareStalkerEntity.createAttributes().build());
        event.put(CornerEntities.FALLEN_CHAOS_KNIGHT.get(), FallenChaosKnightEntity.createAttributes().build());
        event.put(CornerEntities.MISSIONER.get(), MissionerEntity.createAttributes().build());
        event.put(CornerEntities.SEARED_SPIRIT.get(), SearedSpiritEntity.createAttributes().build());
        event.put(CornerEntities.PHANTOM_CREEPER.get(), PhantomCreeperEntity.createAttributes().build());
        event.put(CornerEntities.CORPSE_FISH.get(), CorpseFishEntity.createAttributes().build());
        event.put(CornerEntities.MAGGOT.get(), MaggotEntity.createAttributes().build());
        event.put(CornerEntities.THORNSHELL_CRAB.get(), ThornshellCrabEntity.createAttributes().build());
        event.put(CornerEntities.DIRE_HOUND_LEADER.get(), DireHoundLeaderEntity.createAttributes().build());
        event.put(CornerEntities.CRYSTALLINE_GUARDIAN.get(), net.ludocrypt.corners.entity.CrystallineGuardianEntity.createAttributes().build());
    }

    private void registerSpawnPlacements(net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent event) {
        event.register(
            CornerEntities.CRYSTALLINE_GUARDIAN.get(),
            net.minecraft.world.entity.SpawnPlacementTypes.NO_RESTRICTIONS,
            net.minecraft.world.level.levelgen.Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            net.minecraft.world.entity.monster.Monster::checkMonsterSpawnRules,
            net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent.Operation.REPLACE
        );
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


