package model.order;

import java.util.Date;

import model.CollectionItem;
import model.customer.Customer;
import model.product.Product;

public class Order implements CollectionItem {
	
	private enum Status {CREATED, PLACED}
	
	private String orderID;
	private Status status;
	private Date placementDate;
	private Date deliveryDate;

	public Order(String orderID, Customer customer, Date deliveryDate, Product product, int qty) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
}
