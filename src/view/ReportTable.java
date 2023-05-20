package view;

/**
 * Clase ReportTable
 * Contiene tabla para informe
 */
public class ReportTable {
	private String reportTitle;
	private Table reportTable;
	
	/**
	 * Constructor
	 * @param reportTitle
	 * @param reportTable
	 */
	public ReportTable(String reportTitle, Table reportTable) {
		this.reportTitle = reportTitle;
		this.reportTable = reportTable;
	}
	
	/**
	 * Devuelve el título
	 */
	public String getTitle() {
		return reportTitle;
	}

	/**
	 * Devuelve el objeto tabla
	 * @return
	 */
	public Table getTable() {
		return reportTable;
	}
}
