package model.order;

import model.logistic.Logistic;

/**
 * Clase envío
 */
public class Shipment {
	
	private Logistic logistic;
	private double price;
	
	/**
	 * Constructor
	 * @param logistic
	 * @param price
	 */
	public Shipment(Logistic logistic, double price) {
		this.logistic = logistic;
		this.price = price;
	} 
	
	/**
	 * Devuelve la linea imprimible con la información
	 * @return
	 */
	public String getInfoLine() {
		return logistic.getId() + "    --    " + logistic.getName() + "    --    " + price;
	}
	
	/**
	 * Devuelve la logística
	 * @return
	 */
	public Logistic getLogistic() {
		return logistic;
	}
	
	/**
	 * Devuelve el ID de logística
	 * @return
	 */
	public Object getLogisticID() {
		return logistic.getId();
	}
	
	/**
	 * Devuelve el precio
	 * @return
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * Devuelve la linea de información para el resumen de confirmación de pedido
	 * @return
	 */
	public String getSummaryInfoLine() {
		return logistic.getId() + "-" + logistic.getName() + "    --    " + price;		
	}
}
