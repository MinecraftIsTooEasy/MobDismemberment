package vbonedra.mob_dismemberment.model;

import vbonedra.mob_dismemberment.entity.EntityGibBase;
import net.minecraft.ModelBase;
import net.minecraft.ModelRenderer;
import net.minecraft.Entity;

public class ModelGibEarthElemental extends ModelBase {
    public ModelRenderer elementHead;
    public ModelRenderer elementBody;
    public ModelRenderer elementArm;
    public ModelRenderer elementLeg;
    public ModelGibEarthElemental() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.elementHead = new ModelRenderer(this, 0, 0).setTextureSize(64, 32);
        this.elementHead.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8);
        this.elementHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.elementBody = new ModelRenderer(this, 16, 16).setTextureSize(64, 32);
        this.elementBody.addBox(-4.0F, -6.0F, -2.0F, 8, 12, 4);
        this.elementBody.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.elementArm = new ModelRenderer(this, 40, 16).setTextureSize(64, 32);
        this.elementArm.addBox(-2.0F, -6.0F, -2.0F, 4, 12, 4);
        this.elementArm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.elementLeg = new ModelRenderer(this, 0, 16).setTextureSize(64, 32);
        this.elementLeg.addBox(-2.0F, -6.0F, -2.0F, 4, 12, 4);
        this.elementLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
    }
    @Override
    public void render(Entity ent, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
        if (ent instanceof EntityGibBase) {
            EntityGibBase gib = (EntityGibBase) ent;
            if (gib.type == 0) {
                this.elementHead.render(f5);
            } else if (gib.type == 1 || gib.type == 2) {
                this.elementArm.render(f5);
            } else if (gib.type == 3) {
                this.elementBody.render(f5);
            } else if (gib.type == 4 || gib.type == 5) {
                this.elementLeg.render(f5);
            }
        }
    }
    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
        this.elementHead.rotateAngleY = 0.0F; this.elementHead.rotateAngleX = 0.0F;
        this.elementBody.rotateAngleY = 0.0F; this.elementBody.rotateAngleX = 0.0F;
        this.elementArm.rotateAngleY = 0.0F; this.elementArm.rotateAngleX = 0.0F;
        this.elementLeg.rotateAngleY = 0.0F; this.elementLeg.rotateAngleX = 0.0F;
    }
}
