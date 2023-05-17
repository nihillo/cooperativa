package model.order;

import java.util.ArrayList;

public class ShippingLine {
	
	private ShipmentType shipmentType;
	private String shipmentTypeLabel;
	private int distance;
	private Shipment shipment;
	private ArrayList<Shipment> shipmentQuotes;
	
	public ShippingLine(ShipmentType shipmentType, int distance) {
		this.shipmentType = shipmentType;
		
		switch(shipmentType) {
			case BIG_LOGISTIC:
				this.shipmentTypeLabel = "Gran Logística";
				break;
			case SMALL_LOGISTIC:
				this.shipmentTypeLabel = "Pequeña Logística";
				break;
		}
		
		this.distance = distance;
		this.shipmentQuotes = new ArrayList<Shipment>();
	}

	public ShipmentType getShipmentType() {
		return shipmentType;
	}
	
	public String getShipmentTypeLabel() {
		return this.shipmentTypeLabel;
	}

	public int getDistance() {
		return distance;
	}

	public void addShipmentQuote(Shipment shipmentQuote) {
		shipmentQuotes.add(shipmentQuote);		
	}

	public ArrayList<Shipment> getShipmentQuotes() {
		return this.shipmentQuotes;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	public Shipment getShipment() {
		return this.shipment;
	}

	public Shipment getShipmentQuote(String selectionID) {
		for (Shipment quote : shipmentQuotes) {
			if (quote.getLogisticID().equals(selectionID)) {
				return quote;
			}
		}
		return null;
	}
}
