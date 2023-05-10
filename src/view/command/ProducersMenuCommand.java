package view.command;

import view.ConsoleView;

public class ProducersMenuCommand extends Command {

	public ProducersMenuCommand(ConsoleView receiver) {
		super(receiver);
	}

	@Override
	public void execute() {
		ConsoleView view = (ConsoleView) receiver;
		view.setCurrentMenu("PRODUCERS_MENU");
		view.printMenu();
	}

}
