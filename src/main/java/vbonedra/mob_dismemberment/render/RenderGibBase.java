package vbonedra.mob_dismemberment.render;

import net.minecraft.*;
import vbonedra.mob_dismemberment.config.MDConfig;
import vbonedra.mob_dismemberment.entity.EntityGibBase;
import org.lwjgl.opengl.GL11;

public class RenderGibBase extends Render {
    protected ModelBase modelGib;
    protected ResourceLocation fallbackTexture;

    public RenderGibBase(ModelBase model, ResourceLocation defaultTexture) {
        this.modelGib = model;
        this.fallbackTexture = defaultTexture;
    }

    @Override
    public ResourceLocation getEntityTexture(Entity ent) {
        return this.fallbackTexture;
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
        // fade out
        float fadeout = 1.0F;
        int gibGroundTime = MDConfig.gibGroundTime.getIntegerValue();
        if (gib.groundTime >= gibGroundTime) {
            fadeout = 1.0F - (gib.groundTime - gibGroundTime + par9) / 20F;
            if (fadeout < 0.0F) {
                fadeout = 0.0F;
            }
            if (fadeout > 1.0F) {
                fadeout = 1.0F;
            }
        }
        float blackout = MDConfig.gibFadeoutBlackout.getBooleanValue() ? fadeout : 1;
        GL11.glColor4f(blackout, blackout, blackout, MDConfig.gibFadeoutTransparency.getBooleanValue() ? fadeout : 1);
        GL11.glAlphaFunc(GL11.GL_GREATER, 0.004F);
        // move
        double randomYOffset = -((gib.entityId * 4513) % 1001 / 1000.0D) * 0.0625D;
        GL11.glTranslated(par2, par4 + (gib.height * 0.5F) + randomYOffset, par6);
        // rotate
        float renderYaw = gib.prevRotationYaw + (gib.rotationYaw - gib.prevRotationYaw) * par9;
        float renderPitch = gib.prevRotationPitch + (gib.rotationPitch - gib.prevRotationPitch) * par9;
        GL11.glRotatef(180.0F - renderYaw, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-renderPitch, 1.0F, 0.0F, 0.0F);
        GL11.glScalef(-1.0F, -1.0F, 1.0F);
        // scale
        if (RenderManager.instance.getEntityRenderObject(gib.parent) instanceof RendererLivingEntity rendererLivingEntity) {
            rendererLivingEntity.preRenderCallback(gib.parent, 1f);
        } else {
            float scale = getScale(gib);
            GL11.glScalef(scale, scale, scale);
        }
        float scaleout_factor = (MDConfig.gibFadeoutScale.getBooleanValue() ? fadeout : 1);
        GL11.glScalef(scaleout_factor, scaleout_factor, scaleout_factor);

        this.modelGib.render(gib, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
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
                    OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, var6, var7);
                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                    this.modelGib.render(gib, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
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

    private static float getScale(EntityGibBase gib) {
        if (gib.parent == null) {
            return 1.0F;
        }

        Object parentObj = gib.parent;
        Class<?> parentClass = parentObj.getClass();

        if (parentClass == EntityGhast.class) {
            return 4.0F;
        }
        if (parentClass == EntityCaveSpider.class) {
            return 0.7F;
        }
        if (parentClass == EntityWoodSpider.class
                || parentClass == EntityBlackWidowSpider.class
                || parentClass == EntityPhaseSpider.class) {
            return 0.6F;
        }

        if (parentObj instanceof EntityBat bat) {
            return 0.35F * bat.getScaleFactor();
        }

        return 1.0F;
    }

}
