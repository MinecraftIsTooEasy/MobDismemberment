package vbonedra.mob_dismemberment.model;

import vbonedra.mob_dismemberment.entity.EntityGibBase;
import net.minecraft.ModelBase;
import net.minecraft.ModelRenderer;
import net.minecraft.Entity;

public class ModelGibChicken extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer rightLeg;
    public ModelRenderer leftLeg;
    public ModelRenderer rightWing;
    public ModelRenderer leftWing;
    public ModelRenderer bill;
    public ModelRenderer chin;

    public ModelGibChicken() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.head = new ModelRenderer(this, 0, 0).setTextureSize(64, 32);
        this.head.addBox(-2.0F, -6.0F, -2.0F, 4, 6, 3);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bill = new ModelRenderer(this, 14, 0).setTextureSize(64, 32);
        this.bill.addBox(-2.0F, -4.0F, -4.0F, 4, 2, 2);
        this.bill.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addChild(this.bill);
        this.chin = new ModelRenderer(this, 14, 4).setTextureSize(64, 32);
        this.chin.addBox(-1.0F, -2.0F, -3.0F, 2, 2, 2);
        this.chin.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addChild(this.chin);
        this.body = new ModelRenderer(this, 0, 9).setTextureSize(64, 32);
        this.body.addBox(-3.0F, -4.0F, -3.0F, 6, 8, 6);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body.rotateAngleX = ((float)Math.PI / 2F);
        this.leftLeg = new ModelRenderer(this, 26, 0).setTextureSize(64, 32);
        this.leftLeg.addBox(-1.0F, -2.5F, -1.5F, 3, 5, 3);
        this.leftLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightLeg = new ModelRenderer(this, 26, 0).setTextureSize(64, 32);
        this.rightLeg.addBox(-2.0F, -2.5F, -1.5F, 3, 5, 3);
        this.rightLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftWing = new ModelRenderer(this, 24, 13).setTextureSize(64, 32);
        this.leftWing.addBox(-0.5F, -2.0F, -3.0F, 1, 4, 6);
        this.leftWing.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightWing = new ModelRenderer(this, 24, 13).setTextureSize(64, 32);
        this.rightWing.addBox(-0.5F, -2.0F, -3.0F, 1, 4, 6);
        this.rightWing.setRotationPoint(0.0F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity ent, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
        if (ent instanceof EntityGibBase) {
            EntityGibBase gib = (EntityGibBase) ent;
            if (gib.type == 0) {
                this.head.render(f5);
            } else if (gib.type == 1) {
                this.body.render(f5);
            } else if (gib.type == 2) {
                this.leftWing.render(f5);
            } else if (gib.type == 3) {
                this.rightWing.render(f5);
            } else if (gib.type == 4) {
                this.leftLeg.render(f5);
            } else if (gib.type == 5) {
                this.rightLeg.render(f5);
            }
        }
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
        this.head.rotateAngleY = 0.0F; this.head.rotateAngleX = 0.0F;
        this.leftWing.rotateAngleY = 0.0F; this.leftWing.rotateAngleZ = 0.0F;
        this.rightWing.rotateAngleY = 0.0F; this.rightWing.rotateAngleZ = 0.0F;
        this.leftLeg.rotateAngleY = 0.0F; this.leftLeg.rotateAngleX = 0.0F;
        this.rightLeg.rotateAngleY = 0.0F; this.rightLeg.rotateAngleX = 0.0F;
    }
}
