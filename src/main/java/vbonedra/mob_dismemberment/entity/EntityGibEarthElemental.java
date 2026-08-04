package vbonedra.mob_dismemberment.entity;

import net.minecraft.Entity;
import net.minecraft.EntityLivingBase;
import net.minecraft.World;

public class EntityGibEarthElemental extends EntityGibBase {
    public EntityGibEarthElemental(World world) {
        super(world);
    }
    public EntityGibEarthElemental(World world, EntityLivingBase gibParent, int gibType, Entity explosion_source) {
        super(world, gibParent, gibType, explosion_source, 0.4F, 0.5F, 0.0D);
        double startX = gibParent.posX;
        double startY = gibParent.boundingBox.minY;
        double startZ = gibParent.posZ;
        float yawOffset = gibParent.renderYawOffset;
        double mathYaw = Math.toRadians(yawOffset);
        if (gibType == 0) {
            this.setSize(0.5F, 0.5F);
            this.rotationYaw = gibParent.rotationYaw;
            startY += 1.6D;
        } else if (gibType == 1 || gibType == 2) {
            this.setSize(0.35F, 0.6F);
            double sideOffset = 0.45D;
            double forwardOffset = -0.1D;
            if (gibType == 2) {
                sideOffset *= -1.0D;
            }
            startX += sideOffset * Math.cos(mathYaw);
            startZ += sideOffset * Math.sin(mathYaw);
            startX += forwardOffset * Math.sin(mathYaw);
            startZ -= forwardOffset * Math.cos(mathYaw);
            startY += 1.2D;
            this.rotationPitch = -90.0F;
        } else if (gibType == 3) {
            this.setSize(0.6F, 0.7F);
            startY += 0.9D;
        } else if (gibType == 4 || gibType == 5) {
            this.setSize(0.3F, 0.5F);
            double sideOffset = 0.2D;
            if (gibType == 5) {
                sideOffset *= -1.0D;
            }
            startX += sideOffset * Math.cos(mathYaw);
            startZ += sideOffset * Math.sin(mathYaw);
            startY += 0.4D;
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
