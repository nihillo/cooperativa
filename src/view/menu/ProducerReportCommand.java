package view.menu;

import controller.ReportController;
import view.ConsoleView;
import view.command.Command;
import view.command.ReportCommand;

public class ProducerReportCommand extends ReportCommand implements Command {

	public ProducerReportCommand(ConsoleView view, ReportController reportController) {
		super(view, reportController);
	}

	@Override
	protected void retrieveReport() {
		// TODO Auto-generated method stub
		
	}

}
