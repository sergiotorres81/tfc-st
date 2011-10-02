package server;

import commons.*;


/**
 * Esta clase soporta la interfaz de IClaseHola
 * También mantiene el estado de su propia referencia en el servidor.
 * @author Sergio
 *
 */
public class ClaseHola extends ORBObjectImpl implements IClaseHola{
	public ClaseHola(){
		super();
	}
	public ClaseHola (ObjectRef ref){
		super (ref);
	}
	@Override
	public String decirHola() {
		return "holaMundo de la práctica 4";
	}

}
