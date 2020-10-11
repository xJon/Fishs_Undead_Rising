package com.Fishmod.mod_LavaCow.item;

import java.util.Random;

import com.Fishmod.mod_LavaCow.mod_LavaCow;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;

public class ItemCursedBandage extends ItemFishCustom {
	
	public ItemCursedBandage(String registryName) {
    	super(registryName, null, mod_LavaCow.TAB_ITEMS, true);
    }
	
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target, EnumHand hand)
    {	
    	if (target instanceof EntityTameable && ((EntityTameable)target).isTamed() && ((EntityTameable)target).getOwner() != null && ((EntityTameable)target).getOwner().equals(playerIn) && target.getHealth() < target.getMaxHealth())
        {
    		target.heal(2.0F);
    		if(!playerIn.isCreative())
    			stack.shrink(1);
    		
    		playerIn.playSound(SoundEvents.BLOCK_GRASS_STEP, 1.0F, 1.0F);
        	for (int i = 0; i < 5; ++i)
            {
                double d0 = new Random().nextGaussian() * 0.02D;
                double d1 = new Random().nextGaussian() * 0.02D;
                double d2 = new Random().nextGaussian() * 0.02D;
                target.world.spawnParticle(EnumParticleTypes.TOTEM, target.posX + (double)(new Random().nextFloat() * target.width * 2.0F) - (double)target.width, target.posY + 1.0D + (double)(new Random().nextFloat() * target.height), target.posZ + (double)(new Random().nextFloat() * target.width * 2.0F) - (double)target.width, d0, d1, d2);
            }
        	
    		return true;
        }
        else
        	return super.itemInteractionForEntity(stack, playerIn, target, hand);
    }
}
