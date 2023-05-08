package model.producer;

/**
 * Factoria de instanciacion de productores, dependiendo de la extension
 * de cultivos y el umbral definido para el año fiscal
 * 
 * @author Juan Barranco 
 * @version 0.1
 */
public class ProducerFactory
{
    /**
     * Constructor
     */
    public ProducerFactory()
    {
    }

    /**
     * Metodo estatico para la generacion de productores
     * Devuelve SmallProducer si la extension con que se llama es inferior
     * al umbral, GreatProducer si es igual o mayor
     * 
     * @param name   nombre del productor
     * @param crop   cultivo explotado por el productor
     * @param extension   extension de explotacion
     * @param threshold   umbral para el año fiscal
     * @return     Producer
     */
    public static Producer get(String name, String crop, int extension, int threshold)
    {
        if (extension < threshold) {
            return new SmallProducer(name, crop, extension);
        } else {
            return new BigProducer(name, crop, extension);
        }
    }
}