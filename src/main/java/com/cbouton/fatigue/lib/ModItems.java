package com.cbouton.fatigue.lib;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

import com.cbouton.fatigue.items.CoffeeSeedsItem;
import com.cbouton.fatigue.items.ColdCoffeeItem;
import com.cbouton.fatigue.items.HotCoffeeItem;
import com.cbouton.fatigue.items.WoodenMugItem;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems {

	public static void init() {
		Item coffeeSeeds = new CoffeeSeedsItem(ItemStatics.ITEM_COFFEE_SEEDS);
		Item woodenMug = new WoodenMugItem(ItemStatics.ITEM_WOODEN_MUG);
		Item coldCoffee = new ColdCoffeeItem(ItemStatics.ITEM_COLD_COFFEE);
		Item hotCoffee = new HotCoffeeItem(ItemStatics.ITEM_HOT_COFFEE);

		GameRegistry.registerItem(woodenMug, woodenMug.getUnlocalizedName()
				.replace("item.", ""), Statics.MODID);
		GameRegistry.registerItem(coffeeSeeds, coffeeSeeds.getUnlocalizedName()
				.replace("item.", ""), Statics.MODID);
		GameRegistry.registerItem(coldCoffee, coldCoffee.getUnlocalizedName()
				.replace("item.", ""), Statics.MODID);
		GameRegistry.registerItem(hotCoffee, hotCoffee.getUnlocalizedName()
				.replace("item.", ""), Statics.MODID);

		//Crafting for coffee mug
		ItemStack woodStack = new ItemStack(Block.planks);
		ItemStack stick = new ItemStack(Item.stick);
		ItemStack woodMug = new ItemStack(woodenMug);
		
		//Crafting of cold coffee
		ItemStack coldCoffeeStack = new ItemStack(coldCoffee);
		ItemStack waterStack = new ItemStack(Item.bucketWater.setContainerItem(Item.bucketEmpty));
		ItemStack coffeeSeedStack = new ItemStack(coffeeSeeds);
		
		//Hot coffee smelting
		ItemStack hotCoffeeStack = new ItemStack(hotCoffee);

		//Crafting recipes
		GameRegistry.addRecipe(woodMug, "WWS", "WWS", "WWS", 'W', woodStack, 'S', stick);
		GameRegistry.addRecipe(coldCoffeeStack, " W ", " S ", " M ", 'W', waterStack, 'S', coffeeSeedStack, 'M', woodMug);
		
		//Smelting recipes
		GameRegistry.addSmelting(coldCoffee.itemID, hotCoffeeStack, 0.1f);

		LanguageRegistry.addName(coffeeSeeds, "Coffee Seeds");
		LanguageRegistry.addName(woodenMug, "Wooden Mug");
		LanguageRegistry.addName(coldCoffee, "Cold Coffee");
		LanguageRegistry.addName(hotCoffee, "Hot Coffee");

		MinecraftForge.addGrassSeed(new ItemStack(coffeeSeeds), 10);
	}

}
