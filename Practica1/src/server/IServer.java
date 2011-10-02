package server;
/**
 * Exporta los métodos que deberán implementar los distintos tipos de servidores
 * @author Sergio Torres
 *
 */
public interface IServer {
	/**
	 * Pone al servidor a la escucha de un puerto
	 */
	public void accept();
	/**
	 * Recibe un byte del cliente como entero, lo procesa y lo devuelve al cliente.
	 */
	public void handleByte();
	/**
	 * Cierra la conexión
	 */
	public void close();
}
