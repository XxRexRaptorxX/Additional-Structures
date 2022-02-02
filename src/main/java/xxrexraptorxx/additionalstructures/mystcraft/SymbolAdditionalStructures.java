package xxrexraptorxx.additionalstructures.mystcraft;

import com.xcompwiz.mystcraft.api.symbol.IAgeSymbol;
import com.xcompwiz.mystcraft.api.world.AgeDirector;
import com.xcompwiz.mystcraft.symbol.SymbolBase;

import net.minecraft.util.ResourceLocation;

/**
 * Implementation of symbol for Additional Structure's pages.
 * Most logic is handled in world generator instead.
 * 
 * @author v19930312
 *
 */
public class SymbolAdditionalStructures extends SymbolBase {
	public SymbolAdditionalStructures(ResourceLocation registryName) {
		super(registryName);
	}

	@Override
	public boolean generatesConfigOption() {
		return true;
	}

	@Override
	public void registerLogic(AgeDirector controller, long seed) {
	}
	
	@Override
	public String getUnlocalizedName() {
		return "additionalstructures.symbol." + getRegistryName().getResourcePath();
	}
	
	@Override
	public IAgeSymbol setRegistryName(ResourceLocation name) {
		return null;
	}
	
	@Override
	public int instabilityModifier(int count) {
		if (count > 1) {
			// This is a fairly low amount of instablility
			return 20;
		}
		
		return 0;
	}
}
