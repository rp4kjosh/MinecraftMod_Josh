package com.josh.rp4kmod.entities.render;

import com.josh.rp4kmod.RP4KMod;
import com.josh.rp4kmod.entities.PenguinEntity;
import com.josh.rp4kmod.models.PenguinModel;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class PenguinRenderer extends MobRenderer<PenguinEntity, PenguinModel<PenguinEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(RP4KMod.MOD_ID,"textures/entity/penguin.png");

    public PenguinRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new PenguinModel<PenguinEntity>(), 0.5f);
    }

    @Override
    public void render(PenguinEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    public ResourceLocation getEntityTexture(PenguinEntity entity) {
        return TEXTURE;
    }
}
