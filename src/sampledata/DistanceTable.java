package sampledata;

import java.util.HashMap;

public class DistanceTable {
	
	private HashMap<String, Integer> distanceTable;

	public DistanceTable() {
		this.distanceTable = new HashMap<String, Integer>();
		
		distanceTable.put("01", 540);
		distanceTable.put("02", 0);
		distanceTable.put("03", 190);
		distanceTable.put("04", 425);
		distanceTable.put("05", 330);
		distanceTable.put("06", 430);
		distanceTable.put("08", 550);
		distanceTable.put("09", 420);
		distanceTable.put("10", 250);
		distanceTable.put("11", 420);
		distanceTable.put("12", 300);
		distanceTable.put("13", 120);
		distanceTable.put("14", 240);
		distanceTable.put("15", 780);
		distanceTable.put("16", 220);
		distanceTable.put("17", 620);
		distanceTable.put("18", 320);
		distanceTable.put("19", 240);
		distanceTable.put("20", 580);
		distanceTable.put("21", 510);
		distanceTable.put("22", 470);
		distanceTable.put("23", 270);
		distanceTable.put("24", 510);
		distanceTable.put("25", 480);
		distanceTable.put("26", 430);
		distanceTable.put("27", 670);
		distanceTable.put("28", 245);
		distanceTable.put("29", 380);
		distanceTable.put("30", 180);
		distanceTable.put("31", 490);
		distanceTable.put("32", 660);
		distanceTable.put("33", 690);
		distanceTable.put("34", 470);
		distanceTable.put("36", 670);
		distanceTable.put("37", 300);
		distanceTable.put("39", 700);
		distanceTable.put("40", 300);
		distanceTable.put("41", 430);
		distanceTable.put("42", 460);
		distanceTable.put("43", 510);
		distanceTable.put("44", 290);
		distanceTable.put("45", 250);
		distanceTable.put("46", 220);
		distanceTable.put("47", 450);
		distanceTable.put("48", 550);
		distanceTable.put("49", 460);
		distanceTable.put("50", 310);
	}



	public int getDistance(String firstTwoChars) {
		return this.distanceTable.get(firstTwoChars);
	}

}
