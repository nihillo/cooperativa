package view.command;

import controller.ReportController;
import view.ConsoleView;
import view.ReportTable;

public class PricesReportCommand extends ReportCommand implements Command {

	public PricesReportCommand(ConsoleView view, ReportController reportController) {
		super(view, reportController);
	}

	@Override
	protected void retrieveReport() {
		// limpiar posibles ejecuciones previas
		this.reportTables.clear();
		
		ReportTable reportTable = new ReportTable("Evolución semanal de precios por producto", reportController.getPriceEvolution());
		this.reportTables.add(reportTable);
	}

}
