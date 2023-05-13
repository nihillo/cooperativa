package sampledata;

public enum SampleCustomer {
	
	_018("018", "AgroVida", "S", "Calle Real, 3", "Tarazona de la Mancha, Albacete", "02100"),
	_099("099", "GreenHarvest", "S", "Ctra. Antigua de Málaga, 45", "Granada, Granada", "18071"),
	_121("121", "Juana Sánchez", "E", "Plaza Mayor, 7", "Logroño, La Rioja", "26001"),
	_423("423", "TerraCrops", "S", "Calle del Pilar, 20", "Gijón, Asturias", "33201"),
	_641("641", "Alejandro Gómez", "E", "Avenida de la Libertad, 12", "Vigo, Pontevedra", "36202"),
	_922("922", "Sofía Martínez", "E",  "Calle Mayor, 10", "Jumilla, Murcia", "30520");
	
	
	private String id;
	private String name;
	private String type;
	private String address;
	private String cityProvince;
	private String zipCode;
	
	private SampleCustomer(String id, String name, String type, String address, String cityProvince, String zipCode) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.address = address;
		this.cityProvince = cityProvince;
		this.zipCode = zipCode;
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

	public String getAddress() {
		return address;
	}

	public String getCityProvince() {
		return cityProvince;
	}

	public String getZipCode() {
		return zipCode;
	}
}
