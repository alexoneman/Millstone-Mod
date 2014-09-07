package com.millstone.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.millstone.MillstoneMod;
import com.millstone.container.ContainerMillstone;
import com.millstone.gui.GuiMillstone;
import com.millstone.tileentity.TileEntityMillstone;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		

		if(entity != null) {
			switch(ID) {
				
			case MillstoneMod.guiIDMillstone:
				if (entity instanceof TileEntityMillstone) {
					return new ContainerMillstone(player.inventory, (TileEntityMillstone) entity);
				}	
				
			}
		}
		
		return null;
		
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null) {
			switch(ID){
			case MillstoneMod.guiIDMillstone:
				if (entity instanceof TileEntityMillstone) {
					return new GuiMillstone(player.inventory, (TileEntityMillstone) entity);
				}
				
			}
		}
		
		return null;
	}


}