package controller;

import java.util.ArrayList;

import model.producer.Producer;
import model.producer.ProducerFactory;


public class ProducerController extends Controller {
	
	public Producer registerProducer(String id, String name, ArrayList<String> cropStrArr) {
		ProducerFactory producerFactory = new ProducerFactory();
		Producer newProducer = producerFactory.getProducer(id, name, cropStrArr);
		
		return newProducer;
	}
}
