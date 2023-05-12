package view.command;

import view.ConsoleView;

/**
 * Clase SetMenuCommand - Comando establecer menú
 * Implementa la interfaz Command
 * Actualiza el menú actual en ConsoleView
 * 
 * @author Juan Barranco
 * @version 0.1
 */
public class SetMenuCommand implements Command {
	
	ConsoleView view;
	String menuID;
	
	/**
	 * Constructor
	 * @param view
	 * @param menuID
	 */
	public SetMenuCommand(ConsoleView view, String menuID) {
		this.view = view;
		this.menuID = menuID;
	}
	
	/**
	 * Ejecuta la acción establecer menú actual
	 */
	@Override
	public void execute() {
		view.setCurrentMenu(menuID);
	}
}
