package vbonedra.mob_dismemberment.event;

import net.minecraft.Entity;
import net.minecraft.EntityLivingBase;
import net.minecraft.EntityCreeper;
import net.minecraft.EntityTNTPrimed;
import net.minecraft.EntityMinecartTNT;
import net.minecraft.EntityGelatinousCube;
import net.minecraft.EntityMagmaCube;
import net.minecraft.EntityVillager;
import net.minecraft.MathHelper;
import net.minecraft.Minecraft;
import net.minecraft.World;
import net.minecraft.WorldClient;
import vbonedra.mob_dismemberment.entity.EntityGibBase;
import vbonedra.mob_dismemberment.particle.ParticleBlood;
import vbonedra.mob_dismemberment.util.EntityGibList;
import vbonedra.mob_dismemberment.config.MDConfig;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class EventHandlerMain {
    public HashMap<EntityLivingBase, Integer> dismemberTimeout = new HashMap<>();
    public HashMap<Entity, Integer> exploTime = new HashMap<>();
    public ArrayList<Entity> explosionSources = new ArrayList<>();
    public int ticks = 0;

    public void onLivingDeath(EntityLivingBase entity) {
        if (!entity.isChild()) {
            if (entity instanceof EntityGelatinousCube && ((EntityGelatinousCube) entity).getSize() > 1) {
                return;
            }
            if (entity instanceof EntityMagmaCube && ((EntityMagmaCube) entity).getSize() > 1) {
                return;
            }
            if (entity instanceof EntityVillager && entity.worldObj != null) {
                if (entity.worldObj.difficultySetting == 0) {
                    return;
                }
                double searchRadius = 4.0D;
                List closeEntities = entity.worldObj.getEntitiesWithinAABBExcludingEntity(entity, entity.boundingBox.expand(searchRadius, searchRadius, searchRadius));
                if (closeEntities != null) {
                    List safeClose = new ArrayList<>(closeEntities);
                    for (Object obj : safeClose) {
                        if (obj != null && obj.getClass().getName().contains("Zombie")) {
                            return;
                        }
                    }
                }
            }
            EntityGibList.GibData data = EntityGibList.getGibData(entity);
            if (data != null && data.gibClass() != null) {
                this.dismemberTimeout.put(entity, 2);
            }
        }
    }

    public void worldTick() {
        this.ticks++;
        Minecraft mc = Minecraft.getMinecraft();
        if (mc.theWorld == null || mc.isGamePaused) {
            return;
        }
        WorldClient world = mc.theWorld;
        List<Entity> safeEntityList = new ArrayList<>(world.loadedEntityList);
        for (int i = 0; i < safeEntityList.size(); i++) {
            Entity ent = safeEntityList.get(i);
            if (ent == null) continue;
            if (ent instanceof EntityCreeper || ent instanceof EntityTNTPrimed || ent instanceof EntityMinecartTNT) {
                if (!this.explosionSources.contains(ent)) {
                    this.explosionSources.add(ent);
                }
            }
            if (ent instanceof EntityLivingBase living && !ent.isEntityAlive() && living.getHealth() <= 0.0F && !this.dismemberTimeout.containsKey(ent)) {
                if (!living.isChild()) {
                    if (living instanceof EntityGelatinousCube && ((EntityGelatinousCube) living).getSize() > 1) {
                        continue;
                    }
                    if (living instanceof EntityMagmaCube && ((EntityMagmaCube) living).getSize() > 1) {
                        continue;
                    }
                    if (living instanceof EntityVillager && living.worldObj != null) {
                        if (living.worldObj.difficultySetting == 0) {
                            continue;
                        }
                        double searchRadius = 4.0D;
                        List closeEntities = living.worldObj.getEntitiesWithinAABBExcludingEntity(living, living.boundingBox.expand(searchRadius, searchRadius, searchRadius));
                        boolean infected = false;
                        if (closeEntities != null) {
                            List safeClose = new ArrayList<>(closeEntities);
                            for (Object obj : safeClose) {
                                if (obj != null && obj.getClass().getName().contains("Zombie")) {
                                    infected = true;
                                    break;
                                }
                            }
                        }
                        if (infected) {
                            continue;
                        }
                    }
                    EntityGibList.GibData data = EntityGibList.getGibData(living);
                    if (data != null && data.gibClass() != null) {
                        this.dismemberTimeout.put(living, 2);
                    }
                }
            }
        }
        for (int i = this.explosionSources.size() - 1; i >= 0; i--) {
            Entity ent = this.explosionSources.get(i);
            if (ent.isDead) {
                if (ent instanceof EntityCreeper livingCreeper) {
                    int igniteTime = livingCreeper.getCreeperState();
                    int maxFuseTime = 30;
                    if (igniteTime >= maxFuseTime) {
                        if (!this.exploTime.containsKey(ent)) {
                            int time = this.ticks % 24000;
                            if (time > 23959) {
                                time -= 23999;
                            }
                            this.exploTime.put(ent, time);
                        }
                        this.dismemberTimeout.put(livingCreeper, 2);
                    }
                } else if (ent instanceof EntityTNTPrimed || ent instanceof EntityMinecartTNT) {
                    if (!this.exploTime.containsKey(ent)) {
                        int time = this.ticks % 24000;
                        if (time > 23959) {
                            time -= 23999;
                        }
                        this.exploTime.put(ent, time);
                    }
                }
                this.explosionSources.remove(i);
            }
        }
        Iterator<Entry<EntityLivingBase, Integer>> ite = this.dismemberTimeout.entrySet().iterator();
        while (ite.hasNext()) {
            Entry<EntityLivingBase, Integer> e = ite.next();
            e.setValue(e.getValue() - 1);
            e.getKey().hurtTime = 0;
            e.getKey().deathTime = 0;
            Entity explo = null;
            double dist = 1000.0D;
            List<Entry<Entity, Integer>> safeExploTime = new ArrayList<>(this.exploTime.entrySet());
            for (Entry<Entity, Integer> e1 : safeExploTime) {
                double mobDist = e1.getKey().getDistanceToEntity(e.getKey());
                if (mobDist < 10.0D && mobDist < dist) {
                    dist = mobDist;
                    explo = e1.getKey();
                    e.setValue(0);
                }
            }
            if (e.getValue() <= 0) {
                if (this.dismember(e.getKey().worldObj, e.getKey(), explo)) {
                    e.getKey().setDead();
                }
                ite.remove();
            }
        }
        Iterator<Entry<Entity, Integer>> ite1 = this.exploTime.entrySet().iterator();
        int worldTime = this.ticks % 24000;
        while (ite1.hasNext()) {
            Entry<Entity, Integer> e = ite1.next();
            if (e.getValue() + 40 < worldTime) {
                ite1.remove();
            }
        }
    }

    public boolean dismember(World world, EntityLivingBase living, Entity explo) {
        if (living.isChild()) {
            return false;
        }
        EntityGibList.GibData data = EntityGibList.getGibData(living);
        if (data == null || data.gibClass() == null) {
            return false;
        }
        try {
            Constructor<? extends EntityGibBase> constr = data.gibClass().getConstructor(World.class, EntityLivingBase.class, int.class, Entity.class);
            float targetYaw = living.prevRenderYawOffset;
            float targetPitch = 0.0F;
            for (int i : data.validTypes()) {
                EntityGibBase gib = constr.newInstance(world, living, i, explo);
                gib.rotationYaw = targetYaw;
                gib.prevRotationYaw = targetYaw;
                gib.rotationPitch = targetPitch;
                gib.prevRotationPitch = targetPitch;
                world.spawnEntityInWorld(gib);
            }
            if (data.hasBlood() && MDConfig.blood.getBooleanValue()) {
                int loopCount = explo != null ? MDConfig.bloodCount.getIntegerValue() * 10 : MDConfig.bloodCount.getIntegerValue();
                loopCount *= data.bloodAmountMultiplier();
                for (int k = 0; k < loopCount; k++) {
                    float var4 = 0.3F;
                    double mX = -MathHelper.sin(living.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(living.rotationPitch / 180.0F * (float)Math.PI) * var4;
                    double mZ = MathHelper.cos(living.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(living.rotationPitch / 180.0F * (float)Math.PI) * var4;
                    double mY = -MathHelper.sin(living.rotationPitch / 180.0F * (float)Math.PI) * var4 + 0.1F;
                    var4 = 0.02F;
                    float var5 = living.getRNG().nextFloat() * (float)Math.PI * 2.0F;
                    var4 *= living.getRNG().nextFloat();
                    if (explo != null) {
                        var4 *= 100.0F;
                    }
                    mX += Math.cos(var5) * (double)var4;
                    mY += (living.getRNG().nextFloat() - living.getRNG().nextFloat()) * 0.1F;
                    mZ += Math.sin(var5) * (double)var4;
                    ParticleBlood bloodFX = new ParticleBlood(living.worldObj, living.posX, living.posY + 0.5D + (living.getRNG().nextDouble() * 0.7D), living.posZ, living.motionX + mX, living.motionY + mY, living.motionZ + mZ, false);
                    bloodFX.setBloodColor(data.bloodR(), data.bloodG(), data.bloodB());
                    bloodFX.setBloodScale(data.bloodScale());
                    Minecraft.getMinecraft().effectRenderer.addEffect(bloodFX);
                }
            }
        } catch (Exception e) {
            vbonedra.mob_dismemberment.MobDismembermentMod.MDLOGGER.error("Failed to spawn gib!", e);
        }
        return true;
    }
}
