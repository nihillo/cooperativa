package model.order;

import model.logistic.Logistic;

public class Shipment {
	
	private Logistic logistic;
	private double price;
	
	public Shipment(Logistic logistic, double price) {
		this.logistic = logistic;
		this.price = price;
	} 
	
	public String getInfoLine() {
		return logistic.getId() + "    --    " + logistic.getName() + "    --    " + price;
	}
	
	public Logistic getLogistic() {
		return logistic;
	}
	
	public Object getLogisticID() {
		return logistic.getId();
	}
	
	public double getPrice() {
		return this.price;
	}

	public String getSummaryInfoLine() {
		return logistic.getId() + "-" + logistic.getName() + "    --    " + price;		
	}
}
