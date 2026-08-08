package vbonedra.mob_dismemberment.mixin;

import vbonedra.mob_dismemberment.MobDismembermentMod;
import net.minecraft.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Inject(method = "runTick", at = @At("RETURN"))
    private void injectRunTick(CallbackInfo ci) {
        if (MobDismembermentMod.EventHandlerClient != null) {
            MobDismembermentMod.EventHandlerClient.worldTick();
        }
    }
}
