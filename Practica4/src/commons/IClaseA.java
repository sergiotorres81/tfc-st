package commons;

/**
 * Contiene la interfaz de la clase ClaseA.
 * Esta interfaz deberás ser implementada por las clases stub y servidora
 * @author Sergio 
 *
 */
public interface IClaseA extends ORBObject{
	/**
	 * Se asocia un valor entero a una cadena.
	 * En caso de que la cadena ya tenga asociado un valor, asocia la cadena al nuevo valor.
	 * @param key Clave
	 * @param value Valor que asociamos a la clave.
	 */
	public void asociar(String key, int value);
	/**
	 * Se recibe el valor entero asociado a una cadena.
	 * Si la cadena no existe se recibe -1
	 * @param key 
	 * @return Valor asociado a la cadena.
	 */
	public int obtener (String key);
}
