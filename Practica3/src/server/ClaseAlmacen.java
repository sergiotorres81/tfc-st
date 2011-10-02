package server;

import java.util.Hashtable;

import commons.IAlamacen;
import commons.IClaseA;
import commons.IClaseB;
import commons.IClaseHola;
import commons.ORBObjectImpl;
import commons.ObjectRef;
/**
 * Contiene la implementación de la interfaz IAlmacen.
 * Esta implementación se utilizará para dar soporte a los objetos servidores de esta interfaz.
 * @author Sergio Torres
 *
 */
public class ClaseAlmacen extends ORBObjectImpl implements IAlamacen{
	
	public ClaseAlmacen(ObjectRef ref) {
		super(ref);
	}
	/**
	 * Base de datos para guardar los objetos a partir de su identificador
	 */
	private Hashtable<Integer, ObjectRef> bbddObjetos = new Hashtable<Integer, ObjectRef>();
	/**
	 * Base de datos para guardar el nombre de un objeto y su identificador en la tabla bbddObjetos
	 */
	private Hashtable<String, Integer> bbddNombres = new Hashtable<String, Integer>();

	@Override
	public void guardarHola(IClaseHola ho) {
		ClaseHola hola = (ClaseHola) ho;
		bbddObjetos.put(hola.getRef().getObid(), hola.getRef()); // Se utiliza el id. del objeto como clave.
		bbddNombres.put("hola", hola.getRef().getObid()); // En una tabla guardamos el tipo del objeto y su id.
	}
	@Override
	public IClaseHola obtieneHola() {
		int idHola = bbddNombres.get("hola");
		ObjectRef refHola = bbddObjetos.get(idHola);
		IClaseHola ho = new ClaseHola(refHola);
		return ho;
	}
	@Override
	public void guardarObjetoA(IClaseA oa) {
		ClaseA objA = (ClaseA) oa;
		bbddNombres.put("claseA", objA.getRef().getObid()); 
		bbddObjetos.put(objA.getRef().getIid(), objA.getRef()); // Se utiliza el id. del objeto como clave.
	}
	@Override
	public IClaseA obtieneObjetoA() {
		int idObjetoA = bbddNombres.get("claseA");
		ObjectRef refA = bbddObjetos.get(idObjetoA);
		IClaseA oa = new ClaseA(refA);
		return oa;
	}
	@Override
	public void guardarObjetoB(IClaseB ob) {
		ClaseB objB = (ClaseB) ob;
		bbddObjetos.put(objB.getRef().getIid(), objB.getRef()); // Se utiliza el id. del objeto como clave.
		bbddNombres.put("claseB", objB.getRef().getObid());
	}
	@Override
	public IClaseB obtieneObjetoB() {
		int idObjetoB = bbddNombres.get("claseB"); 
		ObjectRef refB = bbddObjetos.get(idObjetoB);;
		IClaseB ob = new ClaseB(refB);
		return ob;
	}

}
