package xxrexraptorxx.additionalstructures.config;

import net.minecraftforge.common.config.Config;
import xxrexraptorxx.additionalstructures.main.Reference;

@Config(modid = Reference.MODID, category = "general", name = "Additional Structures - General")
public class ConfigGeneral {

		@Config.Comment(value = "Activate the ingame Update Checker from Additional Structures")
	    public static boolean activateUpdateChecker = true;
	    
		@Config.Comment(value = "Activate the Debug Mode from Additional Structures")
	    public static boolean activateDebugMode = false;
	    
		@Config.Comment(value = "Activate structure generation in the Overworld")
	    public static boolean activateOverworldGeneration = true;
	    
		@Config.Comment(value = "Activate structure generation in the Nether")
	    public static boolean activateNetherGeneration = true;
	    
		@Config.Comment(value = "Activate structure generation in the End")
	    public static boolean activateEndGeneration = true; 
		
		@Config.Comment(value = "Adds extra dimensions from other mods to the AS generator (No support for this dimensions!) [Don't add -1 or 1] [0 = vanilla overworld]")
		public static int[] additionalDimensions = new int [] {0};

}
