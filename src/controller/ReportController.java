package controller;

import java.util.ArrayList;

import model.order.Order;
import model.order.ProductLine;
import model.producer.Producer;
import model.product.Crop;
import model.product.Product;
import model.product.ProductCollection;
import view.Table;

public class ReportController extends Controller {

	public Table getTotalSales() {
		
		ArrayList<String> header = new ArrayList<String>();
		header.add("PRODUCTO");
		header.add("CANTIDAD TOTAL KG");
		header.add("VENTA TOTAL €");
		
		ArrayList<Integer> widths = new ArrayList<Integer>();
		widths.add(15);
		widths.add(17);
		widths.add(20);
		
		ProductCollection productCollection = ProductCollection.getInstance();
		
		ArrayList<Product> products = productCollection.getAll();
		ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();
		
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
			
			ArrayList<String> line = new ArrayList<String>();
			line.add(id);
			line.add(Integer.toString(productQty));
			line.add(Double.toString(productSale));
			
			lines.add(line);
		});
		
		Table report = new Table(header, lines, widths);
		
		return report;
	}
	
	public String getProducerReportTitle(Producer producer) {
		String producerStr = producer.getId() + " - " + producer.getName() + "(" + producer.getType() + ")";
		return "Productor: " + producerStr;
	}

	public Table getProducerBenefit(Producer producer) {
		ArrayList<String> header = new ArrayList<String>();
		header.add("PRODUCTO");
		header.add("CANTIDAD TOTAL KG");
		header.add("VENTA TOTAL €");
		
		ArrayList<Integer> widths = new ArrayList<Integer>();
		widths.add(15);
		widths.add(17);
		widths.add(20);
		
		ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();
		ArrayList<Crop> producerCrops = producer.getCrops();
		
		producerCrops.forEach(crop -> {
			Product product = crop.getProduct();
			String id = product.getId();
			double qtySold = crop.getQtySold();
			double benefit = crop.getBenefit();
			
			ArrayList<String> line = new ArrayList<String>();
			line.add(id);
			line.add(Double.toString(qtySold));
			line.add(Double.toString(benefit));
			
			lines.add(line);
		});

		Table report = new Table(header, lines, widths);
		
		return report;
	}
}
