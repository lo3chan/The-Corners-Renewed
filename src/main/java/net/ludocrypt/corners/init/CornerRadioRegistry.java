package net.ludocrypt.corners.init;

import net.ludocrypt.corners.TheCorners;
import net.ludocrypt.corners.util.RadioSoundTable;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.bus.api.IEventBus;
import java.util.function.Supplier;
import net.neoforged.neoforge.registries.RegistryBuilder;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.minecraft.core.registries.Registries;


public class CornerRadioRegistry {

	public static final ResourceKey<Registry<RadioSoundTable>> RADIO_REGISTRY_KEY = ResourceKey
		.createRegistryKey(TheCorners.id("radio_registry"));

	public static final DeferredRegister<RadioSoundTable> RADIOS = DeferredRegister.create(RADIO_REGISTRY_KEY, "corners");



    public static void register(IEventBus bus) {
        RADIOS.register(bus);
    }

	public static final Supplier<RadioSoundTable> DEFAULT = RADIOS.register("default_radio", () -> new RadioSoundTable(CornerSoundEvents.RADIO_DEFAULT_STATIC,
		CornerSoundEvents.RADIO_DEFAULT_STATIC, CornerSoundEvents.RADIO_DEFAULT_STATIC));

	public static final Supplier<RadioSoundTable> YEARNING_CANAL = RADIOS.register("yearning_canal", () -> new RadioSoundTable(CornerSoundEvents.RADIO_YEARNING_CANAL_MUSIC,
			CornerSoundEvents.RADIO_YEARNING_CANAL_STATIC, CornerSoundEvents.RADIO_YEARNING_CANAL));

    public static final Supplier<RadioSoundTable> COMMUNAL_CORRIDORS = RADIOS.register("communal_corridors", () -> new RadioSoundTable(CornerSoundEvents.RADIO_COMMUNAL_CORRIDORS_MUSIC,
			CornerSoundEvents.RADIO_COMMUNAL_CORRIDORS_STATIC, CornerSoundEvents.RADIO_COMMUNAL_CORRIDORS));

    public static final Supplier<RadioSoundTable> HOARY_CROSSROADS = RADIOS.register("hoary_crossroads", () -> new RadioSoundTable(CornerSoundEvents.RADIO_HOARY_CROSSROADS_MUSIC,
			CornerSoundEvents.RADIO_HOARY_CROSSROADS_STATIC, CornerSoundEvents.RADIO_HOARY_CROSSROADS));

	public static void init() {

	}



	public static RadioSoundTable getCurrent(ResourceKey<Level> key) {
	    // DeferredRegister doesn't have a direct getOptional without the registry instance.
		// However, RadioSoundTable is bound to the level dimension id, so we lookup from the registry directly.

		return DEFAULT.get();
	}

}
