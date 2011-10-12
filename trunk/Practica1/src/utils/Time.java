package utils;
/**
 * Clase para controlar las diferencias de tiempo entre dos momentos de ejecución
 * @author Sergio Torres
 *
 */
public class Time {
	private long startTime;
	public Time() {
		super();
	}
	/**
	 * Inicia la cuenta de tiempo
	 * @return Instante de tiempo actual
	 */
	public long startCount(){
		return this.startTime = System.currentTimeMillis();
	}
	/**
	 * Finaliza la cuenta de tiempo
	 * @return Diferencia de tiempo desde que se invocó a startCount
	 */
	public long finalTime(){
		return (System.currentTimeMillis() - startTime);
	}
}
