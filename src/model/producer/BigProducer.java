package model.producer;

import java.util.ArrayList;

import model.product.Crop;

/**
 * Clase BigProducer  (Gran Productor)
 * 
 * @author Juan Barranco 
 * @version 0.1
 */
public class BigProducer extends Producer {
	
	/**
	 * Constructor de la clase BigProducer
	 * @param id String - ID del productor
	 * @param name String - Nombre del productor
	 * @param crops ArrayList<Crop> - Lista de cultivos
	 */
	public BigProducer(String id, String name, ArrayList<Crop> crops) {
		super(id, name, crops);
	}

	@Override
	protected String getType() {
		return "B";
	}

}
