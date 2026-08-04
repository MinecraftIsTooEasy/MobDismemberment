package vbonedra.mob_dismemberment.render;

import vbonedra.mob_dismemberment.entity.EntityGibBase;
import net.minecraft.Render;
import net.minecraft.RenderManager;
import net.minecraft.Entity;
import net.minecraft.ResourceLocation;
import net.minecraft.OpenGlHelper;
import net.minecraft.ModelBase;
import org.lwjgl.opengl.GL11;

public class RenderGibGhast extends RenderGibBase {
    public RenderGibGhast(ModelBase model, ResourceLocation defaultTexture) {
        super(model, defaultTexture);
    }

    @Override
    public void doRender(Entity ent, double par2, double par4, double par6, float par8, float par9) {
        if (!(ent instanceof EntityGibBase gib)) {
            return;
        }
        GL11.glDisable(GL11.GL_CULL_FACE);
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glTexEnvi(GL11.GL_TEXTURE_ENV, GL11.GL_TEXTURE_ENV_MODE, GL11.GL_MODULATE);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        ResourceLocation targetTexture = this.fallbackTexture;
        Render parentRenderer = null;
        if (gib.parent != null) {
            parentRenderer = RenderManager.instance.getEntityRenderObject(gib.parent);
            if (parentRenderer != null) {
                ResourceLocation dynamicLoc = parentRenderer.getEntityTexture(gib.parent);
                if (dynamicLoc != null) {
                    targetTexture = dynamicLoc;
                }
            }
        }
        if (RenderManager.instance != null && RenderManager.instance.renderEngine != null) {
            RenderManager.instance.renderEngine.bindTexture(targetTexture);
        } else {
            this.bindTexture(targetTexture);
        }
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        float alpha = 1.0F;
        int maxGroundTime = vbonedra.mob_dismemberment.config.MDConfig.gibGroundTime.getIntegerValue();
        if (gib.groundTime >= maxGroundTime) {
            alpha = 1.0F - (gib.groundTime - maxGroundTime + par9) / 20F;
            if (alpha < 0.0F) {
                alpha = 0.0F;
            }
            if (alpha > 1.0F) {
                alpha = 1.0F;
            }
        }
        GL11.glColor4f(1.0F, 1.0F, 1.0F, alpha);
        GL11.glAlphaFunc(GL11.GL_GREATER, 0.003921569F);
        GL11.glTranslated(par2, par4 + (gib.height * 0.5F), par6);
        float renderYaw = gib.prevRotationYaw + (gib.rotationYaw - gib.prevRotationYaw) * par9;
        float renderPitch = gib.prevRotationPitch + (gib.rotationPitch - gib.prevRotationPitch) * par9;
        GL11.glRotatef(180.0F - renderYaw, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-renderPitch, 1.0F, 0.0F, 0.0F);
        GL11.glScalef(-1.0F, -1.0F, 1.0F);

        GL11.glPushMatrix();
        GL11.glScalef(4.0F, 4.0F, 4.0F);

        this.modelGib.render(gib, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();

        if (parentRenderer != null && targetTexture != null) {
            try {
                ResourceLocation nativeGlowTexture = parentRenderer.getGlowingTextureCounterpart(targetTexture);
                if (nativeGlowTexture != null) {
                    parentRenderer.use_glowing_texture = true;
                    if (RenderManager.instance != null && RenderManager.instance.renderEngine != null) {
                        RenderManager.instance.renderEngine.bindTexture(nativeGlowTexture);
                    } else {
                        this.bindTexture(nativeGlowTexture);
                    }
                    GL11.glDisable(GL11.GL_BLEND);
                    GL11.glEnable(GL11.GL_ALPHA_TEST);
                    GL11.glAlphaFunc(GL11.GL_GREATER, 0.003921569F);
                    GL11.glDisable(GL11.GL_LIGHTING);
                    int var5 = 15728880;
                    int var6 = var5 % 65536;
                    int var7 = var5 / 65536;
                    OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)var6 / 1.0F, (float)var7 / 1.0F);
                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

                    GL11.glPushMatrix();
                    if (gib.type == 0) {
                        GL11.glScalef(4.0F, 4.0F, 4.0F);
                    }
                    this.modelGib.render(gib, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    GL11.glPopMatrix();

                    GL11.glEnable(GL11.GL_LIGHTING);
                    GL11.glEnable(GL11.GL_BLEND);
                    GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
                    parentRenderer.use_glowing_texture = false;
                }
            } catch (Exception ignored) {}
        }
        GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
        GL11.glEnable(GL11.GL_CULL_FACE);
    }
}
