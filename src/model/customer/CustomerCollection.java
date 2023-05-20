package model.customer;

import java.util.ArrayList;

import model.Collection;

/**
 * Clase CustomerCollection  (Colección de empresas de logística)
 * 
 * Wrapper de Collection (utiliza por composición la clase Collection,
 * como objeto interno en donde almacena los CollectionItems). Sobre esta, 
 * implementa los métodos propios específicos derivados de la naturaleza
 * de los objetos Customer, que no comparten interfaz con otras colecciones
 * 
 * Sigue patrón Singleton, de modo que exista una única instancia
 * accesible desde múltiples clientes sin que necesiten mantener trazabilidad
 * de esta
 * 
 * @author Juan Barranco 
 * @version 0.1
 */
public class CustomerCollection {

	private static CustomerCollection instance;
	private Collection<Customer> collection;
	
	private CustomerCollection() {
		collection = new Collection<Customer>();
	}
	
	/**
	 * Método estático que devuelve la instancia
	 * singleton de la clase
	 * @return CustomerCollection
	 */
	public static CustomerCollection getInstance() {
		if (instance == null) {
			instance = new CustomerCollection();
		}
		
		return instance;
	}
	
	/**
	 * Verifica si la colección contiene un 
	 * cliente a partir de su ID
	 * @param id
	 * @return boolean
	 */
	public boolean contains(String id) {
		return collection.contains(id);
	}

	/**
	 * Añade un productor a la colección
	 * @param customer
	 */
	public void add(Customer customer) {
		collection.add(customer);
	}
	
	/**
	 * Obtiene la lista de todos los clientes
	 * @return ArrayList<Customer>
	 */
	public ArrayList<Customer> getAll() {
		return collection.getAll();
	}

	/**
	 * Devuelve un cliente por su id
	 * @param id
	 * @return
	 */
	public Customer get(String id) {
		return collection.get(id);
	}
}
