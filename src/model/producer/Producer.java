package model.producer;

import java.util.ArrayList;

/**
 * Abstract class Producer - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class Producer {
	protected String id;
	protected String name;
	protected ArrayList<Crop> crops;
	
	public Producer(String id, String name, ArrayList<Crop> crops) {
		this.id = id;
		this.name = name;
		this.crops = crops;
	}
}
