package client;

import commons.*;

/**
 * Stub que implementa en el lado del cliente las operaciones de objetos de claseB
 * @author Sergio Torres
 *
 */
public class StubB extends StubA implements IOperations{
	public StubB(){
		super();
	}
	public StubB(String host,int port, int idObjeto, int idSkeleton){
		super(host,port,idObjeto,idSkeleton);
	}
	public int resta(String op1, String op2) {
		connect();
		mar.putInt(idObjeto);
		mar.putInt(idSkeleton);
		mar.putInt(4); 			// Resta tiene asignado el id de operación 4
		mar.putString(op1);
		mar.putString(op2);
		int res = unmar.getInt();
		disconnect();		
		return res;		
	}
	public int suma(String op1, String op2) {
		connect();
		mar.putInt(idObjeto);
		mar.putInt(idSkeleton);
		mar.putInt(3);		 // Suma tiene asignado el id de operación 3
		mar.putString(op1);
		mar.putString(op2);		
		int res = unmar.getInt();		
		disconnect();		
		return res;
	}
}
