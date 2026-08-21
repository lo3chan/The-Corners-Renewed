package net.ludocrypt.corners.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.ludocrypt.corners.config.CornerConfig;
import net.ludocrypt.corners.init.CornerSoundEvents;
import net.ludocrypt.corners.init.CornerWorlds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.sounds.Music;

@Mixin(Minecraft.class)
public class MinecraftClientMixin {

	@Shadow
	public LocalPlayer player;
	@Shadow
	public ClientLevel level;

	@Inject(method = "getSituationalMusic", at = @At("HEAD"), cancellable = true)
	private void corners$getMusic(CallbackInfoReturnable<Music> ci) {

		if (this.player != null && this.level != null) {

			if (this.level.dimension().equals(CornerWorlds.COMMUNAL_CORRIDORS_KEY)) {

				if (CornerConfig.get().christmas.isChristmas()) {
					ci
						.setReturnValue(
							new Music(net.minecraft.core.Holder.direct(CornerSoundEvents.MUSIC_COMMUNAL_CORRIDORS_CHRISTMAS.get()), 3000, 8000, true));
				} else {
					ci.setReturnValue(new Music(net.minecraft.core.Holder.direct(CornerSoundEvents.MUSIC_COMMUNAL_CORRIDORS.get()), 3000, 8000, true));
				}

			}

		}

	}

}
