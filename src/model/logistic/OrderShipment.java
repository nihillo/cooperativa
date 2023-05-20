package model.logistic;

import model.order.Shipment;

public class OrderShipment {
	String orderID;
	Shipment shipment;
	
	public OrderShipment(String orderID, Shipment shipment) {
		this.orderID = orderID;
		this.shipment = shipment;
	}
	
	
}
