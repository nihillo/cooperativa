package model.product;

/**
 * Clase CropShareItem - Guarda un cultivo y su coeficiente
 * de participación en la producción del producto
 * @author Juan Barranco
 *
 */
public class CropShareItem {
	
	private double shareCoefficient;
	private Crop crop;
	
	public CropShareItem(Crop crop) {
		this.crop = crop;
		this.shareCoefficient = 0;
	}

	public double getShareCoefficient() {
		return shareCoefficient;
	}

	public void setShareCoefficient(double shareCoefficient) {
		this.shareCoefficient = shareCoefficient;
	}

	public Crop getCrop() {
		return crop;
	}
	
}
