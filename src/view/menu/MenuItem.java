package view.menu;

import view.command.Command;

public class MenuItem {
	String displayText;
	Command command;
	
	public MenuItem(String displayText, Command command) {
		this.displayText = displayText;
		this.command = command;
	}

	public String getDisplayText() {
		return displayText;
	}
	
	public void executeCommand() {
		command.execute();		
	}
}
