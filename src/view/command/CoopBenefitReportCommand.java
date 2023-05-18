package view.command;

import controller.ReportController;
import view.ConsoleView;
import view.ReportTable;

public class CoopBenefitReportCommand extends ReportCommand implements Command {

	public CoopBenefitReportCommand(ConsoleView view, ReportController reportController) {
		super(view, reportController);
	}

	@Override
	protected void retrieveReport() {
		// limpiar posibles ejecuciones previas
		this.reportTables.clear();
		
		ReportTable reportTable = new ReportTable("Beneficios de la cooperativa por producto", reportController.getCoopBenefit());
		this.reportTables.add(reportTable);
		
	}

}
