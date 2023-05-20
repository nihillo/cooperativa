package model.logistic;

import model.order.Shipment;

public class OrderShipment {
	String orderID;
	Shipment shipment;
	
	/**
	 * Constructor
	 * @param orderID
	 * @param shipment
	 */
	public OrderShipment(String orderID, Shipment shipment) {
		this.orderID = orderID;
		this.shipment = shipment;
	}

	/**
	 * Devuelve el Shipment contenido
	 * @return
	 */
	public Shipment getShipment() {
		return shipment;
	}
	
	
}
