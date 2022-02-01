package xxrexraptorxx.additionalstructures.proxy;
 
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import xxrexraptorxx.additionalstructures.util.Events;
import xxrexraptorxx.additionalstructures.util.UpdateChecker;
import xxrexraptorxx.additionalstructures.world.WorldGenStructures;

@Mod.EventBusSubscriber
public class CommonProxy {
 
    public void preInit(FMLPreInitializationEvent event) {

        UpdateChecker.checkForUpdates();  
        MinecraftForge.EVENT_BUS.register(new Events());  
           
    	GameRegistry.registerWorldGenerator(new WorldGenStructures(), 0);
    	
    }

    public void init(FMLInitializationEvent event) {
    }

    public void postInit(FMLPostInitializationEvent event) {
    }

}
   

  