package vbonedra.mob_dismemberment.entity;

import net.minecraft.Entity;
import net.minecraft.EntityLivingBase;
import net.minecraft.World;

public class EntityGibGelatinousCube extends EntityGibBase {
    public EntityGibGelatinousCube(World world) {
        super(world);
    }
    public EntityGibGelatinousCube(World world, EntityLivingBase gibParent, int gibType, Entity explosion_source) {
        super(world, gibParent, gibType, explosion_source, 0.4F, 0.4F, 0.0D);
        double startX = gibParent.posX;
        double startY = gibParent.boundingBox.minY;
        double startZ = gibParent.posZ;
        float yawOffset = gibParent.renderYawOffset;
        double mathYaw = Math.toRadians(yawOffset);
        if (gibType >= 0 && gibType <= 3) {
            this.setSize(0.5F, 0.5F);
            double sideOffset = 0.3D;
            double forwardOffset = (gibType == 0 || gibType == 1) ? 0.3D : -0.3D;
            if (gibType == 1 || gibType == 3) {
                sideOffset *= -1.0D;
            }
            startX += sideOffset * Math.cos(mathYaw);
            startZ += sideOffset * Math.sin(mathYaw);
            startX += forwardOffset * Math.sin(mathYaw);
            startZ -= forwardOffset * Math.cos(mathYaw);
            startY += 0.4D;
        } else {
            this.setSize(0.25F, 0.25F);
            double sideOffset = 0.15D;
            if (gibType == 5) {
                sideOffset *= -1.0D;
            }
            startX += sideOffset * Math.cos(mathYaw);
            startZ += sideOffset * Math.sin(mathYaw);
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
