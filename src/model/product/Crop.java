package model.product;

public class Crop {
	
	private Product product;
	private Float extension;
	
	
	/**
	 * Clase Crop (Cultivo)
	 * Conecta semántica y funcionalmente el productor con los
	 * productos que produce, representando la extensión dedicada 
	 * a la producción de cada producto.
	 * 
	 * @author Juan Barranco 
	 * @version 0.1
	 */
	public Crop(String productID, Float extension) {
		ProductCollection productCollection = ProductCollection.getInstance();
		this.product = productCollection.getProduct(productID);
		this.extension  = extension;
	}
	
	/**
	 * Devuelve la extensión del cultivo
	 * @return float - extensión
	 */
	public float getExtension() {
		return extension;
	}
	
	/**
	 * Devuelve el producto explotado en el cultivo
	 * @return Product
	 */
	public Product getProduct() {
		return product;
	}
	
	/**
	 * Devuelve la representación en String
	 * del objeto
	 */
	@Override
	public String toString() {
		return this.product.getId() + ": " + this.extension.toString();
	}
}
