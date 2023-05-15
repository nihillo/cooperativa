package model.order;

public class ShippingLine {
	
	public enum ShipmentType {BIG_LOGISTIC, SMALL_LOGISTIC}
	
	private ShipmentType shipmentType;
	private int distance;
	private Shipment shipment;
	
	public ShippingLine(ShipmentType shipmentType, int distance) {
		this.shipmentType = shipmentType;
		this.distance = distance;
	}
}
