package com.cbouton.fatigue.items;

import com.cbouton.fatigue.lib.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CoffeeSeedsItem extends Item {

	public CoffeeSeedsItem(int id) {
		super(id);
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("coffeeSeeds");
		setTextureName("fatigue:coffeeBeans");
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, World par3World, int par4, int par5,
			int par6, int par7, float par8, float par9, float par10) {
		int i1 = par3World.getBlockId(par4, par5, par6);
		int j1 = par3World.getBlockMetadata(par4, par5, par6);

		if (i1 == Block.wood.blockID && BlockLog.limitToValidMetadata(j1) == 3) {
			if (par7 == 0) {
				return false;
			}

			if (par7 == 1) {
				return false;
			}

			if (par7 == 2) {
				--par6;
			}

			if (par7 == 3) {
				++par6;
			}

			if (par7 == 4) {
				--par4;
			}

			if (par7 == 5) {
				++par4;
			}

			if (par3World.isAirBlock(par4, par5, par6)) {
				int k1 = Block.cocoaPlant
						.onBlockPlaced(par3World, par4, par5, par6, par7, par8,
								par9, par10, 0);
				par3World.setBlock(par4, par5, par6, Block.cocoaPlant.blockID,
						k1, 2);

				if (!par2EntityPlayer.capabilities.isCreativeMode) {
					--par1ItemStack.stackSize;
				}
			}

			return true;
		}

		return false;
	}
}
