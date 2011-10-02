package server;

import commons.*;
/**
 * Una posible opción de implementación de Skeleton para tratar las
 * peticiones a objetos ClaseHola
 * @author Sergio Torres
 *
 */
public class SkeletonHola implements Skeleton{

	@Override
	public void process(UnMarshall unmar, Marshall mar, Object obj) {
		ClaseHola hola = (ClaseHola) obj; // Hay que hacer un cast del objeto genérico que nos pasan
		int operationID = unmar.getInt();
		switch (operationID) {
		case 1:
			mar.putString(hola.decirHola());
			break;
		default:
			break;
		}
	}
}
