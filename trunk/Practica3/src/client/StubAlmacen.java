package client;

import commons.IAlamacen;
import commons.IClaseA;
import commons.IClaseB;
import commons.IClaseHola;
import commons.Invocation;
import commons.ORBObjectImpl;
import commons.ObjectRef;
/**
 * Stub que implementa en el lado del cliente las operaciones de objetos de clase Almacen
 * 
 * @author Sergio Torres
 *
 */
public class StubAlmacen extends ORBObjectImpl implements IAlamacen{
	public StubAlmacen(ObjectRef ref){
		super(ref);
	}
	@Override
	public void guardarHola(IClaseHola ho) {
		StubHola ho1 = (StubHola) ho;
		Invocation in = ref.newInvocation();
		in.putInt(1); // Operación 1
		in.putObject(ho1.getRef());
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
	public IClaseHola obtieneHola() {
		IClaseHola hola;
		Invocation in = ref.newInvocation();
		in.putInt(2); // El id. de operación es 2
		in.send();
		ObjectRef ref = null;
		ref =  in.getObj();
		hola = new StubHola(ref);
		int errorCode = -1;
		errorCode = in.getInt(); // Se utiliza getInt en lugar de wait para poder recibir un posible código de error
		if (errorCode != 0){
			System.out.println("No se ha recibido el fin de la conexión");
			System.out.println("Recibido: " + errorCode);
			System.exit(errorCode);
		}
		return hola;
	}
	@Override
	public IClaseA obtieneObjetoA() {
		IClaseA objA;
		Invocation in = ref.newInvocation();
		in.putInt(4); // El id. operación para obtener un objeto IClaseA es 4
		in.send();
		ObjectRef ref = null;
		ref =  in.getObj();
		objA = new StubA(ref);
		System.out.println("Referencia obtenida del servidor -- > " + ref.getHost());
		int errorCode = -1;
		errorCode = in.getInt(); // Se utiliza getInt en lugar de wait para poder recibir un posible código de error
		if (errorCode != 0){
			System.out.println("No se ha recibido el fin de la conexión");
			System.out.println("Recibido: " + errorCode);
			System.exit(errorCode);
		}
		return objA;
	}
	@Override
	public IClaseB obtieneObjetoB() {
		IClaseB objB;
		Invocation in = ref.newInvocation();
		in.putInt(6); // El id. operación para obtener un objeto IClaseB es 6
		in.send();
		ObjectRef ref = null;
		ref =  in.getObj();
		objB = new StubB(ref);
		int errorCode = -1;
		errorCode = in.getInt(); // Se utiliza getInt en lugar de wait para poder recibir un posible código de error
		if (errorCode != 0){
			System.out.println("No se ha recibido el fin de la conexión");
			System.out.println("Recibido: " + errorCode);
			System.exit(errorCode);
		}
		return objB;
	}
	@Override
	public void guardarObjetoA(IClaseA oa) {
		StubA objA = (StubA) oa;
		Invocation in = ref.newInvocation();
		in.putInt(3); // Operación 3: guardar un objeto de tipo IClaseA
		in.putObject(objA.getRef());
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
	public void guardarObjetoB(IClaseB ob) {
		StubB objB = (StubB) ob;
		Invocation in = ref.newInvocation();
		in.putInt(5); // Operación 5: guardar un objeto de tipo IClaseA
		in.putObject(objB.getRef());
		in.send();
		int errorCode = -1;
		errorCode = in.getInt(); // Se utiliza getInt en lugar de wait para poder recibir un posible código de error
		if (errorCode != 0){
			System.out.println("No se ha recibido el fin de la conexión");
			System.out.println("Recibido: " + errorCode);
			System.exit(errorCode);
		}
	}
}
