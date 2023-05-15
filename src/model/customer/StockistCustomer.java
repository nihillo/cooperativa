package model.customer;

/**
 * Clase StockistCustomer (Distribuidor)
 * @author Juan Barranco
 *
 */
public class StockistCustomer extends Customer {
	
	/**
	 * Constructor
	 * @param id
	 * @param name
	 * @param addressObj
	 */
	public StockistCustomer(String id, String name, Address addressObj) {
		super(id, name, addressObj);
	}

	@Override
	public String getType() {
		return "S";
	}

	@Override
	public double getCoopBenefit() {
		return 1.05;
	}

}
