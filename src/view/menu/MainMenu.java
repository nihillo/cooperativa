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
		this.executableItems.put("1", new MenuExecutableItem("Productores", new SetMenuCommand(view, "PRODUCERS")));
		this.executableItems.put("2", new MenuExecutableItem("Logística", new SetMenuCommand(view, "LOGISTICS")));
		this.executableItems.put("3", new MenuExecutableItem("Clientes", new SetMenuCommand(view, "CUSTOMERS")));
		this.executableItems.put("4", new MenuExecutableItem("Pedidos", new SetMenuCommand(view, "ORDERS")));
		this.executableItems.put("5", new MenuExecutableItem("Informes", new SetMenuCommand(view, "REPORTS")));
		this.executableItems.put("q", new MenuExecutableItem("Salir", new QuitCommand(view)));
	}

	@Override
	public void refresh() {		
	}
}
