package net.ludocrypt.corners.client;



import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.ludocrypt.corners.client.render.CornerBoatEntityRenderer;
import net.ludocrypt.corners.entity.CornerBoatEntity.CornerBoat;
import net.ludocrypt.corners.init.CornerBlocks;
import net.ludocrypt.corners.init.CornerEntities;
import net.ludocrypt.corners.init.CornerModelRenderers;
import net.ludocrypt.corners.packet.ServerToClientPackets;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.PaintingRenderer;

@EventBusSubscriber(modid = "corners",  value = Dist.CLIENT)
public class TheCornersClient {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
        });

        TheCornersModelPlugin.init();
        CornerModelRenderers.init();
        TheCornersShaders.init();
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(CornerEntities.DIMENSIONAL_PAINTING_ENTITY.get(), PaintingRenderer::new);
        event.registerEntityRenderer(CornerEntities.GAIA_BOAT.get(), context -> new CornerBoatEntityRenderer(context, false, CornerBoat.GAIA));
        event.registerEntityRenderer(CornerEntities.GAIA_CHEST_BOAT.get(), context -> new CornerBoatEntityRenderer(context, true, CornerBoat.GAIA));
        event.registerEntityRenderer(CornerEntities.CORVUS.get(), net.ludocrypt.corners.client.entity.corvus.CorvusEntityRenderer::new);

        event.registerEntityRenderer(CornerEntities.THE_SWARMER.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_swarmer"));
        event.registerEntityRenderer(CornerEntities.THE_LURKER.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_lurker"));
        event.registerEntityRenderer(CornerEntities.THE_HEAVY.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_heavy"));
        event.registerEntityRenderer(CornerEntities.THE_SPITTER.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_spitter"));
        event.registerEntityRenderer(CornerEntities.THE_SPECTRE.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_spectre"));
        event.registerEntityRenderer(CornerEntities.THE_HUNTER.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_hunter"));
        event.registerEntityRenderer(CornerEntities.THE_HORRORS.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_horrors"));
        event.registerEntityRenderer(CornerEntities.THE_UNDEAD_WOLF.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_undead_wolf"));
        event.registerEntityRenderer(CornerEntities.THE_ROD.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_rod"));
        event.registerEntityRenderer(CornerEntities.THE_CLOGGER.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_clogger"));
        event.registerEntityRenderer(CornerEntities.THE_PREGNANT.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_pregnant"));
        event.registerEntityRenderer(CornerEntities.THE_WHEEZER.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_wheezer"));
        event.registerEntityRenderer(CornerEntities.THE_LUMBER.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_lumber"));
        event.registerEntityRenderer(CornerEntities.THE_SUCKER.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_sucker"));
        event.registerEntityRenderer(CornerEntities.THE_BIG_SUCKER.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_big_sucker"));
        event.registerEntityRenderer(CornerEntities.THE_FIRE_DUST.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_fire_dust"));
        event.registerEntityRenderer(CornerEntities.DEAD_CLOGGER.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "dead_clogger"));
        event.registerEntityRenderer(CornerEntities.SLAVEMAN.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "slaveman"));
        event.registerEntityRenderer(CornerEntities.THE_MOONFLOWER.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_moonflower"));
        event.registerEntityRenderer(CornerEntities.THE_BEARTAMER.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_beartamer"));
        event.registerEntityRenderer(CornerEntities.THE_BIDY.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_bidy"));
        event.registerEntityRenderer(CornerEntities.THE_BIDY_UPSIDE.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_bidy_upside"));
        event.registerEntityRenderer(CornerEntities.THE_DUNGEON.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_dungeon"));
        event.registerEntityRenderer(CornerEntities.THE_GLITER.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_gliter"));
        event.registerEntityRenderer(CornerEntities.THE_IMMORTAL.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_immortal"));
        event.registerEntityRenderer(CornerEntities.THE_ORDURE.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_ordure"));
        event.registerEntityRenderer(CornerEntities.THE_POSESSIVE.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_posessive"));
        event.registerEntityRenderer(CornerEntities.THE_RABIDUS.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_rabidus"));
        event.registerEntityRenderer(CornerEntities.THE_SKEEPER.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_skeeper"));
        event.registerEntityRenderer(CornerEntities.THE_SMOKER.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_smoker"));
        event.registerEntityRenderer(CornerEntities.THE_SOMNOLENCE.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "the_somnolence"));
        event.registerEntityRenderer(CornerEntities.RESTLESS_SPIRIT.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "restless_spirit"));
        event.registerEntityRenderer(CornerEntities.DECREPIT_SKELETON.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "decrepit_skeleton"));
        event.registerEntityRenderer(CornerEntities.DECAYING_ZOMBIE.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "decaying_zombie"));
        event.registerEntityRenderer(CornerEntities.SKELETON_DEMOMAN.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "skeleton_demoman"));
        event.registerEntityRenderer(CornerEntities.SKELETON_THRASHER.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "skeleton_thrasher"));
        event.registerEntityRenderer(CornerEntities.DARK_VORTEX.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "dark_vortex"));
        event.registerEntityRenderer(CornerEntities.BONE_IMP.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "bone_imp"));
        event.registerEntityRenderer(CornerEntities.NIGHTMARE_STALKER.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "nightmare_stalker"));
        event.registerEntityRenderer(CornerEntities.FALLEN_CHAOS_KNIGHT.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "fallen_chaos_knight"));
        event.registerEntityRenderer(CornerEntities.MISSIONER.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "missioner"));
        event.registerEntityRenderer(CornerEntities.SEARED_SPIRIT.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "seared_spirit"));
        event.registerEntityRenderer(CornerEntities.PHANTOM_CREEPER.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "phantom_creeper"));
        event.registerEntityRenderer(CornerEntities.CORPSE_FISH.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "corpse_fish"));
        event.registerEntityRenderer(CornerEntities.MAGGOT.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "maggot"));
        event.registerEntityRenderer(CornerEntities.THORNSHELL_CRAB.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "thornshell_crab"));
        event.registerEntityRenderer(CornerEntities.DIRE_HOUND_LEADER.get(), context -> new net.ludocrypt.corners.client.entity.undead.GenericGeoRenderer<>(context, "dire_hound_leader"));
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CornerBoatEntityRenderer.getModelLayer(CornerBoat.GAIA, false), BoatModel::createBodyModel);
        event.registerLayerDefinition(CornerBoatEntityRenderer.getModelLayer(CornerBoat.GAIA, true), ChestBoatModel::createBodyModel);
        event.registerLayerDefinition(net.ludocrypt.corners.client.entity.corvus.CorvusEntityModel.LAYER_LOCATION, net.ludocrypt.corners.client.entity.corvus.CorvusEntityModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerItemColors(net.neoforged.neoforge.client.event.RegisterColorHandlersEvent.Item event) {
        event.register((stack, tintIndex) -> {
            if (stack.getItem() instanceof net.neoforged.neoforge.common.DeferredSpawnEggItem egg) {
                return egg.getColor(tintIndex);
            }
            return -1;
        },
            CornerBlocks.THE_SWARMER_SPAWN_EGG.get(),
            CornerBlocks.THE_LURKER_SPAWN_EGG.get(),
            CornerBlocks.THE_HEAVY_SPAWN_EGG.get(),
            CornerBlocks.THE_SPITTER_SPAWN_EGG.get(),
            CornerBlocks.THE_SPECTRE_SPAWN_EGG.get(),
            CornerBlocks.THE_HUNTER_SPAWN_EGG.get(),
            CornerBlocks.THE_HORRORS_SPAWN_EGG.get(),
            CornerBlocks.THE_UNDEAD_WOLF_SPAWN_EGG.get(),
            CornerBlocks.THE_ROD_SPAWN_EGG.get(),
            CornerBlocks.THE_CLOGGER_SPAWN_EGG.get(),
            CornerBlocks.THE_PREGNANT_SPAWN_EGG.get(),
            CornerBlocks.THE_WHEEZER_SPAWN_EGG.get(),
            CornerBlocks.THE_LUMBER_SPAWN_EGG.get(),
            CornerBlocks.THE_SUCKER_SPAWN_EGG.get(),
            CornerBlocks.THE_BIG_SUCKER_SPAWN_EGG.get(),
            CornerBlocks.THE_FIRE_DUST_SPAWN_EGG.get(),
            CornerBlocks.DEAD_CLOGGER_SPAWN_EGG.get(),
            CornerBlocks.SLAVEMAN_SPAWN_EGG.get(),
            CornerBlocks.THE_MOONFLOWER_SPAWN_EGG.get(),
            CornerBlocks.THE_BEARTAMER_SPAWN_EGG.get(),
            CornerBlocks.THE_BIDY_SPAWN_EGG.get(),
            CornerBlocks.THE_BIDY_UPSIDE_SPAWN_EGG.get(),
            CornerBlocks.THE_DUNGEON_SPAWN_EGG.get(),
            CornerBlocks.THE_GLITER_SPAWN_EGG.get(),
            CornerBlocks.THE_IMMORTAL_SPAWN_EGG.get(),
            CornerBlocks.THE_ORDURE_SPAWN_EGG.get(),
            CornerBlocks.THE_POSESSIVE_SPAWN_EGG.get(),
            CornerBlocks.THE_RABIDUS_SPAWN_EGG.get(),
            CornerBlocks.THE_SKEEPER_SPAWN_EGG.get(),
            CornerBlocks.THE_SMOKER_SPAWN_EGG.get(),
            CornerBlocks.THE_SOMNOLENCE_SPAWN_EGG.get(),
            CornerBlocks.RESTLESS_SPIRIT_SPAWN_EGG.get(),
            CornerBlocks.DECREPIT_SKELETON_SPAWN_EGG.get(),
            CornerBlocks.DECAYING_ZOMBIE_SPAWN_EGG.get(),
            CornerBlocks.SKELETON_DEMOMAN_SPAWN_EGG.get(),
            CornerBlocks.SKELETON_THRASHER_SPAWN_EGG.get(),
            CornerBlocks.DARK_VORTEX_SPAWN_EGG.get(),
            CornerBlocks.BONE_IMP_SPAWN_EGG.get(),
            CornerBlocks.NIGHTMARE_STALKER_SPAWN_EGG.get(),
            CornerBlocks.FALLEN_CHAOS_KNIGHT_SPAWN_EGG.get(),
            CornerBlocks.MISSIONER_SPAWN_EGG.get(),
            CornerBlocks.SEARED_SPIRIT_SPAWN_EGG.get(),
            CornerBlocks.PHANTOM_CREEPER_SPAWN_EGG.get(),
            CornerBlocks.CORPSE_FISH_SPAWN_EGG.get(),
            CornerBlocks.MAGGOT_SPAWN_EGG.get(),
            CornerBlocks.THORNSHELL_CRAB_SPAWN_EGG.get(),
            CornerBlocks.DIRE_HOUND_LEADER_SPAWN_EGG.get(),
            CornerBlocks.CORVUS_SPAWN_EGG.get()
        );
    }

}
