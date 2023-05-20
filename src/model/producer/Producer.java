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
public abstract class Producer implements CollectionItem {
	
	protected enum ProducerType { BIG_PRODUCER, SMALL_PRODUCER, FEDERATE_PRODUCER }
	
	protected String id;
	protected String name;
	protected ArrayList<Crop> crops;
	protected ProducerType type;
	protected String typeLabel;
	
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
	
	public String getInfoLine() {
		String cropsStr = "";

		for (int i = 0; i < crops.size(); i++ ) {
			Crop crop = crops.get(i);
			cropsStr += crop.toString();
			if (i < crops.size() - 1) {
				cropsStr += ", ";
			}
		}
		
		String infoLine = this.id + "   --  " + this.getTypeLabel() + "  --   " + this.name + "   --   " + cropsStr;
		return infoLine;
	}

	/**
	 * Devuelve el flag de tipo de productor: 
	 * B: gran productor, S: pequeño productor
	 * F: productor federado
	 * @return
	 */
	public String getTypeLabel() {
		return this.typeLabel;
	}
	
	/**
	 * Devuelve el tipo de productor
	 * @return
	 */
	public String getType() {
		return this.typeLabel;
	}

	/**
	 * Devuelve el nombre
	 * @return
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Devuelve los cultivos del productor
	 * @return
	 */
	public ArrayList<Crop> getCrops() {
		return this.crops;
	}
}
