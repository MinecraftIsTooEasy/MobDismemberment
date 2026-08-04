package vbonedra.mob_dismemberment.model;

import vbonedra.mob_dismemberment.entity.EntityGibBase;
import net.minecraft.ModelBase;
import net.minecraft.ModelRenderer;
import net.minecraft.Entity;

public class ModelGibHumanoidClassic extends ModelBase {
    public ModelRenderer head32;
    public ModelRenderer body32;
    public ModelRenderer arm32;
    public ModelRenderer leg32;

    public ModelGibHumanoidClassic() {
        this.textureWidth = 64;
        this.textureHeight = 32;

        this.head32 = new ModelRenderer(this, 0, 0).setTextureSize(64, 32);
        this.head32.addBox(-4F, -4F, -4F, 8, 8, 8);
        this.head32.setRotationPoint(0F, 0F, 0F);

        this.body32 = new ModelRenderer(this, 16, 16).setTextureSize(64, 32);
        this.body32.addBox(-4F, -6F, -2F, 8, 12, 4);
        this.body32.setRotationPoint(0F, 0F, 0F);

        this.arm32 = new ModelRenderer(this, 40, 16).setTextureSize(64, 32);
        this.arm32.addBox(-2F, -6F, -2F, 4, 12, 4);
        this.arm32.setRotationPoint(0F, 0F, 0F);

        this.leg32 = new ModelRenderer(this, 0, 16).setTextureSize(64, 32);
        this.leg32.addBox(-2F, -6F, -2F, 4, 12, 4);
        this.leg32.setRotationPoint(0F, 0F, 0F);
    }

    @Override
    public void render(Entity ent, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, ent);

        if (ent instanceof EntityGibBase gib) {
            if (gib.type == 0) {
                this.head32.render(f5);
            } else if (gib.type == 1 || gib.type == 2) {
                this.arm32.render(f5);
            } else if (gib.type == 3) {
                this.body32.render(f5);
            } else if (gib.type == 4 || gib.type == 5) {
                this.leg32.render(f5);
            }
        }
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
        this.head32.rotateAngleY = 0.0F; this.head32.rotateAngleX = 0.0F;
        this.body32.rotateAngleY = 0.0F; this.body32.rotateAngleX = 0.0F;
        this.arm32.rotateAngleY = 0.0F; this.arm32.rotateAngleX = 0.0F;
        this.leg32.rotateAngleY = 0.0F; this.leg32.rotateAngleX = 0.0F;
    }
}
