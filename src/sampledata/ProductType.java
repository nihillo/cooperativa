package sampledata;

/**
 * Enum auxiliar ProductType
 * Usada para cargar datos de prueba de productos
 * Define de forma acotada los productos disponibles
 * y sus atributos
 */
public enum ProductType {
	ALMENDRA(false, 2.1),
	ACEITE(false, 1.8),
	TRIGO(false, 2.9),
	UVA(true, 12),
	TOMATE(true, 44),
	PIMIENTO(true, 22.3);
	
	private boolean perishable;
	private double performance;
	
	
	ProductType(boolean perishable, double performance) {
		this.perishable = perishable;
		this.performance = performance;
	}


	public boolean isPerishable() {
		return this.perishable;
	}


	public double getPerformance() {
		return this.performance;
	}
}
