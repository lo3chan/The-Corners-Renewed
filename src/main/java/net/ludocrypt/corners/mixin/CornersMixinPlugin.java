package net.ludocrypt.corners.mixin;

import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public final class CornersMixinPlugin implements IMixinConfigPlugin {

    private boolean irisLoaded;

    @Override
    public void onLoad(String mixinPackage) {
        irisLoaded = net.neoforged.fml.ModList.get().isLoaded("iris");
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }


@Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.contains("client.") || mixinClassName.contains("MinecraftClientMixin") || mixinClassName.contains("LevelRendererMixin") || mixinClassName.contains("SectionCompilerMixin") || mixinClassName.contains("RenderTypeMixin") || mixinClassName.contains("SoundManagerAccessor") || mixinClassName.contains("MusicTrackerMixin") || mixinClassName.contains("BlockModelDeserializerMixin") || mixinClassName.contains("BlockModelMixin") || mixinClassName.contains("FrustumAccessor") || mixinClassName.contains("GameRendererAccessor") || mixinClassName.contains("MultiPartBakedModelAccessor") || mixinClassName.contains("ShaderInstanceMixin") || mixinClassName.contains("SimpleBakedModelMixin") || mixinClassName.contains("WeightedBakedModelAccessor") || mixinClassName.contains("WorldRendererAccessor") || mixinClassName.contains("BackgroundRendererMixin")) {
            return net.neoforged.fml.loading.FMLEnvironment.dist.isClient();
        }
        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }
}
