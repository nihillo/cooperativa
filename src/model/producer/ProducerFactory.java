package model.producer;

import java.util.ArrayList;

import model.product.Crop;
import sampledata.SystemData;

/**
 * Factoria de instanciacion de productores, dependiendo de la extension
 * de cultivos y el umbral definido para el año fiscal
 * 
 * @author Juan Barranco 
 * @version 0.1
 */
public class ProducerFactory
{	
	private float extensionThreshold;
	private int cropsNoThreshold;
	
    /**
     * Constructor
     */
    public ProducerFactory()
    {
    	extensionThreshold = SystemData.getAnualExtensionThreshold();
    	cropsNoThreshold = SystemData.getCropsNoThreshold();
    }

    /**
     * Metodo estatico para la generacion de productores
     * Devuelve SmallProducer si la extension con que se llama es inferior
     * al umbral, BigProducer si es igual o mayor
     * 
     * @param id   id del productor
     * @param name   nombre del productor
     * @param cropStrArr   array de cultivos serializados a String en la forma PRODUCTO,Ha (p. ej. ALMENDRA,3.1 )
     * @return     Producer
     */
    public Producer getProducer(String id, String name, ArrayList<String> cropStrArr) {
    	ArrayList<Crop> crops = buildCrops(cropStrArr, id);
    	float totalExtension = 0;
    	
    	for (Crop c : crops) {
    		totalExtension += c.getExtension(); 
    	}
    	
    	Producer producer = null; 
    	if (totalExtension < this.extensionThreshold && crops.size() <= this.cropsNoThreshold) {
    		producer = new SmallProducer(id, name, crops);
    	} else {
    		producer = new BigProducer(id, name, crops);
    	}
    	
    	return producer;
    }
    
    private ArrayList<Crop> buildCrops(ArrayList<String> cropStrArr, String producerID) {
    	ArrayList<Crop> crops = new ArrayList<Crop>();
    	
    	cropStrArr.forEach(cropStr -> {
    		String[] cropStrParts = cropStr.split(",");
    		String productID = cropStrParts[0];
    		float extension = Float.parseFloat(cropStrParts[1]);
    		
    		Crop crop = new Crop(producerID, productID, extension);
    		crops.add(crop);    		
    	});
    	
		return crops;
    }
}