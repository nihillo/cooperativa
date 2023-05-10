package view.command;

import controller.Controller;
import controller.ProducerController;

public class RegisterProducerCommand extends Command {

	public RegisterProducerCommand(Controller controller) {
		super(controller);
	}
	
	public void execute() {
		((ProducerController) receiver).registerProducer();
	}

}
