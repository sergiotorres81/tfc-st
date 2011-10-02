package server;

import commons.Marshall;
import commons.UnMarshall;
/**
 * Una posible opción de implementación de Skeleton para tratar las
 * peticiones de objetos ClaseB
 * @author Sergio Torres
 *
 */
public class SkeletonB implements Skeleton{

	@Override
	public void process(UnMarshall unmar, Marshall mar, Object obj) {
		ClaseB objb = (ClaseB)obj;  // Hay que hacer un cast para ajustar el objeto
		String key;
		String op1;
		String op2;
		int res;
		int operationID = unmar.getInt();
		switch (operationID) {
		case 1:
			key = unmar.getString();
			int value = unmar.getInt();
			objb.asociar(key, value);
			break;
		case 2:
			key = unmar.getString();
			res = objb.obtener(key);
			mar.putInt(res);
			break;
		case 3:
			op1 = unmar.getString();
			op2 = unmar.getString();
			res = objb.suma(op1, op2);
			mar.putInt(res);
			break;
		case 4:
			op1 = unmar.getString();
			op2 = unmar.getString();
			res = objb.resta(op1, op2);
			mar.putInt(res);
			break;
		default:			
			break;
		}	
		
	}

}
