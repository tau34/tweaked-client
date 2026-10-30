package io.github.tau34.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import io.github.tau34.config.ConfigLoader;
import net.minecraft.client.renderer.SubmitNodeCollection;
import net.minecraft.client.renderer.SubmitNodeStorage;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(SubmitNodeStorage.class)
public abstract class SubmitNodeStorageMixin {
    @Shadow
    protected abstract SubmitNodeCollection order(int order);

    @Inject(method = "submitNameTag", at = @At("HEAD"), cancellable = true)
    private void getInstance(PoseStack poseStack, @Nullable Vec3 nameTagAttachment, int offset,
                             Component name, boolean seeThrough, int lightCoords, CameraRenderState camera,
                             CallbackInfo ci) {
        if (!ConfigLoader.CONFIG.playerTag) return;
        this.order(0).submitNameTag(poseStack, nameTagAttachment, offset, name, true, lightCoords, camera);
        ci.cancel();
    }
}
