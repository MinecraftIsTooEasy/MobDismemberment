package vbonedra.mob_dismemberment.model;

import vbonedra.mob_dismemberment.entity.EntityGibBase;
import net.minecraft.ModelBase;
import net.minecraft.ModelRenderer;
import net.minecraft.Entity;

public class ModelGibSheep extends ModelBase {
    public ModelRenderer sheepHead;
    public ModelRenderer sheepBody;
    public ModelRenderer sheepLeg;

    public ModelGibSheep() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.sheepHead = new ModelRenderer(this, 0, 0).setTextureSize(64, 32);
        this.sheepHead.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.6F);
        this.sheepHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sheepBody = new ModelRenderer(this, 28, 8).setTextureSize(64, 32);
        this.sheepBody.addBox(-4.0F, -8.0F, -3.0F, 8, 16, 6, 1.75F);
        this.sheepBody.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sheepLeg = new ModelRenderer(this, 0, 16).setTextureSize(64, 32);
        this.sheepLeg.addBox(-2.0F, -3.0F, -2.0F, 4, 6, 4, 0.5F);
        this.sheepLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity ent, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
        if (ent instanceof EntityGibBase gib) {
            if (gib.type == 0) {
                this.sheepHead.render(f5);
            } else if (gib.type == 1) {
                this.sheepBody.render(f5);
            } else if (gib.type >= 2 && gib.type <= 5) {
                this.sheepLeg.render(f5);
            }
        }
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
        this.sheepHead.rotateAngleY = 0.0F; this.sheepHead.rotateAngleX = 0.0F;
        this.sheepBody.rotateAngleY = 0.0F; this.sheepBody.rotateAngleX = 0.0F;
        this.sheepLeg.rotateAngleY = 0.0F; this.sheepLeg.rotateAngleX = 0.0F;
    }
}
