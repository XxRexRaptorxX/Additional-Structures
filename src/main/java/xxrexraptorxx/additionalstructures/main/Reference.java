package xxrexraptorxx.additionalstructures.main;

import net.minecraft.util.ResourceLocation;

/**
 *	 @author XxRexRaptorxX (RexRaptor)
 *	 @projectPage https://minecraft.curseforge.com/projects/additional-structures
 **/
public class Reference {
	
	public static final String NAME = "Additional Structures";
    public static final String MODID = "additionalstructures";
    public static final String VERSION = "2.5.0";
    public static final String MCVERSIONS = "[1.12.0,1.12.2]";
    public static final String DEPENDENCIES = "after:mystcraft@[0.13.7.01,)";
    public static final String CLIENT = "xxrexraptorxx.additionalstructures.proxy.ClientProxy";
    public static final String SERVER = "xxrexraptorxx.additionalstructures.proxy.ServerProxy";


    public static final ResourceLocation SYMBOL_NORMAL_STRUCTURE_GENERATION = forAdditionalStrctures("normal_generation");

    public static final ResourceLocation SYMBOL_END_STRUCTURES = forAdditionalStrctures("end_structures");
    public static final ResourceLocation SYMBOL_NETHER_STRUCTURES = forAdditionalStrctures("nether_structures");

    public static final ResourceLocation SYMBOL_DESERT_STRUCTURES = forAdditionalStrctures("desert_structures");
    public static final ResourceLocation SYMBOL_SNOW_STRUCTURES = forAdditionalStrctures("snow_structures");
    public static final ResourceLocation SYMBOL_JUNGLE_STRUCTURES = forAdditionalStrctures("jungle_structures");
    public static final ResourceLocation SYMBOL_SWAMP_STRUCTURES = forAdditionalStrctures("swamp_structures");
    public static final ResourceLocation SYMBOL_FOREST_STRUCTURES = forAdditionalStrctures("forest_structures");
    public static final ResourceLocation SYMBOL_PLAINS_STRUCTURES = forAdditionalStrctures("plains_structures");
    public static final ResourceLocation SYMBOL_MOUNTAIN_STRUCTURES = forAdditionalStrctures("mountain_structures");
    public static final ResourceLocation SYMBOL_MESA_STRUCTURES = forAdditionalStrctures("mesa_structures");
    public static final ResourceLocation SYMBOL_OCEAN_STRUCTURES = forAdditionalStrctures("ocean_structures");
    public static final ResourceLocation SYMBOL_SAVANNA_STRUCTURES = forAdditionalStrctures("savanna_structures");
    public static final ResourceLocation SYMBOL_WASTELAND_STRUCTURES = forAdditionalStrctures("wasteland_structures");
    public static final ResourceLocation SYMBOL_SPOOKY_STRUCTURES = forAdditionalStrctures("spooky_structures");

    public static ResourceLocation forAdditionalStrctures(final String path) {
    	return new ResourceLocation(MODID, path);
    }
}
