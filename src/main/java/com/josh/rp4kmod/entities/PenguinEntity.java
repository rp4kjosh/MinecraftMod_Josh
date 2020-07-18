package com.josh.rp4kmod.entities;

import com.josh.rp4kmod.util.RegistryHandler;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

public class PenguinEntity extends AnimalEntity {

    public PenguinEntity(final World worldIn) {
        super(RegistryHandler.PENGUIN_ENTITY.get(), worldIn);
    }

    public PenguinEntity(final EntityType<? extends AnimalEntity> type, final World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(16.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20D);
    }

    /**
     * Creates a child new entity from the parent entity.
     * Can be used to set additional on the child entity based on the parent.
     *
     * @param parent The entity that made this child
     * @return A new Penguin
     */
    @Override
    public PenguinEntity createChild(final AgeableEntity parent) {
        // Use getType to support overrides in subclasses
        return (PenguinEntity) getType().create(this.world);
    }

    /**
     * Called on the logical server to get a packet to send to the client containing data necessary to spawn your entity.
     * Using Forge's method instead of the default vanilla one allows extra stuff to work such as sending extra data,
     * using a non-default entity factory and having {@link IEntityAdditionalSpawnData} work.
     *
     * It is not actually necessary for our WildBoarEntity to use Forge's method as it doesn't need any of this extra
     * functionality, however, this is an example mod and many modders are unaware that Forge's method exists.
     *
     * @return The packet with data about your entity
     * @see FMLPlayMessages.SpawnEntity
     */
    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
