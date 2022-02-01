package xxrexraptorxx.additionalstructures.mystcraft;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

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
		GameRegistry.registerWorldGenerator(new MystcraftWorldGenStructures(), 0);
	}

	@Override
	public void init(FMLInitializationEvent event) {
    }

	@Override
    public void postInit(FMLPostInitializationEvent event) {
    }
}
