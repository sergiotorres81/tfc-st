package client;

import java.net.Socket;

import utils.Marshall;
import utils.UnMarshall;

/**
 * Stub abstracto que provee las operaciones básicas para conectar con el
 * servicio
 * 
 * @author Sergio Torres
 * 
 */
abstract class AStub {
    private String host = "localhost";
    private int port = 8080;
    private Socket so;
    protected Marshall mar;
    protected UnMarshall unmar;
    protected int idObjeto = 0;
    protected int idSkeleton = 0;

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
    protected AStub(String host, int port, int idObjeto, int idSkeleton) {
	this.host = host;
	this.port = port;
	this.idObjeto = idObjeto;
	this.idSkeleton = idSkeleton;
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

    protected String getHost() {
	return host;
    }

    protected void setHost(String host) {
	this.host = host;
    }

    protected int getPort() {
	return port;
    }

    protected void setPort(int port) {
	this.port = port;
    }

    protected Socket getSo() {
	return so;
    }

    protected void setSo(Socket so) {
	this.so = so;
    }

    protected Marshall getMar() {
	return mar;
    }

    protected void setMar(Marshall mar) {
	this.mar = mar;
    }

    protected UnMarshall getUnmar() {
	return unmar;
    }

    protected void setUnmar(UnMarshall unmar) {
	this.unmar = unmar;
    }

    protected int getIdObjeto() {
	return idObjeto;
    }

    protected void setIdObjeto(int idObjeto) {
	this.idObjeto = idObjeto;
    }

    protected int getIdInterfaz() {
	return idSkeleton;
    }

    protected void setIdInterfaz(int idInterfaz) {
	this.idSkeleton = idInterfaz;
    }
}
