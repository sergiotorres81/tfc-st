package commons;

import java.util.ArrayList;

/**
 * Da soporte para poder registrar y encontrar objetos en el servidor de nombres
 * @author Sergio Torres
 *
 */
public interface NameServer extends ORBObject{
	/**
	 * Registra un objeto en el servidor de nombres
	 * @param name Nombre del objeto (Key)
	 * @param obj Referencia al objeto que se quiere registrar
	 */
	public void registrer(String name, ORBObject obj);
	/**
	 * Encuntra la referencia a un objeto y la devuelve.
	 * @param name Nombre del objeto
	 * @return ORBOject con la referencia del objeto que buscamos.
	 */
	public ORBObject find(String name);
	/**
	 * Obtiene un array con todos los nombres de los objetos básicos que proporciona este servidor de nombres
	 * @return array con la información
	 */
	public ArrayList<String> listInitialServices();
}
