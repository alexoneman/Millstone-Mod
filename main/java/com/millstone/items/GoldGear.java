package com.millstone.items;

import com.millstone.MillstoneMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GoldGear extends Item {
	public GoldGear(int i) {
		this.setUnlocalizedName("goldGear");
		this.setTextureName("millstonemod:goldGear");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxStackSize(1);
	}
}

