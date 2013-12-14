package com.cbouton.fatigue.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ColdCoffeeItem extends Item {

	public ColdCoffeeItem(int id) {
		super(id);
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabFood);
		setUnlocalizedName("coldCoffee");
		setTextureName("fatigue:coldCoffee");
	}

}
