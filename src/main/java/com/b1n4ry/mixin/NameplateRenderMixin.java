package com.b1n4ry.mixin;

import com.b1n4ry.client.NicknamedClient;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(PlayerEntityRenderer.class)
public abstract class NameplateRenderMixin {
    @ModifyVariable(at = @At("HEAD"), method = "renderLabelIfPresent(Lnet/minecraft/client/network/AbstractClientPlayerEntity;Lnet/minecraft/text/Text;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V", argsOnly = true)
    private Text injected(Text text) {
        if(NicknamedClient.isEnabled()) return Text.of(NicknamedClient.getNick());
        return text;
    }
}