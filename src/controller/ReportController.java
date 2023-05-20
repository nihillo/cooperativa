package controller;

import java.util.ArrayList;

import model.order.Order;
import model.order.ProductLine;
import model.product.Product;
import model.product.ProductCollection;

public class ReportController extends Controller {

	public ArrayList<String> getTotalSales() {
		ArrayList<String> report = new ArrayList<String>();
		
		ProductCollection productCollection = ProductCollection.getInstance();
		
		ArrayList<Product> products = productCollection.getAll();
		
		products.forEach(product -> {
			String id = product.getId();
			int productQty = 0;
			double productSale = 0;
			
			ArrayList<Order> productOrderHistory = product.getOrderHistory();
			
			for (Order order : productOrderHistory) {
				ProductLine productLine = order.getProductLine();
				productQty += productLine.getQty();
				productSale += productLine.getTotalPrice();
			}
			
			String line = id + "    --    " + productQty + "    --    " + productSale;
			report.add(line);
		});
		
		return report;
	}

}
