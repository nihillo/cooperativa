package view.menu;

import controller.Controller;
import view.ConsoleView;
import view.command.MainMenuCommand;
import view.command.RegisterProducerCommand;

public class ProducersMenu extends Menu {
	public ProducersMenu(
		ConsoleView view,
		Controller controller
	) {
		super();
		this.title = "===== PRODUCTORES =====";
		this.items.put("1", new MenuItem("Registrar productor", new RegisterProducerCommand(view, controller)));
		this.items.put("q", new MenuItem("Atrás", new MainMenuCommand(view)));
	}

}
