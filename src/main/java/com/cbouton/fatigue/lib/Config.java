package com.cbouton.fatigue.lib;

import java.io.File;
import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;

import net.minecraftforge.common.Configuration;

public class Config {

	public static void init(File configFile) {
		Configuration configuration = new Configuration(configFile);
		try {
			configuration.load();
			ItemStatics.ITEM_COFFEE_SEEDS = configuration.getItem(
					"Coffee Seeds", ItemStatics.ITEM_COFFEE_SEEDS_DEFAULT)
					.getInt(ItemStatics.ITEM_COFFEE_SEEDS_DEFAULT) - 256;
			ItemStatics.ITEM_WOODEN_MUG = configuration.getItem("Wooden Mug",
					ItemStatics.ITEM_WOODEN_MUG_DEFAULT).getInt(
					ItemStatics.ITEM_WOODEN_MUG_DEFAULT) - 256;
			ItemStatics.ITEM_COLD_COFFEE = configuration.getItem("Cold Coffee",
					ItemStatics.ITEM_COLD_COFFEE_DEFAULT).getInt(
					ItemStatics.ITEM_COLD_COFFEE_DEFAULT) - 256;
			ItemStatics.ITEM_HOT_COFFEE = configuration.getItem("Hot Coffee",
					ItemStatics.ITEM_HOT_COFFEE_DEFAULT).getInt(
					ItemStatics.ITEM_HOT_COFFEE_DEFAULT) - 256;

		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, "Fatigue has had a problem loading its configuration");
		}
		finally {
			configuration.save();
		}

	}

}
