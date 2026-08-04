package vbonedra.mob_dismemberment.entity;

import net.minecraft.Entity;
import net.minecraft.EntityLivingBase;
import net.minecraft.World;

public class EntityGibBat extends EntityGibBase {
	public EntityGibBat(World world) {
		super(world);
	}

	public EntityGibBat(World world, EntityLivingBase gibParent, int gibType, Entity explosion_source) {
		super(world, gibParent, gibType, explosion_source, 0.2F, 0.2F, 0.0D);
		double startX = gibParent.posX;
		double startY = gibParent.boundingBox.minY;
		double startZ = gibParent.posZ;
		float yawOffset = gibParent.renderYawOffset;
		double mathYaw = Math.toRadians(yawOffset);
		double cos = Math.cos(mathYaw);
		double sin = Math.sin(mathYaw);

		// gibType: 0 = Head, 1 = Body, 2 = Right Wing Pack, 3 = Left Wing Pack
		if (gibType == 0) {
			this.setSize(0.25F, 0.25F);
			this.rotationYaw = gibParent.rotationYaw;
			startY += 0.45D;
		} else if (gibType == 1) {
			this.setSize(0.25F, 0.45F);
			startY += 0.25D;
		} else {
			this.setSize(0.45F, 0.4F);
			double localX = (gibType == 2) ? -0.15D : 0.15D;
			startX += localX * cos;
			startZ += localX * sin;
			startY += 0.3D;
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
