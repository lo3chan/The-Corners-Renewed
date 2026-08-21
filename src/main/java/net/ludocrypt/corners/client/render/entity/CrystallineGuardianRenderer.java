package net.ludocrypt.corners.client.render.entity;

import net.ludocrypt.corners.TheCorners;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.GuardianRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Guardian;

public class CrystallineGuardianRenderer extends GuardianRenderer {

    private static final ResourceLocation TEXTURE = TheCorners.id("textures/entity/crystalline_guardian.png");

    public CrystallineGuardianRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(Guardian entity) {
        return TEXTURE;
    }
}
