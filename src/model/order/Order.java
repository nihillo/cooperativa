package model.order;

import java.util.Date;

import model.CollectionItem;
import model.customer.Customer;
import model.product.Product;
import utils.DistanceUtils;

public class Order implements CollectionItem {
	
	private enum Status {CREATED, CONFIRMED}
	
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

	public Order(String orderID, Customer customer, Date placementDate, Date deliveryDate, Product product, int qty) {
		this.orderID = orderID;
		this.status = Status.CREATED;
		this.placementDate = placementDate;
		this.deliveryDate = deliveryDate;
		this.customer = customer;
		
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
			shippingLines[0] = new ShippingLine(ShippingLine.ShipmentType.BIG_LOGISTIC, bigLogisticDistance);
		}
		
		if (smallLogisticDistance > 0) {
			shippingLines[1] = new ShippingLine(ShippingLine.ShipmentType.SMALL_LOGISTIC, smallLogisticDistance);
		}
	}

	@Override
	public String getId() {
		return orderID;
	}
}
