package server;

import utils.Marshall;
import utils.UnMarshall;

/**
 * Contiene la interfaz Skeleton que es la que debe ser implementada por los
 * esqueletos de las nuevas clases
 * 
 * @author upv - Bernabéu, Muñoz, Galdámez
 * 
 */
public interface Skeleton {

    /**
     * Método invocado por el switcher una vez que tiene el ID de objeto y de
     * interfaz.
     * 
     * @param unmar
     *            Necesario para obtener el resto del mensaje
     * @param mar
     *            Necesario para empaquetar la respuesta
     * @param obj
     *            Objeto a quien deberá invocar el esqueleto
     */
    public void process(UnMarshall unmar, Marshall mar, Object obj);
}
