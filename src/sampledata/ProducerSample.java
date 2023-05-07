package sampledata;
import java.util.ArrayList;
import model.Producer;
import model.ProducerFactory;


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