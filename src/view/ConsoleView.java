package view;
import java.util.HashMap;
import java.util.Scanner;

import controller.Controller;
import controller.ProducerController;
import view.menu.MainMenu;
import view.menu.Menu;
import view.menu.MenuItem;
import view.menu.ProducersMenu;


/**
 * Clase principal de las vistas de la aplicacion
 * 
 * @author Juan Barranco
 * @version 0.1
 */
public class ConsoleView
{	
	private boolean endSignal;
	private Scanner prompt;
	
	private HashMap<String, Controller> controllers;
	
	private HashMap<String, Menu> menus;
	private Menu currentMenu;
	
    /**
     * Constructor 
     */
    public ConsoleView() {
    	endSignal = false;
    	prompt = new Scanner(System.in);
    	
    	controllers = new HashMap<String, Controller>();
    	controllers.put("PRODUCER", new ProducerController());
    	
    	menus = new HashMap<String, Menu>();
    	menus.put("MAIN_MENU", new MainMenu(this));
    	menus.put("PRODUCERS_MENU", new ProducersMenu(this, controllers.get("PRODUCER")));

    	setCurrentMenu("MAIN_MENU");
    }
    
    public void setCurrentMenu(String menuID) {
    	Menu menu = menus.get(menuID);
    	currentMenu = menu;
	}

	/**
     * Imprime una linea
     * @param str String: linea a imprimir
     */
    public void print(String str) {
        System.out.println(str);
    }
    
    /**
     * Imprime el menu de la aplicacion
     */
    public void printMenu() {
    	print("");
    	print(currentMenu.getTitle());
    	print("");
        currentMenu.getItems().forEach((key, item) -> {
        	print(key + " - " + item.getDisplayText());
        });
        print("");
    }
    
    
    /**
     * Imprime la linea de prompt y queda a la espera de entrada
     * de usuario
     */
    public boolean prompt() {   	
        print("Seleccione una opcion:");
        String key = prompt.nextLine();
        
        MenuItem selectedItem = null;
        if(currentMenu.getItems().containsKey(key)) {
        	selectedItem = currentMenu.getItems().get(key);
        	selectedItem.executeCommand();
        }
        
        return endSignal;
    }
    
    public void exit() {
    	
    }

	public void setEndSignal(boolean b) {
		endSignal = b;		
	}

	public void printHeader() {
		// TODO Auto-generated method stub
		
	}
}