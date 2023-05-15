package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import model.customer.Customer;
import model.order.Order;
import model.order.OrderCollection;
import model.product.Product;
import sampledata.SystemData;
import view.command.PlaceOrderCommand;

/**
 * Clase OrderController
 * Punto de entrada a casos de uso relacionados con los
 * pedidos
 * @author Juan Barranco
 *
 */
public class OrderController extends Controller {
	private OrderCollection orderCollection;

	public OrderController() {
		this.orderCollection = OrderCollection.getInstance();
	}

	public Date parseDate(String deliveryDateStr) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		Date date;
		try {
			date = dateFormat.parse(deliveryDateStr);
		} catch (Exception e) {
			throw new Exception("Formato incorrecto, el formato esperado es dd/MM/yyyy");
		}
			
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int fiscalYear = SystemData.getFiscalYear();
		
		if (year != fiscalYear) {
			throw new Exception("Sólo se pueden establecer fechas del año fiscal actual (" + fiscalYear + ")");
		}
		
		return date;
	}

	public Date getPlacementDate(Date deliveryDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(deliveryDate);
		calendar.add(Calendar.DAY_OF_MONTH, -10);
		Date placementDate = calendar.getTime();
		
		return placementDate;
	}
	
	public void createOrder(Customer customer, Date deliveryDate, Product product, int qty, PlaceOrderCommand placeOrderCommand) {
		String orderID = orderCollection.getNextAvailableOrderID();
		Order order = new Order(orderID, customer, deliveryDate, product, qty);

		// generate logistic quotes
		// execute placeOrderCommand		
	}
	
	public void placeOrder() {
		// addshippinglines
		// place order
	}	
}
