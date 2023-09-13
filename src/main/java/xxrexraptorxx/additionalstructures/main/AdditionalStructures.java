package xxrexraptorxx.additionalstructures.main;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxrexraptorxx.additionalstructures.utils.Config;

/**
 * @author XxRexRaptorxX (RexRaptor)
 * @projectPage https://www.curseforge.com/minecraft/mc-mods/additional-structures
 **/
@Mod(References.MODID)
public class AdditionalStructures {

    public static final Logger LOGGER = LogManager.getLogger();

    public AdditionalStructures() {
        Config.init();
    }

}
