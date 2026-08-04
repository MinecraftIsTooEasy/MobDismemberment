package vbonedra.mob_dismemberment.model;

import vbonedra.mob_dismemberment.entity.EntityGibBase;
import net.minecraft.ModelBase;
import net.minecraft.ModelRenderer;
import net.minecraft.Entity;

public class ModelGibGelatinousCube extends ModelBase {
    public ModelRenderer outerLayer;
    public ModelRenderer nucleus;
    public ModelRenderer rightEye;
    public ModelRenderer leftEye;
    public ModelRenderer mouth;

    public ModelGibGelatinousCube() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.outerLayer = new ModelRenderer(this, 0, 16).setTextureSize(64, 32);
        this.outerLayer.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6);
        this.outerLayer.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightEye = new ModelRenderer(this, 32, 0).setTextureSize(64, 32);
        this.rightEye.addBox(-3.25F, -2.0F, -3.5F, 2, 2, 2);
        this.rightEye.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.outerLayer.addChild(this.rightEye);
        this.leftEye = new ModelRenderer(this, 32, 4).setTextureSize(64, 32);
        this.leftEye.addBox(1.25F, -2.0F, -3.5F, 2, 2, 2);
        this.leftEye.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.outerLayer.addChild(this.leftEye);
        this.mouth = new ModelRenderer(this, 32, 8).setTextureSize(64, 32);
        this.mouth.addBox(0.0F, 1.0F, -3.5F, 1, 1, 1);
        this.mouth.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.outerLayer.addChild(this.mouth);
        this.nucleus = new ModelRenderer(this, 0, 0).setTextureSize(64, 32);
        this.nucleus.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8);
        this.nucleus.setRotationPoint(0.0F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity ent, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
        if (ent instanceof EntityGibBase) {
            EntityGibBase gib = (EntityGibBase) ent;
            if (gib.type == 0) {

                this.outerLayer.render(f5);
            } else if (gib.type == 1) {
                this.nucleus.render(f5);
            }
        }
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
        this.outerLayer.rotateAngleY = 0.0F; this.outerLayer.rotateAngleX = 0.0F;
        this.nucleus.rotateAngleY = 0.0F; this.nucleus.rotateAngleX = 0.0F;
    }
}
