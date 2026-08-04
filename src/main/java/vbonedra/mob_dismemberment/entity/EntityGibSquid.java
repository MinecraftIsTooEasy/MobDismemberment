package vbonedra.mob_dismemberment.entity;

import net.minecraft.Entity;
import net.minecraft.EntityLivingBase;
import net.minecraft.World;

public class EntityGibSquid extends EntityGibBase {
    public EntityGibSquid(World world) {
        super(world);
    }
    public EntityGibSquid(World world, EntityLivingBase gibParent, int gibType, Entity explosion_source) {
        super(world, gibParent, gibType, explosion_source, 0.4F, 0.4F, 0.0D);
        double startX = gibParent.posX;
        double startY = gibParent.boundingBox.minY;
        double startZ = gibParent.posZ;
        float yawOffset = gibParent.renderYawOffset;
        double mathYaw = Math.toRadians(yawOffset);
        // gibType: 0 = Body, 1-8 = Tentacles
        if (gibType == 0) {
            this.setSize(0.7F, 0.8F);
            startY += 0.5D;
        } else {
            this.setSize(0.2F, 0.6F);
            int index = gibType - 1;
            double angleFactor = (double)index * Math.PI * 2.0D / 8.0D;
            double localX = Math.cos(angleFactor) * 0.3125D;
            double localZ = Math.sin(angleFactor) * 0.3125D;
            startX += localX * Math.cos(mathYaw) - localZ * Math.sin(mathYaw);
            startZ += localX * Math.sin(mathYaw) + localZ * Math.cos(mathYaw);
            startY += 0.1D;
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
