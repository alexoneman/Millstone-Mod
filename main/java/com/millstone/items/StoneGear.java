package com.millstone.items;

import com.millstone.MillstoneMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class StoneGear extends Item {
	public StoneGear(int i) {
		this.setUnlocalizedName("stoneGear");
		this.setTextureName("millstonemod:stoneGear");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxStackSize(1);
	}
}

