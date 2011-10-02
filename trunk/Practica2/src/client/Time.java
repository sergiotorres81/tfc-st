package client;
/**
 * Clase para controlar las diferencias de tiempo entre dos momentos de ejecución
 * @author Sergio Torres
 *
 */
public class Time {
	private long tiempoInicial;
	private long tiempoTotal;
	public Time() {
		super();
	}
	/**
	 * Inicia la cuenta de tiempo
	 * @return Instante de tiempo actual
	 */
	public long startCount(){
		return this.tiempoInicial = System.currentTimeMillis();
	}
	/**
	 * Finaliza la cuenta de tiempo
	 * @return Diferencia de tiempo desde que se invocó a startCount
	 */
	public long finalTime(){
		this.tiempoTotal = System.currentTimeMillis() - tiempoInicial;
		return this.tiempoTotal;
	}
}
