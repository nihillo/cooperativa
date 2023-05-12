package view.command;

/**
 * Interfaz Command
 * Debe ser implementada por todas las clases Command
 * consistentes en objetos preparados para ejecutar
 * una determinada acción, desacoplando quién
 * proporciona la información necesaria para ejecutarla
 * y quién la ejecuta
 * 
 * @author Juan Barranco
 * @version 0.1
 */
public interface Command {
	
	/**
	 * Ejecuta la acción objeto de la clase que lo implementa
	 */
	public void execute();
	
}
