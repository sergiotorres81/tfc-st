package client;

import commons.*;
/**
 * Stub que implementa en el lado del cliente las operaciones de objetos de ClaseB
 * 
 * @author Sergio Torres
 *
 */
public class StubB extends StubA implements IClaseB{
	public StubB(ObjectRef ref){
		super(ref);
	}
	@Override
	public int resta(String op1, String op2) {
		Invocation in = ref.newInvocation();		
		in.putInt(4);
		in.putString(op1);
		in.putString(op2);
		int res = in.getInt();
		int errorCode = -1; 
		errorCode = in.getInt();
		if (errorCode != 0){
			System.out.println("No se ha recibido el fin de la conexión");
			System.out.println("Recibido: " + errorCode);
			System.exit(errorCode);
		}
		return res;		
	}

	@Override
	public int suma(String op1, String op2) {
		Invocation in = ref.newInvocation();
		in.putInt(3); // Suma tiene asignado el id de operación 3
		in.putString(op1);
		in.putString(op2);
		int res = in.getInt();		
		int errorCode = -1; 
		errorCode = in.getInt();
		if (errorCode != 0){
			System.out.println("No se ha recibido el fin de la conexión");
			System.out.println("Recibido: " + errorCode);
			System.exit(errorCode);
		}
		return res;
	}
}
