package com.cbouton.fatigue.items;

import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class CoffeeSeedsItem extends Item implements IPlantable {

	public CoffeeSeedsItem(int id, int plantId, int soilId) {
		super(id);
	}

	@Override
	public int getPlantID(World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPlantMetadata(World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EnumPlantType getPlantType(World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
