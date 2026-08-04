package vbonedra.mob_dismemberment.entity;

import net.minecraft.Entity;
import net.minecraft.EntityLivingBase;
import net.minecraft.World;

public class EntityGibWitch extends EntityGibBase {
    public EntityGibWitch(World world) {
        super(world);
    }

    public EntityGibWitch(World world, EntityLivingBase gibParent, int gibType, Entity explosion_source) {
        super(world, gibParent, gibType, explosion_source, 0.25F, 0.25F, 0.0D);
        double startX = gibParent.posX;
        double startY = gibParent.boundingBox.minY;
        double startZ = gibParent.posZ;
        float yawOffset = gibParent.renderYawOffset;
        double mathYaw = Math.toRadians(yawOffset);
        double cos = Math.cos(mathYaw);
        double sin = Math.sin(mathYaw);

        if (gibType == 0) {
            this.setSize(0.5F, 0.65F);
            this.rotationYaw = gibParent.rotationYaw;
            startY += 1.375D;
        } else if (gibType == 1) {
            this.setSize(0.65F, 0.5F);
            this.rotationYaw = gibParent.rotationYaw;
            startY += 1.5D;
        } else if (gibType == 2) {
            this.setSize(0.55F, 1.15F);
            startY += 0.55D;
        } else if (gibType == 3) {
            this.setSize(0.5F, 0.25F);
            double localZ = -0.0625D;
            startX -= localZ * sin;
            startZ += localZ * cos;
            startY += 1.0D;
        } else {
            this.setSize(0.25F, 0.75F);
            double localX = (gibType == 4) ? -0.125D : 0.125D;
            startX += localX * cos;
            startZ += localX * sin;
            startY += 0.375D;
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
