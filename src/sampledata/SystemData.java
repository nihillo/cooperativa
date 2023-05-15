package sampledata;

public class SystemData {
	private static final int FISCAL_YEAR = 2023;
	private static final float PRODUCER_ANNUAL_EXTENSION_THRESHOLD = 5;
	private static final int PRODUCER_CROPS_NO_THRESHOLD = 5;
	
	public static int getFiscalYear() {
		return FISCAL_YEAR;
	}
	
	public static float getAnualExtensionThreshold() {
		return PRODUCER_ANNUAL_EXTENSION_THRESHOLD;
	}

	public static int getCropsNoThreshold() {
		return PRODUCER_CROPS_NO_THRESHOLD;
	}
}
