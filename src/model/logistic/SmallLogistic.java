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
		this.type = LogisticType.SMALL_LOGISTIC;
		this.typeLabel = "Peq. L";
	}
}
