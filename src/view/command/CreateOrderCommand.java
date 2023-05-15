package view.command;

import java.util.Date;
import java.util.Scanner;

import controller.CustomerController;
import controller.LogisticController;
import controller.OrderController;
import controller.ProductController;
import model.customer.Customer;
import model.order.Order;
import model.product.Product;
import view.ConsoleView;

/**
 * Clase PlaceOrderCommand - comando crear pedido
 * @author Juan Barranco
 *
 */
public class CreateOrderCommand implements Command {
	
	private ConsoleView view;
	private OrderController orderController;	
	private CustomerController customerController;
	private ProductController productController;
	private LogisticController logisticController;
	
	/**
	 * Constructor
	 * @param view
	 * @param orderController
	 */
	public CreateOrderCommand(
		ConsoleView view, 
		OrderController orderController, 
		CustomerController customerController, 
		ProductController productController,
		LogisticController logisticController
	) {
		this.view = view;
		this.orderController = orderController;
		this.customerController = customerController;
		this.productController = productController;
		this.logisticController = logisticController;
	}
	
	/**
	 * Ejecuta la secuencia de acciones crear pedido
	 */
	@Override
	public void execute() {
		
		Scanner prompt = view.getPrompt();
		
		Customer customer = promptCustomer(prompt);	
		Date deliveryDate = promptDeliveryDate(prompt);
		Date placementDate = orderController.getPlacementDate(deliveryDate);
		Product product = promptProduct(prompt);
		int qty = promptQty(prompt, product, customer);
		boolean accept = promptAcceptOrder(prompt, product.getId(), qty, product.getPrice(placementDate)*qty*customer.getCoopBenefit());
		
		// no continuar a la creación del pedido si el usuario no lo acepta
		if (!accept) return;
	
		Order order = orderController.createOrder(customer, deliveryDate, product, qty);
		
		// generar ofertas de logística
		logisticController.generateShipmentQuotes(order);
		
		// prompt logistic quote
		// place order
						
	}

	private boolean promptAcceptOrder(Scanner prompt, String productID, int qty, double cost) {
		view.print("CANTIDAD    --    PRODUCTO    --    PRECIO*");
		view.print(Integer.toString(qty) + "    --    " + productID + "    --    " + cost);
		view.print("");
		view.print("*Este precio no incluye impuestos ni transporte");
		view.print("");
		
		view.print("¿Desea continuar con el pedido? (S/N)");
		String acceptStr = null;
		while(acceptStr == null || !(acceptStr.equals("S") || acceptStr.equals("N"))) {
			acceptStr = prompt.nextLine().toUpperCase();
			
			if (!(acceptStr.equals("S") || acceptStr.equals("N"))) {
				view.print("Introduzca S o N");
			}
		}
		
		boolean accept = acceptStr.equals("S") ? true : false;
		return accept;
	}

	private Date promptDeliveryDate(Scanner prompt) {
		Date deliveryDate = null;
		while (deliveryDate == null) {
			view.print("Introduzca fecha de entrega del pedido (dd/MM/yyyy):");
			String deliveryDateStr = prompt.nextLine();
					
			try {
				deliveryDate = orderController.parseDate(deliveryDateStr);
			} catch (Exception e) {
				view.print(e.getMessage());
			}
		}
		return deliveryDate;
	}

	private Customer promptCustomer(Scanner prompt) {
		Customer customer = null;
		while (customer == null) {
			view.print("Introduzca ID de cliente:");
			String customerId = prompt.nextLine();
			customer = customerController.getCustomer(customerId);
			if (customer == null) {
				view.print("Cliente no encontrado");
			}
		}
		return customer;
	}
	
	private Product promptProduct(Scanner prompt) {
		Product product = null;
		String[] availableProductList = productController.getRegisteredProductList();
		while (product == null) {
			view.print("Introduzca producto");
			view.print("IDs de productos disponibles: " + String.join(", ", availableProductList));
			view.print("Introduzca ID de producto:");
			String productID = prompt.nextLine();
			
			product = productController.getProduct(productID);
			if (product == null) {
				view.print("Producto no válido");
			}
		}
		
		return product;
	}
	
	private int promptQty(Scanner prompt, Product product, Customer customer) {
		int qty = 0;
		boolean saleAllowed = false;
		while (qty == 0 || !saleAllowed) {
			view.print("Introduzca cantidad (kg):");
			String qtyStr = prompt.nextLine();
			try {
				qty = Integer.parseInt(qtyStr);
			} catch (Exception e) {
				view.print("Entrada incorrecta. Introduzca un número entero.");
			}
			
			int productStock = product.getStock();
			int[] customerAllowedQtyRange = customer.getAllowedQtyRange();
			
			boolean productAvailable = (qty <= productStock);
			boolean qtyAllowed = (qty >= customerAllowedQtyRange[0] && qty <= customerAllowedQtyRange[1]);
			
			if (!productAvailable) {
				view.print("Cantidad de producto no disponible. Introduzca un máximo de " + productStock + " kg.");
			} 
			
			if (!qtyAllowed) {
				view.print("La cantidad permitida para este tipo de cliente es de entre " + customerAllowedQtyRange[0] + " y " + customerAllowedQtyRange[1] + " kg.");
			} 
			saleAllowed = productAvailable && qtyAllowed;
		}
			
		return qty;
	}
}
