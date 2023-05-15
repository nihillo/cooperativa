package view.menu;

/**
 * Clase MenuExecutableItem
 * Define un elemento genérico de menú, p. ej. una
 * linea de información a imprimir
 * 
 * @author Juan Barranco
 * @version 0.1
 */
public class MenuItem {
	protected String displayText;
	
	/**
	 * Constructor
	 * @param displayText
	 * @param command
	 */
	public MenuItem(String displayText) {
		this.displayText = displayText;
	}
	
	/**
	 * Devuelve el texto a imprimir en la linea del elemento
	 * @return
	 */
	public String getDisplayText() {
		return displayText;
	}
	
}
