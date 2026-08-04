package vbonedra.mob_dismemberment.entity;

import net.minecraft.Entity;
import net.minecraft.EntityLivingBase;
import net.minecraft.World;

public class EntityGibOcelot extends EntityGibBase {
    public EntityGibOcelot(World world) {
        super(world);
    }
    public EntityGibOcelot(World world, EntityLivingBase gibParent, int gibType, Entity explosion_source) {
        super(world, gibParent, gibType, explosion_source, 0.2F, 0.3F, 0.0D);
        double startX = gibParent.posX;
        double startY = gibParent.boundingBox.minY;
        double startZ = gibParent.posZ;
        float yawOffset = gibParent.renderYawOffset;
        double mathYaw = Math.toRadians(yawOffset);
        if (gibType == 0) {
            this.setSize(0.25F, 0.25F);
            this.rotationYaw = gibParent.rotationYaw;
            startX += 0.55D * Math.sin(mathYaw);
            startZ -= 0.55D * Math.cos(mathYaw);
            startY += 0.4D;
        } else if (gibType == 1) {
            this.setSize(0.3F, 0.4F);
            startY += 0.3D;
        } else if (gibType == 6 || gibType == 7) {
            this.setSize(0.1F, 0.3F);
            startX -= 0.5D * Math.sin(mathYaw);
            startZ += 0.5D * Math.cos(mathYaw);
            startY += 0.35D;
            if (gibType == 7) {
                startY -= 0.15D;
            }
        } else {
            this.setSize(0.15F, 0.35F);
            double sideOffset = 0.12D;
            double forwardOffset = (gibType == 2 || gibType == 3) ? 0.3D : -0.3D;
            if (gibType == 3 || gibType == 5) {
                sideOffset *= -1.0D;
            }
            startX += sideOffset * Math.cos(mathYaw);
            startZ += sideOffset * Math.sin(mathYaw);
            startX += forwardOffset * Math.sin(mathYaw);
            startZ -= forwardOffset * Math.cos(mathYaw);
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
