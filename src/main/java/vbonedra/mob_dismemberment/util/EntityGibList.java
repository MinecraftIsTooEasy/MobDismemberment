package vbonedra.mob_dismemberment.util;

import net.minecraft.*;
import vbonedra.mob_dismemberment.entity.*;

public class EntityGibList {

    public record GibData(Class<? extends EntityGibBase> gibClass, int[] validTypes, boolean hasBlood, float bloodR, float bloodG, float bloodB, int bloodAmountMultiplier, float bloodScale) {
    }

    public static GibData getGibData(EntityLivingBase living) {
        if (living == null) {
            return null;
        }

        Render renderer = RenderManager.instance.getEntityRenderObject(living);

        if (renderer == null) {
            return null;
        }

        // TODO: gibs must use parents scale, so Ghasts have matching size gibs and baby mobs drop small gibs, RenderGibBase must handle it
        // must be used in: baby mobs, ghast, wither skeleton, giant, arachnid, bat
        // TODO: blood must have loot table so its not just 1 size and color but multiple blood groups
        // TODO: fix ModelGibBat wingPacks
        // TODO: Horse is too complex
        Class<?> renderClass = renderer.getClass();
        if (renderClass == RenderBlaze.class) return new GibData(EntityGibBlaze.class, new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, false, 0.0F, 0.0F, 0.0F, 0, 1.2F);
        if (renderClass == RenderChicken.class) return new GibData(EntityGibChicken.class, new int[]{0, 1, 2, 3, 4, 5}, true, 1.0F, 0.0F, 0.0F, 1, 0.7F);
        if (renderClass == RenderPlayer.class) return new GibData(EntityGibHumanoidClassic.class, new int[]{0, 1, 2, 3, 4, 5}, true, 1.0F, 0.0F, 0.0F, 1, 1.2F);
        if (renderClass == RenderGhoul.class) return new GibData(EntityGibHumanoidClassic.class, new int[]{0, 1, 2, 3, 4, 5}, true, 0.5F, 0.0F, 0.0F, 1, 1.2F);
        if (renderClass == RenderWight.class) return new GibData(EntityGibHumanoidClassic.class, new int[]{0, 1, 2, 3, 4, 5}, true, 0.7F, 0.0F, 0.3F, 1, 1.2F);
//        if (renderClass == RenderShadow.class) return new GibData(EntityGibHumanoidClassic.class, new int[]{0, 1, 2, 3, 4, 5}, false, 0.0F, 0.0F, 0.0F, 2, 1.2F);
//        if (renderClass == RenderInvisibleStalker.class) return new GibData(EntityGibHumanoidClassic.class, new int[]{0, 1, 2, 3, 4, 5}, false, 0.0F, 0.0F, 0.0F, 0, 1.2F);
        if (renderClass == RenderSilverfish.class) return new GibData(EntityGibSilverfish.class, new int[]{0, 1, 2, 3, 4, 5, 6}, false, 0.0F, 0.0F, 0.0F, 0, 1.2F);
        if (renderClass == RenderSquid.class) return new GibData(EntityGibSquid.class, new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1}, true, 0.0F, 0.0F, 0.2F, 2, 1.2F);
        if (renderClass == RenderOcelot.class) return new GibData(EntityGibOcelot.class, new int[]{0, 1, 2, 3, 4, 5, 6}, true, 1.0F, 0.0F, 0.0F, 1, 0.7F);
        if (renderClass == RenderCow.class) return new GibData(EntityGibCow.class, new int[]{0, 1, 2, 3, 4, 5}, true, 1.0F, 0.0F, 0.0F, 2, 1.2F);
        if (renderClass == RenderMooshroom.class) return new GibData(EntityGibCow.class, new int[]{0, 1, 2, 3, 4, 5}, true, 1.0F, 0.0F, 0.0F, 2, 1.2F);
        if (renderClass == RenderCreeper.class) return new GibData(EntityGibCreeper.class, new int[]{0, 3, 6, 7, 8, 9}, true, 0.2F, 0.6F, 0.2F, 1, 1.2F);
        if (renderClass == RenderInfernalCreeper.class) return new GibData(EntityGibCreeper.class, new int[]{0, 3, 6, 7, 8, 9}, true, 0.6F, 0.2F, 0.2F, 1, 1.2F);
        if (renderClass == RenderWolf.class) return new GibData(EntityGibWolf.class, new int[]{0, 1, 2, 3, 4, 5, 6, 7}, true, 1.0F, 0.0F, 0.0F, 1, 1.2F);
        if (renderClass == RenderHellhound.class) return new GibData(EntityGibWolf.class, new int[]{0, 1, 2, 3, 4, 5, 6, 7}, true, 1.0F, 0.0F, 0.0F, 1, 1.2F);
        if (renderClass == RenderDireWolf.class) return new GibData(EntityGibWolf.class, new int[]{0, 1, 2, 3, 4, 5, 6, 7}, true, 1.0F, 0.0F, 0.0F, 1, 1.2F);
        if (renderClass == RenderEarthElemental.class) return new GibData(EntityGibEarthElemental.class, new int[]{0, 1, 2, 3, 4, 5}, false, 0.0F, 0.0F, 0.0F, 0, 1.2F);
        if (RenderEarthElemental.class.isAssignableFrom(renderClass)) return new GibData(EntityGibEarthElemental.class, new int[]{0, 1, 2, 3, 4, 5}, false, 0.0F, 0.0F, 0.0F, 0, 1.2F);
        if (renderClass == RenderEnderman.class) return new GibData(EntityGibEnderman.class, new int[]{0, 1, 2, 3, 4, 5}, true, 0.5F, 0.0F, 0.5F, 2, 1.2F);
        if (renderClass == RenderGhast.class) return new GibData(EntityGibGhast.class, new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, true, 0.9F, 0.9F, 0.9F, 3, 2.2F);
        if (renderClass == RenderPig.class) return new GibData(EntityGibPig.class, new int[]{0, 1, 2, 3, 4, 5}, true, 1.0F, 0.0F, 0.0F, 1, 1.2F);
        if (renderClass == RenderSheep.class) return new GibData(EntityGibSheep.class, new int[]{0, 1, 2, 3, 4, 5}, true, 1.0F, 0.0F, 0.0F, 1, 1.2F);
        if (renderClass == RenderSkeleton.class) return new GibData(EntityGibSkeleton.class, new int[]{0, 1, 2, 3, 4, 5}, false, 0.0F, 0.0F, 0.0F, 0, 1.2F);
        if (renderClass == RenderGelatinousCube.class) return new GibData(EntityGibGelatinousCube.class, new int[]{0, 1}, false, 0.0F, 0.0F, 0.0F, 2, 1.2F);
        if (renderClass == RenderMagmaCube.class) return new GibData(EntityGibMagmaCube.class, new int[]{0, 1, 2, 3, 4}, true, 0.8F, 0.3F, 0.0F, 2, 1.2F);
        if (renderClass == RenderSpider.class) return new GibData(EntityGibArachnid.class, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, true, 0.5F, 0.5F, 0.0F, 1, 1.2F);
        if (renderClass == RenderCaveSpider.class) return new GibData(EntityGibArachnid.class, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, true, 0.5F, 0.5F, 0.0F, 1, 1.2F);
        if (renderClass == RenderWoodSpider.class) return new GibData(EntityGibArachnid.class, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, true, 0.5F, 0.5F, 0.0F, 1, 1.2F);
        if (renderClass == RenderDemonSpider.class) return new GibData(EntityGibArachnid.class, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, true, 0.5F, 0.5F, 0.0F, 1, 1.2F);
        if (renderClass == RenderPhaseSpider.class) return new GibData(EntityGibArachnid.class, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, true, 0.5F, 0.5F, 0.0F, 1, 1.2F);
        if (renderClass == RenderBlackWidowSpider.class) return new GibData(EntityGibArachnid.class, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, true, 0.5F, 0.5F, 0.0F, 1, 1.2F);
        if (RenderArachnid.class.isAssignableFrom(renderClass)) return new GibData(EntityGibArachnid.class, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, true, 0.5F, 0.5F, 0.0F, 1, 1.2F);
        if (renderClass == RenderBat.class) return new GibData(EntityGibBat.class, new int[]{0, 1}, true, 1.0F, 0.0F, 0.0F, 1, 0.7F);
//        if (renderClass == RenderSnowMan.class) return new GibData(EntityGibSnowMan.class, new int[]{0, 1, 2, 3, 4, 5}, false, 0.0F, 0.0F, 0.0F, 0, 1.2F);
        if (renderClass == RenderZombie.class) return new GibData(EntityGibZombie.class, new int[]{0, 1, 2, 3, 4}, true, 0.9F, 0.0F, 0.1F, 1, 1.2F);
//        if (renderClass == RenderGiantZombie.class) return new GibData(EntityGibZombie.class, new int[]{0, 1, 2, 3, 4, 5}, true, 0.2F, 0.3F, 0.2F, 1, 1.2F);
        if (renderClass == RenderVillager.class) return new GibData(EntityGibVillager.class, new int[]{0, 1, 2, 3, 4, 5}, true, 1.0F, 0.0F, 0.0F, 1, 1.2F);
//        if (renderClass == RenderWither.class) return new GibData(EntityGibWither.class, new int[]{0, 1, 2, 3, 4}, false, 0.0F, 0.0F, 0.0F, 0, 1.2F);
        if (renderClass == RenderWitch.class) return new GibData(EntityGibWitch.class, new int[]{0, 1, 2, 3, 4, 5}, true, 1.0F, 0.0F, 0.0F, 1, 1.2F);
//        if (renderClass == RenderIronGolem.class) return new GibData(EntityGibIronGolem.class, new int[]{0, 1, 2, 3, 4, 5, 6}, false, 0.0F, 0.0F, 0.0F, 0, 1.2F);
//        if (renderClass == RenderHorse.class) return new GibData(EntityGibHorse.class, new int[]{0, 1, 2, 3, 4, 5, 6, 7}, true, 1.0F, 0.0F, 0.0F, 3, 1.2F);
//        if (renderClass == RenderDragon.class) return new GibData(EntityGibDragon.class, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}, true, 0.3F, 0.0F, 0.3F, 10, 2.2F);

        // TODO: add fallback meat clump gibs
        return null;
    }
}
