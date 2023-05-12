package model.producer;

import java.util.ArrayList;

import model.product.Crop;

/**
 * Clase FederateProducer  (ProductorFederado)
 * 
 * @author Juan Barranco 
 * @version 0.1
 */
public class FederateProducer extends Producer {
	
	/**
	 * Constructor de la clase FederateProducer
	 * @param id String - ID del productor
	 * @param name String - Nombre del productor
	 * @param crops ArrayList<Crop> - Lista de cultivos
	 */
	public FederateProducer(String id, String name, ArrayList<Crop> crops) {
		super(id, name, crops);
	}

}
