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

@EventBusSubscriber(modid = "corners", bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TheCornersClient {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(CornerBlocks.SNOWY_GLASS_PANE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(CornerBlocks.SNOWY_GLASS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(CornerBlocks.SNOWY_GLASS_SLAB.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(CornerBlocks.GAIA_DOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(CornerBlocks.GAIA_TRAPDOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(CornerBlocks.GAIA_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(CornerBlocks.POTTED_GAIA_SAPLING.get(), RenderType.cutout());
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
        event.registerEntityRenderer(CornerEntities.CRYSTALLINE_GUARDIAN.get(), net.ludocrypt.corners.client.render.entity.CrystallineGuardianRenderer::new);

        event.registerEntityRenderer(CornerEntities.THE_SWARMER.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_LURKER.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_HEAVY.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_SPITTER.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_SPECTRE.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_HUNTER.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_HORRORS.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_UNDEAD_WOLF.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_ROD.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_CLOGGER.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_PREGNANT.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_WHEEZER.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_LUMBER.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_SUCKER.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_BIG_SUCKER.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_FIRE_DUST.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.DEAD_CLOGGER.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.SLAVEMAN.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_MOONFLOWER.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_BEARTAMER.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_BIDY.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_BIDY_UPSIDE.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_DUNGEON.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_GLITER.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_IMMORTAL.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_ORDURE.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_POSESSIVE.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_RABIDUS.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_SKEEPER.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_SMOKER.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THE_SOMNOLENCE.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.RESTLESS_SPIRIT.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.DECREPIT_SKELETON.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.DECAYING_ZOMBIE.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.SKELETON_DEMOMAN.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.SKELETON_THRASHER.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.DARK_VORTEX.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.BONE_IMP.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.NIGHTMARE_STALKER.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.FALLEN_CHAOS_KNIGHT.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.MISSIONER.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.SEARED_SPIRIT.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.PHANTOM_CREEPER.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.CORPSE_FISH.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.MAGGOT.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.THORNSHELL_CRAB.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
        event.registerEntityRenderer(CornerEntities.DIRE_HOUND_LEADER.get(), net.minecraft.client.renderer.entity.ZombieRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CornerBoatEntityRenderer.getModelLayer(CornerBoat.GAIA, false), BoatModel::createBodyModel);
        event.registerLayerDefinition(CornerBoatEntityRenderer.getModelLayer(CornerBoat.GAIA, true), ChestBoatModel::createBodyModel);
        event.registerLayerDefinition(net.ludocrypt.corners.client.entity.corvus.CorvusEntityModel.LAYER_LOCATION, net.ludocrypt.corners.client.entity.corvus.CorvusEntityModel::createBodyLayer);
    }
}
