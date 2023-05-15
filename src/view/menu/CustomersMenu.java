package view.menu;

import java.util.ArrayList;

import controller.CustomerController;
import controller.LogisticController;
import controller.OrderController;
import controller.ProductController;
import model.customer.Customer;
import view.ConsoleView;
import view.command.CreateOrderCommand;
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
	OrderController orderController;
	ProductController productController;
	LogisticController logisticController;
	
	/**
	 * Constructor
	 * @param view
	 * @param customerController
	 */
	public CustomersMenu(
		ConsoleView view, 
		CustomerController customerController,
		OrderController orderController,
		ProductController productController,
		LogisticController logisticController
	) {
		super();
		this.view = view;
		this.customerController = customerController;
		this.orderController = orderController;
		this.productController = productController;
		this.logisticController = logisticController;
		
		this.title = "===== CLIENTES =====";
		
		updateDisplayItems();
		
		this.executableItems.put("1", new MenuExecutableItem("Registrar cliente", new RegisterCustomerCommand(view, this.customerController)));
		this.executableItems.put("2", new MenuExecutableItem(
				"Crear pedido para cliente", 
				new CreateOrderCommand(
						view, 
						this.orderController, 
						this.customerController, 
						this.productController,
						this.logisticController
		)));
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
