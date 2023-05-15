package model.customer;

import model.CollectionItem;

/**
 * Clase Customer (Cliente)
 * @author Juan Barranco
 *
 */
public abstract class Customer implements CollectionItem {
	
	protected enum CustomerType { STOCKIST, ENDCUSTOMER }
	
	private String id;
	private String name;
	private Address address;
	protected CustomerType type;
	protected String typeLabel;
	
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
	
	public CustomerType getType() {
		return this.type;
	}
	
	public String getTypeLabel() {
		return this.typeLabel;
	}

	/**
	 * Devuelve la linea de información del cliente
	 * @return String infoLine
	 */
	public String getInfoLine() {
		String infoLine = this.id + "   --  " + this.getTypeLabel() + "  --   " + this.name + "   --   "  + this.address.getCityProvince();
		return infoLine;
	}
	
	public abstract double getCoopBenefit();

	public abstract int[] getAllowedQtyRange();

	public Address getAddress() {
		return this.address;
	}
}
