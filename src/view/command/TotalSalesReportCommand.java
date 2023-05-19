package view.command;

import java.util.ArrayList;

import controller.ReportController;
import view.ConsoleView;
import view.ReportTable;

public class TotalSalesReportCommand extends ReportCommand implements Command {

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
