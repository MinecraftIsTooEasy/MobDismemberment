package vbonedra.mob_dismemberment.entity;

import net.minecraft.Entity;
import net.minecraft.EntityLivingBase;
import net.minecraft.World;

public class EntityGibVillager extends EntityGibBase {
	public EntityGibVillager(World world) {
		super(world);
	}

	public EntityGibVillager(World world, EntityLivingBase gibParent, int gibType, Entity explosion_source) {
		super(world, gibParent, gibType, explosion_source, 0.25F, 0.25F, 0.0D);
		double startX = gibParent.posX;
		double startY = gibParent.boundingBox.minY;
		double startZ = gibParent.posZ;
		float yawOffset = gibParent.renderYawOffset;
		double mathYaw = Math.toRadians(yawOffset);
		double cos = Math.cos(mathYaw);
		double sin = Math.sin(mathYaw);

		if (gibType == 0) {
			this.setSize(0.35F, 0.45F);
			this.rotationYaw = gibParent.rotationYaw;
			startY += 1.35D;
		} else if (gibType == 1) {
			this.setSize(0.4F, 0.65F);
			startY += 0.8D;
		} else if (gibType == 2) {
			this.setSize(0.5F, 0.25F);
			double localZ = -0.0625D;
			startX -= localZ * sin;
			startZ += localZ * cos;
			startY += 1.0D;
		} else {
			this.setSize(0.25F, 0.75F);
			double localX = (gibType == 3) ? -0.125D : 0.125D;
			startX += localX * cos;
			startZ += localX * sin;
			startY += 0.375D;
		}

		this.setPosition(startX, startY, startZ);
		this.setLocationAndAngles(startX, startY, startZ, this.rotationYaw, this.rotationPitch);
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		this.prevRotationYaw = this.rotationYaw;
		this.prevRotationPitch = this.rotationPitch;
	}
}
