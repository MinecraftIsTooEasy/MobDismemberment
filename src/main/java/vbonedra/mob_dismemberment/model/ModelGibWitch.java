package vbonedra.mob_dismemberment.model;

import vbonedra.mob_dismemberment.entity.EntityGibBase;
import net.minecraft.ModelBase;
import net.minecraft.ModelRenderer;
import net.minecraft.Entity;

public class ModelGibWitch extends ModelBase {
    public ModelRenderer witchHead;
    public ModelRenderer witchHat;
    public ModelRenderer witchTorso;
    public ModelRenderer witchArms;
    public ModelRenderer witchLeg;

    public ModelGibWitch() {
        this.textureWidth = 64;
        this.textureHeight = 128;

        this.witchHead = new ModelRenderer(this, 0, 0).setTextureSize(64, 128);
        this.witchHead.addBox(-4.0F, -5.0F, -4.0F, 8, 10, 8);
        this.witchHead.setRotationPoint(0.0F, 0.0F, 0.0F);

        ModelRenderer witchNose = new ModelRenderer(this, 24, 0).setTextureSize(64, 128);
        witchNose.addBox(-1.0F, -1.0F, -6.0F, 2, 4, 2);
        witchNose.setRotationPoint(0.0F, 2.25F, 0.0F);
        this.witchHead.addChild(witchNose);

        ModelRenderer wart = new ModelRenderer(this, 0, 0).setTextureSize(64, 128);
        wart.addBox(0.0F, 3.0F, -6.75F, 1, 1, 1, -0.25F);
        wart.setRotationPoint(0.0F, -2.0F, 0.0F);
        witchNose.addChild(wart);

        this.witchHat = new ModelRenderer(this, 0, 64).setTextureSize(64, 128);
        this.witchHat.addBox(-5.0F, -1.0F, -5.0F, 10, 2, 10);
        this.witchHat.setRotationPoint(0.0F, 0.0F, 0.0F);

        ModelRenderer hatLayer2 = new ModelRenderer(this, 0, 76).setTextureSize(64, 128);
        hatLayer2.addBox(0.0F, 0.0F, 0.0F, 7, 4, 7);
        hatLayer2.setRotationPoint(-3.25F, -5.0F, -3.0F);
        hatLayer2.rotateAngleX = -0.05235988F;
        hatLayer2.rotateAngleZ = 0.02617994F;
        this.witchHat.addChild(hatLayer2);

        ModelRenderer hatLayer3 = new ModelRenderer(this, 0, 87).setTextureSize(64, 128);
        hatLayer3.addBox(0.0F, 0.0F, 0.0F, 4, 4, 4);
        hatLayer3.setRotationPoint(1.75F, -4.0F, 2.0F);
        hatLayer3.rotateAngleX = -0.10471976F;
        hatLayer3.rotateAngleZ = 0.05235988F;
        hatLayer2.addChild(hatLayer3);

        ModelRenderer hatLayer4 = new ModelRenderer(this, 0, 95).setTextureSize(64, 128);
        hatLayer4.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.25F);
        hatLayer4.setRotationPoint(1.75F, -2.0F, 2.0F);
        hatLayer4.rotateAngleX = -0.20943952F;
        hatLayer4.rotateAngleZ = 0.10471976F;
        hatLayer3.addChild(hatLayer4);

        this.witchTorso = new ModelRenderer(this, 16, 20).setTextureSize(64, 128);
        this.witchTorso.addBox(-4.0F, -6.0F, -3.0F, 8, 12, 6);
        this.witchTorso.setRotationPoint(0.0F, 0.0F, 0.0F);

        ModelRenderer robeOverlay = new ModelRenderer(this, 0, 38).setTextureSize(64, 128);
        robeOverlay.addBox(-4.0F, -6.0F, -3.0F, 8, 18, 6, 0.5F);
        robeOverlay.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.witchTorso.addChild(robeOverlay);

        this.witchArms = new ModelRenderer(this, 44, 22).setTextureSize(64, 128);
        this.witchArms.addBox(-8.0F, -2.0F, -2.0F, 4, 8, 4);
        this.witchArms.setTextureOffset(44, 22).addBox(4.0F, -2.0F, -2.0F, 4, 8, 4);
        this.witchArms.setTextureOffset(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8, 4, 4);
        this.witchArms.setRotationPoint(0.0F, 0.0F, 0.0F);

        this.witchLeg = new ModelRenderer(this, 0, 22).setTextureSize(64, 128);
        this.witchLeg.addBox(-2.0F, -6.0F, -2.0F, 4, 12, 4);
        this.witchLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity ent, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
        if (ent instanceof EntityGibBase gib) {
            if (gib.type == 0) {
                this.witchHead.render(f5);
            } else if (gib.type == 1) {
                this.witchHat.render(f5);
            } else if (gib.type == 2) {
                this.witchTorso.render(f5);
            } else if (gib.type == 3) {
                this.witchArms.render(f5);
            } else if (gib.type == 4 || gib.type == 5) {
                this.witchLeg.render(f5);
            }
        }
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
        this.witchHead.rotateAngleX = 0.0F; this.witchHead.rotateAngleY = 0.0F;
        this.witchHat.rotateAngleX = 0.0F; this.witchHat.rotateAngleY = 0.0F;
        this.witchTorso.rotateAngleX = 0.0F; this.witchTorso.rotateAngleY = 0.0F;
        this.witchArms.rotateAngleX = 0.0F; this.witchArms.rotateAngleY = 0.0F; this.witchArms.rotateAngleZ = 0.0F;
        this.witchLeg.rotateAngleX = 0.0F; this.witchLeg.rotateAngleY = 0.0F;
    }
}
