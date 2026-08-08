package vbonedra.mob_dismemberment.mixin;

import vbonedra.mob_dismemberment.MobDismembermentMod;
import net.minecraft.EntityLivingBase;
import net.minecraft.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityLivingBase.class)
public class EntityLivingBaseMixin {
    @Inject(method = "onDeath", at = @At("HEAD"))
    private void injectOnDeath(DamageSource source, CallbackInfo ci) {
        EntityLivingBase entity = (EntityLivingBase) (Object) this;
        if (entity.worldObj != null && entity.worldObj.isWorldClient()) {
            if (MobDismembermentMod.EventHandlerClient != null) {
                MobDismembermentMod.EventHandlerClient.onLivingDeath(entity);
            }
        }
    }
}
