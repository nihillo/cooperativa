package sampledata;

public enum ProductType {
	ALMENDRA(false, 2.1),
	ACEITE(false, 1.8),
	TRIGO(false, 2.9),
	UVA(true, 12),
	TOMATE(true, 44),
	PIMIENTO(true, 22.3);
	
	boolean perishable;
	private double performance;
	
	
	ProductType(boolean perishable, double performance) {
		this.perishable = perishable;
		this.performance = performance;
	}
}
