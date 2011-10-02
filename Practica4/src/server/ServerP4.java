package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import commons.IClaseA;
import commons.IClaseHola;
import commons.NameServer;
import commons.ORBObjectImpl;
import commons.ObjectRef;

import client.StubNameServer;

/**
 * Programa servidor de objetos de la práctica 4
 * 
 * @author Sergio Torres
 *
 */
public class ServerP4 {

	/**
	 * @param args
	 * @author Sergio
	 */
	public static void main(String[] args) {
		int port = 7070;
		String host = "localhost";
		Switcher sw = new Switcher(host,port);	// Aquí se añade ya el nameServer interno de este servidor
		// Hay que dar la referencia del name server dónde registramos los objetos a mano
		ObjectRef refNS = new ObjectRef(host, 8080, 1, 1);
		NameServer NS = new StubNameServer(refNS);
		// Se instancias los esqueletos y se alamcenan en el switcher
		sw.addInterface(3, new SkeletonHola());
		sw.addInterface(6, new SkeletonA());
		// Se instancian los objetos y se registran en el Servidor de nombres
		IClaseHola hola = new ClaseHola();
		ORBObjectImpl orbHola = (ORBObjectImpl)sw.addObject(hola, 3);
		hola = new ClaseHola(orbHola.getRef());
		NS.registrer("hola", hola);
		
		IClaseA objA = new ClaseA();
		ORBObjectImpl orbA = (ORBObjectImpl)sw.addObject(objA, 6);
		objA = new ClaseA(orbA.getRef());
		NS.registrer("claseA", objA );
		
		IClaseHola holita = new ClaseHola();
		ORBObjectImpl orbHolita = (ORBObjectImpl)sw.addObject(holita, 3);
		holita = new ClaseHola(orbHolita.getRef());
		NS.registrer("holita", holita);
		// Se instancia la conexión del servidor
		ServerSocket ss;
		Socket so;
		try {
			ss = new ServerSocket(port);
			System.out.println("ServerP4 TCP/MT en puerto " + port );
			while (true){
				try{
					so = ss.accept();
					System.out.println();
					new Thread(new WorkerMT(sw, so)).start();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
