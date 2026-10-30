package io.github.tau34.mixin;

import io.github.tau34.config.ConfigLoader;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.LightmapRenderStateExtractor;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = LightmapRenderStateExtractor.class)
public class LightmapMixin {
    @Redirect(method = "extract", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;hasEffect(Lnet/minecraft/core/Holder;)Z"))
    private boolean redirectHasEffect(LocalPlayer instance, Holder<MobEffect> statusEffect) {
        return ConfigLoader.CONFIG.nightVision || instance.hasEffect(statusEffect);
    }
}
