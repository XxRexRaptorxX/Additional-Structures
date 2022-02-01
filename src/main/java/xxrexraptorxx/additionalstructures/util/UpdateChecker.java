package xxrexraptorxx.additionalstructures.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import xxrexraptorxx.additionalstructures.main.Reference;


public class UpdateChecker {

	private static final String UPDATE_URL = "https://raw.githubusercontent.com/XxRexRaptorxX/Update-Checker/main/AdditionalStructures%201.12.x?dl=0";

	private static boolean newVersionAvailable = false;
			
	public static void checkForUpdates() {
		new Thread("Update-Checker") {
			
			public void run() {
				try {
				URL url = new URL(UPDATE_URL);
				Scanner scanner = new Scanner(url.openStream());
				String latestVersion = scanner.nextLine();
				scanner.close();
				if (!Reference.VERSION.equals(latestVersion)) {
					newVersionAvailable = true;
				}
			} catch (MalformedURLException e) {
				System.err.println("Update-URL not found!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		};
			
		}.start();
		
	}
	
	public static synchronized boolean isNewVersionAvailable() {
		return newVersionAvailable;
	}
	
}
