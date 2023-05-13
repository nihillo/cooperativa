package view.command;

import java.util.Scanner;

import controller.CustomerController;
import view.ConsoleView;

/**
 * Clase RegisterCustomerCommand - comando registrar cliente
 * @author nihillo
 *
 */
public class RegisterCustomerCommand implements Command {
	
	private ConsoleView view;
	private CustomerController customerController;	
	
	/**
	 * Constructor
	 * @param view
	 * @param customerController
	 */
	public RegisterCustomerCommand(ConsoleView view, CustomerController customerController) {
		this.view = view;
		this.customerController = customerController;
	}


	/**
	 * Ejecuta la acción registrar cliente
	 */
	@Override
	public void execute() {
		Scanner prompt = view.getPrompt();

		view.print("Introduzca ID:");
		String id = prompt.nextLine();
		
		view.print("Introduzca nombre:");
		String name = prompt.nextLine();
		
		String type = null;
		view.print("Tipos disponibles:");
		view.print("E - Cliente final");
		view.print("S - Distribuidor");
		view.print("Introduzca tipo:");
		while (type == null || (!type.equals("E") && !type.equals("e") && !type.equals("S") && !type.equals("s"))) {
			type = prompt.nextLine();
			if (!type.equals("E") && !type.equals("e") && !type.equals("S") && !type.equals("s")) {
				view.print("Introduzca E o S");
			}
		}
		
		type = type.toUpperCase();
		
		view.print("Introduzca dirección:");
		String address = prompt.nextLine();
		
		view.print("Introduzca ciudad y provincia (Ciudad, Provincia):");
		String cityProvince = prompt.nextLine();
		
		view.print("Introduzca código postal:");
		String zipCode = prompt.nextLine();
		
		customerController.registerCustomer(id, name, type, address, cityProvince, zipCode);
		view.refreshMenu("CUSTOMERS");
	}

}
