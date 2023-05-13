package view.command;

import java.util.Scanner;

import controller.LogisticController;
import view.ConsoleView;

public class RegisterLogisticCommand implements Command {
	
	private ConsoleView view;
	private LogisticController logisticController;

	/**
	 * Constructor
	 * @param view
	 * @param logisticController
	 */
	public RegisterLogisticCommand(ConsoleView view, LogisticController logisticController) {
		this.view = view;
		this.logisticController = logisticController;
	}
	
	/**
	 * Ejecuta la acción registrar empresa de logística
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
		view.print("B - Gran logística");
		view.print("S - Pequeña logística");
		view.print("Introduzca tipo:");
		while (type == null || (!type.equals("B") && !type.equals("b") && !type.equals("S") && !type.equals("s"))) {
			type = prompt.nextLine();
			if (!type.equals("B") && !type.equals("b") && !type.equals("S") && !type.equals("s")) {
				view.print("Introduzca B o S");
			}
		}
		
		type = type.toUpperCase();
		
		logisticController.registerLogistic(id, name, type);
		view.refreshMenu("LOGISTICS");
	}

}
