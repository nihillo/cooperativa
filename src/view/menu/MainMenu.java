package view.menu;

import view.ConsoleView;
import view.command.QuitCommand;
import view.command.SetMenuCommand;

/**
 * Clase MainMenu (Menú Principal)
 * Extiende Menu, estableciendo sus elementos propios
 * 
 * @author Juan Barranco
 * @version 0.1
 */
public class MainMenu extends Menu{
	
	/**
	 * Constructor
	 * @param view
	 */
	public MainMenu(
		ConsoleView view
	) {
		super();
		this.title = "==== MENU PRINCIPAL ====";
		this.items.put("1", new MenuItem("Productores", new SetMenuCommand(view, "PRODUCERS_MENU")));
		this.items.put("q", new MenuItem("Salir", new QuitCommand(view)));
	}
}
