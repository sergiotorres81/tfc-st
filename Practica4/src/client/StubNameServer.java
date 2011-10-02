package client;

import java.util.ArrayList;

import commons.Invocation;
import commons.NameServer;
import commons.ORBObject;
import commons.ORBObjectImpl;
import commons.ObjectRef;
/**
 * Stub que implementa en el lado del cliente las operaciones de objetos de clase NameServer
 * 
 * @author Sergio Torres
 *
 */
public class StubNameServer extends ORBObjectImpl implements NameServer {

	public StubNameServer(ObjectRef ref) {
		super(ref);
	}

	@Override
	public ORBObject find(String name) {
		Invocation in = ref.newInvocation();
		in.putInt(2); // Encontrar es la operación 2
		in.putString(name);
		in.send();
		ORBObjectImpl orb = new ORBObjectImpl(in.getObj());
		return orb;
	}

	@Override
	public void registrer(String name, ORBObject obj) {
		Invocation in = ref.newInvocation();
		in.putInt(1); // Registrar es la operación 1
		in.putString(name);
		ORBObjectImpl orbObj = (ORBObjectImpl) obj;
		in.putObject(orbObj.getRef());
		in.send();
		int errorCode = -1;
		errorCode = in.getInt();  // Para recibir el final de conexión
		if (errorCode != 0){
			System.out.println("No se ha recibido el fin de la conexión");
			System.out.println("Recibido: " + errorCode);
			System.exit(errorCode);
		}
	}

	@Override
	public ArrayList<String> listInitialServices() {
		Invocation in = ref.newInvocation();
		in.putInt(3); // Obtener la lista de servicios es la operación 3
		in.send();
		ArrayList<String> lis = in.getArrayString();
		int errorCode = -1;
		errorCode = in.getInt();  // Para recibir el final de conexión
		if (errorCode != 0){
			System.out.println("No se ha recibido el fin de la conexión");
			System.out.println("Recibido: " + errorCode);
			System.exit(errorCode);
		}
		return lis;
	}

}
