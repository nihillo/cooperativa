package controller;

import model.product.Product;
import model.product.ProductCollection;

/**
 * Controlador de Productos. Punto de entrada a 
 * los casos de uso relacionados con los Productos
 * 
 * @author Juan Barranco 
 * @version 0.1
 */
public class ProductController extends Controller {
	
	private ProductCollection productCollection;
	
	/**
	 * Constructor de la clase ProductController
	 */
	public ProductController() {
		this.productCollection = ProductCollection.getInstance();
	}
	
	/**
	 * Devuelve lista de productos registrados, como array de Strings
	 * @return productIDs - String[]
	 */
	public String[] getRegisteredProductList() {
		String[] productIDs = productCollection.getAllProductIDs();
		return productIDs; 				
	}

	public Product getProduct(String productID) {
		return productCollection.get(productID);
	}
}
