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
		return "Final";
	}

	@Override
	public double getCoopBenefit() {
		return 1.15;
	}

	@Override
	public int[] getAllowedQtyRange() {
		// min 1, max 100
		int[] range = {1, 100};
		return range;
	}

}
