package view.command;

import java.util.ArrayList;

import controller.ReportController;
import view.ConsoleView;

public abstract class ReportCommand implements Command {
	protected ConsoleView view;
	protected ReportController reportController;
	protected String reportTitle;
	protected String reportHeader;
	protected ArrayList<String> reportLines;
	
	public ReportCommand(ConsoleView view, ReportController reportController) {
		this.view = view;
		this.reportController = reportController;
	}

	@Override
	public void execute() {
		retrieveReport();
		
		view.print(reportTitle);
		view.print(reportHeader);
		reportLines.forEach(line -> {
			view.print(line);
		});
	}

	protected abstract void retrieveReport();
}
