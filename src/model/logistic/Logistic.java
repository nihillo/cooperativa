package model.logistic;

import model.CollectionItem;

/**
 * Clase Logistic (empresa de logística)
 * Implementa CollectionItem
 * 
 * @author Juan Barranco
 *
 */
public abstract class Logistic implements CollectionItem {
	
	private String id;
	private String name;
	
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
		String infoLine = this.id + "   --  " + this.getType() + "  --   " + this.name;
		return infoLine;
	}
	
	/**
	 * Devuelve el flag de tipo de logística: 
	 * B: gran logística, S: pequeña logística
	 * @return
	 */
	protected abstract String getType();
}
