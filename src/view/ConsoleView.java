package view;
import java.util.HashMap;
import java.util.Scanner;

import controller.Controller;
import controller.CustomerController;
import controller.LogisticController;
import controller.OrderController;
import controller.ProducerController;
import controller.ProductController;
import view.menu.CustomersMenu;
import view.menu.LogisticsMenu;
import view.menu.MainMenu;
import view.menu.Menu;
import view.menu.MenuExecutableItem;
import view.menu.OrdersMenu;
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
    	controllers.put("PRODUCT", new ProductController());
    	controllers.put("LOGISTIC", new LogisticController());
    	controllers.put("CUSTOMER", new CustomerController());
    	controllers.put("ORDER", new OrderController());
    	
    	menus = new HashMap<String, Menu>();
    	menus.put("MAIN", new MainMenu(this));
    	menus.put("PRODUCERS", new ProducersMenu(this, (ProducerController) controllers.get("PRODUCER"), (ProductController) controllers.get("PRODUCT")));
    	menus.put("LOGISTICS", new LogisticsMenu(this, (LogisticController) controllers.get("LOGISTIC")));
    	menus.put("CUSTOMERS", 
    			new CustomersMenu(
    					this, 
    					(CustomerController) controllers.get("CUSTOMER"), 
    					(OrderController) controllers.get("ORDER"), 
    					(ProductController) controllers.get("PRODUCT"),
    					(LogisticController) controllers.get("LOGISTIC")
    	));
    	menus.put("ORDERS",  new OrdersMenu(this, (OrderController) controllers.get("ORDER")));
    	
    	setCurrentMenu("MAIN");
    }
    
    /**
     * Establece el menú actual, a partir de su ID
     * @param menuID
     */
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
    	print("------------------------");
    	print("");
    	print(currentMenu.getTitle());
    	print("");
    	currentMenu.getDisplayItems().forEach(displayItem -> {
    		print(displayItem.getDisplayText());
    	});
    	print("");
        currentMenu.getExecutableItems().forEach((key, item) -> {
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
        String key = prompt.nextLine().toLowerCase();
        
        MenuExecutableItem selectedItem = null;
        if(currentMenu.getExecutableItems().containsKey(key)) {
        	selectedItem = currentMenu.getExecutableItems().get(key);
        	selectedItem.executeCommand();
        }
        
        return endSignal;
    }
    
    /**
     * Devuelve el prompt
     * @return Scaner - prompt
     */
    public Scanner getPrompt() {
    	return prompt;
    }
    
    /**
     * Establece el atributo endSignal,
     * que en caso de ser true hace que el bucle del prompt
     * termine y se salga de la aplicación
     * @param b boolean
     */
	public void setEndSignal(boolean b) {
		endSignal = b;		
	}
	
	/**
	 * Refresca el menú identificado por menuID
	 * @param menuID
	 */
	public void refreshMenu(String menuID) {
		Menu menu = menus.get(menuID);
		menu.refresh();
	}
	
	/**
	 * Carga datos de prueba
	 */
	public void loadSampleData() {
		ProducerController producerController = (ProducerController) controllers.get("PRODUCER");
		producerController.loadSampleProducers();
		this.refreshMenu("PRODUCERS");
		
		LogisticController logisticController = (LogisticController) controllers.get("LOGISTIC");
		logisticController.loadSampleLogistics();
		this.refreshMenu("LOGISTICS");
		
		CustomerController customerController = (CustomerController) controllers.get("CUSTOMER");
		customerController.loadSampleCustomers();
		this.refreshMenu("CUSTOMERS");
	}
}