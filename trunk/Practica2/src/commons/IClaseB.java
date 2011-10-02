package commons;
/**
 * Contiene la interfaz de la clase ObjetoB.
 * Esta interfaz deberá ser implementada por las clases stub y servidora asociadas a ella.
 * @author Sergio Torres
 *
 */
public interface IClaseB extends IClaseA{
	/**
	 * Se devuelve la suma de los enteros asociados a las dos cadenas pasadas como argumentos
	 * @param op1 Primer sumando
	 * @param op2 Segundo sumando
	 * @return suma de los parámetros
	 */
	public int suma (String op1, String op2);
	/**
	 * Se devuelve la diferencia entre los valores enteros asociados a las dos cadenas pasadas como argumentos
	 * @param op1 Minuendo
	 * @param op2 Sustraendo
	 * @return diferencia de los parámetros
	 */
	public int resta (String op1, String op2);
}
