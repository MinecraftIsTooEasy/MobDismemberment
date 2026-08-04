package vbonedra.mob_dismemberment.model;

import vbonedra.mob_dismemberment.entity.EntityGibBase;
import net.minecraft.ModelBase;
import net.minecraft.ModelRenderer;
import net.minecraft.Entity;

public class ModelGibCreeper extends ModelBase {
    public ModelRenderer creeperHead;
    public ModelRenderer creeperBody;
    public ModelRenderer creeperLeg;
    public ModelGibCreeper() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.creeperHead = new ModelRenderer(this, 0, 0).setTextureSize(64, 32);
        this.creeperHead.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8);
        this.creeperHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.creeperBody = new ModelRenderer(this, 16, 16).setTextureSize(64, 32);
        this.creeperBody.addBox(-4.0F, -6.0F, -2.0F, 8, 12, 4);
        this.creeperBody.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.creeperLeg = new ModelRenderer(this, 0, 16).setTextureSize(64, 32);
        this.creeperLeg.addBox(-2.0F, -3.0F, -2.0F, 4, 6, 4);
        this.creeperLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
    }
    @Override
    public void render(Entity ent, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
        if (ent instanceof EntityGibBase) {
            EntityGibBase gib = (EntityGibBase) ent;
            if (gib.type == 0) {
                this.creeperHead.render(f5);
            } else if (gib.type == 3) {
                this.creeperBody.render(f5);
            } else if (gib.type >= 6 && gib.type <= 9) {
                this.creeperLeg.render(f5);
            }
        }
    }
    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
        this.creeperHead.rotateAngleY = 0.0F; this.creeperHead.rotateAngleX = 0.0F;
        this.creeperBody.rotateAngleY = 0.0F; this.creeperBody.rotateAngleX = 0.0F;
        this.creeperLeg.rotateAngleY = 0.0F; this.creeperLeg.rotateAngleX = 0.0F;
    }
}
