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
	 * @param op1 primera cadena de caracteres
	 * @param op2 segunda cadena de caracteres
	 * @return suma de op1 y op2
	 */
	public int suma (String op1, String op2);
	/**
	 * Se devuelve la diferencia entre los valores enteros asociados a las dos cadenas pasadas como argumentos
	 * @param op1 primera cadena de caracteres
	 * @param op2 segunda cadena de caracteres
	 * @return entero con la diferencia entre op1 y op2
	 */
	public int resta (String op1, String op2);
}
