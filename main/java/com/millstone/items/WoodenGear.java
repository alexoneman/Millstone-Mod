package com.millstone.items;

import com.millstone.MillstoneMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class WoodenGear extends Item {
	public WoodenGear(int i) {
		this.setUnlocalizedName("woodenGear");
		this.setTextureName("millstonemod:woodGear");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxStackSize(1);
	}
}

