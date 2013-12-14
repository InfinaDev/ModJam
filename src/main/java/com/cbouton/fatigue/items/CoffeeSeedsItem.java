package com.cbouton.fatigue.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CoffeeSeedsItem extends Item {

	public CoffeeSeedsItem(int id) {
		super(id);
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("coffeeSeeds");
		setTextureName("fatigue:coffeeBeans");
	}
}
