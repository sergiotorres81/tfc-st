package serverName;

import java.util.ArrayList;
import java.util.HashMap;

import commons.NameServer;
import commons.ORBObject;
import commons.ORBObjectImpl;
import commons.ObjectRef;
/**
 * Contiene la implementación de la interfaz NameServer.
 * Esta implementación se utilizará para dar soporte a los objetos servidores de esta interfaz.
 * @author Sergio Torres
 *
 */
public class CNameServer extends ORBObjectImpl implements NameServer{
	private HashMap<String, ORBObject> bbdd_objetos = new HashMap<String, ORBObject>();
	private ArrayList<String> bbdd_nombres = new ArrayList<String>();
	public CNameServer(ObjectRef ref) {
		super(ref);
	}

	@Override
	public ORBObject find(String name) {
		return this.bbdd_objetos.get(name);
	}

	@Override
	public void registrer(String name, ORBObject obj) {
		this.bbdd_objetos.put(name, obj);
		this.bbdd_nombres.add(name);
	}

	@Override
	public ArrayList<String> listInitialServices() {		
		return bbdd_nombres;
	}
	

}
