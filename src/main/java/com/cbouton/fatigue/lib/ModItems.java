package com.cbouton.fatigue.lib;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

import com.cbouton.fatigue.blocks.BlockCoffee;
import com.cbouton.fatigue.items.CoffeeSeedsItem;
import com.cbouton.fatigue.items.ColdCoffeeItem;
import com.cbouton.fatigue.items.HotCoffeeItem;
import com.cbouton.fatigue.items.WoodenMugItem;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.crafting.FurnaceRecipes;

public class ModItems {
	public static Item woodenMug;
	public static Item coffeeSeeds;
	public static Block coffeeblock;

	public static void init() {
		Item coffeeSeeds = new CoffeeSeedsItem();
		Item woodenMug = new WoodenMugItem();
		Item coldCoffee = new ColdCoffeeItem(2,
				1f, false).setContainerItem(woodenMug);
		Item hotCoffee = new HotCoffeeItem(4, 1f,
				false).setContainerItem(woodenMug);
		Block coffeeblock = new BlockCoffee();

		GameRegistry.registerItem(woodenMug, woodenMug.getUnlocalizedName()
				.replace("item.", ""));
		GameRegistry.registerItem(coffeeSeeds, coffeeSeeds.getUnlocalizedName()
				.replace("item.", ""));
		GameRegistry.registerItem(coldCoffee, coldCoffee.getUnlocalizedName()
				.replace("item.", ""));
		GameRegistry.registerItem(hotCoffee, hotCoffee.getUnlocalizedName()
				.replace("item.", ""));


		// Crafting of cold coffee
		ItemStack coldCoffeeStack = new ItemStack(coldCoffee);
		ItemStack waterStack = new ItemStack(
				Items.water_bucket.setContainerItem(Items.bucket));
		ItemStack coffeeSeedStack;
        coffeeSeedStack = new ItemStack(coffeeSeeds);

        // Hot coffee smelting
		ItemStack hotCoffeeStack = new ItemStack(hotCoffee);

		// Crafting recipes
		GameRegistry.addRecipe(new ItemStack(woodenMug), "WWS", "WWS", "WWS", 'W',
                Blocks.planks,
				'S', Items.stick);
		GameRegistry.addRecipe(coldCoffeeStack, " W ", " S ", " M ", 'W',
				waterStack, 'S', coffeeSeedStack, 'M', new ItemStack(woodenMug));

		// Smelting recipes
        FurnaceRecipes.smelting().func_151396_a(coldCoffee, hotCoffeeStack, 0.1f);

		LanguageRegistry.addName(coffeeSeeds, "Coffee Seeds");
		LanguageRegistry.addName(woodenMug, "Wooden Mug");
		LanguageRegistry.addName(coldCoffee, "Cold Coffee");
		LanguageRegistry.addName(hotCoffee, "Hot Coffee");

		MinecraftForge.addGrassSeed(new ItemStack(coffeeSeeds), 10);
	}

}
