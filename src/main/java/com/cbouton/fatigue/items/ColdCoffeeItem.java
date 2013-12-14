package com.cbouton.fatigue.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class ColdCoffeeItem extends ItemFood {

	public ColdCoffeeItem(int id, int hungerRegen, float probabilityOfPotionEffect, boolean canAlwaysEat) {
		super(id, hungerRegen, probabilityOfPotionEffect, canAlwaysEat);
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabFood);
		setUnlocalizedName("coldCoffee");
		setTextureName("fatigue:coldCoffee");
	}

}
