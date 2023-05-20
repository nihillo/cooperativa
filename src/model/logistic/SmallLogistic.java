package model.logistic;

import model.order.Order;
import model.order.Shipment;
import model.order.ShipmentType;
import model.order.ShippingLine;

/**
 * Clase SmallLogistic (empresa de pequeña logística)
 * Hereda de Logistic
 * 
 * @author Juan Barranco
 *
 */
public class SmallLogistic extends Logistic {
	
	/**
	 * Constructor
	 * @param id
	 * @param name
	 */
	public SmallLogistic(String id, String name) {
		super(id, name);
		this.type = ShipmentType.SMALL_LOGISTIC;
		this.typeLabel = "Peq. L";
	}

	@Override
	public Shipment getShipmentQuote(Order order) {
		ShippingLine shippingLine = order.getShippingLines()[1];
		
		double variation = calculateVariationRate();
		double price = 1.5 * pricePerDistance(order, shippingLine) * variation;
		
		Shipment quote = new Shipment(this, price);
		return quote;
	}
}