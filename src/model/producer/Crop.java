package model.producer;

public class Crop {
	
	private String product;
	private Float extension;

	public Crop(String productID, Float extension) {
		this.product = productID; // TODO convertir productID a Product
		this.extension  = extension;
	}

	public float getExtension() {
		return extension;
	}

}
