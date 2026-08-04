package vbonedra.mob_dismemberment.entity;

import net.minecraft.Entity;
import net.minecraft.EntityLivingBase;
import net.minecraft.World;

public class EntityGibBlaze extends EntityGibBase {
    public EntityGibBlaze(World world) {
        super(world);
    }
    public EntityGibBlaze(World world, EntityLivingBase gibParent, int gibType, Entity explosion_source) {
        super(world, gibParent, gibType, explosion_source, 0.3F, 0.3F, 0.0D);
        double startX = gibParent.posX;
        double startY = gibParent.boundingBox.minY;
        double startZ = gibParent.posZ;
        float yawOffset = gibParent.renderYawOffset;
        double mathYaw = Math.toRadians(yawOffset);
        if (gibType == 0) {
            this.setSize(0.4F, 0.4F);
            startY += 1.6D;
        } else {
            this.setSize(0.15F, 0.5F);
            double radius = 0.4D;
            double angle = mathYaw + ((gibType - 1) * (Math.PI / 6.0D));
            startX += radius * Math.cos(angle);
            startZ += radius * Math.sin(angle);
            if (gibType <= 4) {
                startY += 1.4D;
            } else if (gibType <= 8) {
                startY += 0.9D;
            } else {
                startY += 0.4D;
            }
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
