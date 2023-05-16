package utils;

import sampledata.DistanceTable;

public class DistanceUtils {
	
	private static DistanceUtils instance;
	private DistanceTable distanceTable;
	
	private DistanceUtils() {
		distanceTable = new DistanceTable();
	}
	
	public static DistanceUtils getInstance() {
		if (instance == null) {
			instance = new DistanceUtils();
		}
		
		return instance;
	}

	public int getInterprovincialDistance(String destZipCode) {
		String firstTwoChars = destZipCode.substring(0, 2);
		int distance = distanceTable.getDistance(firstTwoChars);
		
		return distance;
	}

	public int getLastMileDistance(String destZipCode) {
		String lastThreeChars = destZipCode.substring(destZipCode.length() - 3);
		return Integer.parseInt(lastThreeChars)/10;
	}
}
