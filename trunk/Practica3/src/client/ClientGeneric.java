package client;

import commons.IAlamacen;
import commons.IClaseA;
import commons.IClaseB;
import commons.IClaseHola;
import commons.ObjectRef;
/**
 * Cliente que hace uso intensivo de referencias remotas
 * 
 * @author Sergio Torres
 *
 */
public class ClientGeneric {


	public static void main(String[] args) {
		// Se instancia el almacén
		ObjectRef refAlmacen = new ObjectRef("localhost", 8080, 4, 4);  // Las referencias de momento: "a fuego"
		ObjectRef refHola= new ObjectRef("localhost", 8080, 3, 3);		
		ObjectRef refA = new ObjectRef("localhost", 8080, 1, 1);
		ObjectRef refB = new ObjectRef("localhost", 8080, 2, 2);
		IAlamacen stAlmacen  = new StubAlmacen(refAlmacen);
		// Se construyen los objetos que se van a almacenar
		IClaseHola ho = new StubHola(refHola);
		IClaseA oa = new StubA(refA);
		IClaseB ob = new StubB(refB);
		// HOLA
		stAlmacen.guardarHola(ho); // Se guarda el hola
		IClaseHola nuevaHola = (StubHola)stAlmacen.obtieneHola();// Creamos un nuevo hola
		String msm = "no va bien!"; // Lo necesitamos para recoger el mensaje
		msm = nuevaHola.decirHola();
		System.out.println(msm);
		// OBJETO A
		stAlmacen.guardarObjetoA(oa); // Se guarda el objeto de clase A
		IClaseA objetoA = (StubA)stAlmacen.obtieneObjetoA();
		objetoA.asociar("prus", 2);
		System.out.println("Se ha asociado prus a -->" + objetoA.obtener("prus"));
		//OBJETO B
		stAlmacen.guardarObjetoB(ob);
		IClaseB objetoB = (StubB)stAlmacen.obtieneObjetoB();
		objetoB.asociar("prueba1", 22);
		objetoB.asociar("prueba2", 11);
		System.out.println("La suma de prueba1 y prueba2 es -->" + objetoB.suma("prueba1", "prueba2"));
	}
}
