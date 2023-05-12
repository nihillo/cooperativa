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
		this.executableItems.put("1", new MenuExecutableItem("Productores", new SetMenuCommand(view, "PRODUCERS_MENU")));
		this.executableItems.put("q", new MenuExecutableItem("Salir", new QuitCommand(view)));
	}

	@Override
	public void refresh() {		
	}
}
