package xxrexraptorxx.additionalstructures.util;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import xxrexraptorxx.additionalstructures.config.ConfigGeneral;
import xxrexraptorxx.additionalstructures.main.AdditionalStructures;
import xxrexraptorxx.additionalstructures.main.Reference;


public class Events {    
	
	
    	/** Update-Checker **/
	
	private boolean hasShownUp = false;
	
	
	@SubscribeEvent
	public void onClientTick(ClientTickEvent event) {
		if (ConfigGeneral.activateUpdateChecker) {
		if (UpdateChecker.isNewVersionAvailable() && !hasShownUp && Minecraft.getMinecraft().currentScreen == null) {
	        
				ClickEvent versionCheckChatClickEvent = new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.curseforge.com/minecraft/mc-mods/additional-structures");
	            Style clickableChatStyle = new Style().setClickEvent(versionCheckChatClickEvent);
	            Minecraft.getMinecraft().player.sendMessage(new TextComponentString(TextFormatting.BLUE + "A newer version of " + TextFormatting.YELLOW + Reference.NAME + TextFormatting.BLUE + " is available!"));
	            TextComponentString versionWarningChatComponent = new TextComponentString(TextFormatting.GRAY + "Click here to update!");
	            versionWarningChatComponent.setStyle(clickableChatStyle);
	            Minecraft.getMinecraft().player.sendMessage(versionWarningChatComponent);

			hasShownUp = true;
		}
	  }
	}
	
	
	
	  /** Config Sync **/
	
    @SubscribeEvent
    public void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(Reference.MODID)) {
            ConfigManager.sync(Reference.MODID, Config.Type.INSTANCE);
        }
    }

}


