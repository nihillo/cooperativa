package model.logistic;

/**
 * Clase BigLogistic (empresa de gran logística)
 * Hereda de Logistic
 * 
 * @author Juan Barranco
 *
 */
public class BigLogistic extends Logistic {
	
	/**
	 * Constructor
	 * @param id
	 * @param name
	 */
	public BigLogistic(String id, String name) {
		super(id, name);
	}

	@Override
	protected String getType() {
		return "Gran L";
	}
}
