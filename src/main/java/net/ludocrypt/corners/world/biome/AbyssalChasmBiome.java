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
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_FIRE_DUST.get(), 50, 2, 4));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.DEAD_CLOGGER.get(), 30, 1, 2));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.SLAVEMAN.get(), 40, 2, 4));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_MOONFLOWER.get(), 35, 1, 2));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_BEARTAMER.get(), 20, 1, 1));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_BIDY.get(), 75, 3, 6));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_BIDY_UPSIDE.get(), 75, 3, 6));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_DUNGEON.get(), 15, 1, 1));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_GLITER.get(), 30, 1, 3));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_IMMORTAL.get(), 10, 1, 1));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_ORDURE.get(), 45, 2, 4));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_POSESSIVE.get(), 25, 1, 2));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_RABIDUS.get(), 50, 2, 4));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_SKEEPER.get(), 45, 2, 4));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_SMOKER.get(), 55, 2, 4));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THE_SOMNOLENCE.get(), 30, 1, 2));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.RESTLESS_SPIRIT.get(), 40, 1, 3));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.DECREPIT_SKELETON.get(), 60, 2, 4));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.DECAYING_ZOMBIE.get(), 70, 2, 5));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.SKELETON_DEMOMAN.get(), 35, 1, 2));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.SKELETON_THRASHER.get(), 20, 1, 2));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.DARK_VORTEX.get(), 15, 1, 1));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.BONE_IMP.get(), 80, 3, 6));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.NIGHTMARE_STALKER.get(), 20, 1, 1));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.FALLEN_CHAOS_KNIGHT.get(), 15, 1, 2));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.MISSIONER.get(), 25, 1, 2));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.SEARED_SPIRIT.get(), 35, 1, 3));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.PHANTOM_CREEPER.get(), 25, 1, 2));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.CORPSE_FISH.get(), 70, 4, 8));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.MAGGOT.get(), 90, 4, 10));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.THORNSHELL_CRAB.get(), 40, 2, 4));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CornerEntities.DIRE_HOUND_LEADER.get(), 30, 1, 2));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(net.minecraft.world.entity.EntityType.SPIDER, 65, 2, 4));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(net.minecraft.world.entity.EntityType.CAVE_SPIDER, 85, 3, 6));





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
