package vbonedra.mob_dismemberment.model;

import vbonedra.mob_dismemberment.entity.EntityGibBase;
import net.minecraft.ModelBase;
import net.minecraft.ModelRenderer;
import net.minecraft.Entity;

public class ModelGibSilverfish extends ModelBase {
    public ModelRenderer[] parts = new ModelRenderer[7];
    private static final int[][] lengths = new int[][]{{3, 2, 2}, {4, 3, 2}, {6, 4, 3}, {3, 3, 3}, {2, 2, 3}, {2, 1, 2}, {1, 1, 2}};
    private static final int[][] texturePositions = new int[][]{{0, 0}, {0, 4}, {0, 9}, {0, 16}, {0, 22}, {11, 0}, {13, 4}};

    public ModelGibSilverfish() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        for (int i = 0; i < this.parts.length; i++) {
            this.parts[i] = new ModelRenderer(this, texturePositions[i][0], texturePositions[i][1]).setTextureSize(64, 32);
            this.parts[i].addBox((float)lengths[i][0] * -0.5F, (float)lengths[i][1] * -0.5F, (float)lengths[i][2] * -0.5F, lengths[i][0], lengths[i][1], lengths[i][2]);
            this.parts[i].setRotationPoint(0.0F, 0.0F, 0.0F);
            if (i == 2) {
                ModelRenderer wing0 = new ModelRenderer(this, 20, 0).setTextureSize(64, 32);
                wing0.addBox(-5.0F, -4.0F, (float)lengths[2][2] * -0.5F, 10, 8, lengths[2][2]);
                wing0.setRotationPoint(0.0F, 0.0F, 0.0F);
                this.parts[i].addChild(wing0);
            } else if (i == 4) {
                ModelRenderer wing1 = new ModelRenderer(this, 20, 11).setTextureSize(64, 32);
                wing1.addBox(-3.0F, -2.0F, (float)lengths[4][2] * -0.5F, 6, 4, lengths[4][2]);
                wing1.setRotationPoint(0.0F, 0.0F, 0.0F);
                this.parts[i].addChild(wing1);
            } else if (i == 1) {
                ModelRenderer wing2 = new ModelRenderer(this, 20, 18).setTextureSize(64, 32);
                wing2.addBox(-3.0F, -2.5F, (float)lengths[1][2] * -0.5F, 6, 5, lengths[1][2]);
                wing2.setRotationPoint(0.0F, 0.0F, 0.0F);
                this.parts[i].addChild(wing2);
            }
        }
    }

    @Override
    public void render(Entity ent, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
        if (ent instanceof EntityGibBase gib) {
            if (gib.type >= 0 && gib.type < this.parts.length) {
                this.parts[gib.type].render(f5);
            }
        }
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
        for (ModelRenderer part : this.parts) {
            part.rotateAngleY = 0.0F;
            part.rotateAngleX = 0.0F;
        }
    }
}
