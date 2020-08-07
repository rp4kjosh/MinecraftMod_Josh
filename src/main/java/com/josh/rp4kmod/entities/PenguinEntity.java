package com.josh.rp4kmod.entities;

import com.josh.rp4kmod.util.RegistryHandler;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
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
     * Registers actions for the penguin to do during it's life
     * Now a penguin can float on water, panic when hit, look at you when you walk by, and more.
     *
     */
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
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
        return RegistryHandler.PENGUIN_ENTITY.get().create(this.world);
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
