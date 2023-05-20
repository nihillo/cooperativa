package controller;

import java.util.ArrayList;

import model.producer.Producer;
import model.producer.ProducerCollection;
import model.producer.ProducerFactory;
import sampledata.SampleProducer;


/**
 * Controlador de Productores. Punto de entrada a 
 * los casos de uso relacionados con los Productores
 * 
 * @author Juan Barranco 
 * @version 0.1
 */
public class ProducerController extends Controller {
	
	private ProducerCollection producerCollection;
	
	/**
	 * Constructor
	 */
	public ProducerController() {
		producerCollection = ProducerCollection.getInstance();
	}
	
	/**
	 * Registra un productor en el sistema
	 * @param id String - ID del productor 
	 * @param name String - Nombre del productor
	 * @param cropStrArr ArrayList<String> - Lista de cultivos serializados en String en formato CULTIVO,Ha (ej. ALMENDRA,2.3 )
	 */
	public void registerProducer(String id, String name, ArrayList<String> cropStrArr) {
				
		if (producerCollection.contains(id)) throw new Error("El ID de Productor proporcionado ya está registrado");
		
		ProducerFactory producerFactory = new ProducerFactory();
		Producer producer = producerFactory.getProducer(id, name, cropStrArr);
		producerCollection.add(producer);
	}
	
	/**
	 * Devuelve todos los productores
	 * @return ArrayList<Producer> productores
	 */
	public ArrayList<Producer> getAllProducers() {
		return producerCollection.getAll();
	}
	
	/**
	 * Carga los datos de prueba de productores
	 */
	public void loadSampleProducers() {
		for (SampleProducer sampleProducer : SampleProducer.values()) {
			registerProducer(sampleProducer.getID(), sampleProducer.getName(), sampleProducer.getCropStrArr());
		}
	}
}
