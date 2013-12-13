package com.cbouton.fatigue.blocks;

import java.util.Random;

import com.cbouton.fatigue.Fatigue;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class CoffeePlantBlock extends Block {

	public CoffeePlantBlock(int id) {
		super(id, Material.cactus);
		setTickRandomly(true);
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
    
    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {
        if (world.getBlockMetadata(x, y, z) == 1) {
            return;
        }

        if (world.getBlockLightValue(x, y + 1, z) < 9) {
            return;
        }

        if (random.nextInt(isFertile(world, x, y - 1, z) ? 12 : 25) != 0) {
            return;
        }

        world.setBlockMetadataWithNotify(x, y, z, Fatigue.coffeePlant.blockID, 1);
    }
    
    @Override
    public void onNeighborBlockChange (World world, int x, int y, int z,
            int neighborId) {
        if (!canBlockStay(world, x, y, z)) {
            dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlock(x, y, z, 0);
        }
    }
    
    @Override
    public boolean canBlockStay (World world, int x, int y, int z) {
        Block soil = blocksList[world.getBlockId(x, y - 1, z)];
        return (world.getFullBlockLightValue(x, y, z) >= 8 ||
                world.canBlockSeeTheSky(x, y, z)) &&
                (soil != null && soil.canSustainPlant(world, x, y - 1, z,
                      ForgeDirection.UP, (IPlantable) Fatigue.coffeeSeeds));
    }
    
    @Override
    public int idDropped(int metadata, Random random, int par2) {
        switch (metadata) {
        case 0:
            return Fatigue.coffeeSeeds.itemID;
        case 1:
            return Fatigue.coffeeSeeds.itemID;
        default: // Error case!
            return -1; // no item
        }
    }
    
    @Override
    public int idPicked (World world, int x, int y, int z) {
        return Fatigue.coffeeSeeds.itemID;
    }

}
