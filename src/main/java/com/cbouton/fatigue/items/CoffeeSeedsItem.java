package com.cbouton.fatigue.items;

import com.cbouton.fatigue.lib.ModItems;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.block.BlockLog;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CoffeeSeedsItem extends Item {

    public CoffeeSeedsItem() {
        setMaxStackSize(64);
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("coffeeSeeds");
        setTextureName("fatigue:coffeeBeans");
    }

    @Override
    public boolean onItemUse(ItemStack par1ItemStack,
                             EntityPlayer par2EntityPlayer, World par3World, int par4, int par5,
                             int par6, int par7, float par8, float par9, float par10) {
        Block block = par3World.getBlock(par4, par5, par6);
        int i1 = par3World.getBlockMetadata(par4, par5, par6);

        if (block == Blocks.log && BlockLog.func_150165_c(i1) == 3)
        {
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
                int k1 = Blocks.cocoa
                        .onBlockPlaced(par3World, par4, par5, par6, par7, par8,
                                par9, par10, 0);
                par3World.setBlock(par4, par5, par6, Blocks.cocoa,
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
