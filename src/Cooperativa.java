import view.View;

/**
 * Clase principal de la aplicacion
 * 
 * @author Juan Barranco 
 * @version 0.1
 */
public class Cooperativa
{
    private static String title = "Cooperativa - v0.1 - 2023";
    
    /**
     * Metodo main de la aplicacion
     * 1. Inicializa la vista
     * 2. Carga datos de prueba
     * 3. Inicializa el menu y el bucle del prompt
     */
    public static void main() {
        View view = new View();
        view.print(title);
        
        view.print("Cargando datos de prueba...");
        // do cargar datos de prueba
        view.print("Datos de prueba cargados");
        
        view.printMenu();
        
        // while not exit
        view.prompt();
    }
}
