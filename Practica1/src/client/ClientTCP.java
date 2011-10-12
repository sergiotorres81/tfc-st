package client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Implementación un cliente TCP
 * 
 * @author Sergio Torres
 * 
 */
public class ClientTCP implements IClient {
    private String host = "localhost";
    private int port = 8080;
    private Socket socketCliente;
    private InputStream inputChannel;
    private OutputStream outputChannel;

    /**
     * Constructor de la clase. Instancia el socket de comunicaciones con el
     * servidor.
     * 
     * @param host
     *            Dirección donde está el servidor
     * @param port
     *            Puerto en el que escucha el servidor
     */
    public ClientTCP(String host, int port) {

	this.host = host;
	this.port = port;
    }

    public void connect() {
	try {
	    socketCliente = new Socket(host, port);
	} catch (Exception e) {
	    System.out.println("Error de conexión");
	}
    }

    public void sendByte(int b) {
	try {
	    outputChannel = socketCliente.getOutputStream();
	    outputChannel.write(b);
	} catch (Exception e) {
	    System.out.println("Error en envío / recepción de datos");
	}
	System.out.println("Envío: " + b); // La información hay que obtenerla
					   // fuera del try / catch
    }

    public int receiveByte() {
	int b = 0;
	try {
	    inputChannel = socketCliente.getInputStream();
	    b = inputChannel.read();
	} catch (Exception e) {
	    System.out.println("Error en envío / recepción de datos");
	}
	System.out.println("Recibo: " + b);
	return b;
    }

    public void close() {
	try {
	    this.socketCliente.close();
	} catch (Exception e) {
	    System.out.println("Error de conexión");
	}
    }
}
