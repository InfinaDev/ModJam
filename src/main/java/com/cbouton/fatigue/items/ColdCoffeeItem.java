package com.cbouton.fatigue.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

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
	
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.drink;
    }

}
