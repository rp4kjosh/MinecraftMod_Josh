package com.josh.rp4kmod.models;// Made with Blockbench 3.6.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.josh.rp4kmod.entities.PenguinEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class PenguinModel<T extends PenguinEntity> extends EntityModel<T> {
	private final ModelRenderer main;
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer beak;
	private final ModelRenderer leftarm;
	private final ModelRenderer rightarm;
	private final ModelRenderer leftleg;
	private final ModelRenderer rightleg;

	public PenguinModel() {
		textureWidth = 64;
		textureHeight = 32;

		main = new ModelRenderer(this);
		main.setRotationPoint(-3.0F, 24.0F, -2.0F);


		body = new ModelRenderer(this);
		body.setRotationPoint(3.0F, -2.0F, 2.0F);
		main.addChild(body);
		body.setTextureOffset(0, 16).addBox(-4.0F, -8.0F, -2.0F, 8.0F, 8.0F, 4.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(3.0F, -10.0F, 2.0F);
		main.addChild(head);
		head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		beak = new ModelRenderer(this);
		beak.setRotationPoint(-3.0F, 10.0F, -2.0F);
		head.addChild(beak);
		beak.setTextureOffset(32, 8).addBox(2.0F, -12.0F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(7.0F, -9.0F, 1.0F);
		main.addChild(leftarm);
		leftarm.setTextureOffset(24, 16).addBox(0.0F, -1.0F, -1.0F, 1.0F, 8.0F, 3.0F, 0.0F, false);

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(-1.0F, -9.0F, 1.0F);
		main.addChild(rightarm);
		rightarm.setTextureOffset(24, 16).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 8.0F, 3.0F, 0.0F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(5.0F, -2.0F, 2.0F);
		main.addChild(leftleg);
		leftleg.setTextureOffset(32, 0).addBox(-1.0F, 0.0F, -4.0F, 3.0F, 2.0F, 6.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(1.0F, -2.0F, 2.0F);
		main.addChild(rightleg);
		rightleg.setTextureOffset(32, 0).addBox(-2.0F, 0.0F, -4.0F, 3.0F, 2.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(PenguinEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		// Makes the penguins arms swing and feet flap when moving
		leftarm.rotateAngleX = MathHelper.cos(ageInTicks * 0.6662F) * 1.4F * limbSwingAmount;
		rightarm.rotateAngleX = MathHelper.cos(ageInTicks * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount;
		leftarm.rotateAngleY = 0.0F;
		rightarm.rotateAngleY = 0.0F;
		leftleg.rotateAngleX = MathHelper.cos(ageInTicks) * 1.4F * limbSwingAmount * 0.5F;
		rightleg.rotateAngleX = MathHelper.cos(ageInTicks + 3.141593F) * 1.4F * limbSwingAmount * 0.5F;
		leftleg.rotateAngleY = 0.0F;
		rightleg.rotateAngleY = 0.0F;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}