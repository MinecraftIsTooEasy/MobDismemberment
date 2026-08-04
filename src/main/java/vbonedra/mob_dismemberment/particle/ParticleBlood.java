package vbonedra.mob_dismemberment.particle;

import vbonedra.mob_dismemberment.config.MDConfig;
import net.minecraft.EntityFX;
import net.minecraft.World;

public class ParticleBlood extends EntityFX {
    public ParticleBlood(World world, double d, double d1, double d2, double d3, double d4, double d5, boolean isPlayer) {
        super(world, d, d1, d2, d3, d4, d5);
        this.particleGravity = 0.06F;

        this.particleRed = 1.0F;
        this.particleGreen = MDConfig.greenBlood.getBooleanValue() && !isPlayer ? 1.0F : 0.0F;
        this.particleBlue = 0.0F;

        this.particleScale *= 1.2F;
        this.particleScale = (float)((double)this.particleScale * MDConfig.bloodScale.getDoubleValue());

        this.motionX *= 1.2F;
        this.motionY *= 1.2F;
        this.motionZ *= 1.2F;

        this.motionY += this.rand.nextFloat() * 0.15F;
        this.motionZ *= 0.4F / (this.rand.nextFloat() * 0.9F + 0.1F);
        this.motionX *= 0.4F / (this.rand.nextFloat() * 0.9F + 0.1F);

        this.particleMaxAge = (int)(MDConfig.bloodTime.getIntegerValue() + (20.0F / (this.rand.nextFloat() * 0.9F + 0.1F)));

        this.setSize(0.01F, 0.01F);
        this.setParticleTextureIndex(19 + this.rand.nextInt(4));
    }

    public void setBloodColor(float r, float g, float b){
        if (MDConfig.greenBlood.getBooleanValue()){
            this.particleRed = 0.0F;
            this.particleGreen = 1.0F;
            this.particleBlue = 0.0F;
        } else{
            this.particleRed = r;
            this.particleGreen = g;
            this.particleBlue = b;
        }
    }

    public void setBloodScale(float scale){
        this.particleScale = (float) ((double) scale * (1.0 + (double) this.rand.nextFloat() * 0.5D) * MDConfig.bloodScale.getDoubleValue());
    }

    @Override
    public void onUpdate() {
        if(this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
            return;
        }

        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if(this.motionX != 0.0D && this.motionZ != 0.0D && !this.onGround) {
            this.motionY -= this.particleGravity;
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.98;
            this.motionY *= 0.98;
            this.motionZ *= 0.98;

            if(this.onGround) {
                this.motionX *= 0.7;
                this.motionZ *= 0.7;

                double dynamicOffset = (double)this.particleScale * 0.08D;
                this.posY += dynamicOffset;
                this.boundingBox.offset(0.0D, dynamicOffset, 0.0D);
            }
        }
    }

    @Override
    public int getFXLayer() {
        return 0;
    }
}
