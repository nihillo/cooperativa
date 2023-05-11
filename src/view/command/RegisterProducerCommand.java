package view.command;

import java.util.ArrayList;
import java.util.Scanner;

import controller.Controller;
import controller.ProducerController;
import model.producer.Producer;
import view.ConsoleView;

public class RegisterProducerCommand extends Command {
	
	private ConsoleView view;
	
	public RegisterProducerCommand(
		ConsoleView view,
		Controller controller
	) {
		super(controller);
		this.view = view;
	}
	
	public void execute() {
		Scanner prompt = view.getPrompt();
		
		view.print("Introduzca ID:");
		String id = prompt.nextLine();
		
		view.print("Introduzca nombre:");
		String name = prompt.nextLine();
		
		ArrayList<String> crops = new ArrayList<String>();
		
		boolean continueAddingCrops;
		
		do {
			view.print("Introduzca cultivo (  producto,Ha  - p. ej.: ALMENDRA,2.1  )");
			view.print("Productos disponibles: ALMENDRA, ACEITE, UVA, TOMATE, PIMIENTO"); // TODO obtener lista desde registrados
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
		
		
		Producer producer = ((ProducerController) receiver).registerProducer(id, name, crops);
		// TODO abrir menú productor con el productor creado
	}

}
