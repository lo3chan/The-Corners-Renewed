package net.ludocrypt.corners.world.biome;

import net.ludocrypt.corners.init.CornerEntities;
import net.ludocrypt.corners.init.CornerSoundEvents;
import net.minecraft.core.HolderGetter;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class AbyssalChasmBiome {

	public static Biome create(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
		Biome.BiomeBuilder biome = new Biome.BiomeBuilder();

		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_SWARMER.get(), 90, 4, 8));

		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_LURKER.get(), 60, 1, 2));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_HEAVY.get(), 30, 1, 2));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_SPITTER.get(), 60, 2, 4));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_SPECTRE.get(), 40, 1, 3));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_HUNTER.get(), 50, 1, 2));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_HORRORS.get(), 15, 1, 1));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_UNDEAD_WOLF.get(), 70, 3, 5));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_ROD.get(), 50, 1, 3));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_CLOGGER.get(), 40, 1, 2));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_PREGNANT.get(), 45, 1, 2));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_WHEEZER.get(), 60, 2, 4));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_LUMBER.get(), 35, 1, 2));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_SUCKER.get(), 80, 3, 6));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_BIG_SUCKER.get(), 25, 1, 1));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_FIRE_DUST.get(), 50, 2, 4));



		BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(features, carvers);

		BiomeSpecialEffects.Builder biomeEffects = new BiomeSpecialEffects.Builder();
		biomeEffects.skyColor(0x050508);
		biomeEffects.waterColor(0x1a2b3c);
		biomeEffects.waterFogColor(0x081018);
		biomeEffects.fogColor(0x050508);
		biomeEffects.grassColorOverride(0x2a3828);
		biomeEffects.ambientLoopSound(net.minecraft.core.Holder.direct(CornerSoundEvents.BIOME_LOOP_THE_ABYSS.get()));

		BiomeSpecialEffects effects = biomeEffects.build();

		biome.mobSpawnSettings(spawnSettings.build());
		biome.generationSettings(generationSettings.build());
		biome.specialEffects(effects);
		biome.hasPrecipitation(false);
		biome.temperature(0.2F);
		biome.downfall(0.0F);

		return biome.build();
	}

}
