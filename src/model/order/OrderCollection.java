package model.order;

import java.util.ArrayList;

import model.Collection;


/**
 * Clase OrderCollection  (Colección de pedidos)
 * 
 * Wrapper de Collection (utiliza por composición la clase Collection,
 * como objeto interno en donde almacena los CollectionItems). Sobre esta, 
 * implementa los métodos propios específicos derivados de la naturaleza
 * de los objetos Order, que no comparten interfaz con otras colecciones
 * 
 * Sigue patrón Singleton, de modo que exista una única instancia
 * accesible desde múltiples clientes sin que necesiten mantener trazabilidad
 * de esta
 * 
 * @author Juan Barranco 
 * @version 0.1
 */
public class OrderCollection {
	
	private static OrderCollection instance;
	private Collection<Order> collection;
	
	private OrderCollection() {
		collection = new Collection<Order>();
	}
	
	/**
	 * Método estático que devuelve la instancia
	 * singleton de la clase
	 * @return OrderCollection
	 */
	public static OrderCollection getInstance() {
		if (instance == null) {
			instance = new OrderCollection();
		}
		
		return instance;
	}
	
	/**
	 * Verifica si la colección contiene un 
	 * pedido a partir de su ID
	 * @param id
	 * @return boolean
	 */
	public boolean contains(String id) {
		return collection.contains(id);
	}
	
	/**
	 * Añade un productor a la colección
	 * @param order
	 */
	public void add(Order order) {
		collection.add(order);
	}
	
	/**
	 * Obtiene la lista de todos los pedidos
	 * @return ArrayList<Order>
	 */
	public ArrayList<Order> getAll() {
		return collection.getAll();
	}
	
	public Order get(String id) {
		return collection.get(id);
	}
	
	public String getNextAvailableOrderID() {
		if (collection.size() == 0) {
			return "001";
		}
		Order lastOrder = collection.getLast();
		String lastID = lastOrder.getId();
		
		return String.format("%03d", Integer.parseInt(lastID)+1);
	}
}
