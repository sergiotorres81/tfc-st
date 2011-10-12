package server;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Implementa un servidor de tipo TCP con multi-thread
 * 
 * @author Sergio Torres
 */
public class ServerMT implements IServer {
    private ServerSocket socketServidor;
    private Socket socketComunicación;
    private int port = 8080;
    private int delay = 0;

    public ServerMT(int p, int d) {
	this.port = p;
	this.delay = d;
	try {
	    socketServidor = new ServerSocket(this.port);
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
    }

    public synchronized void accept() {
	try {
	    socketComunicación = socketServidor.accept();
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
    }

    public void close() {
	// No es necesaria. La comunicación es cerrada por cada thread
	// de forma independiente
    }

    public synchronized void handleByte() {
	new Thread(new Conection(socketComunicación, delay)).start();
    }
}