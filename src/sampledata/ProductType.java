package sampledata;

/**
 * Enum auxiliar ProductType
 * Usada para cargar datos de prueba de productos
 * Define de forma acotada los productos disponibles
 * y sus atributos
 */
public enum ProductType {
	ALMENDRA(false, 2100),
	ACEITE(false, 1800),
	TRIGO(false, 2900),
	UVA(true, 12000),
	TOMATE(true, 44000),
	PIMIENTO(true, 22300);
	
	private boolean perishable;
	private int performance;
	
	
	ProductType(boolean perishable, int performance) {
		this.perishable = perishable;
		this.performance = performance;
	}


	public boolean isPerishable() {
		return this.perishable;
	}


	public int getPerformance() {
		return this.performance;
	}
}
