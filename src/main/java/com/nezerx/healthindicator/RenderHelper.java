package com.nezerx.healthindicator;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import org.joml.Matrix4f;

public class RenderHelper {

    public static void drawTexture(PoseStack poseStack, ResourceLocation texture, float x, float y, float width, float height) {
        RenderSystem.setShaderTexture(0, texture);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);

        Matrix4f matrix = poseStack.last().pose();
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();

        // Рисуем четырехугольник (квад)
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.vertex(matrix, x, y + height, 0.0F).uv(0, 1).endVertex();
        bufferbuilder.vertex(matrix, x + width, y + height, 0.0F).uv(1, 1).endVertex();
        bufferbuilder.vertex(matrix, x + width, y, 0.0F).uv(1, 0).endVertex();
        bufferbuilder.vertex(matrix, x, y, 0.0F).uv(0, 0).endVertex();

        BufferUploader.drawWithShader(bufferbuilder.end());
    }
}