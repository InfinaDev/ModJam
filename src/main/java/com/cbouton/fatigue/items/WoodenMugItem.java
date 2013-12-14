package com.cbouton.fatigue.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class WoodenMugItem extends Item {

	public WoodenMugItem(int id) {
		super(id);
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("woodenMug");
		setTextureName("fatigue:woodenMug");
	}

}
