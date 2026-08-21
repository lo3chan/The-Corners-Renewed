package net.ludocrypt.corners.init;

import net.ludocrypt.corners.TheCorners;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.bus.api.IEventBus;
import java.util.function.Supplier;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;

public class CornerSoundEvents {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, "corners");

    public static void register(IEventBus bus) {
        SOUND_EVENTS.register(bus);
    }

	// Misc
	public static final Supplier<SoundEvent> PAINTING_PORTAL_TRAVEL = SOUND_EVENTS.register("misc.portal.painting.travel", () -> SoundEvent.createVariableRangeEvent(TheCorners.id("misc.portal.painting.travel")));
	// Music
	public static final Supplier<SoundEvent> MUSIC_YEARNING_CANAL = SOUND_EVENTS.register("music.yearning_canal", () -> SoundEvent.createVariableRangeEvent(TheCorners.id("music.yearning_canal")));
	public static final Supplier<SoundEvent> MUSIC_COMMUNAL_CORRIDORS = SOUND_EVENTS.register("music.communal_corridors", () -> SoundEvent.createVariableRangeEvent(TheCorners.id("music.communal_corridors")));
	public static final Supplier<SoundEvent> MUSIC_COMMUNAL_CORRIDORS_CHRISTMAS = SOUND_EVENTS.register(
		"music.communal_corridors.christmas", () -> SoundEvent.createVariableRangeEvent(TheCorners.id(
		"music.communal_corridors.christmas")));
	public static final Supplier<SoundEvent> MUSIC_HOARY_CROSSROADS = SOUND_EVENTS.register("music.hoary_crossroads", () -> SoundEvent.createVariableRangeEvent(TheCorners.id("music.hoary_crossroads")));
	// Radio
	public static final Supplier<SoundEvent> RADIO_DEFAULT_STATIC = SOUND_EVENTS.register("radio.default.static", () -> SoundEvent.createVariableRangeEvent(TheCorners.id("radio.default.static")));
	public static final Supplier<SoundEvent> RADIO_YEARNING_CANAL = SOUND_EVENTS.register("radio.yearning_canal", () -> SoundEvent.createVariableRangeEvent(TheCorners.id("radio.yearning_canal")));
	public static final Supplier<SoundEvent> RADIO_COMMUNAL_CORRIDORS = SOUND_EVENTS.register("radio.communal_corridors", () -> SoundEvent.createVariableRangeEvent(TheCorners.id("radio.communal_corridors")));
	public static final Supplier<SoundEvent> RADIO_HOARY_CROSSROADS = SOUND_EVENTS.register("radio.hoary_crossroads", () -> SoundEvent.createVariableRangeEvent(TheCorners.id("radio.hoary_crossroads")));
	public static final Supplier<SoundEvent> RADIO_YEARNING_CANAL_STATIC = SOUND_EVENTS.register("radio.yearning_canal.static", () -> SoundEvent.createVariableRangeEvent(TheCorners.id("radio.yearning_canal.static")));
	public static final Supplier<SoundEvent> RADIO_COMMUNAL_CORRIDORS_STATIC = SOUND_EVENTS.register(
		"radio.communal_corridors.static", () -> SoundEvent.createVariableRangeEvent(TheCorners.id(
		"radio.communal_corridors.static")));
	public static final Supplier<SoundEvent> RADIO_HOARY_CROSSROADS_STATIC = SOUND_EVENTS.register("radio.hoary_crossroads.static", () -> SoundEvent.createVariableRangeEvent(TheCorners.id("radio.hoary_crossroads.static")));
	public static final Supplier<SoundEvent> RADIO_YEARNING_CANAL_MUSIC = SOUND_EVENTS.register("radio.yearning_canal.music", () -> SoundEvent.createVariableRangeEvent(TheCorners.id("radio.yearning_canal.music")));
	public static final Supplier<SoundEvent> RADIO_COMMUNAL_CORRIDORS_MUSIC = SOUND_EVENTS.register("radio.communal_corridors.music", () -> SoundEvent.createVariableRangeEvent(TheCorners.id("radio.communal_corridors.music")));
	public static final Supplier<SoundEvent> RADIO_HOARY_CROSSROADS_MUSIC = SOUND_EVENTS.register("radio.hoary_crossroads.music", () -> SoundEvent.createVariableRangeEvent(TheCorners.id("radio.hoary_crossroads.music")));
	// Ambient
	public static final Supplier<SoundEvent> BIOME_LOOP_COMMUNAL_CORRIDORS = SOUND_EVENTS.register("biome.communal_corridors.loop", () -> SoundEvent.createVariableRangeEvent(TheCorners.id("biome.communal_corridors.loop")));
	public static final Supplier<SoundEvent> BIOME_LOOP_HOARY_CROSSROADS = SOUND_EVENTS.register("biome.hoary_crossroads.loop", () -> SoundEvent.createVariableRangeEvent(TheCorners.id("biome.hoary_crossroads.loop")));





}
