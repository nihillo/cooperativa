package view.menu;

import java.util.ArrayList;

import controller.LogisticController;
import model.logistic.Logistic;
import view.ConsoleView;
import view.command.RegisterLogisticCommand;
import view.command.SetMenuCommand;

/**
 * Clase ge genera y maneja el menú de empresas de logística
 * @author Juan Barranco
 *
 */
public class LogisticsMenu extends Menu {
	
	private LogisticController logisticController;
	
	/**
	 * Constructor
	 * @param view
	 * @param logisticController
	 */
	public LogisticsMenu(
		ConsoleView view, 
		LogisticController logisticController
	) {
		super();
		
		this.logisticController = logisticController;
		
		this.title = "===== LOGÍSTICA =====";
		
		this.executableItems.put("1", new MenuExecutableItem("Registrar empresa de logística", new RegisterLogisticCommand(view, this.logisticController)));
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
		
		this.displayItems.add(new MenuItem("ID   --  TIPO  --   NOMBRE"));
		ArrayList<Logistic> logistics = logisticController.getAllLogistics();
			
		logistics.forEach(logistic -> {
			this.displayItems.add(new MenuItem(logistic.getInfoLine()));
		});
	}

}
