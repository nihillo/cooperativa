package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase Collection. 
 * Nucleo a usar por composición por todas las 
 * colecciones. Provee los métodos comunes a 
 * utilizar por ellas.
 * 
 * @author Juan Barranco 
 * @version 0.1
 */
public class Collection<E> {

	private HashMap<String, E> collection;
	
	/**
	 * Constructor de la clase Collection
	 */
	public Collection() {
		collection = new HashMap<String, E>();
	}
	
	/**
	 * Añade un elemento a la colección
	 * @param e - elemento a añadir
	 */
	public void add(E e) {
		String id = ((CollectionItem) e).getId();
		collection.put(id, e);
	}
	
	/**
	 * Obtiene un elemento a partir de su ID, null si no existe
	 * @param id
	 * @return e CollectionItem
	 */
	public E get(String id) {
		if (collection.containsKey(id)) {
			return collection.get(id);
		}
		
		return null;
	}
	
	/**
	 * Verifica si la colección contiene un elemento
	 * a partir de su ID
	 * @param id
	 * @return boolean
	 */
	public boolean contains(String id) {
		return collection.containsKey(id);
	}
	
	/**
	 * Devuelve un array con los IDs de todos los elementos
	 * @return String[]
	 */
	public String[] getIDs() {
		String[] array = collection.keySet().toArray(new String[0]);
		return array;
	}
	
	public ArrayList<E> getAll() {
		ArrayList<E> allElements = new ArrayList<>(collection.values());
		return allElements;
	}
}
