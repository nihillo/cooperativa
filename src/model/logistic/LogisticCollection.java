package model.logistic;

import java.util.ArrayList;
import java.util.Iterator;

import model.Collection;
import model.order.ShipmentType;


/**
 * Clase LogisticCollection  (Colección de empresas de logística)
 * 
 * Wrapper de Collection (utiliza por composición la clase Collection,
 * como objeto interno en donde almacena los CollectionItems). Sobre esta, 
 * implementa los métodos propios específicos derivados de la naturaleza
 * de los objetos Logistic, que no comparten interfaz con otras colecciones
 * 
 * Sigue patrón Singleton, de modo que exista una única instancia
 * accesible desde múltiples clientes sin que necesiten mantener trazabilidad
 * de esta
 * 
 * @author Juan Barranco 
 * @version 0.1
 */
public class LogisticCollection {
	
	private static LogisticCollection instance;
	private Collection<Logistic> collection;
	
	private LogisticCollection() {
		collection = new Collection<Logistic>();
	}
	
	/**
	 * Método estático que devuelve la instancia
	 * singleton de la clase
	 * @return LogisticCollection
	 */
	public static LogisticCollection getInstance() {
		if (instance == null) {
			instance = new LogisticCollection();
		}
		
		return instance;
	}

	/**
	 * Verifica si la colección contiene una empresa
	 * de logística a partir de su ID
	 * @param id
	 * @return boolean
	 */
	public boolean contains(String id) {
		return collection.contains(id);
	}

	/**
	 * Añade un productor a la colección
	 * @param logistic
	 */
	public void add(Logistic logistic) {
		collection.add(logistic);
	}
	
	/**
	 * Obtiene la lista de todas las empresas
	 * de logística
	 * @return ArrayList<Logistic>
	 */
	public ArrayList<Logistic> getAll() {
		return collection.getAll();
	}

	/**
	 * Devuelve todas las logísticas de un determinado tipo
	 * @param type
	 * @return
	 */
	public ArrayList<Logistic> getAllByType(ShipmentType type) {
		ArrayList<Logistic> allLogistics = collection.getAll();
		ArrayList<Logistic> filteredLogistics = new ArrayList<Logistic>();
		
		Iterator<Logistic> iterator =  allLogistics.iterator();
		
		while (iterator.hasNext()) {
			Logistic logistic = iterator.next();
			if (logistic.getType() == type) {
				filteredLogistics.add(logistic);
			}
		}
		
		return filteredLogistics;
	}
}
