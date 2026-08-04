package vbonedra.mob_dismemberment.entity;

import net.minecraft.Entity;
import net.minecraft.EntityLivingBase;
import net.minecraft.World;

public class EntityGibSkeleton extends EntityGibBase {
    public EntityGibSkeleton(World world) {
        super(world);
    }

    public EntityGibSkeleton(World world, EntityLivingBase gibParent, int gibType, Entity explosion_source) {
        super(world, gibParent, gibType, explosion_source, 0.25F, 0.25F, 0.0D);
        double startX = gibParent.posX;
        double startY = gibParent.boundingBox.minY;
        double startZ = gibParent.posZ;
        float yawOffset = gibParent.renderYawOffset;
        double mathYaw = Math.toRadians(yawOffset);
        double cos = Math.cos(mathYaw);
        double sin = Math.sin(mathYaw);

        // gibType: 0 = Head, 1 = Torso/Chest, 2 = Right Arm, 3 = Left Arm, 4 = Right Leg, 5 = Left Leg
        if (gibType == 0) {
            this.setSize(0.25F, 0.25F);
            this.rotationYaw = gibParent.rotationYaw;
            startY += 1.6D;
        } else if (gibType == 1) {
            this.setSize(0.3F, 0.45F);
            startY += 1.0D;
        } else if (gibType == 2 || gibType == 3) {
            this.setSize(0.125F, 0.45F);
            double localX = (gibType == 2) ? -0.3125D : 0.3125D;
            startX += localX * cos;
            startZ += localX * sin;
            startY += 1.1D;
        } else {
            this.setSize(0.125F, 0.45F);
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
