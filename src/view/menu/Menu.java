package view.menu;

import java.util.HashMap;

public class Menu {
	protected HashMap<String, MenuItem> items;
	protected String title;
	
	public Menu() {
		this.items = new HashMap<String, MenuItem>();
	}
	
	public void executeOption(String character) {
		this.items.get(character).executeCommand();
	}
	
	public String getTitle() {
		return title;
	}
	
	public HashMap<String, MenuItem> getItems() {
		return this.items;
	}
}
