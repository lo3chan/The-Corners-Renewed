package net.ludocrypt.corners.client.entity.undead;

import net.ludocrypt.corners.TheCorners;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.model.GeoModel;

import java.util.Map;
import java.util.HashMap;

public class GenericGeoModel<T extends GeoEntity> extends GeoModel<T> {

    private final String id;
    private final String resolvedId;
    
    // Fallback dictionary for irregular namings
    private static final Map<String, String> MAPPINGS = Map.ofEntries(
        Map.entry("the_swarmer", "swarmer"),
        Map.entry("the_lurker", "lurker"),
        Map.entry("the_heavy", "zombiebruiser"),
        Map.entry("the_spitter", "spitter"),
        Map.entry("the_spectre", "spectre"),
        Map.entry("the_hunter", "thehunter"),
        Map.entry("the_horrors", "horror"),
        Map.entry("the_undead_wolf", "thewolf"),
        Map.entry("the_rod", "the_rod"),
        Map.entry("the_clogger", "clogger"),
        Map.entry("the_pregnant", "pregnant"),
        Map.entry("the_wheezer", "screamer"),
        Map.entry("the_lumber", "zombielumberjack"),
        Map.entry("the_sucker", "sucker"),
        Map.entry("the_big_sucker", "suckerboss"),
        Map.entry("the_fire_dust", "firelight"),
        Map.entry("dead_clogger", "clogger"),
        Map.entry("slaveman", "grappler"),
        Map.entry("the_moonflower", "moonflower"),
        Map.entry("the_beartamer", "thebear"),
        Map.entry("the_bidy", "bidy"),
        Map.entry("the_bidy_upside", "bidy"),
        Map.entry("the_dungeon", "thedugeon"),
        Map.entry("the_gliter", "gliter"),
        Map.entry("the_immortal", "immortal"),
        Map.entry("the_ordure", "ordure"),
        Map.entry("the_posessive", "the_possesive"),
        Map.entry("the_rabidus", "therabidus"),
        Map.entry("the_skeeper", "skeeper"),
        Map.entry("the_smoker", "corpsefly"),
        Map.entry("the_somnolence", "twicther"),
        Map.entry("restless_spirit", "restlessspirit"),
        Map.entry("decrepit_skeleton", "decrepitskeleton"),
        Map.entry("decaying_zombie", "rottenzombie"),
        Map.entry("skeleton_demoman", "thebomber"),
        Map.entry("skeleton_thrasher", "skeletonthrasher"),
        Map.entry("dark_vortex", "darkvortex"),
        Map.entry("bone_imp", "boneimp2"),
        Map.entry("nightmare_stalker", "nightmarestalker"),
        Map.entry("fallen_chaos_knight", "fallenchaosknight"),
        Map.entry("missioner", "missioner"),
        Map.entry("seared_spirit", "shyspirit"),
        Map.entry("phantom_creeper", "phantomcreeper"),
        Map.entry("corpse_fish", "corpsefish"),
        Map.entry("maggot", "maggot"),
        Map.entry("thornshell_crab", "thornshell"),
        Map.entry("dire_hound_leader", "direhoundleader")
    );

    public GenericGeoModel(String id) {
        this.id = id;
        this.resolvedId = MAPPINGS.getOrDefault(id, id.replace("the_", ""));
    }

    @Override
    public ResourceLocation getModelResource(T object) {
        return TheCorners.id("geo/" + resolvedId + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(T object) {
        return TheCorners.id("textures/entity/" + resolvedId + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(T object) {
        return TheCorners.id("animations/" + resolvedId + ".animation.json");
    }
}
