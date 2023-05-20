package view;

public class ReportTable {
	private String reportTitle;
	private Table reportTable;
	
		
	public ReportTable(String reportTitle, Table reportTable) {
		this.reportTitle = reportTitle;
		this.reportTable = reportTable;
	}
	
	
	public String getTitle() {
		return reportTitle;
	}
	public Table getTable() {
		return reportTable;
	}
}
