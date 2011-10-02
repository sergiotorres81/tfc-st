package client;

import commons.*;
/**
 * Stub que implementa en el lado del cliente las operaciones de objetos de ClaseHola
 * 
 * @author Sergio Torres
 *
 */
public class StubHola extends ORBObjectImpl implements IClaseHola{
	public StubHola(ObjectRef ref){
		super(ref);
	}
	public String decirHola() {
		String s = "prus";
		Invocation in = ref.newInvocation();
		in.putInt(1);
		in.send();
		s = in.getString();
		int errorCode = -1; 
		errorCode = in.getInt();
		if (errorCode != 0){
			System.out.println("No se ha recibido el fin de la conexión");
			System.out.println("Recibido: " + errorCode);
			System.exit(errorCode);
		}
		return s;
	}
}
