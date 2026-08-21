package net.ludocrypt.corners.datagen;

import net.ludocrypt.corners.TheCorners;

import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraft.data.PackOutput;
import org.dimdev.limlib.api.LimLibRegistryKeys;
import org.dimdev.limlib.api.effects.sound.SoundEffects;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.ImpossibleTrigger;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.dimension.LevelStem;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@EventBusSubscriber(modid = "corners", bus = EventBusSubscriber.Bus.MOD)
public class CornersDatagen {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        PackOutput packOutput = event.getGenerator().getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        event.getGenerator().addProvider(
                event.includeServer(),
                new DatapackBuiltinEntriesProvider(
                        packOutput,
                        lookupProvider,
                        new RegistrySetBuilder()
                                .add(SoundEffects.SOUND_EFFECTS_KEY, CornersDynamicRegistryProvider::soundEffects)
                                .add(LimLibRegistryKeys.SKYBOX, CornersDynamicRegistryProvider::skyboxes)
                                .add(LimLibRegistryKeys.DIMENSION_EFFECTS, CornersDynamicRegistryProvider::dimensionEffects)
                                .add(LimLibRegistryKeys.POST_EFFECT, CornersDynamicRegistryProvider::postEffects)
                                .add(Registries.CONFIGURED_FEATURE, CornersDynamicRegistryProvider::configuredFeature)
                                .add(Registries.BIOME, CornersDynamicRegistryProvider::biomes)
                                .add(Registries.PAINTING_VARIANT, CornersDynamicRegistryProvider::paintingVariants)
                                .add(Registries.DIMENSION_TYPE, CornersDynamicRegistryProvider::dimensionTypes)
                                .add(Registries.LEVEL_STEM, CornersDynamicRegistryProvider::levelStems),
                        Set.of("corners")
                )
        );
    }
}
