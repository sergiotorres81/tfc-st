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
public class StubA implements ILinker {
    private String host = "localhost";
    private int port = 8080;
    private Socket so;
    protected Marshall mar;
    protected UnMarshall unmar;
    protected int idObjeto = 0;
    protected int idSkeleton = 0;

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
    public StubA(String host, int port, int idObjeto, int idSkeleton) {
	this.host = host;
	this.port = port;
	this.idObjeto = idObjeto;
	this.idSkeleton = idSkeleton;
    }

    @Override
    public void associate(String key, int value) {
	connect();
	mar.putInt(idObjeto); // Id. del objeto en el lado del servidor
	mar.putInt(idSkeleton); // Id. del esqueleto en el lado del servidor
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
	mar.putInt(idObjeto);
	mar.putInt(idSkeleton);
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

    public String getHost() {
	return host;
    }

    public void setHost(String host) {
	this.host = host;
    }

    public int getPort() {
	return port;
    }

    public void setPort(int port) {
	this.port = port;
    }

    public Socket getSo() {
	return so;
    }

    public void setSo(Socket so) {
	this.so = so;
    }

    public Marshall getMar() {
	return mar;
    }

    public void setMar(Marshall mar) {
	this.mar = mar;
    }

    public UnMarshall getUnmar() {
	return unmar;
    }

    public void setUnmar(UnMarshall unmar) {
	this.unmar = unmar;
    }

    public int getIdObjeto() {
	return idObjeto;
    }

    public void setIdObjeto(int idObjeto) {
	this.idObjeto = idObjeto;
    }

    public int getIdInterfaz() {
	return idSkeleton;
    }

    public void setIdInterfaz(int idInterfaz) {
	this.idSkeleton = idInterfaz;
    }
}
