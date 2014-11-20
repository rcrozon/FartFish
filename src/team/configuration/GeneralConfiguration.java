package team.configuration;

import android.util.DisplayMetrics;

public class GeneralConfiguration {

	public static String SCREEN_WIDTH = "SCREEN_WIDTH";
	public static String SCREEN_HEIGHT = "SCREEN_HEIGHT";
	
	private static GeneralConfiguration oInstance = null;

	public static GeneralConfiguration getInstance() {
		if (oInstance == null) {
			oInstance = new GeneralConfiguration();
		}
		return oInstance;
	}

}
