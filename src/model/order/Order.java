package model.order;

import java.util.Date;

import model.CollectionItem;
import model.customer.Customer;
import model.product.Product;
import utils.DistanceUtils;

/**
 * Clase pedido
 */
public class Order implements CollectionItem {
	
	public enum Status {CREATED, CONFIRMED}
	
	private String orderID;
	private Status status;
	private Date placementDate;
	private Date deliveryDate;
	private Customer customer;
	private ProductLine productLine;
	
	// Array de dos posiciones fijas, primera para gran logística
	// y segunda para pequeña logística. Si alguno de los dos tipos 
	// no existe, se deja como null
	private ShippingLine[] shippingLines = new ShippingLine[2];
	private double taxRate;
	private double tax;
	private double basePrice;
	private double totalPrice;

	/**
	 * Constructor
	 * @param orderID
	 * @param customer
	 * @param placementDate
	 * @param deliveryDate
	 * @param product
	 * @param qty
	 */
	public Order(String orderID, Customer customer, Date placementDate, Date deliveryDate, Product product, int qty) {
		this.orderID = orderID;
		this.status = Status.CREATED;
		this.placementDate = placementDate;
		this.deliveryDate = deliveryDate;
		this.customer = customer;
		this.taxRate = customer.getTaxRate();
		
		double productUnitPrice = product.getPrice(placementDate);
		double lineBasePrice = productUnitPrice * qty;
		double lineTotalPrice = lineBasePrice * customer.getCoopBenefit();
		this.productLine = new ProductLine(product, qty, productUnitPrice, lineBasePrice, lineTotalPrice);
		
		calculateShippingLines();
	}

	/**
	 * Calcula y genera las líneas de envío necesarias
	 */
	private void calculateShippingLines() {
		String destZipCode = customer.getAddress().getZipCode();
		DistanceUtils distanceUtils = DistanceUtils.getInstance();
		
		int bigLogisticDistance = distanceUtils.getInterprovincialDistance(destZipCode);
		
		int lastMileDistance = distanceUtils.getLastMileDistance(destZipCode);		
		int smallLogisticDistance = 0;
		
		if (lastMileDistance > 5 || bigLogisticDistance == 0) {
			smallLogisticDistance += lastMileDistance;
		} else {
			bigLogisticDistance += lastMileDistance;
		}
		
		if (bigLogisticDistance > 0) {
			shippingLines[0] = new ShippingLine(ShipmentType.BIG_LOGISTIC, bigLogisticDistance);
		}
		
		if (smallLogisticDistance > 0) {
			shippingLines[1] = new ShippingLine(ShipmentType.SMALL_LOGISTIC, smallLogisticDistance);
		}
	}

	@Override
	public String getId() {
		return orderID;
	}

	/**
	 * Devuelve las lineas de envío
	 * @return
	 */
	public ShippingLine[] getShippingLines() {
		return shippingLines;
	}

	/**
	 * Devuelve la linea de producto
	 * @return
	 */
	public ProductLine getProductLine() {
		return productLine;
	}

	/**
	 * Calcula los totales
	 */
	public void calculateAmounts() {
		this.basePrice = this.productLine.getTotalPrice();
		
		for (ShippingLine shippingLine : this.shippingLines) {
			if (shippingLine != null) {
				this.basePrice += shippingLine.getShipment().getPrice();
			}
		}
		
		this.tax = this.basePrice * (taxRate/100);
		this.totalPrice = this.basePrice + this.tax;
	}

	/**
	 * Devuelve el precio base
	 * @return
	 */
	public double getBasePrice() {
		return this.basePrice;
	}


	/**
	 * Devuelve el tipo de IVA
	 */
	public double getTaxRate() {
		return this.taxRate;
	}
	
	/**
	 * Devuelve el IVA
	 * @return
	 */
	public double getTax() {
		return this.tax;
	}

	/**
	 * Devuelve el precio total
	 * @return
	 */
	public double getTotalPrice() {
		return this.totalPrice;
	}

	/**
	 * Devuelve el cliente
	 * @return
	 */
	public Customer getCustomer() {
		return this.customer;
	}

	/**
	 * Establece el estado del pedido
	 * @param status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
}
