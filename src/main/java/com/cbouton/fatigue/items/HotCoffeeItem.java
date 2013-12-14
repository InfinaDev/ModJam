package com.cbouton.fatigue.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class HotCoffeeItem extends ItemFood {

	public HotCoffeeItem(int id, int healthRegen, float probabilityOfPotionEffect, boolean canAlwaysEat) {
		super(id, healthRegen, probabilityOfPotionEffect, canAlwaysEat);
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabFood);
		setUnlocalizedName("hotCoffee");
		setTextureName("fatigue:hotCoffee");
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		super.onEaten(stack, world, player);
		
		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 600, 3));
		return stack;
	}

}
