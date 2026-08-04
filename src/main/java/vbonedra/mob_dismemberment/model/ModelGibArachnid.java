package vbonedra.mob_dismemberment.model;

import vbonedra.mob_dismemberment.entity.EntityGibBase;
import net.minecraft.ModelBase;
import net.minecraft.ModelRenderer;
import net.minecraft.Entity;

public class ModelGibArachnid extends ModelBase {
    public ModelRenderer spiderHead;
    public ModelRenderer spiderNeck;
    public ModelRenderer spiderBody;
    public ModelRenderer spiderLegLeft;
    public ModelRenderer spiderLegRight;

    public ModelGibArachnid() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.spiderHead = new ModelRenderer(this, 32, 4).setTextureSize(64, 32);
        this.spiderHead.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8);
        this.spiderHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.spiderNeck = new ModelRenderer(this, 0, 0).setTextureSize(64, 32);
        this.spiderNeck.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6);
        this.spiderNeck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.spiderBody = new ModelRenderer(this, 0, 12).setTextureSize(64, 32);
        this.spiderBody.addBox(-5.0F, -4.0F, -6.0F, 10, 8, 12);
        this.spiderBody.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.spiderLegLeft = new ModelRenderer(this, 18, 0).setTextureSize(64, 32);
        this.spiderLegLeft.addBox(-8.0F, -1.0F, -1.0F, 16, 2, 2);
        this.spiderLegLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.spiderLegRight = new ModelRenderer(this, 18, 0).setTextureSize(64, 32);
        this.spiderLegRight.addBox(-8.0F, -1.0F, -1.0F, 16, 2, 2);
        this.spiderLegRight.setRotationPoint(0.0F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity ent, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
        if (ent instanceof EntityGibBase gib) {
            if (gib.type == 0) {
                this.spiderHead.render(f5);
            } else if (gib.type == 1) {
                this.spiderNeck.render(f5);
            } else if (gib.type == 2) {
                this.spiderBody.render(f5);
            } else if (gib.type >= 3 && gib.type <= 10) {
                int legIndex = gib.type - 3;
                if (legIndex % 2 == 0) {
                    this.spiderLegLeft.render(f5);
                } else {
                    this.spiderLegRight.render(f5);
                }
            }
        }
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
        this.spiderHead.rotateAngleX = 0.0F; this.spiderHead.rotateAngleY = 0.0F;
        this.spiderNeck.rotateAngleX = 0.0F; this.spiderNeck.rotateAngleY = 0.0F;
        this.spiderBody.rotateAngleX = 0.0F; this.spiderBody.rotateAngleY = 0.0F;
        this.spiderLegLeft.rotateAngleX = 0.0F; this.spiderLegLeft.rotateAngleY = 0.0F;
        this.spiderLegRight.rotateAngleX = 0.0F; this.spiderLegRight.rotateAngleY = 0.0F;
    }
}
