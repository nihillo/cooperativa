package sampledata;

import java.util.Date;

import controller.LogisticController;
import controller.OrderController;
import model.customer.Customer;
import model.customer.CustomerCollection;
import model.order.Order;
import model.order.ShippingLine;
import model.product.Product;
import model.product.ProductCollection;

public class SampleOrder {

	public static void createSampleOrders(OrderController orderController, LogisticController logisticController) {
		for (OrderTemplate template : OrderTemplate.values()) {
			CustomerCollection customerCollection = CustomerCollection.getInstance();
			Customer customer = customerCollection.get(template.getCustomerID());
			Date date = null;
			try {
				date = orderController.parseDate(template.getDeliveryDate());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
			ProductCollection productCollection = ProductCollection.getInstance();
			Product product = productCollection.get(template.getProductID());
			
			Order order = orderController.createOrder(customer, date, product, template.getQty()); // customer, deliveryDate, product, qty
			logisticController.generateShipmentQuotes(order);
			
			int i = 0;
			for (ShippingLine shippingLine : order.getShippingLines()) {
				String[] shipmentChoice = template.getShipmentChoice();
				
				if (shippingLine != null) {
					logisticController.setShipment(shippingLine, shipmentChoice[i]); //shippingLine, logistic id
				}
				i++;
			}
					
			orderController.calculateAmounts(order);
			orderController.placeOrder(order);
		}
	}
	
	private enum OrderTemplate {
		_001("018", "15/01/2023", "ALMENDRA", 1000, "007", "021"),
		_002("641", "07/03/2023", "ACEITE", 50, "131", "515"),
		_003("641", "21/04/2023", "TRIGO", 98, "007", "057"),
		_004("099", "01/06/2023", "PIMIENTO", 2200, "131", "021"),
		_005("121", "12/07/2023", "TOMATE", 85, "131", "057"),
		_006("423", "24/08/2023", "PIMIENTO", 1540, "007", "515"),
		_007("922", "29/09/2023", "ACEITE", 25, "131", "515"),
		_008("018", "30/09/2023", "UVA", 1050, "131", "021"),
		_009("121", "15/11/2023", "TOMATE", 53, "007", "057"),
		_010("099", "11/12/2023", "ACEITE", 1100, "007", "515");

		String deliveryDate;
		String productID;
		int qty;
		String[] shipmentChoice;
		
		OrderTemplate(String customerID, String deliveryDate, String productID, int qty, String shipmentChoiceBL, String shipmentChoiceSL) {
			this.customerID = customerID;
			this.deliveryDate = deliveryDate;
			this.productID = productID;
			this.qty = qty;
			this.shipmentChoice = new String[]{shipmentChoiceBL, shipmentChoiceSL}; 
		}
		
		String customerID;
		public String getCustomerID() {
			return customerID;
		}

		public String getDeliveryDate() {
			return deliveryDate;
		}

		public String getProductID() {
			return productID;
		}

		public int getQty() {
			return qty;
		}

		public String[] getShipmentChoice() {
			return shipmentChoice;
		}
	}
}
