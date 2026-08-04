package vbonedra.mob_dismemberment.entity;

import net.minecraft.Entity;
import net.minecraft.EntityLivingBase;
import net.minecraft.World;

public class EntityGibZombieVillager extends EntityGibBase {
	public EntityGibZombieVillager(World world) {
		super(world);
	}

	public EntityGibZombieVillager(World world, EntityLivingBase gibParent, int gibType, Entity explosion_source) {
		super(world, gibParent, gibType, explosion_source, 0.3F, 0.3F, 0.0D);
		double startX = gibParent.posX;
		double startY = gibParent.boundingBox.minY;
		double startZ = gibParent.posZ;
		float yawOffset = gibParent.renderYawOffset;
		double mathYaw = Math.toRadians(yawOffset);
		double cos = Math.cos(mathYaw);
		double sin = Math.sin(mathYaw);

		if (gibType == 0) {
			this.setSize(0.3F, 0.3F);
			this.rotationYaw = gibParent.rotationYaw;
			startY += 1.62D;
		} else if (gibType == 1) {
			this.setSize(0.35F, 0.55F);
			startY += 0.95D;
		} else if (gibType == 2 || gibType == 3) {
			this.setSize(0.18F, 0.45F);
			double localX = (gibType == 2) ? -0.32D : 0.32D;
			startX += localX * cos;
			startZ += localX * sin;
			startY += 1.15D;
		} else {
			this.setSize(0.18F, 0.45F);
			double localX = (gibType == 4) ? -0.125D : 0.125D;
			startX += localX * cos;
			startZ += localX * sin;
			startY += 0.35D;
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
