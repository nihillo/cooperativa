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
	
	/**
	 * Constructor
	 * @param crop
	 */
	public CropShareItem(Crop crop) {
		this.crop = crop;
		this.shareCoefficient = 0;
	}

	/**
	 * Devuelve el coeficiente de participación del cultivo en la
	 * producción total del producto
	 * @return
	 */
	public double getShareCoefficient() {
		return shareCoefficient;
	}

	/**
	 * Establece el coeficiente de participación del cultivo en la
	 * producción total del producto
	 * @param shareCoefficient
	 */
	public void setShareCoefficient(double shareCoefficient) {
		this.shareCoefficient = shareCoefficient;
	}

	/**
	 * Devuelve el cultivo
	 * @return
	 */
	public Crop getCrop() {
		return crop;
	}
	
}
