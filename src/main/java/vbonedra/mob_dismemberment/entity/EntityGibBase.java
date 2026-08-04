package vbonedra.mob_dismemberment.entity;

import net.minecraft.Entity;
import net.minecraft.EntityLivingBase;
import net.minecraft.EntityMinecartTNT;
import net.minecraft.EntityTNTPrimed;
import net.minecraft.NBTTagCompound;
import net.minecraft.World;
import vbonedra.mob_dismemberment.config.MDConfig;

import java.util.List;

public abstract class EntityGibBase extends Entity {
    public EntityLivingBase parent;
    public int type;
    public float pitchSpin;
    public float yawSpin;
    public int groundTime;
    public int liveTime;
    public boolean explosion;

    public EntityGibBase(World world) {
        super(world);
        this.parent = null;
        this.type = 0;
        this.groundTime = 0;
        this.liveTime = 0;
        this.ignoreFrustumCheck = true;
    }

    public EntityGibBase(World world, EntityLivingBase gibParent, int gibType, Entity explosion_source, float widthSize, float heightSize, double yOffset) {
        this(world);
        this.parent = gibParent;
        this.type = gibType;
        this.setSize(widthSize, heightSize);

        this.setLocationAndAngles(parent.posX, parent.boundingBox.minY + yOffset, parent.posZ, parent.rotationYaw, parent.rotationPitch);
        this.rotationYaw = parent.prevRenderYawOffset;
        this.rotationPitch = 0.0F;
        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;

        this.motionX = parent.motionX + (this.rand.nextDouble() - this.rand.nextDouble()) * 0.25D;
        this.motionY = parent.motionY;
        this.motionZ = parent.motionZ + (this.rand.nextDouble() - this.rand.nextDouble()) * 0.25D;

        float i = this.rand.nextInt(45) + 5F + this.rand.nextFloat();
        float j = this.rand.nextInt(45) + 5F + this.rand.nextFloat();
        if (this.rand.nextInt(2) == 0) {
            i *= -1;
        }
        if (this.rand.nextInt(2) == 0) {
            j *= -1;
        }
        this.pitchSpin = i * (float)(this.motionY + 0.3D);
        this.yawSpin = j * (float)(Math.sqrt(Math.abs(this.motionX * this.motionZ)) + 0.3D);

        this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;

        if (explosion_source != null) {
            double mag = 1.0D;
            double dist = (double)explosion_source.getDistanceToEntity(parent);
            dist = Math.pow(dist / 2D, 2);
            if (dist < 0.1D) {
                dist = 0.1D;
            }

            if (explosion_source instanceof EntityTNTPrimed || explosion_source instanceof EntityMinecartTNT) {
                mag = 1.0D * (4.0 / dist);
            } else if (explosion_source.getClass().getName().contains("Creeper")) {
                mag = 1.0D * (3.0D / dist);
            }
            mag = Math.pow(mag, 2) * 0.2D;
            double mag2 = ((this.posY - explosion_source.posY));
            this.motionX *= mag;
            this.motionY = mag2 * 0.4D + 0.22D;
            this.motionZ *= mag;
            this.explosion = true;
        }

        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;
    }


    @Override
    public void onUpdate() {
        if (this.worldObj.isWorldServer()) {
            this.setDead();
            return;
        }

        if (this.parent == null) {
            this.setDead();
            return;
        }

        if (this.explosion) {
            this.motionX *= 1D / 0.92D;
            this.motionY *= 1D / 0.95D;
            this.motionZ *= 1D / 0.92D;
        }

        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.prevRotationPitch = this.rotationPitch;
        this.prevRotationYaw = this.rotationYaw;

        this.moveEntity(this.motionX, this.motionY, this.motionZ);

        this.motionY -= 0.08D;
        this.motionY *= 0.98D;
        this.motionX *= 0.91D;
        this.motionZ *= 0.91D;

        if (this.handleWaterMovement()) {
            if (this.motionY < -0.0) {
                this.motionY += 0.08;
            } else {
                this.motionY *= 0.8;
            }

            this.motionX *= 0.99;
            this.motionZ *= 0.99;

            this.pitchSpin *= 0.8F;
            this.yawSpin *= 0.8F;
        }

        if (this.onGround) {
            this.rotationPitch += (-90F - (this.rotationPitch % 360F)) / 2;
            this.motionY *= 0.8;
            this.motionX *= 0.8;
            this.motionZ *= 0.8;
        } else {
            this.rotationPitch += this.pitchSpin;
            this.rotationYaw += this.yawSpin;
            this.pitchSpin *= 0.98F;
            this.yawSpin *= 0.98F;
        }

        if (MDConfig.gibPushing.getBooleanValue()) {
            List var2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(0.15D, 0.0D, 0.15D));
            if (var2 != null && !var2.isEmpty()) {
                for (Object o : var2) {
                    Entity var4 = (Entity) o;
                    if (var4.canBePushed()) {
                        double distX = var4.posX - this.posX;
                        double distZ = var4.posZ - this.posZ;
                        double maxDist = Math.max(Math.abs(distX), Math.abs(distZ));

                        if (maxDist >= 0.01D) {
                            maxDist = Math.sqrt(maxDist);
                            distX /= maxDist;
                            distZ /= maxDist;
                            double strength = 1.0D / maxDist;

                            if (strength > 1.0D) {
                                strength = 1.0D;
                            }

                            this.motionX -= distX * strength * 0.05D;
                            this.motionZ -= distZ * strength * 0.05D;
                        }
                    }
                }
            }
        }

        int maxGroundTime = MDConfig.gibGroundTime.getIntegerValue();
        if (this.onGround || this.handleWaterMovement()) {
            this.groundTime++;
            if (this.groundTime > maxGroundTime + 20) {
                this.setDead();
            }
        } else if (this.groundTime > maxGroundTime) {
            this.groundTime--;
        } else {
            this.groundTime = 0;
        }

        this.liveTime++;
        if (this.liveTime > MDConfig.gibTime.getIntegerValue()) {
            this.setDead();
        }
    }

    @Override
    protected void entityInit() {
        this.dataWatcher.addObject(5, 0);
    }

    @Override
    public boolean canCatchFire() {
        return false;
    }

    @Override
    public boolean isEntityAlive() {
        return !this.isDead;
    }

    @Override
    protected void setSize(float par1, float par2) {
        super.setSize(par1, Math.min(par1, par2));
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {}

    @Override
    protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {}
}
