package model.order;

import model.product.Product;

public class ProductLine {

	Product product;
	int qty;
	double unitPrice;
	double basePrice;
	double totalPrice;
	
	public ProductLine(Product product, int qty, double unitPrice, double basePrice, double totalPrice) {
		this.product = product;
		this.qty = qty;
		this.unitPrice = unitPrice;
		this.basePrice = basePrice;
		this.totalPrice = totalPrice;
	}

	public boolean isPerishable() {
		return product.isPerishable();
	}
	
	public int getQty() {
		return this.qty;
	}
	
	public double getUnitPrice() {
		return this.unitPrice;
	}
	
	public double getBasePrice() {
		return this.basePrice;
	}
	
	public double getTotalPrice() {
		return this.totalPrice;
	}

	public String getProductID() {
		return product.getId();
	}

	public Product getProduct() {
		return product;
	}
}
