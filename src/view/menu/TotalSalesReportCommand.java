package view.menu;

import controller.ReportController;
import view.ConsoleView;
import view.command.Command;
import view.command.ReportCommand;

public class TotalSalesReportCommand extends ReportCommand implements Command {

	public TotalSalesReportCommand(ConsoleView view, ReportController reportController) {
		super(view, reportController);
	}

	@Override
	protected void retrieveReport() {
		this.reportTitle = "Ventas totales por producto";
		this.reportHeader = "PRODUCTO    --    CANTIDAD TOTAL KG    --    VENTA TOTAL €";
		this.reportLines = reportController.getTotalSales();
	}

}
