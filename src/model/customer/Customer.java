package model.customer;

import model.CollectionItem;

/**
 * Clase Customer (Cliente)
 * @author Juan Barranco
 *
 */
public abstract class Customer implements CollectionItem {
	
	private String id;
	private String name;
	private Address address;
	
	/**
	 * Constructor
	 * @param id
	 * @param name
	 * @param addressObj
	 */
	public Customer(String id, String name, Address addressObj) {
		this.id = id;
		this.name = name;
		this.address = addressObj;
	}

	@Override
	public String getId() {
		return this.id;
	}

	/**
	 * Devuelve la linea de información del cliente
	 * @return String infoLine
	 */
	public String getInfoLine() {
		String infoLine = this.id + "   --  " + this.getType() + "  --   " + this.name + "   --   "  + this.address.getCityProvince();
		return infoLine;
	}
	
	public abstract String getType();

	public abstract double getCoopBenefit();

	public abstract int getMaxQtyAllowed();

	public Address getAddress() {
		return this.address;
	}
}
