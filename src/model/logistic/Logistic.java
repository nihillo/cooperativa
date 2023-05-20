package model.logistic;

import java.util.ArrayList;

import model.CollectionItem;
import model.order.Order;
import model.order.Shipment;
import model.order.ShipmentType;
import model.order.ShippingLine;
import sampledata.ShippingRate;

/**
 * Clase Logistic (empresa de logística)
 * Implementa CollectionItem
 * 
 * @author Juan Barranco
 *
 */
public abstract class Logistic implements CollectionItem {

	private String id;
	private String name;
	protected ShipmentType type;
	protected String typeLabel;
	protected ArrayList<OrderShipment> orderShipmentHistory;
	
	/**
	 * Constructor
	 * @param id
	 * @param name
	 */
	public Logistic(String id, String name) {
		this.id = id;
		this.name = name;
		this.orderShipmentHistory = new ArrayList<OrderShipment>();
	}
	
	/**
	 * Devuelve el id de la empresa de logística
	 */
	@Override
	public String getId() {
		return id;
	}
	
	/**
	 * Devuelve la linea de información de la empresa de logística
	 * @return String infoLine
	 */
	public String getInfoLine() {
		String infoLine = this.id + "   --  " + this.getTypeLabel() + "  --   " + this.name;
		return infoLine;
	}
	
	/**
	 * Devuelve el tipo de logística: 
	 * B: gran logística, S: pequeña logística
	 * @return
	 */
	public ShipmentType getType() {
		return this.type;
	}
	
	/**
	 * Devuelve etiqueta del tipo de logística
	 * @return
	 */
	public String getTypeLabel() {
		return this.typeLabel;
	}
	
	/**
	 * Devuelve el nombre
	 * @return
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Obtener oferta de envío para el pedido
	 * @param order
	 * @return
	 */
	public abstract Shipment getShipmentQuote(Order order);
	
	/**
	 * Devuevle el precio por distancia aplicable
	 * @param order
	 * @param shippingLine
	 * @return
	 */
	protected double pricePerDistance(Order order, ShippingLine shippingLine) {
		boolean isPerishableProduct = order.getProductLine().isPerishable();
		double rate = ShippingRate.getRate(isPerishableProduct, this.type);
		int distance = shippingLine.getDistance();
					
		double price = distance * rate;
		return price;
	}
	
	/**
	 * Devuelve el precio por distancia y peso aplicable
	 * @param order
	 * @param shippingLine
	 * @return
	 */
	protected double pricePerDistanceWeight(Order order, ShippingLine shippingLine) {
		// 0,01 * precio de referencia del producto
		boolean isPerishableProduct = order.getProductLine().isPerishable();
		double coefficient = isPerishableProduct ? 0.0003 : 0.0002;
		double refPrice = order.getProductLine().getBasePrice();
		int distance = shippingLine.getDistance();
		
		double price = coefficient * refPrice * distance;
		return price;
	}
	
	/**
	 * Calcula coeficiente de variación para generación de ofertas de envío
	 * @return
	 */
	protected double calculateVariationRate() {
		double min = 0.85;
		double max = 1.15;
		return (double) ((Math.random() * (max - min)) + min);
	}

	/**
	 * Añade un envío al historial
	 * @param orderID
	 * @param shipment
	 */
	public void addOrderShipment(String orderID, Shipment shipment) {
		OrderShipment orderShipment = new OrderShipment(orderID, shipment);
		orderShipmentHistory.add(orderShipment);
	}

	/**
	 * Devuelve el historial de envíos
	 * @return
	 */
	public ArrayList<OrderShipment> getOrderShipmentHistory() {
		return orderShipmentHistory;
	}

	/**
	 * Devuelve el beneficio total del año fiscal
	 * @return
	 */
	public double getBenefit() {
		double benefit = 0;
		for (OrderShipment orderShipment : orderShipmentHistory) {
			benefit += orderShipment.getShipment().getPrice();
		}
		
		return benefit;
	}
}
