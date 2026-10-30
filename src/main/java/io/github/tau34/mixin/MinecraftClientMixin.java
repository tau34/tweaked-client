package io.github.tau34.mixin;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import io.github.tau34.config.ConfigLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(Minecraft.class)
public class MinecraftClientMixin {
    @Inject(method = "shouldEntityAppearGlowing", at = @At("HEAD"), cancellable = true)
    private void getInstance(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        Identifier id = EntityType.getKey(entity.getType());
        List<String> outlineEntities = List.of(ConfigLoader.CONFIG.outlineEntities);
        if (outlineEntities.contains(id.getPath())) {
            cir.setReturnValue(true);
        }
    }
}
