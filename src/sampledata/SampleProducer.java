package sampledata;

import java.util.ArrayList;
import java.util.Arrays;

public enum SampleProducer {
	_001("001", "Laura Martínez", "ALMENDRA,3.2"),
	_013("013", "Javier Rodríguez", "ACEITE,4.4|TOMATE,6.2"),
	_003("056", "María López", "PIMIENTO,0.3|TOMATE,1.2"),
	_472("472", "Carlos Ramírez", "TRIGO,2.3|UVA,9.2|ALMENDRA,4.4");
	
	private String id;
	private String name;
	private ArrayList<String> cropStrArr;
	
	SampleProducer(String id, String name, String cropSerialized) {
		this.id = id;
		this.name = name;
		if (cropSerialized.contains("|")) {
			String[] spl = cropSerialized.split("\\|");
			this.cropStrArr = new ArrayList<String>(Arrays.asList(spl));
		} else {
			this.cropStrArr = new ArrayList<String>(Arrays.asList(cropSerialized));
		}
	}
	
	public String getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<String> getCropStrArr() {
		return cropStrArr;
	}
}
