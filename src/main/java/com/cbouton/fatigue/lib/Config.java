package com.cbouton.fatigue.lib;

import java.io.File;

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

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
