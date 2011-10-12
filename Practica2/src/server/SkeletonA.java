package server;

import utils.Marshall;
import utils.UnMarshall;

/**
 * Una posible opción de implementación de Skeleton para tratar las peticiones
 * de objetos ClaseA
 * 
 * @author Sergio Torres
 * 
 */
public class SkeletonA implements Skeleton {

    public void process(UnMarshall unmar, Marshall mar, Object obj) {
	ClaseA obja = (ClaseA) obj; // Hay que hacer un cast para ajustar el
				    // objeto
	int operationID = unmar.getInt();
	switch (operationID) {
	case 1:
	    String key = unmar.getString();
	    int value = unmar.getInt();
	    obja.asociar(key, value);
	    break;
	case 2:
	    String clave = unmar.getString();
	    int res = obja.obtener(clave);
	    mar.putInt(res);
	    break;
	default:
	    break;
	}
    }

}
