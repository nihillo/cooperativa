package view.command;

import java.util.ArrayList;

import controller.ReportController;
import model.producer.Producer;
import model.producer.ProducerCollection;
import view.ConsoleView;
import view.ReportTable;

public class ProducerReportCommand extends ReportCommand implements Command {

	public ProducerReportCommand(ConsoleView view, ReportController reportController) {
		super(view, reportController);
	}

	@Override
	protected void retrieveReport() {
		
		this.reportTables.clear();
		
		ProducerCollection producerCollection = ProducerCollection.getInstance();
		ArrayList<Producer> producers = producerCollection.getAll();
		
		for (Producer producer : producers) {			
			ReportTable reportTable = new ReportTable(reportController.getProducerReportTitle(producer), reportController.getProducerBenefit(producer));
			this.reportTables.add(reportTable);
		}
		
	}

}
