package model.logistic;

import model.order.Order;
import model.order.Shipment;
import model.order.ShipmentType;
import model.order.ShippingLine;

/**
 * Clase BigLogistic (empresa de gran logística)
 * Hereda de Logistic
 * 
 * @author Juan Barranco
 *
 */
public class BigLogistic extends Logistic {
	
	/**
	 * Constructor
	 * @param id
	 * @param name
	 */
	public BigLogistic(String id, String name) {
		super(id, name);
		this.type = ShipmentType.BIG_LOGISTIC;
		this.typeLabel = "Gran L";
	}

	@Override
	public Shipment getShipmentQuote(Order order) {
		ShippingLine shippingLine = order.getShippingLines()[0];
		
		double variation = calculateVariationRate();
		double price = ((0.2 * pricePerDistance(order, shippingLine)) + (0.8 * pricePerDistanceWeight(order, shippingLine))) * variation;
		
		Shipment quote = new Shipment(this, price);
		return quote;
	}
}
