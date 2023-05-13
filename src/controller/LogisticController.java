package controller;

import java.util.ArrayList;

import model.logistic.BigLogistic;
import model.logistic.Logistic;
import model.logistic.LogisticCollection;
import model.logistic.SmallLogistic;
import sampledata.SampleLogistic;

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

}
