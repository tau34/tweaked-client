package io.github.tau34.mixin;

import io.github.tau34.config.ConfigLoader;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
	@Inject(method = "nightVisionScale", at = @At("HEAD"), cancellable = true)
    private static void modifyNightVision(LivingEntity camera, float a, CallbackInfoReturnable<Float> cir) {
		if (ConfigLoader.CONFIG.nightVision) cir.setReturnValue(1.0f);
	}
}
