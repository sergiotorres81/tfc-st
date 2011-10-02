package server;

import commons.Marshall;
import commons.ORBObjectImpl;
import commons.UnMarshall;
/**
 * Una posible opción de implementación de Skeleton para tratar las
 * peticiones a objetos NameServer
 * @author Sergio Torres
 *
 */
public class SkeletonNameServer implements Skeleton{

	@Override
	public void process(UnMarshall unmar, Marshall mar, Object obj) {
		CNameServer ns = (CNameServer) obj; // Hay que hacer un cast del objeto genérico que nos pasan
		int operationID = unmar.getInt();
		switch (operationID) {
		case 1: // Registra un objeto
			ns.registrer(unmar.getString(), new ORBObjectImpl(unmar.getObj()));
			unmar.getInt();
			break;
		case 2: // Devuelve la referencia
			ORBObjectImpl orbObj = (ORBObjectImpl) ns.find(unmar.getString());
			unmar.getInt(); // Para recoger el send() del cliente
			mar.putObj(orbObj.getRef());
			break;			
		default:
			break;
		}
		
	}

}
