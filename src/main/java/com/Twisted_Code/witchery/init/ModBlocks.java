package com.Twisted_Code.witchery.init;

import com.Twisted_Code.witchery.Reference;
import com.Twisted_Code.witchery.blocks.*;
import com.Twisted_Code.witchery.util.Utils;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block rowanLog;
	
	public static void init() {
		rowanLog = new BlockRowanLog("rowanlog", "rowanlog");
	}
	public static void register() {
		registerBlock(rowanLog);
	}
	public static void registerRenders() {
		registerRender(rowanLog);
	}
	public static void registerBlock(Block block) {
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		Utils.getLogger().info("registered block: " + block.getUnlocalizedName().substring(5));
	}
	public static void registerRender(Block block) {
		//lesson learned. Item.getItemFromBlock will, if you don't register an itemblock for the block, return null 
		if(null == Item.getItemFromBlock(block)){
			Utils.getLogger().info("this method was null");			
		}
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, block.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("registered render for " + block.getUnlocalizedName().substring(5));
	}
	
}
