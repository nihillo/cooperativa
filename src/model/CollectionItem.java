package model;

/**
 * Interfaz CollectionItem
 * Debe ser implementada por todas las clases 
 * susceptibles de ser elementos que forman parte de
 * una colección
 * 
 * @author Juan Barranco 
 * @version 0.1
 */
public interface CollectionItem {
	
	/**
	 * Devuelve el ID de un elemento de colección
	 * @return ID - String
	 */
	public String getId();
}