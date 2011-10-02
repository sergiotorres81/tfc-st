package commons;

/**
 * Esta clase es la base de todos los stubs, manteniendo la referencia
 * del objeto que está representando.
 * @author Sergio Torres
 *
 */
public class ORBObjectImpl implements ORBObject{
	protected ObjectRef ref;
	public ORBObjectImpl(){ref= null;}
	public ORBObjectImpl (ObjectRef ref){
		this.ref = ref;
	}
	/**
	 * Devuelve la referencia al objeto
	 * @return
	 */
	public ObjectRef getRef(){
		return this.ref;
	}
	public void setRef(ObjectRef ref) {
		this.ref = ref;
	}
}
