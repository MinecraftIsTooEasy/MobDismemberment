package vbonedra.mob_dismemberment.entity;

import net.minecraft.Entity;
import net.minecraft.EntityLivingBase;
import net.minecraft.World;

public class EntityGibGhast extends EntityGibBase {
    public EntityGibGhast(World world) {
        super(world);
    }

    public EntityGibGhast(World world, EntityLivingBase gibParent, int gibType, Entity explosion_source) {
        super(world, gibParent, gibType, explosion_source, 1.0F, 1.0F, 0.0D);
        double startX = gibParent.posX;
        double startY = gibParent.boundingBox.minY;
        double startZ = gibParent.posZ;

        float yawOffset = gibParent.renderYawOffset;
        double mathYaw = Math.toRadians(yawOffset);

        if (gibType == 0) {
            this.setSize(4.0F, 4.0F);
            startY += 2.0D;
        } else {
            this.setSize(0.25F, 1.0F);

            int index = gibType - 1;
            float offsetX = (((float)(index % 3) - (float)(index / 3 % 2) * 0.5F + 0.25F) / 2.0F * 2.0F - 1.0F) * 1.25F;
            float offsetZ = ((float)(index / 3) / 2.0F * 2.0F - 1.0F) * 1.25F;

            double rotatedX = offsetX * Math.cos(mathYaw) - offsetZ * Math.sin(mathYaw);
            double rotatedZ = offsetX * Math.sin(mathYaw) + offsetZ * Math.cos(mathYaw);

            startX += rotatedX;
            startZ += rotatedZ;
            startY += 0.8D;
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
