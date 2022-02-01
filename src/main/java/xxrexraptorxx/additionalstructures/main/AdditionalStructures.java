package xxrexraptorxx.additionalstructures.main;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import xxrexraptorxx.additionalstructures.proxy.CommonProxy;

/**---------------------------------------------------------------------------------*
 * @author XxRexRaptorxX (RexRaptor)
 * @projectPage https://minecraft.curseforge.com/projects/additional-structures
 **---------------------------------------------------------------------------------*/
@Mod(modid = Reference.MODID, version = Reference.VERSION, acceptedMinecraftVersions = Reference.MCVERSIONS, acceptableRemoteVersions = "*")
public class AdditionalStructures {

    @Mod.Instance
    public static AdditionalStructures instance;
    
    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.SERVER)
    public static CommonProxy proxy;
    
    
    /***********************************************************************************************************************************/ 
    /***********************************************************************************************************************************/

    
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	proxy.preInit(event);
    }
  
    
    @Mod.EventHandler
    public void Init(FMLInitializationEvent event) {
    	proxy.init(event);
    }
   
 
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	proxy.postInit(event);
    }
 
}