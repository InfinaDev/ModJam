package com.cbouton.fatigue.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class HotCoffeeItem extends Item {

	public HotCoffeeItem(int id) {
		super(id);
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabFood);
		setUnlocalizedName("hotCoffee");
		setTextureName("fatigue:hotCoffee");
	}

}
