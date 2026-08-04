package vbonedra.mob_dismemberment.model;

import vbonedra.mob_dismemberment.entity.EntityGibBase;
import net.minecraft.ModelBase;
import net.minecraft.ModelRenderer;
import net.minecraft.Entity;

public class ModelGibMagmaCube extends ModelBase {
    public ModelRenderer[] segments = new ModelRenderer[4];
    public ModelRenderer core;

    public ModelGibMagmaCube() {
        this.textureWidth = 64;
        this.textureHeight = 32;

        for (int i = 0; i < 4; ++i) {
            int texX = 0;
            int texY = i;
            if (i == 2) { texX = 24; texY = 10; }
            else if (i == 3) { texX = 24; texY = 19; }

            this.segments[i] = new ModelRenderer(this, texX, texY).setTextureSize(64, 32);
            this.segments[i].addBox(-4.0F, -1.0F, -4.0F, 8, 1, 8);

            this.segments[i].setTextureOffset(0, i + 4).addBox(-4.0F, 1.0F, -4.0F, 8, 1, 8);
            this.segments[i].setRotationPoint(0.0F, 0.0F, 0.0F);
        }

        this.core = new ModelRenderer(this, 0, 16).setTextureSize(64, 32);
        this.core.addBox(-2.0F, -2.0F, -2.0F, 4, 4, 4);
        this.core.setRotationPoint(0.0F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity ent, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
        if (ent instanceof EntityGibBase gib) {
            if (gib.type >= 0 && gib.type <= 3) {
                this.segments[gib.type].render(f5);
            } else if (gib.type == 4) {
                this.core.render(f5);
            }
        }
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
        for (int i = 0; i < this.segments.length; ++i) {
            this.segments[i].rotateAngleY = 0.0F; this.segments[i].rotateAngleX = 0.0F;
        }
        this.core.rotateAngleY = 0.0F; this.core.rotateAngleX = 0.0F;
    }
}
