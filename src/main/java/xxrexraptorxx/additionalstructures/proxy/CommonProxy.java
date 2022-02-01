package xxrexraptorxx.additionalstructures.proxy;
 
import java.lang.reflect.InvocationTargetException;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import xxrexraptorxx.additionalstructures.main.AdditionalStructures;
import xxrexraptorxx.additionalstructures.mystcraft.MystcraftProxy;
import xxrexraptorxx.additionalstructures.util.Events;
import xxrexraptorxx.additionalstructures.util.UpdateChecker;
import xxrexraptorxx.additionalstructures.world.WorldGenStructures;

@Mod.EventBusSubscriber
public class CommonProxy {
 
    public void preInit(FMLPreInitializationEvent event) {

        UpdateChecker.checkForUpdates();  
        MinecraftForge.EVENT_BUS.register(new Events());
        
        // TODO: option to disable integration in config
        if (Loader.isModLoaded("mystcraft")) {
        	try {
        		System.out.println("Loading Mystcraft integration");
				AdditionalStructures.mystcraft_proxy = (MystcraftProxy)Class.forName("xxrexraptorxx.additionalstructures.mystcraft.MystcraftProxyImpl").getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				// Fall back to no-op for the time being
        		System.out.println("Mystcraft integration failed to load!");
				AdditionalStructures.mystcraft_proxy = new MystcraftProxy();
			}
        } else {
    		System.out.println("Mystcraft integration not active");
        	AdditionalStructures.mystcraft_proxy = new MystcraftProxy();
        }
        
        AdditionalStructures.mystcraft_proxy.preInit(event);
           
        if (!AdditionalStructures.mystcraft_proxy.isActive()) {
        	// Mystcraft proxy registers a wrapper on its own
        	GameRegistry.registerWorldGenerator(new WorldGenStructures(), 0);
        }
    	
    }

    public void init(FMLInitializationEvent event) {
    	AdditionalStructures.mystcraft_proxy.init(event);
    }

    public void postInit(FMLPostInitializationEvent event) {
    	AdditionalStructures.mystcraft_proxy.postInit(event);
    }

}
   

  