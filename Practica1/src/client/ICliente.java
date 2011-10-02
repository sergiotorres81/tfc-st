package client;
/**
 * Esta interfaz exporta los métodos que deberán implementar los diferentes clientes
 * @author Sergio Torres 
 *
 */
public interface ICliente {
	/**
	 * Establece una conexion entre el cliente y el servidor
	 * @param host Máquina donde está el servidor
	 * @param port Puerto en el que escucha el servidor
	 */
	public void connect();
	/**
	 * Envía un entero como byte al servidor al que está asociado el socket del cliente
	 * @param b entero que se va a enviar
	 */
	public void sendByte(int b);
	/**
	 * Recibe un byte del servidor y lo transforma en entero
	 * @return b entero que se recibe desde el servidor
	 */
	public int receiveByte();
	/**
	 * Cierra la comunicación con el servidor
	 */
	public void close();
}
