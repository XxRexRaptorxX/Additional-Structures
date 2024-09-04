package xxrexraptorxx.additionalstructures.main;

import net.neoforged.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxrexraptorxx.additionalstructures.utils.Config;

/**
 * @author XxRexRaptorxX (RexRaptor)
 * @projectPage <a href="https://www.curseforge.com/minecraft/mc-mods/additional-structures">...</a>
 **/
@Mod(References.MODID)
public class AdditionalStructures {

    public static final Logger LOGGER = LogManager.getLogger();

    public AdditionalStructures() {
        Config.init();
    }

}
