package client;

import commons.*;

/**
 * Stub que implementa en el lado del cliente las operaciones de objetos de ClaseA
 * 
 * @author Sergio Torres
 *
 */
public class StubA extends ORBObjectImpl implements IClaseA {
	
	public StubA(ObjectRef ref){
		super(ref);
	}

	@Override
	public void asociar(String key, int value) {
		Invocation in = ref.newInvocation();
		in.putInt(1); // Asociar es la operación 1
		in.putString(key);
		in.putInt(value);
		in.send();
		int errorCode = -1;
		errorCode = in.getInt(); // Se utiliza getInt en lugar de wait para poder recibir un posible código de error
		if (errorCode != 0){
			System.out.println("No se ha recibido el fin de la conexión");
			System.out.println("Recibido: " + errorCode);
			System.exit(errorCode);
		}
	}

	@Override
	public int obtener(String key) {
		Invocation in = ref.newInvocation();
		in.putInt(2);
		in.putString(key);
		int res = in.getInt(); // Aquí se recoge el resultado
		int errorCode = -1;
		errorCode = in.getInt(); // Se utiliza getInt en lugar de wait para poder recibir un posible código de error
		if (errorCode != 0){
			System.out.println("No se ha recibido el fin de la conexión");
			System.out.println("Recibido: " + errorCode);
			System.exit(errorCode);
		}
		return res;
	}
}
