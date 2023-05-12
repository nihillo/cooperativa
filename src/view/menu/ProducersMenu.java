package view.menu;

import controller.ProducerController;
import controller.ProductController;
import view.ConsoleView;
import view.command.SetMenuCommand;
import view.command.RegisterProducerCommand;

/**
 * Clase ProducersMenu (Menú Productores)
 * Extiende Menu, estableciendo sus elementos propios
 * 
 * @author Juan Barranco
 * @version 0.1
 */
public class ProducersMenu extends Menu {
	
	/**
	 * Constructor
	 * @param view
	 * @param producerController
	 * @param productController
	 */
	public ProducersMenu(
		ConsoleView view,
		ProducerController producerController,
		ProductController productController
	) {
		super();
		this.title = "===== PRODUCTORES =====";
		this.items.put("1", new MenuItem("Registrar productor", new RegisterProducerCommand(view, producerController, productController)));
		this.items.put("q", new MenuItem("Atrás", new SetMenuCommand(view, "MAIN_MENU")));
	}

}
