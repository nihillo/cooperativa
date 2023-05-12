package controller;

import java.util.ArrayList;

import model.producer.Producer;
import model.producer.ProducerCollection;
import model.producer.ProducerFactory;

/**
 * Controlador de Productores. Punto de entrada a 
 * los casos de uso relacionados con los Productores
 * 
 * @author Juan Barranco 
 * @version 0.1
 */
public class ProducerController extends Controller {
	
	/**
	 * Registra un productor en el sistema
	 * @param id String - ID del productor 
	 * @param name String - Nombre del productor
	 * @param cropStrArr ArrayList<String> - Lista de cultivos serializados en String en formato CULTIVO,Ha (ej. ALMENDRA,2.3 )
	 */
	public void registerProducer(String id, String name, ArrayList<String> cropStrArr) {
		ProducerCollection producerCollection = ProducerCollection.getInstance();
		
		if (producerCollection.contains(id)) throw new Error("El ID de Productor proporcionado ya está registrado");
		
		ProducerFactory producerFactory = new ProducerFactory();
		Producer producer = producerFactory.getProducer(id, name, cropStrArr);
		producerCollection.add(producer);
	}
}
