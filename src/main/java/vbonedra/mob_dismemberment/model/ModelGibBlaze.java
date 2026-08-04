package vbonedra.mob_dismemberment.model;

import vbonedra.mob_dismemberment.entity.EntityGibBase;
import net.minecraft.ModelBase;
import net.minecraft.ModelRenderer;
import net.minecraft.Entity;

public class ModelGibBlaze extends ModelBase {
    public ModelRenderer blazeHead;
    public ModelRenderer blazeRod;
    public ModelGibBlaze() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.blazeHead = new ModelRenderer(this, 0, 0).setTextureSize(64, 32);
        this.blazeHead.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8);
        this.blazeHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.blazeRod = new ModelRenderer(this, 0, 16).setTextureSize(64, 32);
        this.blazeRod.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2);
        this.blazeRod.setRotationPoint(0.0F, 0.0F, 0.0F);
    }
    @Override
    public void render(Entity ent, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
        if (ent instanceof EntityGibBase gib) {
            if (gib.type == 0) {
                this.blazeHead.render(f5);
            } else if (gib.type == 1) {
                this.blazeRod.render(f5);
            }
        }
    }
    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
        this.blazeHead.rotateAngleY = 0.0F; this.blazeHead.rotateAngleX = 0.0F;
        this.blazeRod.rotateAngleY = 0.0F; this.blazeRod.rotateAngleX = 0.0F;
    }
}
