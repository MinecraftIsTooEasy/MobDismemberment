package vbonedra.mob_dismemberment;

import fi.dy.masa.malilib.config.ConfigManager;
import net.fabricmc.api.ClientModInitializer;
import net.xiaoyu233.fml.reload.event.MITEEvents;
import vbonedra.mob_dismemberment.config.MDConfig;
import vbonedra.mob_dismemberment.event.EventHandlerMain;

import net.xiaoyu233.fml.ModResourceManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vbonedra.mob_dismemberment.register.MobDismembermentRegistryInit;

public class MobDismembermentMod implements ClientModInitializer
{
    public static final String MOD_ID = "mob_dismemberment";
    public static final String MOD_NAME = "MobDismemberment";

    public static final Logger MDLOGGER = LogManager.getLogger(MOD_NAME);

    public static MobDismembermentMod instance;
    public static EventHandlerMain EventHandlerMain;


    @Override
    public void onInitializeClient() {
        instance = this;
        MDLOGGER.info("Initializing...");

        ModResourceManager.addResourcePackDomain(MOD_ID);


        // config
        MDConfig.getInstance().load();
        ConfigManager.getInstance().registerConfig(MDConfig.getInstance());

        // Handlers
        EventHandlerMain = new EventHandlerMain();


        MITEEvents.MITE_EVENT_BUS.register(new MobDismembermentRegistryInit());
    }

}
