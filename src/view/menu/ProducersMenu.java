package view.menu;

import java.util.ArrayList;

import controller.ProducerController;
import controller.ProductController;
import model.producer.Producer;
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
	
	private ProducerController producerController;
	
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
		this.producerController = producerController;
		
		this.title = "===== PRODUCTORES =====";
		
		updateDisplayItems();
		
		this.executableItems.put("1", new MenuExecutableItem("Registrar productor", new RegisterProducerCommand(view, producerController, productController)));
		this.executableItems.put("q", new MenuExecutableItem("Atrás", new SetMenuCommand(view, "MAIN_MENU")));
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
		
		this.displayItems.add(new MenuItem("ID   --  TIPO  --   NOMBRE   --   CULTIVOS"));
		
		ArrayList<Producer> producers = producerController.getAllProducers();
			
		producers.forEach(producer -> {
			this.displayItems.add(new MenuItem(producer.getInfoLine()));
		});
	}

}
