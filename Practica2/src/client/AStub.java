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
    protected String host = "localhost";
    protected int port = 8080;
    protected Socket so;
    protected Marshall mar;
    protected UnMarshall unmar;
    protected int objectId = 0;
    protected int skeletonId = 0;

    public AStub(){
    	
    }
    
    /**
     * Constructor para indicar dónde está el servidor, su puerto y los
     * identificadores de objeto en el server.
     * 
     * @param host
     *            Máquina dónde está el servidor
     * @param port
     *            número de puerto dónde escucha
     * @param     protected AStub(String host, int port, int objectId
     *            Identificador del objeto en el lado del servidor
     * @param skeletonId
     *            Identificador del esqueleto en el lado del servidor
     */
    protected AStub(String host, int port, int objectId, int skeletonId) {
	this.host = host;
	this.port = port;
	this.objectId = objectId;
	this.skeletonId = skeletonId;
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


    public int getObjectId() {
		return objectId;
	}

	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}

	public int getSkeletonId() {
		return skeletonId;
	}

	public void setSkeletonId(int skeletonId) {
		this.skeletonId = skeletonId;
	}

}
