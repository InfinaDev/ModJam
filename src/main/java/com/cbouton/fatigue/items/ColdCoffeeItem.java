package com.cbouton.fatigue.items;

import com.cbouton.fatigue.handlers.FatigueHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ColdCoffeeItem extends ItemFood {

	public ColdCoffeeItem(int id, int hungerRegen,
			float probabilityOfPotionEffect, boolean isWolfsFavorite) {
		super(id, hungerRegen, probabilityOfPotionEffect, isWolfsFavorite);
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabFood);
		setUnlocalizedName("coldCoffee");
		setTextureName("fatigue:coldCoffee");
		setAlwaysEdible();
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		super.onEaten(stack, world, player);
		
		FatigueHandler.increaseFatigue(player, 1000);
		
		return stack;
	}
	
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.drink;
    }

}
