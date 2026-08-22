package net.ludocrypt.corners.util;

import java.util.function.Supplier;
import net.minecraft.sounds.SoundEvent;

public class RadioSoundTable {

	private final Supplier<SoundEvent> musicSound;
	private final Supplier<SoundEvent> staticSound;
	private final Supplier<SoundEvent> radioSound;

	public RadioSoundTable(Supplier<SoundEvent> musicSound, Supplier<SoundEvent> staticSound,
			Supplier<SoundEvent> radioSound) {
		this.musicSound = musicSound;
		this.staticSound = staticSound;
		this.radioSound = radioSound;
	}

	public Supplier<SoundEvent> getMusicSound() {
		return musicSound;
	}

	public Supplier<SoundEvent> getStaticSound() {
		return staticSound;
	}

	public Supplier<SoundEvent> getRadioSound() {
		return radioSound;
	}

}
