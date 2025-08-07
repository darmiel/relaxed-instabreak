package io.d2a.relaxedinstabreak.mixin;

import io.d2a.relaxedinstabreak.RelaxedInstabreakMod;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayerInteractionManager.class)
public abstract class BlockBreakMixin {

    @Accessor("blockBreakingCooldown")
    public abstract void setBlockBreakingCooldown(final int i);

    @Inject(method = "breakBlock", at = @At("RETURN"))
    private void updateBlockBreakingProgress(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (RelaxedInstabreakMod.isRelaxingBehaviorEnabled()) {
            setBlockBreakingCooldown(RelaxedInstabreakMod.getConfig().getDelay());
        }
    }

}
