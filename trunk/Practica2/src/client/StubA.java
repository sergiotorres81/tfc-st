package client;

import java.net.Socket;

import utils.ILinker;
import utils.Marshall;
import utils.UnMarshall;

/**
 * Stub que implementa en el lado del cliente las operaciones de objetos de
 * Linker
 * 
 * @author Sergio Torres
 * 
 */
public class StubA extends AStub implements ILinker {

	public StubA() {
		super();
	}

	/**
	 * Constructor para indicar dónde está el servidor, su puerto y los
	 * identificadores de objeto en el server.
	 * 
	 * @param host
	 *            Máquina dónde está el servidor
	 * @param port
	 *            número de puerto dónde escucha
	 * @param idObjeto
	 *            Identificador del objeto en el lado del servidor
	 * @param idSkeleton
	 *            Identificador del esqueleto en el lado del servidor
	 */
	public StubA(String host, int port, int objectId, int skeletonId) {
		this.host = host;
		this.port = port;
		this.objectId = objectId;
		this.skeletonId = skeletonId;
	}

	@Override
	public void associate(String key, int value) {
		connect();
		mar.putInt(objectId); // Id. del objeto en el lado del servidor
		mar.putInt(skeletonId); // Id. del esqueleto en el lado del servidor
		mar.putInt(1); // Asociar tiene asignado el id de operación 1
		mar.putString(key); // Dato
		mar.putInt(value); // Dato
		@SuppressWarnings("unused")
		int fin = unmar.getInt(); // Recogemos el cierre de la conexión
		disconnect(); // Desconectamos
	}

	@Override
	public int obtener(String key) {
		connect();
		mar.putInt(objectId);
		mar.putInt(skeletonId);
		mar.putInt(2);
		mar.putString(key);
		int res = unmar.getInt();
		@SuppressWarnings("unused")
		int fin = unmar.getInt();
		disconnect();
		return res;
	}

	/**
	 * Crea el socket y lo asocia con el servidor
	 */
	protected void connect() {
		try {
			so = new Socket(host, port);
			mar = new Marshall(so.getOutputStream());
			unmar = new UnMarshall(so.getInputStream());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out
					.println("No se ha podido establecer la comunicación correctamente");
			System.exit(1);
		}
	}

	/**
	 * Cierra la comunicación con el servidor
	 */
	protected void disconnect() {
		try {
			so.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al cerrar la comunicación");
			System.exit(2);
		}
	}

}
