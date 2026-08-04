package vbonedra.mob_dismemberment.model;

import vbonedra.mob_dismemberment.entity.EntityGibBase;
import net.minecraft.ModelBase;
import net.minecraft.ModelRenderer;
import net.minecraft.Entity;

public class ModelGibEnderman extends ModelBase {
    public ModelRenderer bipedHead;
    public ModelRenderer bipedHeadwear;
    public ModelRenderer bipedBody;
    public ModelRenderer bipedLeftArm;
    public ModelRenderer bipedRightArm;
    public ModelRenderer bipedLeftLeg;
    public ModelRenderer bipedRightLeg;

    public ModelGibEnderman() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.bipedHead = new ModelRenderer(this, 0, 0).setTextureSize(64, 32);
        this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
        this.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedHeadwear = new ModelRenderer(this, 0, 16).setTextureSize(64, 32);
        this.bipedHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, -0.5F);
        this.bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedHead.addChild(this.bipedHeadwear);
        this.bipedBody = new ModelRenderer(this, 32, 16).setTextureSize(64, 32);
        this.bipedBody.addBox(-4.0F, -6.0F, -2.0F, 8, 12, 4);
        this.bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedLeftArm = new ModelRenderer(this, 56, 0).setTextureSize(64, 32);
        this.bipedLeftArm.mirror = true;
        this.bipedLeftArm.addBox(-1.0F, -15.0F, -1.0F, 2, 30, 2);
        this.bipedLeftArm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedRightArm = new ModelRenderer(this, 56, 0).setTextureSize(64, 32);
        this.bipedRightArm.addBox(-1.0F, -15.0F, -1.0F, 2, 30, 2);
        this.bipedRightArm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedLeftLeg = new ModelRenderer(this, 56, 0).setTextureSize(64, 32);
        this.bipedLeftLeg.mirror = true;
        this.bipedLeftLeg.addBox(-1.0F, -15.0F, -1.0F, 2, 30, 2);
        this.bipedLeftLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedRightLeg = new ModelRenderer(this, 56, 0).setTextureSize(64, 32);
        this.bipedRightLeg.addBox(-1.0F, -15.0F, -1.0F, 2, 30, 2);
        this.bipedRightLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity ent, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
        if (ent instanceof EntityGibBase gib) {
            if (gib.type == 0) {
                this.bipedHead.render(f5);
            } else if (gib.type == 1) {
                this.bipedBody.render(f5);
            } else if (gib.type == 2) {
                this.bipedLeftArm.render(f5);
            } else if (gib.type == 3) {
                this.bipedRightArm.render(f5);
            } else if (gib.type == 4) {
                this.bipedLeftLeg.render(f5);
            } else if (gib.type == 5) {
                this.bipedRightLeg.render(f5);
            }
        }
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
        this.bipedHead.rotateAngleY = 0.0F; this.bipedHead.rotateAngleX = 0.0F;
        this.bipedBody.rotateAngleY = 0.0F; this.bipedBody.rotateAngleX = 0.0F;
        this.bipedLeftArm.rotateAngleY = 0.0F; this.bipedLeftArm.rotateAngleX = 0.0F;
        this.bipedRightArm.rotateAngleY = 0.0F; this.bipedRightArm.rotateAngleX = 0.0F;
        this.bipedLeftLeg.rotateAngleY = 0.0F; this.bipedLeftLeg.rotateAngleX = 0.0F;
        this.bipedRightLeg.rotateAngleY = 0.0F; this.bipedRightLeg.rotateAngleX = 0.0F;
    }
}
