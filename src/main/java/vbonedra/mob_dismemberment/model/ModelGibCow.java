package vbonedra.mob_dismemberment.model;

import vbonedra.mob_dismemberment.entity.EntityGibBase;
import net.minecraft.ModelBase;
import net.minecraft.ModelRenderer;
import net.minecraft.Entity;

public class ModelGibCow extends ModelBase {
    public ModelRenderer cowHead;
    public ModelRenderer cowBody;
    public ModelRenderer cowLeg;
    public ModelRenderer cowHornLeft;
    public ModelRenderer cowHornRight;

    public ModelGibCow() {
        this.textureWidth = 64;
        this.textureHeight = 32;

        // Head box adjusted to be centered around (0,0,0)
        this.cowHead = new ModelRenderer(this, 0, 0).setTextureSize(64, 32);
        this.cowHead.addBox(-4.0F, -4.0F, -3.0F, 8, 8, 6);
        this.cowHead.setRotationPoint(0.0F, 0.0F, 0.0F);

        this.cowHornLeft = new ModelRenderer(this, 22, 0).setTextureSize(64, 32);
        this.cowHornLeft.addBox(-5.0F, -5.0F, -4.0F, 1, 3, 1);
        this.cowHornLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.cowHead.addChild(this.cowHornLeft);

        this.cowHornRight = new ModelRenderer(this, 22, 0).setTextureSize(64, 32);
        this.cowHornRight.addBox(4.0F, -5.0F, -4.0F, 1, 3, 1);
        this.cowHornRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.cowHead.addChild(this.cowHornRight);

        // Body barrel trunk adjusted to be centered around (0,0,0)
        this.cowBody = new ModelRenderer(this, 18, 4).setTextureSize(64, 32);
        this.cowBody.addBox(-6.0F, -9.0F, -6.0F, 12, 18, 10);
        this.cowBody.setRotationPoint(0.0F, 0.0F, 0.0F);

        // Stocky leg box adjusted to be centered around (0,0,0)
        this.cowLeg = new ModelRenderer(this, 0, 16).setTextureSize(64, 32);
        this.cowLeg.addBox(-2.0F, -6.0F, -2.0F, 4, 12, 4);
        this.cowLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity ent, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, ent);

        if (ent instanceof EntityGibBase gib) {
            if (gib.type == 0) {
                this.cowHead.render(f5);
            } else if (gib.type == 1) {
                this.cowBody.render(f5);
            } else if (gib.type >= 2 && gib.type <= 5) {
                this.cowLeg.render(f5);
            }
        }
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
        this.cowHead.rotateAngleY = 0.0F; this.cowHead.rotateAngleX = 0.0F;
        this.cowBody.rotateAngleY = 0.0F; this.cowBody.rotateAngleX = 0.0F;
        this.cowLeg.rotateAngleY = 0.0F; this.cowLeg.rotateAngleX = 0.0F;
    }
}
