package commons;

/**
 * Contiene la interfaz de la clase ObjetoA.
 * Esta interfaz deberás ser implementada por las clases stub y servidora
 * @author Sergio Torres
 *
 */
public interface IClaseA {
	/**
	 * Se asocia un valor entero a una cadena.
	 * En caso de que la cadena ya tenga asociado un valor, asocia la cadena al nuevo valor.
	 * @param key Clave a la que se asocia la cadena
	 * @param value Valor que asociamos a la clave.
	 */
	public void asociar(String key, int value);
	/**
	 * Se recibe el valor entero asociado a una cadena.
	 * Si la cadena no existe se recibe -1
	 * @param key Clave para recuperar la cadena
	 * @return Valor asociado a la cadena.
	 */
	public int obtener (String key);
}
