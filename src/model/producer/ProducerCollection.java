package model.producer;

import model.Collection;

/**
 * Clase ProducerCollection  (Colección de Productores)
 * 
 * Wrapper de Collection (utiliza por composición la clase Collection,
 * como objeto interno en donde almacena los CollectionItems). Sobre esta, 
 * implementa los métodos propios específicos derivados de la naturaleza
 * de los objetos Producer, que no comparten interfaz con otras colecciones
 * 
 * Sigue patrón Singleton, de modo que exista una única instancia
 * accesible desde múltiples clientes sin que necesiten mantener trazabilidad
 * de esta
 * 
 * @author Juan Barranco 
 * @version 0.1
 */
public class ProducerCollection {
	private static ProducerCollection instance;
	private Collection<Producer> collection;
	
	private ProducerCollection() {
		collection = new Collection<Producer>();
		// TODO inicializar productores federados
	}
	
	/**
	 * Método estático que devuelve la instancia
	 * singleton de la clase
	 * @return ProducerCollection
	 */
	public static ProducerCollection getInstance() {
		if (instance == null) {
			instance = new ProducerCollection();
		}
		
		return instance;
	}
	
	/**
	 * Añade un productor a la colección
	 * @param producer
	 */
	public void add(Producer producer) {
		collection.add(producer);
	}

	/**
	 * Verifica si la colección contiene un productor
	 * a partir de su ID
	 * @param id
	 * @return boolean
	 */
	public boolean contains(String id) {
		return collection.contains(id);
	}
}
