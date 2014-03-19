package com.cbouton.fatigue.items;

import com.cbouton.fatigue.handlers.FatigueHandler;
import com.cbouton.fatigue.lib.ItemStatics;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ColdCoffeeItem extends ItemFood {
    Item woodenMug = new WoodenMugItem();
    ItemStack woodMug = new ItemStack(woodenMug);

    public ColdCoffeeItem(int hungerRegen,
                          float saturationModifier, boolean isWolfsFavorite) {
        super(hungerRegen, saturationModifier, isWolfsFavorite);
        setMaxStackSize(1);
        setCreativeTab(CreativeTabs.tabFood);
        setUnlocalizedName("coldCoffee");
        setTextureName("fatigue:coldCoffee");
        setAlwaysEdible();
    }

    @Override
    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
        super.onEaten(stack, world, player);

        FatigueHandler.increaseFatigue(player, 1000);

        return woodMug;
    }

    public EnumAction getItemUseAction(ItemStack par1ItemStack) {
        return EnumAction.drink;
    }

}
