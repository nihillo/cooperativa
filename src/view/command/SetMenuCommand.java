package view.command;

import java.util.Scanner;

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
	String redirectMsg;
	
	/**
	 * Constructor
	 * @param view
	 * @param menuID
	 */
	public SetMenuCommand(ConsoleView view, String menuID) {
		this.view = view;
		this.menuID = menuID;
		this.redirectMsg = null;
	}
	
	/**
	 * Constructor con mensaje de redirección
	 * @param view
	 * @param menuID
	 */
	public SetMenuCommand(ConsoleView view, String menuID, String redirectMsg) {
		this.view = view;
		this.menuID = menuID;
		this.redirectMsg = redirectMsg;
	}
	
	/**
	 * Ejecuta la acción establecer menú actual
	 */
	@Override
	public void execute() {
		if (redirectMsg != null) {
			Scanner prompt = view.getPrompt();
			view.print(redirectMsg);
			view.print("Pulse INTRO para continuar:");
			String key = prompt.nextLine();
		}
		
		view.setCurrentMenu(menuID);
	}
}
