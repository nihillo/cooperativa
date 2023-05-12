package view.menu;

import view.command.Command;

/**
 * Clase MenuExecutableItem
 * Define un elemento de menú ejecutable
 * 
 * @author Juan Barranco
 * @version 0.1
 */
public class MenuExecutableItem extends MenuItem {
	
	private Command command;
	
	/**
	 * Constructor
	 * @param displayText
	 * @param command
	 */
	public MenuExecutableItem(String displayText, Command command) {
		super(displayText);
		this.command = command;
	}
	
	/**
	 * Ejecuta el comando asociado
	 * @return
	 */
	public void executeCommand() {
		command.execute();		
	}
}
