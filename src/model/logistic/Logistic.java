package model.logistic;

import model.CollectionItem;

/**
 * Clase Logistic (empresa de logística)
 * Implementa CollectionItem
 * 
 * @author Juan Barranco
 *
 */
public class Logistic implements CollectionItem {
	
	protected enum LogisticType { BIG_LOGISTIC, SMALL_LOGISTIC }
	
	private String id;
	private String name;
	protected LogisticType type;
	protected String typeLabel;
	
	/**
	 * Constructor
	 * @param id
	 * @param name
	 */
	public Logistic(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * Devuelve el id de la empresa de logística
	 */
	@Override
	public String getId() {
		return id;
	}
	
	/**
	 * Devuelve la linea de información de la empresa de logística
	 * @return String infoLine
	 */
	public String getInfoLine() {
		String infoLine = this.id + "   --  " + this.getTypeLabel() + "  --   " + this.name;
		return infoLine;
	}
	
	/**
	 * Devuelve el flag de tipo de logística: 
	 * B: gran logística, S: pequeña logística
	 * @return
	 */
	public LogisticType getType() {
		return this.type;
	}
	
	public String getTypeLabel() {
		return this.typeLabel;
	}
}
