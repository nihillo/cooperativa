package model.producer;

import java.util.ArrayList;

import model.CollectionItem;
import model.product.Crop;

/**
 * Clase Producer (Productor)
 * Implementa la interfaz CollectionItem
 * Todos los subtipos de Productor heredan de ella
 * 
 * @author Juan Barranco 
 * @version 0.1
 */
public class Producer implements CollectionItem {
	protected String id;
	protected String name;
	protected ArrayList<Crop> crops;
	
	/**
	 * Constructor de la clase Producer
	 * @param id String - ID del productor
	 * @param name String - Nombre del productor
	 * @param crops ArrayList<Crop> - Lista de cultivos
	 */
	public Producer(String id, String name, ArrayList<Crop> crops) {
		this.id = id;
		this.name = name;
		this.crops = crops;
	}
	
	/**
	 * Devuelve el id del Productor
	 */
	public String getId() {
		return id;
	}
}
