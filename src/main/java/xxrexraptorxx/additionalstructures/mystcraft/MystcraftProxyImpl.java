package xxrexraptorxx.additionalstructures.mystcraft;

import com.xcompwiz.mystcraft.api.grammar.GrammarData;
import com.xcompwiz.mystcraft.grammar.GrammarGenerator;
import com.xcompwiz.mystcraft.symbol.SymbolManager;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import xxrexraptorxx.additionalstructures.main.Reference;

import static java.util.Arrays.asList;

/**
 * True implementation of proxy for Mystcraft. It encapsulates
 * all of integration's interactions in order to make Mystcraft optional.
 * 
 * @author v19930312
 *
 */
public class MystcraftProxyImpl extends MystcraftProxy {
	@Override
	public boolean isActive() {
		return true;
	}
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		addStructurePage(Reference.SYMBOL_NORMAL_STRUCTURE_GENERATION, 3, 2, "Terrain", "Encourage", "Balance", "Order");

		addStructurePage(Reference.SYMBOL_END_STRUCTURES, 3, 4, "Terrain", "Encourage", "Void", "Order");
		// Set ranks to 3,4 if/when nether is fixed
		addStructurePage(Reference.SYMBOL_NETHER_STRUCTURES, null, null, "Terrain", "Encourage", "Power", "Order");

		addStructurePage(Reference.SYMBOL_DESERT_STRUCTURES, 3, 4, "Terrain", "Encourage", "Constraint", "Order");
		addStructurePage(Reference.SYMBOL_SNOW_STRUCTURES, 3, 4, "Terrain", "Encourage", "Static", "Order");
		addStructurePage(Reference.SYMBOL_JUNGLE_STRUCTURES, 3, 4, "Terrain", "Encourage", "Sustain", "Order");
		addStructurePage(Reference.SYMBOL_SWAMP_STRUCTURES, 3, 4, "Terrain", "Encourage", "Inhibit", "Order");
		addStructurePage(Reference.SYMBOL_FOREST_STRUCTURES, 3, 4, "Terrain", "Encourage", "Nature", "Order");
		addStructurePage(Reference.SYMBOL_PLAINS_STRUCTURES, 3, 4, "Terrain", "Encourage", "Nurture", "Order");
		addStructurePage(Reference.SYMBOL_MOUNTAIN_STRUCTURES, 3, 4, "Terrain", "Encourage", "Elevate", "Order");
		addStructurePage(Reference.SYMBOL_MESA_STRUCTURES, 3, 4, "Terrain", "Encourage", "Resilience", "Order");
		addStructurePage(Reference.SYMBOL_OCEAN_STRUCTURES, 3, 4, "Terrain", "Encourage", "Flow", "Order");
		addStructurePage(Reference.SYMBOL_SAVANNA_STRUCTURES, 3, 4, "Terrain", "Encourage", "Transform", "Order");
		addStructurePage(Reference.SYMBOL_WASTELAND_STRUCTURES, 3, 4, "Terrain", "Encourage", "Sacrifice", "Order");
		addStructurePage(Reference.SYMBOL_SPOOKY_STRUCTURES, 3, 4, "Terrain", "Encourage", "Survival", "Order");

		GameRegistry.registerWorldGenerator(new MystcraftWorldGenStructures(), 0);
	}

	@Override
	public void init(FMLInitializationEvent event) {
    }

	@Override
    public void postInit(FMLPostInitializationEvent event) {
    }
	
	private void addStructurePage(final ResourceLocation resource, Integer lootRank, Integer grammarRank, String... poem) {
		final SymbolAdditionalStructures symbol = new SymbolAdditionalStructures(resource);
		symbol.setWords(poem);
		symbol.setCardRank(lootRank);
		SymbolManager.tryAddSymbol(symbol);
		GrammarGenerator.Rule rule = new GrammarGenerator.Rule(GrammarData.FEATURE_MEDIUM, asList(resource), grammarRank);
		symbol.addRule(rule);
	}
}
