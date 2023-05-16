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
		this.type = CustomerType.STOCKIST;
		this.typeLabel = "Dist.";
		this.taxRate = 0;
	}

	@Override
	public double getCoopBenefit() {
		return 1.05;
	}

	@Override
	public int[] getAllowedQtyRange() {
		// mínimo 1 T = 1000 kg,
		// máximo ilimitado a efectos prácticos,
		// devolvemos un valor arbitrariamente alto
		int[] range = {1000, 1000000000};
		return range;
	}

}
