package utils;

import sampledata.DistanceTable;

/**
 * Clase DistanceUtils
 * Da útiles para el cálculo de distancias en base
 * al código postal, y otras comprobaciones relacionadas
 */
public class DistanceUtils {
	
	private static DistanceUtils instance;
	private DistanceTable distanceTable;
	
	private DistanceUtils() {
		distanceTable = new DistanceTable();
	}
	
	/**
	 * Devuelve instancia singleton de la clase
	 * @return
	 */
	public static DistanceUtils getInstance() {
		if (instance == null) {
			instance = new DistanceUtils();
		}
		
		return instance;
	}

	/**
	 * Devuelve distancia interprovincial por código postal
	 * @param destZipCode
	 * @return
	 */
	public int getInterprovincialDistance(String destZipCode) {
		String firstTwoChars = destZipCode.substring(0, 2);
		int distance = distanceTable.getDistance(firstTwoChars);
		
		return distance;
	}

	/**
	 * Devuelve distancia desde la capital de provincia
	 * de destino hasta la localización exacta ("última milla")
	 * @param destZipCode
	 * @return
	 */
	public int getLastMileDistance(String destZipCode) {
		String lastThreeChars = destZipCode.substring(destZipCode.length() - 3);
		return Integer.parseInt(lastThreeChars)/10;
	}

	/**
	 * Comprueba si un código postal es válido, si sus dos primeros
	 * dígitos están registrados en la tabla de distancias
	 * @param zipCode
	 * @return
	 */
	public boolean isValidZipCode(String zipCode) {
		String firstTwoChars = zipCode.substring(0, 2);
		return distanceTable.isProvinceRegistered(firstTwoChars);
	}
}
