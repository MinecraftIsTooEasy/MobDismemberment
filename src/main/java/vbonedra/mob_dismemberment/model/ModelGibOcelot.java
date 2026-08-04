package vbonedra.mob_dismemberment.model;

import vbonedra.mob_dismemberment.entity.EntityGibBase;
import net.minecraft.ModelBase;
import net.minecraft.ModelRenderer;
import net.minecraft.Entity;

public class ModelGibOcelot extends ModelBase {
    public ModelRenderer ocelotHead;
    public ModelRenderer ocelotBody;
    public ModelRenderer ocelotFrontLeftLeg;
    public ModelRenderer ocelotFrontRightLeg;
    public ModelRenderer ocelotBackLeftLeg;
    public ModelRenderer ocelotBackRightLeg;
    public ModelRenderer ocelotTail;
    public ModelRenderer ocelotTail2;

    public ModelGibOcelot() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("head.main", 0, 0);
        this.setTextureOffset("head.nose", 0, 24);
        this.setTextureOffset("head.ear1", 0, 10);
        this.setTextureOffset("head.ear2", 6, 10);
        this.ocelotHead = new ModelRenderer(this, "head");
        this.ocelotHead.addBox("main", -2.5F, -2.0F, -2.5F, 5, 4, 5);
        this.ocelotHead.addBox("nose", -1.5F, 0.0F, -3.5F, 3, 2, 2);
        this.ocelotHead.addBox("ear1", -2.0F, -3.0F, 0.5F, 1, 1, 2);
        this.ocelotHead.addBox("ear2", 1.0F, -3.0F, 0.5F, 1, 1, 2);
        this.ocelotHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ocelotBody = new ModelRenderer(this, 20, 0).setTextureSize(64, 32);
        this.ocelotBody.addBox(-2.0F, -8.0F, -3.0F, 4, 16, 6);
        this.ocelotBody.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ocelotBody.rotateAngleX = ((float)Math.PI / 2F);
        this.ocelotFrontLeftLeg = new ModelRenderer(this, 40, 0).setTextureSize(64, 32);
        this.ocelotFrontLeftLeg.addBox(-1.0F, -5.0F, -1.0F, 2, 10, 2);
        this.ocelotFrontLeftLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ocelotFrontRightLeg = new ModelRenderer(this, 40, 0).setTextureSize(64, 32);
        this.ocelotFrontRightLeg.addBox(-1.0F, -5.0F, -1.0F, 2, 10, 2);
        this.ocelotFrontRightLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ocelotBackLeftLeg = new ModelRenderer(this, 8, 13).setTextureSize(64, 32);
        this.ocelotBackLeftLeg.addBox(-1.0F, -3.0F, -1.0F, 2, 6, 2);
        this.ocelotBackLeftLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ocelotBackRightLeg = new ModelRenderer(this, 8, 13).setTextureSize(64, 32);
        this.ocelotBackRightLeg.addBox(-1.0F, -3.0F, -1.0F, 2, 6, 2);
        this.ocelotBackRightLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ocelotTail = new ModelRenderer(this, 0, 15).setTextureSize(64, 32);
        this.ocelotTail.addBox(-0.5F, -4.0F, -0.5F, 1, 8, 1);
        this.ocelotTail.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ocelotTail2 = new ModelRenderer(this, 4, 15).setTextureSize(64, 32);
        this.ocelotTail2.addBox(-0.5F, -4.0F, -0.5F, 1, 8, 1);
        this.ocelotTail2.setRotationPoint(0.0F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity ent, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
        if (ent instanceof EntityGibBase gib) {
            if (gib.type == 0) {
                this.ocelotHead.render(f5);
            } else if (gib.type == 1) {
                this.ocelotBody.render(f5);
            } else if (gib.type == 2) {
                this.ocelotFrontLeftLeg.render(f5);
            } else if (gib.type == 3) {
                this.ocelotFrontRightLeg.render(f5);
            } else if (gib.type == 4) {
                this.ocelotBackLeftLeg.render(f5);
            } else if (gib.type == 5) {
                this.ocelotBackRightLeg.render(f5);
            } else if (gib.type == 6) {
                this.ocelotTail.render(f5);
            } else if (gib.type == 7) {
                this.ocelotTail2.render(f5);
            }
        }
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
        this.ocelotHead.rotateAngleY = 0.0F; this.ocelotHead.rotateAngleX = 0.0F;
        this.ocelotFrontLeftLeg.rotateAngleY = 0.0F; this.ocelotFrontLeftLeg.rotateAngleX = 0.0F;
        this.ocelotFrontRightLeg.rotateAngleY = 0.0F; this.ocelotFrontRightLeg.rotateAngleX = 0.0F;
        this.ocelotBackLeftLeg.rotateAngleY = 0.0F; this.ocelotBackLeftLeg.rotateAngleX = 0.0F;
        this.ocelotBackRightLeg.rotateAngleY = 0.0F; this.ocelotBackRightLeg.rotateAngleX = 0.0F;
        this.ocelotTail.rotateAngleY = 0.0F; this.ocelotTail.rotateAngleX = 0.0F;
        this.ocelotTail2.rotateAngleY = 0.0F; this.ocelotTail2.rotateAngleX = 0.0F;
    }
}
