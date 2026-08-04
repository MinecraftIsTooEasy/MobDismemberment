package vbonedra.mob_dismemberment.model;

import vbonedra.mob_dismemberment.entity.EntityGibBase;
import net.minecraft.ModelBase;
import net.minecraft.ModelRenderer;
import net.minecraft.Entity;

public class ModelGibWolf extends ModelBase {
    public ModelRenderer wolfHead;
    public ModelRenderer wolfBody;
    public ModelRenderer wolfLeg;
    public ModelRenderer wolfTail;
    public ModelRenderer wolfMane;
    public ModelGibWolf() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.wolfHead = new ModelRenderer(this, 0, 0).setTextureSize(64, 32);
        this.wolfHead.addBox(-3.0F, -3.0F, -2.0F, 6, 6, 4);
        this.wolfHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        ModelRenderer nose = new ModelRenderer(this, 0, 10).setTextureSize(64, 32);
        nose.addBox(-1.5F, -1.0F, -5.0F, 3, 3, 4);
        nose.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wolfHead.addChild(nose);
        ModelRenderer earLeft = new ModelRenderer(this, 16, 14).setTextureSize(64, 32);
        earLeft.addBox(-2.5F, -5.0F, -1.0F, 2, 2, 1);
        earLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wolfHead.addChild(earLeft);
        ModelRenderer earRight = new ModelRenderer(this, 16, 14).setTextureSize(64, 32);
        earRight.addBox(0.5F, -5.0F, -1.0F, 2, 2, 1);
        earRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wolfHead.addChild(earRight);
        this.wolfBody = new ModelRenderer(this, 18, 14).setTextureSize(64, 32);
        this.wolfBody.addBox(-3.0F, -4.5F, -3.0F, 6, 9, 6);
        this.wolfBody.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wolfMane = new ModelRenderer(this, 21, 0).setTextureSize(64, 32);
        this.wolfMane.addBox(-4.0F, -3.0F, -3.5F, 8, 6, 7);
        this.wolfMane.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wolfLeg = new ModelRenderer(this, 0, 18).setTextureSize(64, 32);
        this.wolfLeg.addBox(-1.0F, -4.0F, -1.0F, 2, 8, 2);
        this.wolfLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wolfTail = new ModelRenderer(this, 9, 18).setTextureSize(64, 32);
        this.wolfTail.addBox(-1.0F, -4.0F, -1.0F, 2, 8, 2);
        this.wolfTail.setRotationPoint(0.0F, 0.0F, 0.0F);
    }
    @Override
    public void render(Entity ent, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
        if (ent instanceof EntityGibBase) {
            EntityGibBase gib = (EntityGibBase) ent;
            if (gib.type == 0) {
                this.wolfHead.render(f5);
            } else if (gib.type == 1) {
                this.wolfBody.render(f5);
            } else if (gib.type >= 2 && gib.type <= 5) {
                this.wolfLeg.render(f5);
            } else if (gib.type == 6) {
                this.wolfTail.render(f5);
            } else if (gib.type == 7) {
                this.wolfMane.render(f5);
            }
        }
    }
    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
        this.wolfHead.rotateAngleY = 0.0F; this.wolfHead.rotateAngleX = 0.0F;
        this.wolfBody.rotateAngleY = 0.0F; this.wolfBody.rotateAngleX = 0.0F;
        this.wolfMane.rotateAngleY = 0.0F; this.wolfMane.rotateAngleX = 0.0F;
        this.wolfLeg.rotateAngleY = 0.0F; this.wolfLeg.rotateAngleX = 0.0F;
        this.wolfTail.rotateAngleY = 0.0F; this.wolfTail.rotateAngleX = 0.0F;
    }
}
