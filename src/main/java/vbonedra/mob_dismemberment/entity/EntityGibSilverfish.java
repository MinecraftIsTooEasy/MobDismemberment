package vbonedra.mob_dismemberment.entity;

import net.minecraft.Entity;
import net.minecraft.EntityLivingBase;
import net.minecraft.World;

public class EntityGibSilverfish extends EntityGibBase {
    public EntityGibSilverfish(World world) {
        super(world);
    }
    public EntityGibSilverfish(World world, EntityLivingBase gibParent, int gibType, Entity explosion_source) {
        super(world, gibParent, gibType, explosion_source, 0.2F, 0.15F, 0.0D);
        double startX = gibParent.posX;
        double startY = gibParent.boundingBox.minY;
        double startZ = gibParent.posZ;
        float yawOffset = gibParent.renderYawOffset;
        double mathYaw = Math.toRadians(yawOffset);
        double forwardFactor = 0.0D;
        int[][] lengths = new int[][]{{3, 2, 2}, {4, 3, 2}, {6, 4, 3}, {3, 3, 3}, {2, 2, 3}, {2, 1, 2}, {1, 1, 2}};
        double currentOffset = -3.5D;
        for (int i = 0; i <= gibType; i++) {
            if (i == gibType) {
                forwardFactor = currentOffset + (lengths[i][2] * 0.5D);
                break;
            }
            if (i < lengths.length - 1) {
                currentOffset += (lengths[i][2] + lengths[i + 1][2]) * 0.5D;
            }
        }
        startX += (forwardFactor * 0.0625D) * Math.sin(mathYaw);
        startZ -= (forwardFactor * 0.0625D) * Math.cos(mathYaw);
        startY += 0.05D;
        this.setPosition(startX, startY, startZ);
        this.setLocationAndAngles(startX, startY, startZ, this.rotationYaw, this.rotationPitch);
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;
    }
}
