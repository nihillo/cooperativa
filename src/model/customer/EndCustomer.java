package model.customer;

/**
 * Clase EndCustomer (Cliente final)
 * Hereda de Customer
 * @author nihillo
 *
 */
public class EndCustomer extends Customer {

	/**
	 * Constructor
	 * @param id
	 * @param name
	 * @param addressObj
	 */
	public EndCustomer(String id, String name, Address addressObj) {
		super(id, name, addressObj);
	}

	@Override
	public String getType() {
		return "E";
	}

}
