package view.menu;

import view.command.Command;

/**
 * Clase MenuItem
 * Define un elemento de menú
 * 
 * @author Juan Barranco
 * @version 0.1
 */
public class MenuItem {
	String displayText;
	Command command;
	
	/**
	 * Constructor
	 * @param displayText
	 * @param command
	 */
	public MenuItem(String displayText, Command command) {
		this.displayText = displayText;
		this.command = command;
	}
	
	/**
	 * Devuelve el texto a imprimir en la linea del elemento
	 * @return
	 */
	public String getDisplayText() {
		return displayText;
	}
	
	/**
	 * Ejecuta el comando asociado
	 * @return
	 */
	public void executeCommand() {
		command.execute();		
	}
}
