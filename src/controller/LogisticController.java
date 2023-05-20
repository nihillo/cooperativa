package controller;

import java.util.ArrayList;

import model.logistic.BigLogistic;
import model.logistic.Logistic;
import model.logistic.LogisticCollection;
import model.logistic.SmallLogistic;
import model.order.Order;
import model.order.Shipment;
import model.order.ShipmentType;
import model.order.ShippingLine;
import sampledata.SampleLogistic;

/**
 * Clase LogisticController
 * Punto de entrada a casos de uso relacionados 
 * con la logística
 * @author Juan Barranco
 *
 */
public class LogisticController extends Controller {
	
	private LogisticCollection logisticCollection;
	
	/**
	 * Constructor
	 */
	public LogisticController() {
		logisticCollection = LogisticCollection.getInstance();
	}
	
	/**
	 * Registra empresa de logística
	 * @param id
	 * @param name
	 * @param type
	 */
	public void registerLogistic(String id, String name, String type) {
		if (logisticCollection.contains(id)) throw new Error("El ID de Logística proporcionado ya está registrado");	
		
		Logistic logistic = null;
		
		switch(type) {
			case "B":
				logistic = new BigLogistic(id, name);
				break;
			case "S":
				logistic = new SmallLogistic(id, name);
				break;
			default:
				throw new Error("Tipo de logística no proporcionado o erróneo");
		}
		
		if (logistic != null) {
			logisticCollection.add(logistic);
		}
	}
	
	/**
	 * Devuelve todas las empresas de logística
	 * @return ArrayList<Logistic> logísticas
	 */
	public ArrayList<Logistic> getAllLogistics() {
		return logisticCollection.getAll();
	}
	
	/**
	 * Carga los datos de prueba de empresas de logística
	 */
	public void loadSampleLogistics() {
		for (SampleLogistic sampleLogistic : SampleLogistic.values()) {
			registerLogistic(sampleLogistic.getID(), sampleLogistic.getName(), sampleLogistic.getType());
		}
	}

	/**
	 * Genera ofertas para envíos
	 * @param order
	 */
	public void generateShipmentQuotes(Order order) {
		
		for(ShippingLine shippingLine : order.getShippingLines()) {
			if (shippingLine != null) {
				ShipmentType shipmentType = shippingLine.getShipmentType();
				ArrayList<Logistic> logistics = logisticCollection.getAllByType(shipmentType);
				
				for (Logistic logistic : logistics) {
					Shipment shipmentQuote = logistic.getShipmentQuote(order);	
					shippingLine.addShipmentQuote(shipmentQuote);
				}
			}
		}
	}
	
	/**
	 * Guarda un shipment por id en una linea de pedido
	 * @param shippingLine
	 * @param selectionID
	 * @return
	 */
	public boolean setShipment(ShippingLine shippingLine, String selectionID) {
		Shipment shipment = shippingLine.getShipmentQuote(selectionID);
		
		if (shipment != null) {
			shippingLine.setShipment(shipment);
			return true;
		}
		
		return false;
	}

}
