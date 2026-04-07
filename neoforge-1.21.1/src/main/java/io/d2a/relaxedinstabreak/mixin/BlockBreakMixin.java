package io.d2a.relaxedinstabreak.mixin;

import io.d2a.relaxedinstabreak.RelaxedBehavior;
import io.d2a.relaxedinstabreak.config.RelaxedConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MultiPlayerGameMode.class)
public abstract class BlockBreakMixin {

    @Shadow
    private int destroyDelay;

    @Inject(method = "destroyBlock", at = @At("RETURN"))
    private void relaxedinstabreak$onBlockBreak(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        LocalPlayer player = Minecraft.getInstance().player;
        boolean sneaking = player != null && player.isCrouching();
        if (RelaxedBehavior.isEnabled(RelaxedConfig.alwaysEnabled(), RelaxedConfig.isReversed(), sneaking)) {
            this.destroyDelay = RelaxedConfig.getDelay();
        }
    }
}
