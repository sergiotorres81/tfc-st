package server;

import commons.*;
/**
 * Una posible opción de implementación de Skeleton para tratar las
 * peticiones de objetos ClaseHola
 * @author Sergio Torres
 *
 */
public class SkeletonHola implements Skeleton{

	@Override
	public void process(UnMarshall unmar, Marshall mar, Object obj) {
		ClaseHola hola = (ClaseHola) obj; // Hay que hacer un cast del objeto genérico que nos pasan
		int operationID = unmar.getInt();
		int fin = -1;
		switch (operationID) {
		case 1:
			fin = unmar.getInt();
			mar.putString(hola.decirHola());
			if (fin!=0){
				System.out.println("Error -->" + fin);
			}
			break;
		default:
			break;
		}
	}
}
