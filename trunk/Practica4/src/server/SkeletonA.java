package server;

import commons.Marshall;
import commons.UnMarshall;

/**
 * Una posible opción de implementación de Skeleton para tratar las
 * peticiones de objetos ClaseA
 * @author Sergio Torres
 *
 */
public class SkeletonA implements Skeleton{

	@Override
	public void process(UnMarshall unmar, Marshall mar, Object obj) {
		ClaseA obja = (ClaseA)obj;
		String key;
		int operationID = unmar.getInt();
		switch (operationID) {
		case 1:
			key = unmar.getString();
			int value = unmar.getInt();
			unmar.getInt(); // Para recibir el cero que se envía con send()
			obja.asociar(key, value);
			break;
		case 2:
			key = unmar.getString();
			int res = obja.obtener(key);
			mar.putInt(res);
			break;
		default:
			break;
		}	
	}

}
