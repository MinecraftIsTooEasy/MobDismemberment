package vbonedra.mob_dismemberment.entity;

import net.minecraft.Entity;
import net.minecraft.EntityLivingBase;
import net.minecraft.World;

public class EntityGibArachnid extends EntityGibBase {
    public EntityGibArachnid(World world) {
        super(world);
    }

    public EntityGibArachnid(World world, EntityLivingBase gibParent, int gibType, Entity explosion_source) {
        super(world, gibParent, gibType, explosion_source, 0.4F, 0.4F, 0.0D);
        double startX = gibParent.posX;
        double startY = gibParent.boundingBox.minY;
        double startZ = gibParent.posZ;
        float yawOffset = gibParent.renderYawOffset;
        double mathYaw = Math.toRadians(yawOffset);
        double cos = Math.cos(mathYaw);
        double sin = Math.sin(mathYaw);

        // gibType: 0 = Head, 1 = Neck, 2 = Abdomen/Body, 3-10 = Legs 1-8
        if (gibType == 0) {
            this.setSize(0.5F, 0.5F);
            this.rotationYaw = gibParent.rotationYaw;
            double localX = 0.0D;
            double localZ = -0.1875D;
            startX += localX * cos - localZ * sin;
            startZ += localX * sin + localZ * cos;
            startY += 0.5625D;
        } else if (gibType == 1) {
            this.setSize(0.4F, 0.4F);
            startY += 0.5625D;
        } else if (gibType == 2) {
            this.setSize(0.65F, 0.55F);
            double localX = 0.0D;
            double localZ = 0.5625D;
            startX += localX * cos - localZ * sin;
            startZ += localX * sin + localZ * cos;
            startY += 0.5625D;
        } else {
            this.setSize(0.5F, 0.15F);
            int legIndex = gibType - 3;
            double localX = (legIndex % 2 == 0) ? -0.25D : 0.25D;
            double localZ = 0.0D;

            if (legIndex == 0 || legIndex == 1) { localZ = 0.125D; }
            else if (legIndex == 2 || legIndex == 3) { localZ = 0.0625D; }
            else if (legIndex == 4 || legIndex == 5) { localZ = 0.0D; }
            else if (legIndex == 6 || legIndex == 7) { localZ = -0.0625D; }

            startX += localX * cos - localZ * sin;
            startZ += localX * sin + localZ * cos;
            startY += 0.5625D;
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
