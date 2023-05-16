package view.command;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import controller.CustomerController;
import controller.LogisticController;
import controller.OrderController;
import controller.ProductController;
import model.customer.Customer;
import model.order.Order;
import model.order.ProductLine;
import model.order.Shipment;
import model.order.ShippingLine;
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
	
		Order order = orderController.createOrder(customer, deliveryDate, product, qty);
				
		logisticController.generateShipmentQuotes(order);
		promptShipmentSelection(prompt, order);
		
		orderController.calculateAmounts(order);
		
		boolean accept = promptAcceptOrder(prompt, order);
		if (!accept) return;
		
		orderController.placeOrder(order);
	}

	private void promptShipmentSelection(Scanner prompt, Order order) {
		ShippingLine[] shippingLines = order.getShippingLines();
		for (ShippingLine shippingLine : shippingLines) {			
			if (shippingLine != null) {
				view.print("Ofertas para " + shippingLine.getShipmentTypeLabel() + ": ");
				view.print("Distancia: " + shippingLine.getDistance());
				view.print("ID    --   EMPRESA    --    PRECIO");
				
				for (Shipment quote: shippingLine.getShipmentQuotes()) {
					view.print(quote.getInfoLine());
				}
				view.print("");
				
				boolean isShipmentSet = false;
				while (!isShipmentSet) {
					view.print("Seleccione una opción (introduzca ID de empresa seleccionada):");
					String selectionID = prompt.nextLine();
					isShipmentSet = logisticController.setShipment(order.getId(), shippingLine, selectionID);
					
					if (!isShipmentSet) {
						view.print("Opción no válida");
					}
				}
			}
		}
	}

	private boolean promptAcceptOrder(Scanner prompt, Order order) {
		ProductLine productLine = order.getProductLine();
		int qty = productLine.getQty();
		String productID = productLine.getProductID();
		double cost = productLine.getTotalPrice();
		
		view.print("== RESUMEN DEL PEDIDO ==");
		view.print("PRODUCTO:");
		view.print("CANTIDAD    --    PRODUCTO    --    PRECIO");
		view.print(Integer.toString(qty) + "    --    " + productID + "    --    " + cost);
		view.print("");
		view.print("ENVÍO:");
		view.print("#   --  ID-EMPRESA    --    PRECIO");
		int i=1;
		for (ShippingLine shippingLine : order.getShippingLines()) {			
			if (shippingLine != null) {
				view.print(Integer.toString(i) + "  --  " + shippingLine.getShipment().getSummaryInfoLine());
				i++;
			}
		}
		view.print("");
		view.print("-----------");
		if (order.getTaxRate() > 0) {
			view.print("BASE: " + order.getBasePrice());
			view.print("IVA " + order.getTaxRate() + ("%: " + order.getTax()));
		} 
		view.print("TOTAL: " + order.getTotalPrice());
		view.print("");
		view.print("-----------");
		view.print("");
		
		
		view.print("¿Desea confirmar el pedido? (S/N)");
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
