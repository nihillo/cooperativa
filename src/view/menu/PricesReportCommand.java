package view.menu;

import controller.ReportController;
import view.ConsoleView;
import view.command.Command;
import view.command.ReportCommand;

public class PricesReportCommand extends ReportCommand implements Command {

	public PricesReportCommand(ConsoleView view, ReportController reportController) {
		super(view, reportController);
	}

	@Override
	protected void retrieveReport() {
		// TODO Auto-generated method stub
		
	}

}
