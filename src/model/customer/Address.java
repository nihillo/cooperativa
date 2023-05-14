package model.customer;

/**
 * Clase Address
 * Representa una dirección postal
 * @author Juan Barranco
 *
 */
public class Address {
	private String address;
	private String cityProvince;
	private String zipCode;
	
	/**
	 * Constructor
	 * @param address
	 * @param cityProvince
	 * @param zipCode
	 */
	public Address(String address, String cityProvince, String zipCode) {
		this.address = address;
		this.cityProvince = cityProvince;
		this.zipCode = zipCode;
	}
	
	/**
	 * Devuelve la dirección
	 * @return String address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Devuelve la ciudad y provincia (Ciudad, Provincia)
	 * @return String ciudad, provincia
	 */
	public String getCityProvince() {
		return cityProvince;
	}

	/**
	 * Devuelve el código postal
	 * @return String zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}
}
