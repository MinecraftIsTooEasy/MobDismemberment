package vbonedra.mob_dismemberment.model;

import vbonedra.mob_dismemberment.entity.EntityGibBase;
import net.minecraft.ModelBase;
import net.minecraft.ModelRenderer;
import net.minecraft.Entity;

public class ModelGibZombie extends ModelBase {
    public ModelRenderer zombieHead;
    public ModelRenderer zombieTorso;
    public ModelRenderer zombieArm;
    public ModelRenderer zombieLeg;

    public ModelRenderer bipedHeadwear;
    public ModelRenderer zombieTorsoOverlay;
    public ModelRenderer zombieArmOverlay;
    public ModelRenderer zombieLegOverlay;

    public ModelGibZombie() {
        this.textureWidth = 64;
        this.textureHeight = 64;

        this.zombieHead = new ModelRenderer(this, 0, 0).setTextureSize(64, 64);
        this.zombieHead.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8);
        this.zombieHead.setRotationPoint(0.0F, 0.0F, 0.0F);

        this.zombieTorso = new ModelRenderer(this, 16, 16).setTextureSize(64, 64);
        this.zombieTorso.addBox(-4.0F, -6.0F, -2.0F, 8, 12, 4);
        this.zombieTorso.setRotationPoint(0.0F, 0.0F, 0.0F);

        this.zombieArm = new ModelRenderer(this, 40, 16).setTextureSize(64, 64);
        this.zombieArm.addBox(-2.0F, -4.0F, -2.0F, 4, 12, 4);
        this.zombieArm.setRotationPoint(0.0F, 0.0F, 0.0F);

        this.zombieLeg = new ModelRenderer(this, 0, 16).setTextureSize(64, 64);
        this.zombieLeg.addBox(-2.0F, -6.0F, -2.0F, 4, 12, 4);
        this.zombieLeg.setRotationPoint(0.0F, 0.0F, 0.0F);

        this.bipedHeadwear = new ModelRenderer(this, 32, 0).setTextureSize(64, 64);
        this.bipedHeadwear.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.5F);
        this.bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);

        this.zombieTorsoOverlay = new ModelRenderer(this, 16, 32).setTextureSize(64, 64);
        this.zombieTorsoOverlay.addBox(-4.0F, -6.0F, -2.0F, 8, 12, 4, 0.25F);
        this.zombieTorsoOverlay.setRotationPoint(0.0F, 0.0F, 0.0F);

        this.zombieArmOverlay = new ModelRenderer(this, 40, 32).setTextureSize(64, 64);
        this.zombieArmOverlay.addBox(-2.0F, -4.0F, -2.0F, 4, 12, 4, 0.25F);
        this.zombieArmOverlay.setRotationPoint(0.0F, 0.0F, 0.0F);

        this.zombieLegOverlay = new ModelRenderer(this, 0, 32).setTextureSize(64, 64);
        this.zombieLegOverlay.addBox(-2.0F, -6.0F, -2.0F, 4, 12, 4, 0.25F);
        this.zombieLegOverlay.setRotationPoint(0.0F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity ent, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
        if (ent instanceof EntityGibBase gib) {
            if (gib.type == 0) {
                this.zombieHead.render(f5);
                this.bipedHeadwear.render(f5);
            } else if (gib.type == 1) {
                this.zombieTorso.render(f5);
                this.zombieTorsoOverlay.render(f5);
            } else if (gib.type == 2 || gib.type == 3) {
                boolean isLeft = (gib.type == 3);
                this.zombieArm.mirror = isLeft;
                this.zombieArmOverlay.mirror = isLeft;
                this.zombieArm.render(f5);
                this.zombieArmOverlay.render(f5);
            } else if (gib.type == 4 || gib.type == 5) {
                boolean isLeft = (gib.type == 5);
                this.zombieLeg.mirror = isLeft;
                this.zombieLegOverlay.mirror = isLeft;
                this.zombieLeg.render(f5);
                this.zombieLegOverlay.render(f5);
            }
        }
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
        this.zombieHead.rotateAngleX = 0.0F; this.zombieHead.rotateAngleY = 0.0F;
        this.zombieTorso.rotateAngleX = 0.0F; this.zombieTorso.rotateAngleY = 0.0F;
        this.zombieArm.rotateAngleX = 0.0F; this.zombieArm.rotateAngleY = 0.0F;
        this.zombieLeg.rotateAngleX = 0.0F; this.zombieLeg.rotateAngleY = 0.0F;

        this.bipedHeadwear.rotateAngleX = 0.0F; this.bipedHeadwear.rotateAngleY = 0.0F;
        this.zombieTorsoOverlay.rotateAngleX = 0.0F; this.zombieTorsoOverlay.rotateAngleY = 0.0F;
        this.zombieArmOverlay.rotateAngleX = 0.0F; this.zombieArmOverlay.rotateAngleY = 0.0F;
        this.zombieLegOverlay.rotateAngleX = 0.0F; this.zombieLegOverlay.rotateAngleY = 0.0F;
    }
}
