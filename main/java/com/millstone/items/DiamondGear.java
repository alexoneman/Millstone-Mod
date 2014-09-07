package com.millstone.items;

import com.millstone.MillstoneMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class DiamondGear extends Item {
	public DiamondGear(int i) {
		this.setUnlocalizedName("diamondGear");
		this.setTextureName("millstonemod:diamondGear");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxStackSize(1);
	}
}

