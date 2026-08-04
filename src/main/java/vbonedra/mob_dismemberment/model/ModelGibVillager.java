package vbonedra.mob_dismemberment.model;

import vbonedra.mob_dismemberment.entity.EntityGibBase;
import net.minecraft.ModelBase;
import net.minecraft.ModelRenderer;
import net.minecraft.Entity;

public class ModelGibVillager extends ModelBase {
	public ModelRenderer villagerHead;
	public ModelRenderer villagerTorso;
	public ModelRenderer villagerArms;
	public ModelRenderer villagerLeg;

	public ModelGibVillager() {
		this.textureWidth = 64;
		this.textureHeight = 64;

		this.villagerHead = new ModelRenderer(this).setTextureSize(64, 64);
		this.villagerHead.setTextureOffset(0, 0).addBox(-4.0F, -5.0F, -4.0F, 8, 10, 8);
		this.villagerHead.setRotationPoint(0.0F, 0.0F, 0.0F);

		ModelRenderer villagerNose = new ModelRenderer(this).setTextureSize(64, 64);
		villagerNose.setTextureOffset(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2, 4, 2);
		villagerNose.setRotationPoint(0.0F, 2.25F, 0.0F);
		this.villagerHead.addChild(villagerNose);

		this.villagerTorso = new ModelRenderer(this).setTextureSize(64, 64);
		this.villagerTorso.setTextureOffset(16, 20).addBox(-4.0F, -6.0F, -3.0F, 8, 12, 6);
		this.villagerTorso.setTextureOffset(0, 38).addBox(-4.0F, -6.0F, -3.0F, 8, 18, 6, 0.5F);
		this.villagerTorso.setRotationPoint(0.0F, 0.0F, 0.0F);

		this.villagerArms = new ModelRenderer(this).setTextureSize(64, 64);
		this.villagerArms.setTextureOffset(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4, 8, 4);
		this.villagerArms.setTextureOffset(44, 22).addBox(4.0F, -2.0F, -2.0F, 4, 8, 4);
		this.villagerArms.setTextureOffset(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8, 4, 4);
		this.villagerArms.setRotationPoint(0.0F, 0.0F, 0.0F);

		this.villagerLeg = new ModelRenderer(this, 0, 22).setTextureSize(64, 64);
		this.villagerLeg.addBox(-2.0F, -6.0F, -2.0F, 4, 12, 4);
		this.villagerLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
	}

	@Override
	public void render(Entity ent, float f, float f1, float f2, float f3, float f4, float f5) {
		this.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
		if (ent instanceof EntityGibBase gib) {
			if (gib.type == 0) {
				this.villagerHead.render(f5);
			} else if (gib.type == 1) {
				this.villagerTorso.render(f5);
			} else if (gib.type == 2) {
				this.villagerArms.render(f5);
			} else if (gib.type == 3 || gib.type == 4) {
				this.villagerLeg.render(f5);
			}
		}
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
		this.villagerHead.rotateAngleX = 0.0F; this.villagerHead.rotateAngleY = 0.0F;
		this.villagerTorso.rotateAngleX = 0.0F; this.villagerTorso.rotateAngleY = 0.0F;
		this.villagerArms.rotateAngleX = 0.0F; this.villagerArms.rotateAngleY = 0.0F; this.villagerArms.rotateAngleZ = 0.0F;
		this.villagerLeg.rotateAngleX = 0.0F; this.villagerLeg.rotateAngleY = 0.0F;
	}
}
