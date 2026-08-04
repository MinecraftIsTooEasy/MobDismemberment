package vbonedra.mob_dismemberment.model;

import vbonedra.mob_dismemberment.entity.EntityGibBase;
import net.minecraft.ModelBase;
import net.minecraft.ModelRenderer;
import net.minecraft.Entity;

public class ModelGibBat extends ModelBase {
    public ModelRenderer batHead;
    public ModelRenderer batBody;
    public ModelRenderer batRightWingPack;
    public ModelRenderer batLeftWingPack;

    public ModelGibBat() {
        this.textureWidth = 64;
        this.textureHeight = 64;

        this.batHead = new ModelRenderer(this, 0, 0).setTextureSize(64, 64);
        this.batHead.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6);
        this.batHead.setRotationPoint(0.0F, 0.0F, 0.0F);

        ModelRenderer earRight = new ModelRenderer(this, 24, 0).setTextureSize(64, 64);
        earRight.addBox(-4.0F, -6.0F, -2.0F, 3, 4, 1);
        earRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.batHead.addChild(earRight);

        ModelRenderer earLeft = new ModelRenderer(this, 24, 0).setTextureSize(64, 64);
        earLeft.mirror = true;
        earLeft.addBox(1.0F, -6.0F, -2.0F, 3, 4, 1);
        earLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.batHead.addChild(earLeft);

        this.batBody = new ModelRenderer(this, 0, 16).setTextureSize(64, 64);
        this.batBody.addBox(-3.0F, -6.0F, -3.0F, 6, 12, 6);
        this.batBody.setTextureOffset(0, 34).addBox(-5.0F, 6.0F, 0.0F, 10, 6, 1);
        this.batBody.setRotationPoint(0.0F, 0.0F, 0.0F);

        this.batRightWingPack = new ModelRenderer(this, 42, 0).setTextureSize(64, 64);
        this.batRightWingPack.addBox(-2.0F, -9.0F, -0.5F, 10, 16, 1);
        this.batRightWingPack.setRotationPoint(0.0F, 0.0F, 0.0F);

        ModelRenderer batOuterRightWing = new ModelRenderer(this, 24, 16).setTextureSize(64, 64);
        batOuterRightWing.addBox(-8.0F, -7.0F, -0.5F, 8, 12, 1);
        batOuterRightWing.setRotationPoint(-2.0F, -8.0F, 0.0F);
        this.batRightWingPack.addChild(batOuterRightWing);

        this.batLeftWingPack = new ModelRenderer(this, 42, 0).setTextureSize(64, 64);
        this.batLeftWingPack.mirror = true;
        this.batLeftWingPack.addBox(-8.0F, -9.0F, -0.5F, 10, 16, 1);
        this.batLeftWingPack.setRotationPoint(0.0F, 0.0F, 0.0F);

        ModelRenderer batOuterLeftWing = new ModelRenderer(this, 24, 16).setTextureSize(64, 64);
        batOuterLeftWing.mirror = true;
        batOuterLeftWing.addBox(0.0F, -7.0F, -0.5F, 8, 12, 1);
        batOuterLeftWing.setRotationPoint(2.0F, -8.0F, 0.0F);
        this.batLeftWingPack.addChild(batOuterLeftWing);
    }

    @Override
    public void render(Entity ent, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
        if (ent instanceof EntityGibBase gib) {
            if (gib.type == 0) {
                this.batHead.render(f5);
            } else if (gib.type == 1) {
                this.batBody.render(f5);
            } else if (gib.type == 2) {
                this.batRightWingPack.render(f5);
            } else if (gib.type == 3) {
                this.batLeftWingPack.render(f5);
            }
        }
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
        this.batHead.rotateAngleX = 0.0F; this.batHead.rotateAngleY = 0.0F;
        this.batBody.rotateAngleX = 0.0F; this.batBody.rotateAngleY = 0.0F;
        this.batRightWingPack.rotateAngleX = 0.0F; this.batRightWingPack.rotateAngleY = 0.0F;
        this.batLeftWingPack.rotateAngleX = 0.0F; this.batLeftWingPack.rotateAngleY = 0.0F;
    }
}
