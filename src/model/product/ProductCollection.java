package model.product;

import java.util.ArrayList;
import java.util.HashMap;

import model.Collection;
import sampledata.ProductType;
import sampledata.ProductPrices;

/**
 * Clase ProductCollection  (Colección de Productos)
 * 
 * Wrapper de Collection (utiliza por composición la clase Collection,
 * como objeto interno en donde almacena los CollectionItems). Sobre esta, 
 * implementa los métodos propios específicos derivados de la naturaleza
 * de los objetos Product, que no comparten interfaz con otras colecciones
 * 
 * Sigue patrón Singleton, de modo que exista una única instancia
 * accesible desde múltiples clientes sin que necesiten mantener trazabilidad
 * de esta
 * 
 * @author Juan Barranco 
 * @version 0.1
 */
public class ProductCollection {
	
	private static ProductCollection instance;
	private Collection<Product> collection;
	
	
	private ProductCollection() {
		collection = new Collection<Product>();
		
		for (ProductType productType : ProductType.values()) {
			String productID = productType.name();
			ProductPrices productPriceCatalog = new ProductPrices();
			HashMap<String, Double> refPrices = productPriceCatalog.get(productID);
			
			Product product = new Product(productType, refPrices);
			collection.add(product);
		}
	}
	
	/**
	 * Método estático que devuelve la instancia
	 * singleton de la clase
	 * @return ProducerCollection
	 */
	public static ProductCollection getInstance() {
		if (instance == null) {
			instance = new ProductCollection();
		}
		
		return instance;
	}

	/**
	 * Obtiene un producto por su ID
	 * @param productID
	 * @return Product
	 */
	public Product getProduct(String productID) {
		Product product = collection.get(productID);
		
		if (product == null) throw new Error("El producto con ID " + productID + " no existe");
		
		return product;
	}
	
	/**
	 * Obtiene un array con los IDs de todos los productos registrados
	 * @return String[]
	 */
	public String[] getAllProductIDs() {
		String[] ids = collection.getIDs();
		return ids;
	}

	public Product get(String id) {
		return collection.get(id);
	}

	public ArrayList<Product> getAll() {
		return collection.getAll();
	}
}
