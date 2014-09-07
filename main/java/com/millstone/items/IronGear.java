package com.millstone.items;

import com.millstone.MillstoneMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class IronGear extends Item {
	public IronGear(int i) {
		this.setUnlocalizedName("ironGear");
		this.setTextureName("millstonemod:ironGear");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxStackSize(1);
	}
}

