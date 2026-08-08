package vbonedra.mob_dismemberment.config;

import fi.dy.masa.malilib.config.ConfigTab;
import fi.dy.masa.malilib.config.SimpleConfigs;
import fi.dy.masa.malilib.config.options.*;

import java.util.ArrayList;
import java.util.List;

import static vbonedra.mob_dismemberment.MobDismembermentMod.MOD_NAME;

public class MDConfig extends SimpleConfigs {
    public static final ConfigInteger gibTime = new ConfigInteger("Gib Time", 1200, 0, 24000);
    public static final ConfigInteger gibGroundTime = new ConfigInteger("Gib Ground Time", 600, 0, 24000);
    public static final ConfigBoolean gibFadeoutTransparency = new ConfigBoolean("Gib Fadeout Transparency", true);
    public static final ConfigBoolean gibFadeoutScale = new ConfigBoolean("Gib Fadeout Scale", true);
    public static final ConfigBoolean gibFadeoutBlackout = new ConfigBoolean("Gib Fadeout Blackout", true);
    public static final ConfigBoolean blood = new ConfigBoolean("Blood", true);
    public static final ConfigInteger bloodTime = new ConfigInteger("Blood Time", 600, 0, 24000);
    public static final ConfigInteger bloodCount = new ConfigInteger("Blood Count", 250, 1, 1000);
    public static final ConfigDouble bloodScale = new ConfigDouble("Blood Scale", 1.0F, 0.0F, 10.0F);
    public static final ConfigBoolean greenBlood = new ConfigBoolean("Green Blood", false);
    public static final ConfigBoolean gibPushing = new ConfigBoolean("Gib Pushing", true);

    private static MDConfig Instance;
    public static final List<ConfigBase<?>> MainBase;
    public static final List<ConfigBase<?>> Total;
    public static final List<ConfigTab> tabs;

    public MDConfig(String name, List<ConfigHotkey> hotkeys, List<ConfigBase<?>> values) {
        super(name, hotkeys, values);
    }

    public List<ConfigTab> getConfigTabs() {
        return tabs;
    }

    public static MDConfig getInstance() {
        return Instance;
    }

    static {
        Total = new ArrayList<>();
        tabs = new ArrayList<>();
        MainBase = List.of(
                gibTime,
                gibGroundTime,
                gibFadeoutTransparency,
                gibFadeoutScale,
                gibFadeoutBlackout,
                gibPushing,
                blood,
                bloodTime,
                bloodCount,
                bloodScale,
                greenBlood
        );

        Total.addAll(MainBase);
        tabs.add(new ConfigTab(MOD_NAME, MainBase));
        Instance = new MDConfig(MOD_NAME, null, Total);
    }
}
