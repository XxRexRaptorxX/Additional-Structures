package xxrexraptorxx.additionalstructures.util;

import xxrexraptorxx.additionalstructures.config.ConfigGeneral;

public class DebugHelper {
	
	public static void Logger(String message) {
		if(ConfigGeneral.activateDebugMode) {
			System.out.println(message);
		}
	}
	
	
	public static void ErrorLogger(String message) {
		if(ConfigGeneral.activateDebugMode) {
			System.err.println(message);
		}
	}

}
