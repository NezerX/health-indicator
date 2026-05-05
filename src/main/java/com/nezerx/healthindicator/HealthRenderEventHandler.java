package com.nezerx.healthindicator;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraftforge.client.event.RenderNameTagEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.WeakHashMap;

public class HealthRenderEventHandler {

    private static final ResourceLocation BAR_EMPTY = new ResourceLocation(HealthIndicatorMod.MODID, "textures/gui/bar_empty.png");
    private static final ResourceLocation BAR_DAMAGE = new ResourceLocation(HealthIndicatorMod.MODID, "textures/gui/bar_damage.png");
    private static final ResourceLocation BAR_FULL = new ResourceLocation(HealthIndicatorMod.MODID, "textures/gui/bar1.png");

    private static final WeakHashMap<LivingEntity, MobData> DATA = new WeakHashMap<>();

    @SubscribeEvent
    public void onRenderNameTag(RenderNameTagEvent event) {
        if (!(event.getEntity() instanceof Mob mob)) return;

        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;

        if (!(mob instanceof Enemy) || mob.distanceToSqr(mc.player) > 400.0D || !mc.player.hasLineOfSight(mob)) {
            return;
        }

        long time = mob.level().getGameTime();
        float currentHealth = mob.getHealth();

        boolean isActiveNow = mob.isAggressive() || mob.hurtTime > 0;
        if (mob instanceof Creeper creeper && creeper.getSwellDir() > 0) isActiveNow = true;

        if (!isActiveNow && !DATA.containsKey(mob)) return;

        MobData data = DATA.computeIfAbsent(mob, k -> new MobData(currentHealth, 0));

        if (isActiveNow) {
            data.lastActiveTime = time;
        }

        if (time - data.lastActiveTime > 60) {
            DATA.remove(mob);
            return;
        }

        event.setResult(Result.DENY);

        if (currentHealth < data.realHealth) {
            data.recentDamage += (data.realHealth - currentHealth);
            data.lastHitTime = time;
        } else if (currentHealth > data.realHealth) {
            data.displayedHealth = currentHealth;
            data.recentDamage = 0;
        }
        data.realHealth = currentHealth;

        if (time - data.lastHitTime > 15) {
            if (data.displayedHealth > currentHealth) {
                data.displayedHealth -= 0.15F;
                if (data.displayedHealth < currentHealth) data.displayedHealth = currentHealth;
            }
        }

        if (time - data.lastHitTime > 40) data.recentDamage = 0;

        PoseStack poseStack = event.getPoseStack();
        poseStack.pushPose();
        poseStack.translate(0.0D, mob.getBbHeight() + 0.5D, 0.0D);
        poseStack.mulPose(mc.getEntityRenderDispatcher().cameraOrientation());
        poseStack.scale(-0.025F, -0.025F, 0.025F);

        float width = 100.0F;
        float height = 10.0F;
        float x = -width / 2;

        float ratioMain = currentHealth / mob.getMaxHealth();
        float ratioDamage = data.displayedHealth / mob.getMaxHealth();

        RenderHelper.drawTexture(poseStack, BAR_EMPTY, x, 0, width, height);
        RenderHelper.drawTexture(poseStack, BAR_DAMAGE, x, 0, width * ratioDamage, height);
        RenderHelper.drawTexture(poseStack, BAR_FULL, x, 0, width * ratioMain, height);

        if (data.recentDamage > 0.1F) {
            String dmgText = "-" + Math.round(data.recentDamage);

            poseStack.pushPose();
            // Текст слева: x (начало полоски), по вертикали под полоской (height + 2)
            poseStack.translate(x, height + 2, 0);
            poseStack.scale(0.8F, 0.8F, 0.8F);

            mc.font.drawInBatch(
                    dmgText, 0, 0, 0xFFFF5555,
                    true, poseStack.last().pose(),
                    event.getMultiBufferSource(),
                    net.minecraft.client.gui.Font.DisplayMode.NORMAL,
                    0,
                    LightTexture.FULL_BRIGHT // Магия яркости: теперь видно в любой темноте
            );
            poseStack.popPose();
        }

        poseStack.popPose();
    }

    private static class MobData {
        float realHealth;
        float displayedHealth;
        float recentDamage;
        long lastHitTime;
        long lastActiveTime;

        MobData(float initialHealth, long lastActive) {
            this.realHealth = initialHealth;
            this.displayedHealth = initialHealth;
            this.lastActiveTime = lastActive;
        }
    }
}