package view.menu;

import controller.ReportController;
import view.ConsoleView;
import view.command.LogisticReportCommand;
import view.command.PricesReportCommand;
import view.command.ProducerReportCommand;
import view.command.CoopBenefitReportCommand;
import view.command.SetMenuCommand;
import view.command.TotalSalesReportCommand;

public class ReportsMenu extends Menu {
	
	ConsoleView view;
	ReportController reportController;
	
	/**
	 * Constructor
	 * @param reportController 
	 * @param consoleView
	 */
	public ReportsMenu(ConsoleView view, ReportController reportController) {
		super();
		this.view = view;
		this.reportController = reportController;
		
		this.title = "===== INFORMES =====";
		
		this.executableItems.put("1", new MenuExecutableItem("Ventas totales por producto", new TotalSalesReportCommand(view, reportController)));
		this.executableItems.put("2", new MenuExecutableItem("Beneficios por productor", new ProducerReportCommand(view, reportController)));
		this.executableItems.put("3", new MenuExecutableItem("Beneficios por logística", new LogisticReportCommand(view, reportController)));
		this.executableItems.put("4", new MenuExecutableItem("Beneficios de la cooperativa por producto", new CoopBenefitReportCommand(view, reportController)));
		this.executableItems.put("5", new MenuExecutableItem("Evolución semanal de precios por producto", new PricesReportCommand(view, reportController)));
		this.executableItems.put("q", new MenuExecutableItem("Atrás", new SetMenuCommand(view, "MAIN")));
		
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub

	}

}
