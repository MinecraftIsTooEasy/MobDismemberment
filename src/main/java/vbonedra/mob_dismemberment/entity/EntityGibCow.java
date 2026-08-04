package vbonedra.mob_dismemberment.entity;

import net.minecraft.Entity;
import net.minecraft.EntityLivingBase;
import net.minecraft.World;

public class EntityGibCow extends EntityGibBase {

    public EntityGibCow(World world) {
        super(world);
    }

    public EntityGibCow(World world, EntityLivingBase gibParent, int gibType, Entity explosion_source) {
        super(world, gibParent, gibType, explosion_source, 0.4F, 0.4F, 0.0D);
        double startX = gibParent.posX;
        double startY = gibParent.boundingBox.minY;
        double startZ = gibParent.posZ;
        float yawOffset = gibParent.renderYawOffset;
        double mathYaw = Math.toRadians(yawOffset);

        // gibType: 0 = Head, 1 = Body/Torso, 2 = Back Left Leg, 3 = Back Right Leg, 4 = Front Left Leg, 5 = Front Right Leg
        if (gibType == 0) {
            this.setSize(0.5F, 0.5F);
            this.rotationYaw = gibParent.rotationYaw;
            startX += 0.4D * Math.sin(mathYaw);
            startZ -= 0.4D * Math.cos(mathYaw);
            startY += 0.9D;
        } else if (gibType == 1) {
            this.setSize(0.6F, 0.8F);
            startY += 0.6D;
        } else {
            this.setSize(0.25F, 0.5F);
            double sideOffset = 0.25D;
            double forwardOffset = (gibType == 2 || gibType == 3) ? -0.4D : 0.4D;
            if (gibType == 3 || gibType == 5) {
                sideOffset *= -1.0D;
            }
            startX += sideOffset * Math.cos(mathYaw);
            startZ += sideOffset * Math.sin(mathYaw);
            startX += forwardOffset * Math.sin(mathYaw);
            startZ -= forwardOffset * Math.cos(mathYaw);
            startY += 0.2D;
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
