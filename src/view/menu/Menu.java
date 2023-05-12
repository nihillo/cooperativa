package view.menu;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase Menu
 * 
 * @author Juan Barranco
 * @version 0.1
 */
public abstract class Menu {
	protected ArrayList<MenuItem> displayItems;
	protected HashMap<String, MenuExecutableItem> executableItems;
	protected String title;
	
	/**
	 * Cosntructor
	 */
	public Menu() {
		this.executableItems = new HashMap<String, MenuExecutableItem>();
		this.displayItems = new ArrayList<MenuItem>();
	}
	
	/**
	 * Ejecuta la acción asociada a un elemento de menú,
	 * identificado por su clave
	 * @param character
	 */
	public void executeOption(String character) {
		this.executableItems.get(character).executeCommand();
	}
	
	/**
	 * Devuelve el título del menú
	 * @return String - title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Devuelve os elementos ejecutables del menú, indexados por clave
	 * @return HashMap<String - clave, MenuItem - elemento>  
	 */
	public HashMap<String, MenuExecutableItem> getExecutableItems() {
		return this.executableItems;
	}
	
	/**
	 * Devuelve os elementos no ejecutables del menú, indexados por clave
	 * @return HashMap<String - clave, MenuItem - elemento>  
	 */
	public ArrayList<MenuItem> getDisplayItems() {
		return this.displayItems;
	}
	
	protected void clearDisplayItems() {
		this.displayItems = new ArrayList<MenuItem>();
	}

	public abstract void refresh();
}
