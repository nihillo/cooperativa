import view.ConsoleView;

/**
 * Clase principal de la aplicacion
 * 
 * @author Juan Barranco 
 * @version 0.1
 */
public class Cooperativa
{
    private static String title = "Cooperativa - v0.1 - 2023";
    private static boolean runningStatus = true;
    
    /**
     * Metodo main de la aplicacion
     * 1. Inicializa la vista
     * 2. Carga datos de prueba
     * 3. Inicializa el menu y el bucle del prompt
     */

    public static void main(String[] args) {
    	ConsoleView view = new ConsoleView();
        view.print(title);
        view.print("");
        
        view.print("Cargando datos de prueba...");
        // TODO cargar datos de prueba
        view.print("Datos de prueba cargados");
        
        view.print("");
        view.printMenu();
        
        
        while (runningStatus) {
        	boolean promptStatus = view.prompt();
        	runningStatus = !promptStatus;
        }
        
        view.print("Saliendo.....");
	}
}