package view.menu;

import controller.OrderController;
import view.ConsoleView;
import view.command.SetMenuCommand;


public class OrdersMenu extends Menu {
	
	ConsoleView view;
	OrderController orderController;
	
	/**
	 * Constructor
	 * @param consoleView
	 * @param orderController
	 */
	public OrdersMenu(ConsoleView view, OrderController orderController) {
		super();
		this.view = view;
		this.orderController = orderController;
		
		this.title = "===== PEDIDOS =====";
		
		// TODO pintar lista general de pedidos
//		updateDisplayItems();
		
		this.executableItems.put("1", new MenuExecutableItem("Crear pedido", 
				new SetMenuCommand(view, "CUSTOMERS", "Se redirigirá al menú de clientes, desde donde podrá crear un pedido para el cliente seleccionado.")));
		this.executableItems.put("q", new MenuExecutableItem("Atrás", new SetMenuCommand(view, "MAIN")));
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub

	}

}
