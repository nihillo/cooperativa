import view.ConsoleView;

/**
 * Clase principal de la aplicacion
 * 
 * @author Juan Barranco 
 * @version 0.1
 */
public class Cooperativa
{
    private final static String APP_TITLE = "Cooperativa - v0.1 - 2023";
    private static boolean runningStatus = true;
    
    /**
     * Metodo main de la aplicacion
     * 1. Inicializa la vista
     * 2. Carga datos de prueba
     * 3. Inicializa el menu y el bucle del prompt
     */

    public static void main(String[] args) {
    	ConsoleView view = new ConsoleView();
        view.print(APP_TITLE);
        view.print("");
        
        view.print("Cargando datos de prueba...");
        // TODO cargar datos de prueba
        view.print("Datos de prueba cargados");
        
        view.print("");
        
        
        while (runningStatus) {
        	try {
        		view.printMenu();
            	boolean promptStatus = view.prompt();
            	runningStatus = !promptStatus;
        	} catch (Error e) {
        		view.print("ERROR: " + e.getMessage());
        	}
        	
        }
        
        view.print("Saliendo.....");
	}
}