package view.command;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ProducerController;
import controller.ProductController;
import view.ConsoleView;

/**
 * Clase RegisterProducerCommand - Comando registrar productor
 * Implementa la interfaz Command
 * 
 * @author Juan Barranco
 * @version 0.1
 */
public class RegisterProducerCommand implements Command {
	
	private ConsoleView view;
	private ProducerController producerController;
	private ProductController productController;
	
	/**
	 * Constructor
	 * @param view
	 * @param producerController
	 * @param productController
	 */
	public RegisterProducerCommand(
		ConsoleView view,
		ProducerController producerController,
		ProductController productController
	) {
		this.view = view;
		this.producerController = producerController;
		this.productController = productController;
	}
	
	/**
	 * Ejecuta la acción registrar productor
	 */
	public void execute() {
		Scanner prompt = view.getPrompt();
		
		view.print("Introduzca ID:");
		String id = prompt.nextLine();
		
		view.print("Introduzca nombre:");
		String name = prompt.nextLine();
		
		String[] availableProductList = productController.getRegisteredProductList();
		ArrayList<String> crops = new ArrayList<String>();
		
		boolean continueAddingCrops;
		
		do {
			view.print("Introduzca cultivo (  producto,Ha  - p. ej.: ALMENDRA,2.1  )");
			view.print("Productos disponibles: " + String.join(", ", availableProductList));
			view.print("Introduzca cultivo:");
			String crop = prompt.nextLine();
			
			crops.add(crop);
			
			view.print("¿Desea añadir otro cultivo? (s/n)");
			String continueAnswer = prompt.nextLine();
			
			if (continueAnswer.equals("s") || continueAnswer.equals("S")) {
				continueAddingCrops = true;
			} else {
				continueAddingCrops = false;
			}
			
		} while (continueAddingCrops);
		
		
		producerController.registerProducer(id, name, crops);
	}

}
