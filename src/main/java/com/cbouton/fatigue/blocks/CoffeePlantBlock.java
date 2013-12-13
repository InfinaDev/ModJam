package com.cbouton.fatigue.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class CoffeePlantBlock extends Block {

	public CoffeePlantBlock(int id, Material mat) {
		super(id, mat);
	}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        return null;
    }
       
    public int getRenderType() {
        return 6; // Magic number.
    }
   
    public boolean isOpaqueCube() {
        return false;
    }

}
