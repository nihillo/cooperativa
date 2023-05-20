package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import model.customer.Customer;
import model.order.Order;
import model.order.OrderCollection;
import model.order.Shipment;
import model.order.ShippingLine;
import model.product.Product;
import sampledata.SampleOrder;
import sampledata.SystemData;

/**
 * Clase OrderController
 * Punto de entrada a casos de uso relacionados con los
 * pedidos
 * @author Juan Barranco
 *
 */
public class OrderController extends Controller {
	private OrderCollection orderCollection;
	
	/**
	 * Constructor
	 */
	public OrderController() {
		this.orderCollection = OrderCollection.getInstance();
	}
	
	/**
	 * Convierte string fecha a objeto Date
	 * @param deliveryDateStr
	 * @return Date
	 * @throws Exception
	 */
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
	
	/**
	 * Obtiene fecha de realización del pedido a partir de la fecha de entrega provista
	 * @param deliveryDate
	 * @return
	 */
	public Date getPlacementDate(Date deliveryDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(deliveryDate);
		calendar.add(Calendar.DAY_OF_MONTH, -10);
		Date placementDate = calendar.getTime();
		
		return placementDate;
	}
	
	/**
	 * Crea pedido
	 * @param customer
	 * @param deliveryDate
	 * @param product
	 * @param qty
	 * @return
	 * 
	 */
	public Order createOrder(Customer customer, Date deliveryDate, Product product, int qty) {
		String orderID = orderCollection.getNextAvailableOrderID();
		Date placementDate = getPlacementDate(deliveryDate);
				
		Order order = new Order(orderID, customer, placementDate, deliveryDate, product, qty);
		return order;
	}
	
	/**
	 * Calcula totales del pedido
	 * @param order
	 */
	public void calculateAmounts(Order order) {
		order.calculateAmounts();	
	}
	
	/**
	 * Confirma pedido y lo añade a los registros
	 * @param order
	 */
	public void placeOrder(Order order) {
		Product product = order.getProductLine().getProduct();
		product.discountStock(order.getProductLine().getQty());		
		product.addOrderToHistory(order);
		
		Customer customer = order.getCustomer();
		customer.addOrderToHistory(order);
		
		for (ShippingLine shippingLine : order.getShippingLines()) {
			if (shippingLine != null) {
				Shipment shipment = shippingLine.getShipment();
				shipment.getLogistic().addOrderShipment(order.getId(), shipment);
			}
		}
		
		orderCollection.add(order);
		
		order.setStatus(Order.Status.CONFIRMED);
	}

	/**
	 * Carga datos de prueba de pedidos
	 * @param logisticController
	 */
	public void loadSampleOrders(LogisticController logisticController) {
		SampleOrder.createSampleOrders(this, logisticController);		
	}	
}
