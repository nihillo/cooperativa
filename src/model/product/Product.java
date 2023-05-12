package model.product;

import java.util.HashMap;

import model.CollectionItem;
import sampledata.ProductType;

/**
 * Clase Product (Producto)
 * Implementa CollectionItem
 * 
 * @author Juan Barranco 
 * @version 0.1
 */
public class Product implements CollectionItem {
	String id;
	boolean perishable;
	double performance;
	HashMap<String, Double> refPrices;
		
	/**
	 * Constructor
	 * @param type - Producto tipo, desde sampledata
	 * @param refPrices - precios de referencia, desde sampledata
	 */
	Product(ProductType type, HashMap<String, Double> refPrices) {
		this.id = type.name();
		this.perishable = type.isPerishable();
		this.performance = type.getPerformance();
		this.refPrices = refPrices;
	}

	/**
	 * Devuelve ID del producto
	 */
	@Override
	public String getId() {
		return id;
	}
	
	/**
	 * Verifica si el producto es perecedero
	 * @return boolean
	 */
	public boolean isPerishable() {
		return perishable;
	}
	
	/**
	 * Devuelve el rendimiento por Ha. del producto
	 * @return double - toneladas producidas por Ha. de cultivo del producto
	 */
	public double getPerformance() {
		return performance;
	}
}
