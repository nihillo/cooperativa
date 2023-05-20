package model.order;

import java.util.ArrayList;

/**
 * Linea de envío
 */
public class ShippingLine {
	
	private ShipmentType shipmentType;
	private String shipmentTypeLabel;
	private int distance;
	private Shipment shipment;
	private ArrayList<Shipment> shipmentQuotes;
	
	/**
	 * Constructor
	 * @param shipmentType
	 * @param distance
	 */
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

	/**
	 * Obtener el tipo de envío
	 * @return
	 */
	public ShipmentType getShipmentType() {
		return shipmentType;
	}
	
	/**
	 * Devuelve la etiqueta del tipo de envío
	 * @return
	 */
	public String getShipmentTypeLabel() {
		return this.shipmentTypeLabel;
	}

	/**
	 * Devuelve la distancia
	 * @return
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * Añade oferta de envío a la linea
	 * @param shipmentQuote
	 */
	public void addShipmentQuote(Shipment shipmentQuote) {
		shipmentQuotes.add(shipmentQuote);		
	}

	/**
	 * Devuelve las ofertas de envío para la linea
	 * @return
	 */
	public ArrayList<Shipment> getShipmentQuotes() {
		return this.shipmentQuotes;
	}

	/**
	 * Establece el envío
	 * @param shipment
	 */
	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	/**
	 * Devuelve el envío
	 * @return
	 */
	public Shipment getShipment() {
		return this.shipment;
	}

	/**
	 * Devuelve oferta de envío por ID
	 * @param selectionID
	 * @return
	 */
	public Shipment getShipmentQuote(String selectionID) {
		for (Shipment quote : shipmentQuotes) {
			if (quote.getLogisticID().equals(selectionID)) {
				return quote;
			}
		}
		return null;
	}
}
