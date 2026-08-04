package vbonedra.mob_dismemberment.register;

import com.google.common.eventbus.Subscribe;
import moddedmite.rustedironcore.api.event.Handlers;
import net.xiaoyu233.fml.reload.event.EntityRegisterEvent;
import net.xiaoyu233.fml.reload.event.EntityRendererRegistryEvent;

public class MobDismembermentRegistryInit extends Handlers {
    @Subscribe
    public void onEntityRegister(EntityRegisterEvent event) {
        MDEntity.register(event);
    }

    @Subscribe
    public void onEntityRendererRegister(EntityRendererRegistryEvent event) {
        MDEntityRenderer.register(event);
    }
}
