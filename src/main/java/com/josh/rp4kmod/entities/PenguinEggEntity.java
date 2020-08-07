package com.josh.rp4kmod.entities;

import com.josh.rp4kmod.util.RegistryHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class PenguinEggEntity extends ProjectileItemEntity {

    public PenguinEggEntity(World worldIn) {
        super(RegistryHandler.PENGUIN_EGG_ENTITY.get(), worldIn);
    }

    public PenguinEggEntity(EntityType<? extends ProjectileItemEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public PenguinEggEntity(World worldIn, LivingEntity throwerIn) {
        super(RegistryHandler.PENGUIN_EGG_ENTITY.get(), throwerIn, worldIn);
    }

    @Override
    protected Item getDefaultItem() {
        return RegistryHandler.PENGUIN_EGG.get();
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.getType() == RayTraceResult.Type.ENTITY) {
            ((EntityRayTraceResult)result).getEntity().attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
        }

        if (!this.world.isRemote) {
            if (this.rand.nextInt(2) == 0) {
                int i = 1;
                if (this.rand.nextInt(10) == 0) {
                    i = 4;
                }

                for(int j = 0; j < i; ++j) {
                    PenguinEntity penguinentity = new PenguinEntity(this.world);
                    penguinentity.setGrowingAge(-10000);
                    penguinentity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, 0.0F);
                    this.world.addEntity(penguinentity);
                }
            }

            this.world.setEntityState(this, (byte)3);
            this.remove();
        }
    }

    // Necessary for rendering custom entity
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
