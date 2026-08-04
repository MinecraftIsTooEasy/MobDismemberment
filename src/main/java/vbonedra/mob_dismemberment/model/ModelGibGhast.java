package vbonedra.mob_dismemberment.model;

import vbonedra.mob_dismemberment.entity.EntityGibBase;
import net.minecraft.ModelBase;
import net.minecraft.ModelRenderer;
import net.minecraft.Entity;
import net.minecraft.MathHelper;
import java.util.Random;

public class ModelGibGhast extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer tentacle;

    public ModelGibGhast() {
        this.textureWidth = 64;
        this.textureHeight = 32;

        this.body = new ModelRenderer(this, 0, 0);
        this.body.addBox(-8.0F, -8.0F, -8.0F, 16, 16, 16);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);

        this.tentacle = new ModelRenderer(this, 0, 0);
        this.tentacle.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2);
        this.tentacle.setRotationPoint(0.0F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity ent, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
        if (ent instanceof EntityGibBase gib) {
            if (gib.type == 0) {
                this.body.render(f5);
            } else {
                int index = gib.type - 1;
                this.tentacle.render(f5);
            }
        }
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
        this.body.rotateAngleY = 0.0F; this.body.rotateAngleX = 0.0F;
        this.tentacle.rotateAngleY = 0.0F; this.tentacle.rotateAngleX = 0.0F;
    }
}
