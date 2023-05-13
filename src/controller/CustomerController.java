package controller;

import java.util.ArrayList;

import model.customer.Address;
import model.customer.Customer;
import model.customer.CustomerCollection;
import model.customer.EndCustomer;
import model.customer.StockistCustomer;
import sampledata.SampleCustomer;

/**
 * Clase CustomerController
 * Punto de entrada a casos de uso relacionados 
 * con los clientes
 * @author Juan Barranco
 *
 */
public class CustomerController extends Controller {
	
	private CustomerCollection customerCollection;
	
	/**
	 * Constructor
	 */
	public CustomerController() {
		customerCollection = customerCollection.getInstance();
	}
	
	/**
	 * Registra un cliente
	 * @param id
	 * @param name
	 * @param type
	 */
	public void registerCustomer(String id, String name, String type, String address, String cityProvince, String zipCode) {
		if (customerCollection.contains(id)) throw new Error("El ID de Logística proporcionado ya está registrado");	
		
		Address addressObj = new Address(address, cityProvince, zipCode);
		
		Customer customer = null;
		
		switch(type) {
			case "E":
				customer = new EndCustomer(id, name, addressObj);
				break;
			case "S":
				customer = new StockistCustomer(id, name, addressObj);
				break;
			default:
				throw new Error("Tipo de logística no proporcionado o erróneo");
		}
		
		if (customer != null) {
			customerCollection.add(customer);
		}
	}
	
	/**
	 * Devuelve todos los clientes
	 * @return ArrayList<Customer> customers
	 */
	public ArrayList<Customer> getAllCustomers() {
		return customerCollection.getAll();
	}
	
	/**
	 * Carga los datos de prueba de clientes
	 */
	public void loadSampleCustomers() {
		for (SampleCustomer sampleCustomer : SampleCustomer.values()) {
			registerCustomer(sampleCustomer.getID(), sampleCustomer.getName(), sampleCustomer.getType(), sampleCustomer.getAddress(), sampleCustomer.getCityProvince(), sampleCustomer.getZipCode());
		}
	}
}
