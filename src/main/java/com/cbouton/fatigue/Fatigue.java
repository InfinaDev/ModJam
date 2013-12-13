package com.cbouton.fatigue;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

import com.cbouton.fatigue.blocks.CoffeePlantBlock;
import com.cbouton.fatigue.events.playerEvent;
import com.cbouton.fatigue.items.CoffeeSeedsItem;
import com.cbouton.fatigue.lib.Statics;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Statics.MODID, version = Statics.VERSION)
public class Fatigue {
	public int difficulty;
	public static Item coffeeSeeds;
	public static Block coffeePlant;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		//Create the coffee seeds item
		coffeeSeeds = new CoffeeSeedsItem(5624, 5625, Block.tilledField.blockID)
			.setMaxStackSize(64)
			.setCreativeTab(CreativeTabs.tabMisc)
			.setUnlocalizedName("coffeeSeeds")
			.setTextureName("fatigue:coffeeBeans");
		
		coffeePlant = new CoffeePlantBlock(5625, Material.cactus)
			.setHardness(0.5f)
			.setUnlocalizedName("coffeePlant");
	}
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
		//TODO: Register Movement, Player Sleep and Item Use Events.
    	MinecraftForge.EVENT_BUS.register(new playerEvent());
    	
    	//TODO: Get game mode updates
    	difficulty = Minecraft.getMinecraft().theWorld.difficultySetting;
        System.out.println(Statics.MODID + " Version " + Statics.VERSION + " Loaded");
        
        GameRegistry.registerBlock(coffeePlant, "coffeePlant");
        
        LanguageRegistry.addName(coffeeSeeds, "Coffee Seeds");
        LanguageRegistry.addName(coffeePlant, "Coffee Plant");
        
        MinecraftForge.addGrassSeed(new ItemStack(coffeeSeeds), 10);
    }
}
/*
 * Automatic regen on peaceful Easy increases at double and decreases by half
 * Normal increases and decreases by the default amounts Hard increases at half
 * and decrease by double
 * 
 * 1/2 fatigue is normal full fatigue gives Haste/Speed no fatigue gives
 * Slowness/Mining Fatigue
 * 
 * 10 steps/1 mining Operation is the same decrease
 * 
 * above 50% hunger decreases slower/below 50% hunger decreases faster Hard has
 * players spawn at 50% fatigue
 * 
 * Sleeping is the best way to increase fatigue Mounted for a full day increases
 * fatigue by 1/4 of sleeping if not moving. if moving, fatigue decreases at 50%
 * the difficulty rate
 * 
 * Values can be determined later.
 */