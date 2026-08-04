package vbonedra.mob_dismemberment.entity;

import net.minecraft.Entity;
import net.minecraft.EntityLivingBase;
import net.minecraft.World;

public class EntityGibEnderman extends EntityGibBase {
    public EntityGibEnderman(World world) {
        super(world);
    }
    public EntityGibEnderman(World world, EntityLivingBase gibParent, int gibType, Entity explosion_source) {
        super(world, gibParent, gibType, explosion_source, 0.25F, 0.8F, 0.0D);
        double startX = gibParent.posX;
        double startY = gibParent.boundingBox.minY;
        double startZ = gibParent.posZ;
        float yawOffset = gibParent.renderYawOffset;
        double mathYaw = Math.toRadians(yawOffset);
        if (gibType == 0) {
            this.setSize(0.5F, 0.5F);
            this.rotationYaw = gibParent.rotationYaw;
            startY += 2.6D;
        } else if (gibType == 1) {
            this.setSize(0.4F, 0.7F);
            startY += 1.9D;
        } else if (gibType == 2 || gibType == 3) {
            this.setSize(0.2F, 1.4F);
            double sideOffset = 0.3D;
            if (gibType == 3) {
                sideOffset *= -1.0D;
            }
            startX += sideOffset * Math.cos(mathYaw);
            startZ += sideOffset * Math.sin(mathYaw);
            startY += 1.4D;
            this.rotationPitch = -90.0F;
        } else {
            this.setSize(0.2F, 1.4F);
            double sideOffset = 0.12D;
            if (gibType == 5) {
                sideOffset *= -1.0D;
            }
            startX += sideOffset * Math.cos(mathYaw);
            startZ += sideOffset * Math.sin(mathYaw);
            startY += 0.5D;
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
