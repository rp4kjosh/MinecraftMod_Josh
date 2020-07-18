
package com.josh.rp4kmod.entities;

import com.josh.rp4kmod.RP4KMod;
import com.josh.rp4kmod.util.RegistryHandler;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BombEntity extends ProjectileItemEntity {

    public BombEntity(World worldIn) {
        super( RegistryHandler.BOMB_ENTITY.get(), worldIn);
    }

    public BombEntity(World worldIn, LivingEntity throwerIn) {
        super(RegistryHandler.BOMB_ENTITY.get(), throwerIn, worldIn);
    }

    public BombEntity(EntityType<? extends ProjectileItemEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected Item getDefaultItem() {
        return RegistryHandler.BOMB.get();
    }

    @Override
    protected void onImpact(RayTraceResult result) {

        if (!this.world.isRemote) {

            this.world.setEntityState(this, (byte)3);
            this.remove();
            this.explode();
        }
    }

    protected void explode() {
        // Explosion Radius
        float r = 4.0F;
        this.world.createExplosion(this, this.getPosX(), this.getPosYHeight(0.0625D), this.getPosZ(), r, Explosion.Mode.BREAK);
    }

    // Necessary for rendering custom entity
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}

