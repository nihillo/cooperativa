package sampledata;

public enum SampleLogistic {
	_007("007", "MVRDV", "B"),
	_021("021", "SFTP", "S"),
	_057("057", "TCP", "S"),
	_131("131", "RCP", "B"),
	_515("515", "MTV", "S");
	
	private String id;
	private String name;
	private String type;
	
	SampleLogistic(String id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}
	
	public String getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
}
