package vbonedra.mob_dismemberment.register;

import net.xiaoyu233.fml.reload.event.EntityRendererRegistryEvent;
import net.minecraft.ResourceLocation;
import vbonedra.mob_dismemberment.entity.*;
import vbonedra.mob_dismemberment.model.*;
import vbonedra.mob_dismemberment.render.RenderGibBase;
import vbonedra.mob_dismemberment.render.RenderGibBlaze;
import vbonedra.mob_dismemberment.render.RenderGibGhast;
import vbonedra.mob_dismemberment.render.RenderGibMagmaCube;

import static vbonedra.mob_dismemberment.MobDismembermentMod.MDLOGGER;

public class MDEntityRenderer {
    public static void register(EntityRendererRegistryEvent registry) {
        MDLOGGER.info("Registering entity renderers!");
        registry.register(EntityGibHumanoidClassic.class, new RenderGibBase(new ModelGibHumanoidClassic(), new ResourceLocation("textures/entity/zombie/zombie.png")));
        registry.register(EntityGibCow.class, new RenderGibBase(new ModelGibCow(), new ResourceLocation("textures/entity/cow/cow.png")));
        registry.register(EntityGibCreeper.class, new RenderGibBase(new ModelGibCreeper(), new ResourceLocation("textures/entity/creeper/creeper.png")));
        registry.register(EntityGibWolf.class, new RenderGibBase(new ModelGibWolf(), new ResourceLocation("textures/entity/wolf/wolf.png")));
        registry.register(EntityGibEarthElemental.class, new RenderGibBase(new ModelGibHumanoidClassic(), new ResourceLocation("textures/entity/zombie/zombie.png")));
        registry.register(EntityGibGelatinousCube.class, new RenderGibBase(new ModelGibGelatinousCube(), new ResourceLocation("textures/entity/slime/slime.png")));
        registry.register(EntityGibBlaze.class, new RenderGibBlaze());
        registry.register(EntityGibChicken.class, new RenderGibBase(new ModelGibChicken(), new ResourceLocation("textures/entity/chicken.png")));
        registry.register(EntityGibSilverfish.class, new RenderGibBase(new ModelGibSilverfish(), new ResourceLocation("textures/entity/silverfish.png")));
        registry.register(EntityGibSquid.class, new RenderGibBase(new ModelGibSquid(), new ResourceLocation("textures/entity/squid.png")));
        registry.register(EntityGibOcelot.class, new RenderGibBase(new ModelGibOcelot(), new ResourceLocation("textures/entity/cat/ocelot.png")));
        registry.register(EntityGibEnderman.class, new RenderGibBase(new ModelGibEnderman(), new ResourceLocation("textures/entity/enderman/enderman.png")));
        registry.register(EntityGibGhast.class, new RenderGibGhast(new ModelGibGhast(), new ResourceLocation("textures/entity/ghast/ghast.png")));
        registry.register(EntityGibPig.class, new RenderGibBase(new ModelGibPig(), new ResourceLocation("textures/entity/pig/pig.png")));
        registry.register(EntityGibSheep.class, new RenderGibBase(new ModelGibSheep(), new ResourceLocation("textures/entity/sheep/sheep.png")));
        registry.register(EntityGibSkeleton.class, new RenderGibBase(new ModelGibSkeleton(), new ResourceLocation("textures/entity/skeleton/skeleton.png")));
        registry.register(EntityGibMagmaCube.class, new RenderGibMagmaCube());
        registry.register(EntityGibArachnid.class, new RenderGibBase(new ModelGibArachnid(), new ResourceLocation("textures/entity/spider/spider.png")));
        registry.register(EntityGibBat.class, new RenderGibBase(new ModelGibBat(), new ResourceLocation("textures/entity/bat.png")));
//        registry.register(EntityGibSnowMan.class, new RenderGibBase(new ModelGibSnowMan(), new ResourceLocation("textures/entity/snowman.png")));
        registry.register(EntityGibVillager.class, new RenderGibBase(new ModelGibVillager(), new ResourceLocation("textures/entity/villager/villager.png")));
//        registry.register(EntityGibWither.class, new RenderGibBase(new ModelGibWither(), new ResourceLocation("textures/entity/wither/wither.png")));
        registry.register(EntityGibZombieVillager.class, new RenderGibBase(new ModelGibZombieVillager(), new ResourceLocation("textures/entity/zombie/villager.png")));
        registry.register(EntityGibZombie.class, new RenderGibBase(new ModelGibZombie(), new ResourceLocation("textures/entity/zombie/zombie.png")));
        registry.register(EntityGibWitch.class, new RenderGibBase(new ModelGibWitch(), new ResourceLocation("textures/entity/witch.png")));
//        registry.register(EntityGibIronGolem.class, new RenderGibBase(new ModelGibIronGolem(), new ResourceLocation("textures/entity/iron_golem.png")));
//        registry.register(EntityGibHorse.class, new RenderGibBase(new ModelGibHorse(), new ResourceLocation("textures/entity/horse/horse.png")));
//        registry.register(EntityGibDragon.class, new RenderGibBase(new ModelGibDragon(), new ResourceLocation("textures/entity/enderdragon/dragon.png")));
    }
}
