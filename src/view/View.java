package view;
import java.util.Scanner;


/**
 * Clase principal de las vistas de la aplicacion
 * 
 * @author Juan Barranco
 * @version 0.1
 */
public class View
{
    /**
     * Constructor 
     */
    public View()
    {
    }
    
    /**
     * Imprime una linea
     * @param str String: linea a imprimir
     */
    public void print(String str) {
        System.out.println(str);
    }
    
    /**
     * Imprime el menu de la aplicacion
     */
    public void printMenu() {
        print("MENU:");
        // TODO
    }
    
    /**
     * Imprime la linea de prompt y queda a la espera de entrada
     * de usuario
     */
    public void prompt() {
        Scanner prompt = new Scanner(System.in);
        print("Seleccione una opcion:");
        String option = prompt.nextLine();
        //
        print(option);
    }
}