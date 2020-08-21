package com.teamabnormals.abnormals_core.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@Mixin(AnimalEntity.class)
public abstract class MixinAnimalEntity extends Entity {

	public MixinAnimalEntity(EntityType<?> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	@Inject(at = @At("HEAD"), method = "isBreedingItem", cancellable = true)
	private void addBreedingItems(ItemStack stack, CallbackInfoReturnable<Boolean> info) {
		info.setReturnValue(true);
	}
}