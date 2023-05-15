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
		return "Dist.";
	}

	@Override
	public double getCoopBenefit() {
		return 1.05;
	}

	@Override
	public int getMaxQtyAllowed() {
		// ilimitado a efectos prácticos,
		// devolvemos el máximo permitido para int
		return 2147483647;
	}

}
