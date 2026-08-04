package vbonedra.mob_dismemberment.model;

import vbonedra.mob_dismemberment.entity.EntityGibBase;
import net.minecraft.ModelBase;
import net.minecraft.ModelRenderer;
import net.minecraft.Entity;

public class ModelGibZombieVillager extends ModelBase {
    public ModelRenderer bipedHead;
    public ModelRenderer bipedBody;
    public ModelRenderer bipedRightArm;
    public ModelRenderer bipedLeftArm;
    public ModelRenderer bipedRightLeg;
    public ModelRenderer bipedLeftLeg;

    public ModelGibZombieVillager() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.bipedHead = new ModelRenderer(this);
        this.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedHead.setTextureOffset(0, 32).addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8);
        this.bipedHead.setTextureOffset(24, 32).addBox(-1.0F, -3.0F, -6.0F, 2, 4, 2);
        this.bipedBody = new ModelRenderer(this, 16, 16);
        this.bipedBody.addBox(-4.0F, -6.0F, -2.0F, 8, 12, 4);
        this.bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedRightArm = new ModelRenderer(this, 40, 16);
        this.bipedRightArm.addBox(-2.0F, -6.0F, -2.0F, 4, 12, 4);
        this.bipedRightArm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedLeftArm = new ModelRenderer(this, 40, 16);
        this.bipedLeftArm.mirror = true;
        this.bipedLeftArm.addBox(-2.0F, -6.0F, -2.0F, 4, 12, 4);
        this.bipedLeftArm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedRightLeg = new ModelRenderer(this, 0, 16);
        this.bipedRightLeg.addBox(-2.0F, -6.0F, -2.0F, 4, 12, 4);
        this.bipedRightLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
        this.bipedLeftLeg.mirror = true;
        this.bipedLeftLeg.addBox(-2.0F, -6.0F, -2.0F, 4, 12, 4);
        this.bipedLeftLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
        if (par1Entity instanceof EntityGibBase gib) {
            if (gib.type == 0) {
                this.bipedHead.render(par7);
            } else if (gib.type == 1) {
                this.bipedBody.render(par7);
            } else if (gib.type == 2) {
                this.bipedRightArm.render(par7);
            } else if (gib.type == 3) {
                this.bipedLeftArm.render(par7);
            } else if (gib.type == 4) {
                this.bipedRightLeg.render(par7);
            } else if (gib.type == 5) {
                this.bipedLeftLeg.render(par7);
            }
        }
    }

    @Override
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
        this.bipedHead.rotateAngleX = 0.0F; this.bipedHead.rotateAngleY = 0.0F;
        this.bipedBody.rotateAngleX = 0.0F; this.bipedBody.rotateAngleY = 0.0F;
        this.bipedRightArm.rotateAngleX = 0.0F; this.bipedRightArm.rotateAngleY = 0.0F;
        this.bipedLeftArm.rotateAngleX = 0.0F; this.bipedLeftArm.rotateAngleY = 0.0F;
        this.bipedRightLeg.rotateAngleX = 0.0F; this.bipedRightLeg.rotateAngleY = 0.0F;
        this.bipedLeftLeg.rotateAngleX = 0.0F; this.bipedLeftLeg.rotateAngleY = 0.0F;
    }
}
