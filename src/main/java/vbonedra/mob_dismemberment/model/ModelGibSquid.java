package vbonedra.mob_dismemberment.model;

import vbonedra.mob_dismemberment.entity.EntityGibBase;
import net.minecraft.ModelBase;
import net.minecraft.ModelRenderer;
import net.minecraft.Entity;

public class ModelGibSquid extends ModelBase {
    public ModelRenderer squidBody;
    public ModelRenderer squidTentacle;

    public ModelGibSquid() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.squidBody = new ModelRenderer(this, 0, 0).setTextureSize(64, 32);
        this.squidBody.addBox(-6.0F, -8.0F, -6.0F, 12, 16, 12);
        this.squidBody.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.squidTentacle = new ModelRenderer(this, 48, 0).setTextureSize(64, 32);
        this.squidTentacle.addBox(-1.0F, -9.0F, -1.0F, 2, 18, 2);
        this.squidTentacle.setRotationPoint(0.0F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity ent, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
        if (ent instanceof EntityGibBase) {
            EntityGibBase gib = (EntityGibBase) ent;
            if (gib.type == 0) {
                this.squidBody.render(f5);
            } else if (gib.type >= 1 && gib.type <= 8) {
                this.squidTentacle.render(f5);
            }
        }
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
        this.squidBody.rotateAngleY = 0.0F; this.squidBody.rotateAngleX = 0.0F;
        this.squidTentacle.rotateAngleY = 0.0F; this.squidTentacle.rotateAngleX = 0.0F;
    }
}
