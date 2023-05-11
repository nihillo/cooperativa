package model.producer;

import java.util.ArrayList;

/**
 * Factoria de instanciacion de productores, dependiendo de la extension
 * de cultivos y el umbral definido para el año fiscal
 * 
 * @author Juan Barranco 
 * @version 0.1
 */
public class ProducerFactory
{	
	private static final float BIG_PRODUCER_THRESHOLD = 5; 
	
    /**
     * Constructor
     */
    public ProducerFactory()
    {
    }

    /**
     * Metodo estatico para la generacion de productores
     * Devuelve SmallProducer si la extension con que se llama es inferior
     * al umbral, GreatProducer si es igual o mayor
     * 
     * @param id   id del productor
     * @param name   nombre del productor
     * @param cropStrArr   array de cultivos serializados a String en la forma PRODUCTO,Ha (p. ej. ALMENDRA,3.1 )
     * @return     Producer
     */
    public Producer getProducer(String id, String name, ArrayList<String> cropStrArr) {
    	ArrayList<Crop> crops = buildCrops(cropStrArr);
    	float totalExtension = 0;
    	
    	for (Crop c : crops) {
    		totalExtension += c.getExtension(); 
    	}
    	
    	Producer producer = totalExtension < BIG_PRODUCER_THRESHOLD ? new SmallProducer(id, name, crops) : new BigProducer(id, name, crops);
    	
    	return producer;
    }
    
    private ArrayList<Crop> buildCrops(ArrayList<String> cropStrArr) {
    	ArrayList<Crop> crops = new ArrayList<Crop>();
    	
    	cropStrArr.forEach(cropStr -> {
    		String[] cropStrParts = cropStr.split(",");
    		String productID = cropStrParts[0];
    		float extension = Float.parseFloat(cropStrParts[1]);
    		
    		Crop crop = new Crop(productID, extension);
    		crops.add(crop);    		
    	});
    	
		return crops;
    }
}