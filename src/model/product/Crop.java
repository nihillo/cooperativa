package model.product;

public class Crop {
	
	private String id;
	private String producerID;
	private Product product;
	private Float extension;
	private int production;
	private double benefit;
	private double qtySold;
	
	
	/**
	 * Clase Crop (Cultivo)
	 * Conecta semántica y funcionalmente el productor con los
	 * productos que produce, representando la extensión dedicada 
	 * a la producción de cada producto.
	 * 
	 * @author Juan Barranco 
	 * @version 0.1
	 */
	public Crop(String producerID, String productID, Float extension) {
		this.id = producerID + productID;
		
		ProductCollection productCollection = ProductCollection.getInstance();
		this.product = productCollection.getProduct(productID);
		this.producerID = producerID;
		this.extension = extension;
		this.production = (int) (this.extension * this.product.getPerformance());
		this.benefit = 0;
		this.qtySold = 0;
		
		this.product.registerCrop(this);
	}
	
	/**
	 * Devuelve el id del productor
	 * @return
	 */
	public String getProducerID() {
		return producerID;
	}

	/**
	 * Devuelve el id del cultivo
	 * @return String id
	 */
	public String getID() {
		return id;
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
	 * Devuelve la producción en kg anual del cultivo
	 * @return int kg
	 */
	public int getProduction() {
		return production;
	}
	
	/**
	 * Devuelve la representación en String
	 * del objeto
	 */
	@Override
	public String toString() {
		return this.product.getId() + ": " + this.extension.toString();
	}

	public void addBenefit(double benefit) {
		this.benefit += benefit;
	}
	
	public double getBenefit() {
		return benefit;
	}

	public void addQtySold(double qtySold) {
		this.qtySold += qtySold;
	}

	public double getQtySold() {
		return this.qtySold;
	}
}
