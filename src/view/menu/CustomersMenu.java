package view.menu;

import java.util.ArrayList;

import controller.CustomerController;
import model.customer.Customer;
import view.ConsoleView;
import view.command.RegisterCustomerCommand;
import view.command.SetMenuCommand;

/**
 * Clase menu clientes
 * @author Juan Barranco
 *
 */
public class CustomersMenu extends Menu {
	
	ConsoleView view;
	CustomerController customerController;
	
	/**
	 * Constructor
	 * @param view
	 * @param customerController
	 */
	public CustomersMenu(
		ConsoleView view, 
		CustomerController customerController
	) {
		super();
		this.view = view;
		this.customerController = customerController;
		
		this.title = "===== CLIENTES =====";
		
		updateDisplayItems();
		
		this.executableItems.put("1", new MenuExecutableItem("Registrar cliente", new RegisterCustomerCommand(view, this.customerController)));
		this.executableItems.put("q", new MenuExecutableItem("Atrás", new SetMenuCommand(view, "MAIN")));
	}

	@Override
	public void refresh() {
		updateDisplayItems();
	}
	
	/** 
	 * Actualiza displayItems
	 */
	private void updateDisplayItems() {
		this.clearDisplayItems();
		
		this.displayItems.add(new MenuItem("ID   --  TIPO  --   NOMBRE   --   CIUDAD, PROVINCIA"));
		ArrayList<Customer> customers = customerController.getAllCustomers();
		
		customers.forEach(customer -> {
			this.displayItems.add(new MenuItem(customer.getInfoLine()));
		});
	}

}
