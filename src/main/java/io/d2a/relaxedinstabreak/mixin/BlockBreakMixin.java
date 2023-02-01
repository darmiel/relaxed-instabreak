package io.d2a.relaxedinstabreak.mixin;

import io.d2a.relaxedinstabreak.RelaxedInstabreakMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayerInteractionManager.class)
public abstract class BlockBreakMixin {

    protected boolean doCooldown() {
        final ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null) {
            return false;
        }
        return player.isSneaking() != RelaxedInstabreakMod.getConfig().isReversed();
    }

    @Accessor("blockBreakingCooldown")
    public abstract void setBlockBreakingCooldown(final int i);

    @Inject(method = "breakBlock", at = @At("RETURN"))
    private void updateBlockBreakingProgress(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (this.doCooldown()) {
            setBlockBreakingCooldown(RelaxedInstabreakMod.getConfig().getDelay());
        }
    }

}
