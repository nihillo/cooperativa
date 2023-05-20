package model.order;

import model.product.Product;

/**
 * Clase linea de producto
 */
public class ProductLine {

	Product product;
	int qty;
	double unitPrice;
	double basePrice;
	double totalPrice;
	
	/**
	 * Constructor
	 * @param product
	 * @param qty
	 * @param unitPrice
	 * @param basePrice
	 * @param totalPrice
	 */
	public ProductLine(Product product, int qty, double unitPrice, double basePrice, double totalPrice) {
		this.product = product;
		this.qty = qty;
		this.unitPrice = unitPrice;
		this.basePrice = basePrice;
		this.totalPrice = totalPrice;
	}

	/**
	 * Devuelve si el producto contenido es perecedero
	 * @return boolean
	 */
	public boolean isPerishable() {
		return product.isPerishable();
	}
	
	/**
	 * Devuelve la cantidad de producto
	 */
	public int getQty() {
		return this.qty;
	}
	
	/**
	 * Devuelve el precio unitario
	 * @return
	 */
	public double getUnitPrice() {
		return this.unitPrice;
	}
	
	/**
	 * Devuelve el precio base (precio referencia * cantidad)
	 * @return
	 */
	public double getBasePrice() {
		return this.basePrice;
	}
	
	/**
	 * Devuelve el precio total (precio base + beneficio cooperativa)
	 * @return
	 */
	public double getTotalPrice() {
		return this.totalPrice;
	}

	/**
	 * Devuelve el ID de producto
	 * @return
	 */
	public String getProductID() {
		return product.getId();
	}

	/**
	 * Devuelve el producto
	 * @return
	 */
	public Product getProduct() {
		return product;
	}
}
