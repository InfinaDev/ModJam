package com.cbouton.fatigue.lib;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

import com.cbouton.fatigue.items.CoffeeSeedsItem;
import com.cbouton.fatigue.items.WoodenMugItem;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems {

	public static void init() {
		Item coffeeSeeds = new CoffeeSeedsItem(ItemStatics.ITEM_COFFEE_SEEDS);
		Item woodenMug = new WoodenMugItem(ItemStatics.ITEM_WOODEN_MUG);

		ItemStack woodStack = new ItemStack(Block.wood);
		ItemStack stick = new ItemStack(Item.stick);
		ItemStack woodMug = new ItemStack(woodenMug);

		GameRegistry.addRecipe(woodMug, "ww ", "wws", "wws", 'w', woodStack,
				's', stick);

		LanguageRegistry.addName(coffeeSeeds, "Coffee Seeds");
		LanguageRegistry.addName(woodenMug, "Wooden Mug");

		MinecraftForge.addGrassSeed(new ItemStack(coffeeSeeds), 10);
	}

}
