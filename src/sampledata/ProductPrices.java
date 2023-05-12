package sampledata;

import java.util.HashMap;

/**
 * Clase auxiliar ProductPrices
 * Usada para cargar datos de prueba de los precios
 * de cada producto
 */
public class ProductPrices {

	private HashMap<String, Double> ALMENDRA;
	private HashMap<String, Double> ACEITE;
	private HashMap<String, Double> TRIGO;
	private HashMap<String, Double> UVA;
	private HashMap<String, Double> TOMATE;
	private HashMap<String, Double> PIMIENTO;
	
	public ProductPrices() {
		initAlmendra();
		initAceite();
		initTrigo();
		initUva();
		initTomate();
		initPimiento();
	}

	private void initAlmendra() {
		ALMENDRA = new HashMap<String, Double>()
		{{
			put("W01", 9.50);
			put("W02", 9.56);
			put("W03", 9.32);
			put("W04", 9.65);
			put("W05", 9.63);
			put("W06", 9.70);
			put("W07", 9.74);
			put("W08", 9.80);
			put("W09", 9.78);
			put("W10", 9.85);
			put("W11", 9.83);
			put("W12", 9.90);
			put("W13", 9.88);
			put("W14", 9.95);
			put("W15", 9.93);
			put("W16", 10.00);
			put("W17", 9.98);
			put("W18", 10.05);
			put("W19", 10.03);
			put("W20", 10.10);
			put("W21", 10.08);
			put("W22", 10.15);
			put("W23", 10.13);
			put("W24", 10.20);
			put("W25", 10.18);
			put("W26", 10.25);
			put("W27", 10.23);
			put("W28", 10.30);
			put("W29", 10.28);
			put("W30", 10.35);
			put("W31", 10.33);
			put("W32", 10.40);
			put("W33", 10.38);
			put("W34", 10.45);
			put("W35", 10.43);
			put("W36", 10.50);
			put("W37", 10.48);
			put("W38", 10.55);
			put("W39", 10.53);
			put("W40", 10.60);
			put("W41", 10.58);
			put("W42", 10.65);
			put("W43", 10.63);
			put("W44", 10.70);
			put("W45", 10.68);
			put("W46", 10.75);
			put("W47", 10.73);
			put("W48", 10.80);
			put("W49", 10.78);
			put("W50", 10.85);
			put("W51", 10.83);
			put("W52", 10.90);
		}};		
	}
	
	private void initAceite() {
		ACEITE = new HashMap<String, Double>()
		{{
			put("W01", 5.63);
			put("W02", 5.68);
			put("W03", 5.62);
			put("W04", 5.83);
			put("W05", 5.78);
			put("W06", 5.92);
			put("W07", 5.88);
			put("W08", 5.83);
			put("W09", 5.89);
			put("W10", 5.81);
			put("W11", 5.94);
			put("W12", 5.88);
			put("W13", 5.95);
			put("W14", 5.89);
			put("W15", 6.03);
			put("W16", 5.97);
			put("W17", 6.08);
			put("W18", 6.11);
			put("W19", 6.26);
			put("W20", 6.20);
			put("W21", 6.35);
			put("W22", 6.32);
			put("W23", 6.45);
			put("W24", 6.42);
			put("W25", 6.55);
			put("W26", 6.51);
			put("W27", 6.67);
			put("W28", 6.63);
			put("W29", 6.76);
			put("W30", 6.72);
			put("W31", 6.86);
			put("W32", 6.82);
			put("W33", 6.98);
			put("W34", 6.93);
			put("W35", 7.07);
			put("W36", 7.03);
			put("W37", 7.19);
			put("W38", 7.14);
			put("W39", 7.27);
			put("W40", 7.23);
			put("W41", 7.38);
			put("W42", 7.34);
			put("W43", 7.47);
			put("W44", 7.43);
			put("W45", 7.56);
			put("W46", 7.52);
			put("W47", 7.68);
			put("W48", 7.64);
			put("W49", 7.77);
			put("W50", 7.72);
			put("W51", 7.88);
			put("W52", 7.83);
		}};
	}
	
	private void initTrigo() {
		TRIGO = new HashMap<String, Double>()
		{{
			put("W01", 0.37);
			put("W02", 0.41);
			put("W03", 0.44);
			put("W04", 0.39);
			put("W05", 0.42);
			put("W06", 0.38);
			put("W07", 0.41);
			put("W08", 0.44);
			put("W09", 0.47);
			put("W10", 0.45);
			put("W11", 0.48);
			put("W12", 0.52);
			put("W13", 0.50);
			put("W14", 0.55);
			put("W15", 0.51);
			put("W16", 0.54);
			put("W17", 0.51);
			put("W18", 0.53);
			put("W19", 0.57);
			put("W20", 0.54);
			put("W21", 0.56);
			put("W22", 0.59);
			put("W23", 0.62);
			put("W24", 0.60);
			put("W25", 0.64);
			put("W26", 0.61);
			put("W27", 0.64);
			put("W28", 0.68);
			put("W29", 0.65);
			put("W30", 0.69);
			put("W31", 0.66);
			put("W32", 0.69);
			put("W33", 0.73);
			put("W34", 0.70);
			put("W35", 0.73);
			put("W36", 0.76);
			put("W37", 0.74);
			put("W38", 0.77);
			put("W39", 0.80);
			put("W40", 0.78);
			put("W41", 0.81);
			put("W42", 0.78);
			put("W43", 0.81);
			put("W44", 0.84);
			put("W45", 0.82);
			put("W46", 0.85);
			put("W47", 0.88);
			put("W48", 0.86);
			put("W49", 0.89);
			put("W50", 0.92);
			put("W51", 0.90);
			put("W52", 0.93);
		}};
	}

	private void initUva() {
		UVA = new HashMap<String, Double>()
		{{
			put("W01", 0.33);
			put("W02", 0.37);
			put("W03", 0.36);
			put("W04", 0.39);
			put("W05", 0.43);
			put("W06", 0.41);
			put("W07", 0.44);
			put("W08", 0.46);
			put("W09", 0.45);
			put("W10", 0.48);
			put("W11", 0.47);
			put("W12", 0.50);
			put("W13", 0.52);
			put("W14", 0.51);
			put("W15", 0.54);
			put("W16", 0.56);
			put("W17", 0.55);
			put("W18", 0.58);
			put("W19", 0.56);
			put("W20", 0.59);
			put("W21", 0.61);
			put("W22", 0.60);
			put("W23", 0.63);
			put("W24", 0.62);
			put("W25", 0.65);
			put("W26", 0.63);
			put("W27", 0.66);
			put("W28", 0.68);
			put("W29", 0.67);
			put("W30", 0.70);
			put("W31", 0.68);
			put("W32", 0.71);
			put("W33", 0.66);
			put("W34", 0.64);
			put("W35", 0.61);
			put("W36", 0.59);
			put("W37", 0.56);
			put("W38", 0.54);
			put("W39", 0.52);
			put("W40", 0.50);
			put("W41", 0.48);
			put("W42", 0.46);
			put("W43", 0.47);
			put("W44", 0.47);
			put("W45", 0.48);
			put("W46", 0.47);
			put("W47", 0.48);
			put("W48", 0.47);
			put("W49", 0.48);
			put("W50", 0.47);
			put("W51", 0.48);
			put("W52", 0.47);
		}};
		
	}

	private void initTomate() {
		TOMATE = new HashMap<String, Double>()
		{{
			put("W01", 0.86);
			put("W02", 0.83);
			put("W03", 0.80);
			put("W04", 0.77);
			put("W05", 0.80);
			put("W06", 0.76);
			put("W07", 0.79);
			put("W08", 0.77);
			put("W09", 0.74);
			put("W10", 0.71);
			put("W11", 0.74);
			put("W12", 0.72);
			put("W13", 0.75);
			put("W14", 0.77);
			put("W15", 0.79);
			put("W16", 0.76);
			put("W17", 0.74);
			put("W18", 0.72);
			put("W19", 0.74);
			put("W20", 0.77);
			put("W21", 0.79);
			put("W22", 0.82);
			put("W23", 0.80);
			put("W24", 0.78);
			put("W25", 0.80);
			put("W26", 0.83);
			put("W27", 0.85);
			put("W28", 0.87);
			put("W29", 0.85);
			put("W30", 0.87);
			put("W31", 0.90);
			put("W32", 0.88);
			put("W33", 0.85);
			put("W34", 0.83);
			put("W35", 0.86);
			put("W36", 0.88);
			put("W37", 0.90);
			put("W38", 0.92);
			put("W39", 0.94);
			put("W40", 0.96);
			put("W41", 0.94);
			put("W42", 0.96);
			put("W43", 0.93);
			put("W44", 0.95);
			put("W45", 0.97);
			put("W46", 0.99);
			put("W47", 1.01);
			put("W48", 0.99);
			put("W49", 1.02);
			put("W50", 1.05);
			put("W51", 1.03);
			put("W52", 1.06);			
		}};
		
	}
	
	private void initPimiento() {
		PIMIENTO = new HashMap<String, Double>()
		{{
			put("W01", 1.06);
			put("W02", 1.08);
			put("W03", 1.07);
			put("W04", 1.09);
			put("W05", 1.05);
			put("W06", 1.04);
			put("W07", 1.02);
			put("W08", 1.00);
			put("W09", 0.98);
			put("W10", 1.00);
			put("W11", 1.02);
			put("W12", 1.05);
			put("W13", 1.08);
			put("W14", 1.10);
			put("W15", 1.12);
			put("W16", 1.15);
			put("W17", 1.18);
			put("W18", 1.15);
			put("W19", 1.17);
			put("W20", 1.19);
			put("W21", 1.22);
			put("W22", 1.20);
			put("W23", 1.24);
			put("W24", 1.28);
			put("W25", 1.32);
			put("W26", 1.36);
			put("W27", 1.40);
			put("W28", 1.44);
			put("W29", 1.48);
			put("W30", 1.52);
			put("W31", 1.56);
			put("W32", 1.60);
			put("W33", 1.64);
			put("W34", 1.68);
			put("W35", 1.72);
			put("W36", 1.76);
			put("W37", 1.78);
			put("W38", 1.80);
			put("W39", 1.82);
			put("W40", 1.84);
			put("W41", 1.86);
			put("W42", 1.88);
			put("W43", 1.89);
			put("W44", 1.90);
			put("W45", 1.91);
			put("W46", 1.92);
			put("W47", 1.93);
			put("W48", 1.94);
			put("W49", 1.95);
			put("W50", 1.96);
			put("W51", 1.97);
			put("W52", 1.98);
		}};		
	}

	public HashMap<String, Double> get(String productID) {
		switch(productID) {
			case "ALMENDRA": return ALMENDRA;
			case "ACEITE": return ACEITE;
			case "TRIGO": return TRIGO;
			case "UVA": return UVA;
			case "TOMATE": return TOMATE;
			case "PIMIENTO": return PIMIENTO;
			default: return null;
		}
	}
	
	
}
