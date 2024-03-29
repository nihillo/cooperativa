package model.product;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import model.CollectionItem;
import model.order.Order;
import model.order.ProductLine;
import sampledata.ProductType;

/**
 * Clase Product (Producto)
 * Implementa CollectionItem
 * 
 * @author Juan Barranco 
 * @version 0.1
 */
public class Product implements CollectionItem {
	String id;
	boolean perishable;
	int performance;
	HashMap<String, Double> refPrices;
	int stock;
	HashMap<String, CropShareItem> cropShare;
	ArrayList<Order> orderHistory;
		
	/**
	 * Constructor
	 * @param type - Producto tipo, desde sampledata
	 * @param refPrices - precios de referencia, desde sampledata
	 */
	Product(ProductType type, HashMap<String, Double> refPrices) {
		this.id = type.name();
		this.perishable = type.isPerishable();
		this.performance = type.getPerformance();
		this.refPrices = refPrices;
		this.stock = 0;
		this.cropShare = new HashMap<String, CropShareItem>();
		this.orderHistory = new ArrayList<Order>();
	}

	/**
	 * Devuelve ID del producto
	 */
	@Override
	public String getId() {
		return id;
	}
	
	/**
	 * Verifica si el producto es perecedero
	 * @return boolean
	 */
	public boolean isPerishable() {
		return perishable;
	}
	
	/**
	 * Devuelve el rendimiento por Ha. del producto
	 * @return double - kg producidos por Ha. de cultivo del producto
	 */
	public int getPerformance() {
		return performance;
	}
	
	/**
	 * Devuelve el stock del producto, en kg
	 * @return int - stock (kg)
	 */
	public int getStock() {
		return stock;
	}
	
	/**
	 * Registra un cultivo como participante en la producción 
	 * del producto
	 * @param crop
	 */
	public void registerCrop(Crop crop) {
		updateStock(crop.getProduction());
		addCropShare(crop);
	}
	
	/**
	 * Actualiza el stock por incremento, sea positivo o negativo
	 * @param increment
	 */
	public void updateStock(int increment) {
		stock += increment;
	}

	/**
	 * Añade un cultivo a la lista de participantes
	 * y recalcula los coeficientes
	 * @param crop
	 */
	private void addCropShare(Crop crop) {
		CropShareItem cropShareItem = new CropShareItem(crop);
		this.cropShare.put(crop.getID(), cropShareItem);	
		
		int totalProduction = 0;
		for (String cropID : this.cropShare.keySet()) {
			totalProduction += this.cropShare.get(cropID).getCrop().getProduction();
		}
		
		for (String cropID : this.cropShare.keySet()) {
			int cropProduction = this.cropShare.get(cropID).getCrop().getProduction();
			double coefficient = (double) cropProduction / totalProduction;
			this.cropShare.get(cropID).setShareCoefficient(coefficient);
		}
	}

	/**
	 * Devuelve el precio del producto para una determinada fecha
	 * @param placementDate
	 * @return
	 */
	public double getPrice(Date placementDate) {
		
		String week = "1";
		boolean isBeforeFirstWeek;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date firstDayOfFirstWeek = dateFormat.parse("02/01/2023");
			isBeforeFirstWeek = placementDate.before(firstDayOfFirstWeek);
		} catch (Exception e) {
			isBeforeFirstWeek = false;
		}
		
		if (!isBeforeFirstWeek) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(placementDate);
			week = String.format("%02d", calendar.get(Calendar.WEEK_OF_YEAR));			
		}
		
		String weekKey = "W" + week;
		double price = this.refPrices.get(weekKey);
		
		return price;
		
	}

	/**
	 * Registra un pedido en el historial del producto
	 * @param order
	 */
	public void registerOrder(Order order) {
		orderHistory.add(order);
		divideShareBenefit(order);
	}

	/**
	 * Reparte el beneficio de una venta entre los distintos
	 * cultivos según sus coeficientes de participación en la
	 * producción del producto
	 * @param order
	 */
	private void divideShareBenefit(Order order) {
		ProductLine productLine = order.getProductLine();
		double producerTotalBenefit = productLine.getBasePrice();
		double totalQty = productLine.getQty();
		this.cropShare.entrySet().forEach(entry -> {
			CropShareItem cropShareItem = entry.getValue();
			double coefficient = cropShareItem.getShareCoefficient();
			cropShareItem.getCrop().addBenefit(coefficient * producerTotalBenefit);
			cropShareItem.getCrop().addQtySold(coefficient * totalQty);
		});
	}

	/**
	 * Descuenta una cantidad vendida del stock
	 * @param qty
	 */
	public void discountStock(int qty) {
		stock -= qty;		
	}

	/**
	 * Devuelve el historial de pedidos del producto
	 * @return
	 */
	public ArrayList<Order> getOrderHistory() {
		return this.orderHistory;
	}
}
