package model.customer;

import java.util.ArrayList;

import model.CollectionItem;
import model.order.Order;

/**
 * Clase Customer (Cliente)
 * @author Juan Barranco
 *
 */
public abstract class Customer implements CollectionItem {
	
	protected enum CustomerType { STOCKIST, ENDCUSTOMER }
	
	private String id;
	private String name;
	private Address address;
	protected CustomerType type;
	protected String typeLabel;
	protected double taxRate;
	private ArrayList<Order> orderHistory;
	
	/**
	 * Constructor
	 * @param id
	 * @param name
	 * @param addressObj
	 */
	public Customer(String id, String name, Address addressObj) {
		this.id = id;
		this.name = name;
		this.address = addressObj;
		this.orderHistory = new ArrayList<Order>();
	}

	@Override
	public String getId() {
		return this.id;
	}
	
	/**
	 * Devuelve el tipo de cliente
	 * @return
	 */
	public CustomerType getType() {
		return this.type;
	}
	
	/**
	 * Devuelve la etiqueta del tipo de cliente
	 * @return
	 */
	public String getTypeLabel() {
		return this.typeLabel;
	}

	/**
	 * Devuelve la linea de información del cliente
	 * @return String infoLine
	 */
	public String getInfoLine() {
		String infoLine = this.id + "   --  " + this.getTypeLabel() + "  --   " + this.name + "   --   "  + this.address.getCityProvince();
		return infoLine;
	}
	
	/**
	 * Devuelve el porcentaje de beneficios para la cooperativa
	 * de las ventas a este cliente
	 * @return
	 */
	public abstract double getCoopBenefit();

	/**
	 * Devuelve rango de cantidades de venta permitidas para el cliente
	 * @return
	 */
	public abstract int[] getAllowedQtyRange();

	/**
	 * Devuelve la dirección del cliente
	 * @return
	 */
	public Address getAddress() {
		return this.address;
	}

	/**
	 * Devuelve el tipo de IVA aplicable al cliente
	 * @return
	 */
	public double getTaxRate() {
		return this.taxRate;
	}

	/**
	 * Añade pedido al historial del cliente
	 */
	public void addOrderToHistory(Order order) {
		orderHistory.add(order);		
	}
}
