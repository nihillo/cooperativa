package view.command;

import java.util.ArrayList;

import controller.ReportController;
import view.ConsoleView;
import view.ReportTable;
import view.Table;

public abstract class ReportCommand implements Command {
	protected ConsoleView view;
	protected ReportController reportController;
	protected ArrayList<ReportTable> reportTables; 
	
	
	public ReportCommand(ConsoleView view, ReportController reportController) {
		this.view = view;
		this.reportController = reportController;
		this.reportTables = new ArrayList<ReportTable>();
	}

	@Override
	public void execute() {
		retrieveReport();
		
		reportTables.forEach(reportTable -> {
			view.print(reportTable.getTitle());
			reportTable.getTable().render();
			view.print("");
		});
	}

	protected abstract void retrieveReport();
}
