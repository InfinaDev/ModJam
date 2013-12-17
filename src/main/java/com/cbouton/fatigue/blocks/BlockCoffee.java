package com.cbouton.fatigue.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.BlockCocoa;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.cbouton.fatigue.items.CoffeeSeedsItem;
import com.cbouton.fatigue.lib.ItemStatics;
import com.cbouton.fatigue.lib.ModItems;

public class BlockCoffee extends BlockCocoa {

	public BlockCoffee(int par1) {
		super(par1);
	}

	@Override
	public ArrayList<ItemStack> getBlockDropped(World world, int x, int y,
			int z, int metadata, int fortune) {
		ArrayList<ItemStack> dropped = super.getBlockDropped(world, x, y, z,
				metadata, fortune);
		int j1 = func_72219_c(metadata);
		byte b0 = 1;

		if (j1 >= 2) {
			b0 = 3;
		}

		for (int k1 = 0; k1 < b0; ++k1) {
			dropped.add(new ItemStack(ModItems.coffeeSeeds));
		}
		return dropped;
	}

	@Override
	public int idPicked(World par1World, int par2, int par3, int par4) {
		return ModItems.coffeeSeeds.itemID;
	}

}