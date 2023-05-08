package sampledata;
import java.util.ArrayList;

import model.producer.Producer;
import model.producer.ProducerFactory;


/**
 * Write a description of class Producers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProducerSample
{
    static ArrayList<Producer> producers;
    
    public ProducerSample() {
        producers.add(ProducerFactory.get("Juan", "Trigo", 5, 10));
    }
}