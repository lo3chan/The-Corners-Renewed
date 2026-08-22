package net.ludocrypt.corners.client.entity.undead;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import net.minecraft.world.entity.Mob;

public class GenericGeoRenderer<T extends Mob & GeoEntity> extends GeoEntityRenderer<T> {
    public GenericGeoRenderer(EntityRendererProvider.Context context, String id) {
        super(context, new GenericGeoModel<>(id));
    }
}
