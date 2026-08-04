package vbonedra.mob_dismemberment.entity;

import net.minecraft.Entity;
import net.minecraft.EntityLivingBase;
import net.minecraft.World;

public class EntityGibChicken extends EntityGibBase {
    public EntityGibChicken(World world) {
        super(world);
    }
    public EntityGibChicken(World world, EntityLivingBase gibParent, int gibType, Entity explosion_source) {
        super(world, gibParent, gibType, explosion_source, 0.2F, 0.2F, 0.0D);
        double startX = gibParent.posX;
        double startY = gibParent.boundingBox.minY;
        double startZ = gibParent.posZ;
        float yawOffset = gibParent.renderYawOffset;
        double mathYaw = Math.toRadians(yawOffset);
        if (gibType == 0) {
            this.setSize(0.25F, 0.25F);
            startX += 0.25D * Math.sin(mathYaw);
            startZ -= 0.25D * Math.cos(mathYaw);
            startY += 0.55D;
        } else if (gibType == 1) {
            this.setSize(0.35F, 0.35F);
            startY += 0.35D;
        } else if (gibType == 2 || gibType == 3) {
            this.setSize(0.15F, 0.25F);
            double sideOffset = 0.25D;
            if (gibType == 3) {
                sideOffset *= -1.0D;
            }
            startX += sideOffset * Math.cos(mathYaw);
            startZ += sideOffset * Math.sin(mathYaw);
            startY += 0.4D;
        } else {
            this.setSize(0.15F, 0.3F);
            double sideOffset = 0.1D;
            if (gibType == 5) {
                sideOffset *= -1.0D;
            }
            startX += sideOffset * Math.cos(mathYaw);
            startZ += sideOffset * Math.sin(mathYaw);
            startY += 0.15D;
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
