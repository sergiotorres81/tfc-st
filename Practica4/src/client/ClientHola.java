package client;

import commons.IClaseHola;
import commons.NameServer;
import commons.ORBObjectImpl;
import commons.ObjectRef;
/**
 * 
 * 
 * @author Sergio Torres
 *
 */
public class ClientHola {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ObjectRef refNS = new ObjectRef("localhost", 8080, 1, 1);
		NameServer ns = new StubNameServer(refNS);
		ORBObjectImpl objHola = (ORBObjectImpl)ns.find("hola");
		IClaseHola objetoHola = new StubHola(objHola.getRef());
		System.out.println("Voy a decir algo: " + objetoHola.decirHola());
	}

}
