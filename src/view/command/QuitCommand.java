package view.command;

import view.ConsoleView;

/**
 * Clase QuitCommand - Comando cerrar aplicación
 * Implementa la interfaz Command
 * 
 * @author Juan Barranco
 * @version 0.1
 */
public class QuitCommand implements Command {
	
	private ConsoleView view;
	
	public QuitCommand(ConsoleView view) {
		this.view = view;
	}
	
	/**
	 * Ejecuta la acción cerrar aplicación
	 */
	public void execute() {
		view.setEndSignal(true);
	}

}
