package client;

import java.util.ArrayList;

import commons.IClaseHola;
import commons.NameServer;
import commons.ORBObjectImpl;
import commons.ObjectRef;
/**
 * Cliente que hace uso del servidor de nombres para localizar una referencia remota
 * 
 * @author Sergio Torres
 *
 */
public class ClientReference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ObjectRef refNS = new ObjectRef("localhost", 8080, 1, 1);
		NameServer ns = new StubNameServer(refNS);
		ArrayList<String> listaServicios = ns.listInitialServices();
		System.out.println( ns.listInitialServices() );
		ORBObjectImpl objHola = (ORBObjectImpl)ns.find(listaServicios.get(0));
		IClaseHola objetoHola = new StubHola(objHola.getRef());
		System.out.println("Uso servicio--> " +  listaServicios.get(0) + " : "  + objetoHola.decirHola());

	}

}
