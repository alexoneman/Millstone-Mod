//I assume you know how to organize things with packages

package com.millstone;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.millstone.blocks.Millstone;
import com.millstone.handler.GuiHandler;
import com.millstone.items.DiamondGear;
import com.millstone.items.GoldGear;
import com.millstone.items.IronGear;
import com.millstone.items.StoneGear;
import com.millstone.items.WoodenGear;
import com.millstone.proxy.CommonProxy;
import com.millstone.tileentity.TileEntityMillstone;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

//Just putting it out there, I am very organised with my main class file. Hopefully it might help you get around also.

//ModID Stuffs
@Mod(modid = MillstoneMod.MODID, version = MillstoneMod.VERSION)
public class MillstoneMod
{
	//ID's and etc
    public static final String MODID = "millstonemod";
    public static final String VERSION = "1.0";
   
    //Whenever making a new GUI, do this same thing but put a number higher than the previous ID.
    public static final int guiIDMillstone = 1;

	@Instance(MODID)
	public static MillstoneMod instance;
	
	//Proxy Stuff
	@SidedProxy(clientSide = "com.millstone.proxy.ClientProxy", serverSide = "com.millstone.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	//Creative Tab
	//public static CreativeTabs tabMillstone = new CreativeTabs("tabMillstone") {
	//	@Override
	//	@SideOnly(Side.CLIENT)
	//	public Item getTabIconItem() {
	//		return stoneGear;  
	//	}
	//};
	
	//Create the millstone. You need the idle and active.
	public static Block millstoneIdle = new Millstone(false).setBlockName("millstoneIdle").setCreativeTab(CreativeTabs.tabRedstone).setHardness(5F);
	public static Block millstoneActive = new Millstone(true).setBlockName("millstoneActive").setHardness(5F);;
	
	public static Item woodGear = new WoodenGear(49000);
	public static Item stoneGear = new StoneGear(49001);
	public static Item ironGear = new IronGear(49002);
	public static Item goldGear = new GoldGear(49003);
	public static Item diamondGear = new DiamondGear(49004);

	
    @EventHandler
    public void init(FMLInitializationEvent event)
    {   	
    	//Game and Lang reg,
	
		//Register the millstone and millstone active, but only add a name to the active millstone.
		GameRegistry.registerBlock(millstoneIdle, "millstoneIdle");
		LanguageRegistry.addName(millstoneIdle, "Grindstone");
		GameRegistry.registerBlock(millstoneActive, "millstoneActive");
		GameRegistry.registerItem(woodGear, "woodGear");
		LanguageRegistry.addName(woodGear, "Wooden Gear");
		GameRegistry.registerItem(stoneGear, "stoneGear");
		LanguageRegistry.addName(stoneGear, "Stone Gear");
		
		//init()
		
		GameRegistry.registerItem(ironGear, "ironGear");
		LanguageRegistry.addName(ironGear, "Iron Gear");
		GameRegistry.registerItem(goldGear, "goldGear");
		LanguageRegistry.addName(goldGear, "Golden Gear");
		GameRegistry.registerItem(diamondGear, "diamondGear");
		LanguageRegistry.addName(diamondGear, "Diamond Gear");
		
		//Adding the name to the creative tab.
		//LanguageRegistry.instance().addStringLocalization("itemGroup.tabMillstone", "en_US", "Millstone Tab"); 
		
		//Recipes
		
		/**
	    *The number of ticks that the furnace will keep burning
	    *Let me explain recipes. So the "stonegear, 1" in the itemstack is basically the item you want to create, and the 1 for
		*how many. Simple. Now, where you see the " S ", "S S", " S ", 'S', Blocks.stone" is where it gets trickier. Each "" represents
		*one row in the crafting grid. The first "" is the top row, second "" middle, third "" bottom. Now, you put any letter you want 
		*in there, such as S in the order you want to craft your recipe. If you want to leave a space blank, simply put a space there.
		*Make sure there is only 3 characters in each "" for the recipe to work. Now, the 'S', Blocks.stone part is basically defining what
		*the letter(s) you put in your recipe are. For example, its registering the S (caps are important) as the Stone. For a recipe with
		*multiple characters such as "SIS", "ISI", "SIS", you would do (after the 3 "" 's) 'S', Blocks.stone (or whatever you want to use), 
		*'I', Items.iron_ingot
		*Hopefully I didn't make this too confusing*/
		
		GameRegistry.addShapedRecipe(new ItemStack(stoneGear, 1), new Object[]{" S ", "S S", " S ", 'S', Blocks.stone});
		GameRegistry.addShapedRecipe(new ItemStack(millstoneIdle, 1), new Object[]{"IPI", "ISI", "IRI", 'S', Blocks.cobblestone, 'I', Items.iron_ingot, 'P', Blocks.piston, 'R', Items.redstone});


		//Tile Entity Registry
		GameRegistry.registerTileEntity(TileEntityMillstone.class, "tileEntityMillstone");


    		//Register your GUI handler
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

		//Register your renderer in your proxy.
		proxy.registerRenderThings();
    }
   
}
