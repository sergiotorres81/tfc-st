package commons;
/**
 * Contiene la interfaz de la clase ObjetoB.
 * Esta interfaz deberá ser implementada por las clases stub y servidora asociadas a ella.
 * @author Sergio Torres
 *
 */
public interface IAlamacen extends ORBObject{
	/**
	 * Guarda una referencia a un objeto de ClaseHola
	 * @param ho referencia que se va a guardar
	 */
	public void guardarHola(IClaseHola ho);
	/**
	 * Guarda una referencia a un objeto de ClaseA
	 * @param ho referencia que se va a guardar
	 */
	public void guardarObjetoA(IClaseA oa);
	/**
	 * Guarda una referencia a un objeto de ClaseB
	 * @param ho referencia que se va a guardar
	 */
	public void guardarObjetoB(IClaseB ob);
	/**
	 * Devuelve una referencia remota  para un objeto de ClaseHola
	 * @return referencia remota de un obtejo de ClaseHola
	 */
	public IClaseHola obtieneHola();
	/**
	 * Devuelve una referencia remota  para un objeto de ClaseA
	 * @return referencia remota de un obtejo de ClaseA
	 */
	public IClaseA obtieneObjetoA();
	/**
	 * Devuelve una referencia remota  para un objeto de ClaseB
	 * @return referencia remota de un obtejo de ClaseB
	 */
	public IClaseB obtieneObjetoB();
}
