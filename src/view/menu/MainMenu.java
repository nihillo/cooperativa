package view.menu;

import view.ConsoleView;
import view.command.ProducersMenuCommand;
import view.command.QuitCommand;

public class MainMenu extends Menu{
	public MainMenu(
		ConsoleView view
	) {
		super();
		this.title = "==== MENU PRINCIPAL ====";
		this.items.put("1", new MenuItem("Productores", new ProducersMenuCommand(view)));
		this.items.put("q", new MenuItem("Salir", new QuitCommand(view)));
	}
}
