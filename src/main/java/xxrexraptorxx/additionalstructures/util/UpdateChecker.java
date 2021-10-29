package xxrexraptorxx.additionalstructures.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import xxrexraptorxx.additionalstructures.main.AdditionalStructures;
import xxrexraptorxx.additionalstructures.main.Reference;


public class UpdateChecker {

	private static final String UPDATE_URL = "https://1drv.ms/t/s!Agq2FTsQMus2geYnjSgCFD7NIaH-TQ?e=LKhDCj?dl=1";

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

	private static synchronized void setNewVersionAvaiable() {
		newVersionAvailable = true;
	}
	
	public static synchronized boolean isNewVersionAvailable() {
		return newVersionAvailable;
	}
	
}
