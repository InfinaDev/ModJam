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

		GameRegistry.registerItem(woodenMug, woodenMug.getUnlocalizedName()
				.replace("item.", ""), Statics.MODID);
		GameRegistry.registerItem(coffeeSeeds, coffeeSeeds.getUnlocalizedName()
				.replace("item.", ""), Statics.MODID);

		ItemStack woodStack = new ItemStack(Block.planks);
		ItemStack stick = new ItemStack(Item.stick);
		ItemStack woodMug = new ItemStack(woodenMug);

		GameRegistry.addRecipe(woodMug, "WWS", "WWS", "WWS", 'W', woodStack, 'S', stick);

		LanguageRegistry.addName(coffeeSeeds, "Coffee Seeds");
		LanguageRegistry.addName(woodenMug, "Wooden Mug");

		MinecraftForge.addGrassSeed(new ItemStack(coffeeSeeds), 10);
	}

}
