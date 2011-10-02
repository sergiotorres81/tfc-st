package client;

import commons.IAlamacen;
import commons.IClaseHola;
import commons.ObjectRef;

/**
 * Cliente que utiliza referencias remotas.
 * 
 * @author Sergio Torres
 *
 */
public class ClientHola {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ObjectRef refAlmacen = new ObjectRef("localhost", 8080, 4, 4);
		IAlamacen almacen = new StubAlmacen(refAlmacen);
		
		IClaseHola nuevaHola = (StubHola)almacen.obtieneHola();// Creamos un nuevo hola
		String msm = "no va bien!"; // Lo necesitamos para recoger el mensaje
		msm = nuevaHola.decirHola();
		System.out.println(msm);
	}

}
