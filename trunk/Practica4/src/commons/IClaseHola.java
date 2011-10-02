package commons;
/**
 * Contiene la interfaz de la clase ClaseHola
 * Esta interfaz deberá ser implementada por las clases stub y servidora asociadas a ella.
 * @author Sergio Torres
 *
 */
public interface IClaseHola extends ORBObject {
	/**
	 * Devuelve una cadena con un mensaje
	 * @return mensaje HolaMundo!
	 */
	public String decirHola();
}
