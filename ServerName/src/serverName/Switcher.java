package serverName;

import java.util.Hashtable;

import commons.Marshall;
import commons.ORBObject;
import commons.ORBObjectImpl;
import commons.ObjectRef;
import commons.UnMarshall;

/**
 * Esta clase implementa el gestor de invocaciones
 * @author Sergio Torres
 *
 */
public class Switcher {
	private Hashtable <Integer , Object> objs_ht =  new Hashtable<Integer, Object>();
	private Hashtable <Integer , Skeleton> ints_ht = new Hashtable<Integer, Skeleton>();
	private int id_new_object = 2; // Se inicializa a 2 porque el swicher reserva el 1 para el servidor de nombres
	private int port = 8080;
	private String host = "localhost";
	/**
	 * Si no se quiere añadir directamente un objeto servidor de nombres usamos este contructor.
	 */
	public Switcher(){}
	/**
	 * Se le pasa el host donde está alojado y el puerto dónde recibe el servidor las peticines.
	 * También se añade un servidor de nombres interno con Id = 1
	 */
	public Switcher(String host, int port) {
		super();
		this.port = port;
		this.host = host;
		// Se añade manualmente el objeto servidor de nombres con el id = 1
		this.addInterface(1, new SkeletonNameServer());
		this.addObject(1,new CNameServer(new ObjectRef(host, port, 1, 1)));
	}
	/**
	 * Constructor que añade también el objeto servidor de nombres
	 * @param host
	 * @param port
	 * @param idSN
	 */
	public Switcher (String host, int port, int idSN){
		super();
		this.port = port;
		this.host = host;
		this.addInterface(idSN, new SkeletonNameServer());
		this.addObject(idSN,new CNameServer(new ObjectRef(host, port, idSN, idSN)));
	}
	/**
	 * Registra un objeto en el switcher
	 * @param obj Objeto que se quiere registrar
	 * @param type Interfaz del objeto
	 * @return ORBObject del objeto que se registra
	 */
	public ORBObject addObject(Object obj, int type){
		int id = id_new_object++;
		this.objs_ht.put(id, obj);
		ObjectRef ref = new ObjectRef(this.host,this.port,id,type);
		ORBObjectImpl obj_ref = new ORBObjectImpl(ref);
		return obj_ref;
	}
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
	 * @param key Clave con la que se registra la interfaz
	 * @param s Esqueleto que procesará las peticiones
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
	 * Desmultiplexa un mensaje y se lo envía al esqueleto adecuado con el objeto adecuado
	 * @param unmar
	 * @param mar
	 */
	public void procesar ( UnMarshall unmar ,Marshall mar){
		int objectID = unmar.getInt();
		int interfaceID = unmar.getInt();
		System.out.println("Switcher recibe:" + objectID + interfaceID);
		Object obj = getObject(objectID);
		Skeleton sk = getInterface(interfaceID);
		sk.process(unmar, mar, obj);
		mar.putInt(0);
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
