package model.order;

import java.util.ArrayList;
import java.util.Date;

import model.CollectionItem;
import model.customer.Customer;
import model.logistic.Logistic;
import model.product.Product;
import utils.DistanceUtils;

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

	public ShippingLine[] getShippingLines() {
		return shippingLines;
	}

	public ProductLine getProductLine() {
		return productLine;
	}

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

	public double getBasePrice() {
		return this.basePrice;
	}

	public double getTaxRate() {
		return this.taxRate;
	}
	
	public double getTax() {
		return this.tax;
	}

	public double getTotalPrice() {
		return this.totalPrice;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
