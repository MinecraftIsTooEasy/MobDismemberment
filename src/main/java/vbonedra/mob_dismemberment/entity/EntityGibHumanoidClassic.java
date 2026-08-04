package vbonedra.mob_dismemberment.entity;

import net.minecraft.Entity;
import net.minecraft.EntityLivingBase;
import net.minecraft.World;

public class EntityGibHumanoidClassic extends EntityGibBase {

    public EntityGibHumanoidClassic(World world) {
        super(world);
    }

    public EntityGibHumanoidClassic(World world, EntityLivingBase gibParent, int gibType, Entity explosion_source) {
        super(world, gibParent, gibType, explosion_source, 0.3F, 0.4F, 0.0D);

        float yawOffset = gibParent.renderYawOffset;
        double mathYaw = Math.toRadians(yawOffset);

        double startX = gibParent.posX;
        double startY = gibParent.boundingBox.minY;
        double startZ = gibParent.posZ;

        if (gibType == 0) {
            this.setSize(0.5F, 0.5F);
            this.rotationYaw = gibParent.rotationYawHead;
            startY += 1.5D;
        } else if (gibType == 1 || gibType == 2) {
            this.setSize(0.3F, 0.4F);
            double sideOffset = 0.350D;
            double forwardOffset = -0.250D;

            if (gibType == 2) {
                sideOffset *= -1.0D;
            }

            startX += sideOffset * Math.cos(mathYaw);
            startZ += sideOffset * Math.sin(mathYaw);
            startX += forwardOffset * Math.sin(mathYaw);
            startZ -= forwardOffset * Math.cos(mathYaw);
            startY += 1.25D;

            this.rotationPitch = -90.0F;
        } else if (gibType == 3) {
            this.setSize(0.5F, 0.5F);
            startY += 1.0D;
        } else if (gibType == 4 || gibType == 5) {
            this.setSize(0.3F, 0.4F);
            double sideOffset = 0.125D;

            if (gibType == 5) {
                sideOffset *= -1.0D;
            }

            startX += sideOffset * Math.cos(mathYaw);
            startZ += sideOffset * Math.sin(mathYaw);
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
