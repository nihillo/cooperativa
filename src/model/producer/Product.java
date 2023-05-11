package model.producer;

import java.util.Date;
import java.util.HashMap;

import sampledata.ProductType;

public class Product {
	ProductType type;
	HashMap<Date, Float> refPrices;
	
	Product(ProductType type, HashMap<Date, Float> refPrices) {
		this.type = type;
		this.refPrices = refPrices;
	}
}
