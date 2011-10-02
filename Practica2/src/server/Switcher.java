package server;

import java.util.Hashtable;

import commons.Marshall;
import commons.UnMarshall;

/**
 * Esta clase implementa el gestor de invocaciones
 * @author Sergio Torres
 *
 */
public class Switcher {
	private Hashtable <Integer , Object> objs_ht =  new Hashtable<Integer, Object>();
	private Hashtable <Integer , Skeleton> ints_ht = new Hashtable<Integer, Skeleton>();
	/**
	 * Para registrar un objeto se dabe dar su id y una referencia java al objeto.
	 * Ambos se guardan en una tabla hash
	 * @param key
	 * @param obj
	 */
	public void addObject (int key, Object obj){
		objs_ht.put(new Integer(key), obj);
	}
	/**
	 * Para registrar una interface se dabe dar su id y una referencia java al objeto.
	 * @param key
	 * @param s
	 */
	public void addInterface (int key, Skeleton s){
		ints_ht.put(new Integer(key), s);
	}
	/**
	 * Devuelve el objeto asociado al identificador
	 * @param key
	 * @return
	 */
	public Object getObject (int key){
		return objs_ht.get(key);
	}
	/**
	 * Devuelve el interface asociado al identificador
	 * @param key
	 * @return
	 */
	public Skeleton getInterface (int key){
		return (Skeleton) ints_ht.get(key);
	}
	/**
	 * Procesa cada petición que recibe el servidor. Para ello obtiene el id. de objeto y el de esqueleto.
	 * @param unmar
	 * @param mar
	 */
	public void procesar ( UnMarshall unmar ,Marshall mar){
		int objectID = unmar.getInt();
		int interfaceID = unmar.getInt();
		System.out.println("Se va a procesar el objeto: " + objectID );
		System.out.println("Skeleto encargado:  " + interfaceID );
		Object obj = getObject(objectID);
		Skeleton sk = getInterface(interfaceID);
		sk.process(unmar, mar, obj);
		mar.putInt(0); // se añade un cero para indicar el final de la comunicación.
	}
	
	public void setObjs_ht(Hashtable <Integer, Object>  objs_ht) {
		this.objs_ht = objs_ht;
	}
	public Hashtable<Integer, Object> getObjs_ht() {
		return objs_ht;
	}
	public void setInts_ht(Hashtable<Integer, Skeleton> ints_ht) {
		this.ints_ht = ints_ht;
	}
	public Hashtable<Integer, Skeleton> getInts_ht() {
		return ints_ht;
	}
}
