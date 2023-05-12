package model.producer;

import java.util.ArrayList;

import model.product.Crop;

/**
 * Clase SmallProducer  (Pequeño Productor)
 * 
 * @author Juan Barranco 
 * @version 0.1
 */
public class SmallProducer extends Producer {
	
	/**
	 * Constructor de la clase SmallProducer
	 * @param id String - ID del productor
	 * @param name String - Nombre del productor
	 * @param crops ArrayList<Crop> - Lista de cultivos
	 */
	public SmallProducer(String id, String name, ArrayList<Crop> crops) {
		super(id, name, crops);
	}
	
}
