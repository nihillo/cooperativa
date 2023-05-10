package view.command;

import view.ConsoleView;

public class MainMenuCommand extends Command {

	public MainMenuCommand(ConsoleView receiver) {
		super(receiver);
	}

	@Override
	public void execute() {
		ConsoleView view = (ConsoleView) receiver;
		view.setCurrentMenu("MAIN_MENU");
		view.printMenu();
	}

}
