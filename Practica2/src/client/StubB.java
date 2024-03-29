package client;

import utils.IOperations;

/**
 * Stub que implementa en el lado del cliente las operaciones de objetos de
 * claseB
 * 
 * @author Sergio Torres
 * 
 */
public class StubB extends StubA implements IOperations {
	public StubB() {
		super();
	}

	public StubB(String host, int port, int idObjeto, int idSkeleton) {
		super(host, port, idObjeto, idSkeleton);
	}

	public int subtract(String op1, String op2) {
		connect();
		mar.putInt(objectId);
		mar.putInt(skeletonId);
		mar.putInt(4); // Resta tiene asignado el id de operación 4
		mar.putString(op1);
		mar.putString(op2);
		int res = unmar.getInt();
		disconnect();
		return res;
	}

	public int add(String op1, String op2) {
		connect();
		mar.putInt(objectId);
		mar.putInt(skeletonId);
		mar.putInt(3); // Suma tiene asignado el id de operación 3
		mar.putString(op1);
		mar.putString(op2);
		int res = unmar.getInt();
		disconnect();
		return res;
	}
}
