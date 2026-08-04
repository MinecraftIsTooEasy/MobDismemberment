package vbonedra.mob_dismemberment.model;

import vbonedra.mob_dismemberment.entity.EntityGibBase;
import net.minecraft.ModelBase;
import net.minecraft.ModelRenderer;
import net.minecraft.Entity;

public class ModelGibSkeleton extends ModelBase {
    public ModelRenderer skeletonHead;
    public ModelRenderer skeletonTorso;
    public ModelRenderer skeletonArm;
    public ModelRenderer skeletonLeg;

    public ModelGibSkeleton() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.skeletonHead = new ModelRenderer(this, 0, 0).setTextureSize(64, 32);
        this.skeletonHead.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8);
        this.skeletonHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.skeletonTorso = new ModelRenderer(this, 16, 16).setTextureSize(64, 32);
        this.skeletonTorso.addBox(-4.0F, -6.0F, -2.0F, 8, 12, 4);
        this.skeletonTorso.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.skeletonArm = new ModelRenderer(this, 40, 16).setTextureSize(64, 32);
        this.skeletonArm.addBox(-1.0F, -4.0F, -1.0F, 2, 12, 2);
        this.skeletonArm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.skeletonLeg = new ModelRenderer(this, 0, 16).setTextureSize(64, 32);
        this.skeletonLeg.addBox(-1.0F, -6.0F, -1.0F, 2, 12, 2);
        this.skeletonLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity ent, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
        if (ent instanceof EntityGibBase gib) {
            if (gib.type == 0) {
                this.skeletonHead.render(f5);
            } else if (gib.type == 1) {
                this.skeletonTorso.render(f5);
            } else if (gib.type == 2 || gib.type == 3) {
                this.skeletonArm.render(f5);
            } else if (gib.type == 4 || gib.type == 5) {
                this.skeletonLeg.render(f5);
            }
        }
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
        this.skeletonHead.rotateAngleX = 0.0F; this.skeletonHead.rotateAngleY = 0.0F;
        this.skeletonTorso.rotateAngleX = 0.0F; this.skeletonTorso.rotateAngleY = 0.0F;
        this.skeletonArm.rotateAngleX = 0.0F; this.skeletonArm.rotateAngleY = 0.0F;
        this.skeletonLeg.rotateAngleX = 0.0F; this.skeletonLeg.rotateAngleY = 0.0F;
    }
}
