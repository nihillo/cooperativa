package view.command;

import view.ConsoleView;

public class QuitCommand extends Command {
	
	public QuitCommand(ConsoleView receiver) {
		super(receiver);
	}
	
	public void execute() {
		((ConsoleView) receiver).setEndSignal(true);
	}

}
