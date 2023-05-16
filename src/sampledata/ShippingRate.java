package sampledata;

import model.order.ShipmentType;

public class ShippingRate {
	private static double RATE_PERISHABLE_BIG_LOGISTIC = 0.4;
	private static double RATE_PERISHABLE_SMALL_LOGISTIC = 0.5;
	private static double RATE_NON_PERISHABLE_BIG_LOGISTIC = 0.2; 
	private static double RATE_NON_PERISHABLE_SMALL_LOGISTIC = 0.25;
	
	public static double getRate(boolean isPerishable, ShipmentType shipmentType) {
		switch (shipmentType) {
			case SMALL_LOGISTIC: 
				return isPerishable ? RATE_PERISHABLE_SMALL_LOGISTIC : RATE_NON_PERISHABLE_SMALL_LOGISTIC;
			case BIG_LOGISTIC:
			default:
				return isPerishable ? RATE_PERISHABLE_BIG_LOGISTIC : RATE_NON_PERISHABLE_BIG_LOGISTIC;
		}
	}
}
