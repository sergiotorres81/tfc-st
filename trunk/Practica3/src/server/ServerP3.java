package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import commons.IAlamacen;
import commons.IClaseA;
import commons.IClaseB;
import commons.IClaseHola;
import commons.ObjectRef;
/**
 * Programa servidor
 * @author Sergio Torres
 *
 */
public class ServerP3 {

	/**
	 * @param args
	 * @author Sergio
	 */
	public static void main(String[] args) {
		Switcher sw = new Switcher();		
		int port = 8080;
		String host = "localhost";
		// Se crean los objetos y se registran en el switcher
		ObjectRef refA = new ObjectRef(host, port, 1, 1);
		ObjectRef refB = new ObjectRef(host, port, 2, 2);
		ObjectRef refHola = new ObjectRef(host, port, 3, 3);
		ObjectRef refAlmacen = new ObjectRef(host, port, 4, 4);
		// Los objetos ahora se crean con su referencia para poder devolverla
		IClaseA oa = new ClaseA(refA);
		IClaseB ob = new ClaseB(refB);
		IClaseHola chola = new ClaseHola(refHola);
		IAlamacen almacen = new ClaseAlmacen(refAlmacen);
		// Se instancian también los esqueletos
		SkeletonA ska = new SkeletonA();		
		SkeletonB skb = new SkeletonB();
		SkeletonHola skhola= new SkeletonHola();
		SkeletonAlmacen skalmacen = new SkeletonAlmacen();
		// Se guardan las referencias en el almacén
		almacen.guardarObjetoA(oa);
		almacen.guardarObjetoB(ob);
		almacen.guardarHola(chola);
		// Se instancia la conexión del servidor
		ServerSocket ss;
		Socket so;
		// Se añaden manualmente los objetos al switcher
		sw.addInterface(1, ska);
		sw.addObject(1, oa);
		sw.addInterface(2, skb);
		sw.addObject(2, ob);
		sw.addInterface(3, skhola);
		sw.addObject(3, chola);
		sw.addInterface(4, skalmacen);
		sw.addObject(4, almacen);
		try {
			ss = new ServerSocket(port);
			System.out.println("ServerP3 TCP/MT en puerto " + port );
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
