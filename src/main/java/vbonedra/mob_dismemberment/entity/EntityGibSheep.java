package vbonedra.mob_dismemberment.entity;
import net.minecraft.Entity;
import net.minecraft.EntityLivingBase;
import net.minecraft.World;
public class EntityGibSheep extends EntityGibBase {
    public EntityGibSheep(World world) {
        super(world);
    }
    public EntityGibSheep(World world, EntityLivingBase gibParent, int gibType, Entity explosion_source) {
        super(world, gibParent, gibType, explosion_source, 0.4F, 0.4F, 0.0D);
        double startX = gibParent.posX;
        double startY = gibParent.boundingBox.minY;
        double startZ = gibParent.posZ;
        float yawOffset = gibParent.renderYawOffset;
        double mathYaw = Math.toRadians(yawOffset);
        if (gibType == 0) {
            this.setSize(0.45F, 0.45F);
            this.rotationYaw = gibParent.rotationYaw;
            startX += 0.5D * Math.sin(mathYaw);
            startZ -= 0.5D * Math.cos(mathYaw);
            startY += 0.9375D;
        } else if (gibType == 1) {
            this.setSize(0.65F, 0.65F);
            startX -= 0.125D * Math.sin(mathYaw);
            startZ += 0.125D * Math.cos(mathYaw);
            startY += 0.6875D;
        } else {
            this.setSize(0.25F, 0.4F);
            double sideOffset = 0.1875D;
            double forwardOffset = (gibType == 2 || gibType == 3) ? -0.4375D : 0.3125D;
            if (gibType == 3 || gibType == 5) {
                sideOffset *= -1.0D;
            }
            startX += sideOffset * Math.cos(mathYaw);
            startZ += sideOffset * Math.sin(mathYaw);
            startX += forwardOffset * Math.sin(mathYaw);
            startZ -= forwardOffset * Math.cos(mathYaw);
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

