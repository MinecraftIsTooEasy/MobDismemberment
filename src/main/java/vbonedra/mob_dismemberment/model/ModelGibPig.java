package vbonedra.mob_dismemberment.model;

import vbonedra.mob_dismemberment.entity.EntityGibBase;
import net.minecraft.ModelBase;
import net.minecraft.ModelRenderer;
import net.minecraft.Entity;

public class ModelGibPig extends ModelBase {
    public ModelRenderer pigHead;
    public ModelRenderer pigBody;
    public ModelRenderer pigLeg;

    public ModelGibPig() {
        this.textureWidth = 64;
        this.textureHeight = 32;

        this.pigHead = new ModelRenderer(this, 0, 0).setTextureSize(64, 32);
        this.pigHead.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8);
        this.pigHead.setRotationPoint(0.0F, 0.0F, 0.0F);

        ModelRenderer snout = new ModelRenderer(this, 16, 16).setTextureSize(64, 32);
        snout.addBox(-2.0F, 0.0F, -5.0F, 4, 3, 1);
        snout.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.pigHead.addChild(snout);

        this.pigBody = new ModelRenderer(this, 28, 8).setTextureSize(64, 32);
        this.pigBody.addBox(-5.0F, -8.0F, -4.0F, 10, 16, 8);
        this.pigBody.setRotationPoint(0.0F, 0.0F, 0.0F);

        this.pigLeg = new ModelRenderer(this, 0, 16).setTextureSize(64, 32);
        this.pigLeg.addBox(-2.0F, -3.0F, -2.0F, 4, 6, 4);
        this.pigLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity ent, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
        if (ent instanceof EntityGibBase gib) {
            if (gib.type == 0) {
                this.pigHead.render(f5);
            } else if (gib.type == 1) {
                this.pigBody.render(f5);
            } else if (gib.type >= 2 && gib.type <= 5) {
                this.pigLeg.render(f5);
            }
        }
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
        this.pigHead.rotateAngleY = 0.0F; this.pigHead.rotateAngleX = 0.0F;
        this.pigBody.rotateAngleY = 0.0F; this.pigBody.rotateAngleX = 0.0F;
        this.pigLeg.rotateAngleY = 0.0F; this.pigLeg.rotateAngleX = 0.0F;
    }
}
