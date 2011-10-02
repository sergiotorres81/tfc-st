package server;

import java.util.Hashtable;

import commons.IClaseA;
import commons.ORBObjectImpl;
import commons.ObjectRef;

/**
 * Contiene la implementación de la interfaz IClaseA.
 * Esta implementación se utilizará para dar soporte a los objetos servidores de esta interfaz.
 * @author Sergio Torres
 *
 */
public class ClaseA extends ORBObjectImpl implements IClaseA{
	public ClaseA(){
		super();
	}
	public ClaseA(ObjectRef ref) {
		super(ref);
	}
	
	protected Hashtable  <String, Integer> ht = new Hashtable<String, Integer>();
	@Override
	public void asociar(String key, int value) {
		ht.put(key, value);
	}

	@Override
	public int obtener(String key) {
		int aux = -1;
		if (ht.containsKey(key)){
			aux = ht.get(key);
		}
		return aux;
	}

	public void setHt(Hashtable  <String, Integer> ht) {
		this.ht = ht;
	}

	public Hashtable  <String, Integer> getHt() {
		return ht;
	}

}
