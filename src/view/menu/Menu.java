package view.menu;

import java.util.HashMap;

/**
 * Clase Menu
 * 
 * @author Juan Barranco
 * @version 0.1
 */
public class Menu {
	protected HashMap<String, MenuItem> items;
	protected String title;
	
	/**
	 * Cosntructor
	 */
	public Menu() {
		this.items = new HashMap<String, MenuItem>();
	}
	
	/**
	 * Ejecuta la acción asociada a un elemento de menú,
	 * identificado por su clave
	 * @param character
	 */
	public void executeOption(String character) {
		this.items.get(character).executeCommand();
	}
	
	/**
	 * Devuelve el título del menú
	 * @return String - title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Devuelve os elementos del menú, indexados por clave
	 * @return HashMap<String - clave, MenuItem - elemento>  
	 */
	public HashMap<String, MenuItem> getItems() {
		return this.items;
	}
}
