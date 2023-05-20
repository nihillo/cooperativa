package view.command;

import controller.ReportController;
import view.ConsoleView;
import view.ReportTable;

public class LogisticReportCommand extends ReportCommand implements Command {

	public LogisticReportCommand(ConsoleView view, ReportController reportController) {
		super(view, reportController);
	}

	@Override
	protected void retrieveReport() {
		// limpiar posibles ejecuciones previas
		this.reportTables.clear();
		
		ReportTable reportTable = new ReportTable("Beneficios por logística", reportController.getBenefitsByLogistic());
		this.reportTables.add(reportTable);
	}

}
