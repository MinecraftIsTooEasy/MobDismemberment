package vbonedra.mob_dismemberment.register;

import net.xiaoyu233.fml.reload.event.EntityRegisterEvent;
import net.xiaoyu233.fml.reload.utils.IdUtil;
import vbonedra.mob_dismemberment.MobDismembermentMod;
import vbonedra.mob_dismemberment.entity.*;
import static vbonedra.mob_dismemberment.MobDismembermentMod.MDLOGGER;

public class MDEntity {
    public static void register(EntityRegisterEvent registry) {
        MDLOGGER.info("Registering entities!");
        registry.register(EntityGibHumanoidClassic.class, MobDismembermentMod.MOD_ID, "EntityGibHumanoidClassic", IdUtil.getNextEntityID());
        registry.register(EntityGibCow.class, MobDismembermentMod.MOD_ID, "EntityGibCow", IdUtil.getNextEntityID());
        registry.register(EntityGibCreeper.class, MobDismembermentMod.MOD_ID, "EntityGibCreeper", IdUtil.getNextEntityID());
        registry.register(EntityGibWolf.class, MobDismembermentMod.MOD_ID, "EntityGibWolf", IdUtil.getNextEntityID());
        registry.register(EntityGibEarthElemental.class, MobDismembermentMod.MOD_ID, "EntityGibEarthElemental", IdUtil.getNextEntityID());
        registry.register(EntityGibGelatinousCube.class, MobDismembermentMod.MOD_ID, "EntityGibGelatinousCube", IdUtil.getNextEntityID());
        registry.register(EntityGibBlaze.class, MobDismembermentMod.MOD_ID, "EntityGibBlaze", IdUtil.getNextEntityID());
        registry.register(EntityGibChicken.class, MobDismembermentMod.MOD_ID, "EntityGibChicken", IdUtil.getNextEntityID());
        registry.register(EntityGibSilverfish.class, MobDismembermentMod.MOD_ID, "EntityGibSilverfish", IdUtil.getNextEntityID());
        registry.register(EntityGibSquid.class, MobDismembermentMod.MOD_ID, "EntityGibSquid", IdUtil.getNextEntityID());
        registry.register(EntityGibOcelot.class, MobDismembermentMod.MOD_ID, "EntityGibOcelot", IdUtil.getNextEntityID());
        registry.register(EntityGibEnderman.class, MobDismembermentMod.MOD_ID, "EntityGibEnderman", IdUtil.getNextEntityID());
        registry.register(EntityGibGhast.class, MobDismembermentMod.MOD_ID, "EntityGibGhast", IdUtil.getNextEntityID());
        registry.register(EntityGibPig.class, MobDismembermentMod.MOD_ID, "EntityGibPig", IdUtil.getNextEntityID());
        registry.register(EntityGibSheep.class, MobDismembermentMod.MOD_ID, "EntityGibSheep", IdUtil.getNextEntityID());
        registry.register(EntityGibSkeleton.class, MobDismembermentMod.MOD_ID, "EntityGibSkeleton", IdUtil.getNextEntityID());
        registry.register(EntityGibMagmaCube.class, MobDismembermentMod.MOD_ID, "EntityGibMagmaCube", IdUtil.getNextEntityID());
        registry.register(EntityGibArachnid.class, MobDismembermentMod.MOD_ID, "EntityGibArachnid", IdUtil.getNextEntityID());
        registry.register(EntityGibBat.class, MobDismembermentMod.MOD_ID, "EntityGibBat", IdUtil.getNextEntityID());
//        registry.register(EntityGibSnowMan.class, MobDismembermentMod.MOD_ID, "EntityGibSnowMan", IdUtil.getNextEntityID());
        registry.register(EntityGibVillager.class, MobDismembermentMod.MOD_ID, "EntityGibVillager", IdUtil.getNextEntityID());
//        registry.register(EntityGibWither.class, MobDismembermentMod.MOD_ID, "EntityGibWither", IdUtil.getNextEntityID());
        registry.register(EntityGibZombie.class, MobDismembermentMod.MOD_ID, "EntityGibZombie", IdUtil.getNextEntityID());
        registry.register(EntityGibWitch.class, MobDismembermentMod.MOD_ID, "EntityGibWitch", IdUtil.getNextEntityID());
//        registry.register(EntityGibIronGolem.class, MobDismembermentMod.MOD_ID, "EntityGibIronGolem", IdUtil.getNextEntityID());
//        registry.register(EntityGibHorse.class, MobDismembermentMod.MOD_ID, "EntityGibHorse", IdUtil.getNextEntityID());
//        registry.register(EntityGibDragon.class, MobDismembermentMod.MOD_ID, "EntityGibDragon", IdUtil.getNextEntityID());
    }
}
