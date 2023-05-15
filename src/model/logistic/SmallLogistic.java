package model.logistic;

/**
 * Clase SmallLogistic (empresa de pequeña logística)
 * Hereda de Logistic
 * 
 * @author Juan Barranco
 *
 */
public class SmallLogistic extends Logistic {
	
	/**
	 * Constructor
	 * @param id
	 * @param name
	 */
	public SmallLogistic(String id, String name) {
		super(id, name);
	}

	@Override
	protected String getType() {
		return "Peq. L";
	}

}
