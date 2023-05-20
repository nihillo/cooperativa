package view.command;

import controller.ReportController;
import view.ConsoleView;
import view.ReportTable;

/**
 * Comando informe de ventas totales
 */
public class TotalSalesReportCommand extends ReportCommand implements Command {

	/**
	 * Constructor
	 * @param view
	 * @param reportController
	 */
	public TotalSalesReportCommand(ConsoleView view, ReportController reportController) {
		super(view, reportController);
	}

	@Override
	protected void retrieveReport() {
		// limpiar posibles ejecuciones previas
		this.reportTables.clear();
		
		ReportTable reportTable = new ReportTable("Ventas totales por producto", reportController.getTotalSales());
		this.reportTables.add(reportTable);
	}

}
