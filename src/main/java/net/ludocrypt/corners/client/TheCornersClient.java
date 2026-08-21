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
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CornerBoatEntityRenderer.getModelLayer(CornerBoat.GAIA, false), BoatModel::createBodyModel);
        event.registerLayerDefinition(CornerBoatEntityRenderer.getModelLayer(CornerBoat.GAIA, true), ChestBoatModel::createBodyModel);
    }
}
