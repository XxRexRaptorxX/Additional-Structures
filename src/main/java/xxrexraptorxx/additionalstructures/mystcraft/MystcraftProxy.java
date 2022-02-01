package xxrexraptorxx.additionalstructures.mystcraft;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Helper class to make Mystcraft integration easier. This version is purposefully
 * a no-op one, so that methods can be called without extra checking even when
 * Mystcraft is not installed.
 * 
 * @author v19930312
 *
 */
public class MystcraftProxy {
	public boolean isActive() {
		return false;
	}
	
	public void preInit(FMLPreInitializationEvent event) {
	}

	public void init(FMLInitializationEvent event) {
    }

    public void postInit(FMLPostInitializationEvent event) {
    }
}
