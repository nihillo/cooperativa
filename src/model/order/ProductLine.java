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

}
