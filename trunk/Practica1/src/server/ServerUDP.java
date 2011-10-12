package server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Implementa un servidor de tipo UDP
 * 
 * @author Sergio Torres
 * 
 */
public class ServerUDP implements IServer {
    private int port = 8080;
    private int delay = 0;
    private DatagramSocket socketComunicacion;
    private byte[] buf = new byte[1];
    private DatagramPacket paquete = new DatagramPacket(buf, 1);

    public ServerUDP(int port, int delay) {
	this.port = port;
	this.delay = delay;
	try {
	    socketComunicacion = new DatagramSocket(this.port);
	} catch (SocketException e) {
	    System.out.println(e.getMessage());
	}
    }

    public void accept() {
	// No es neceasario
    }

    public void close() {
	// No es neceasario
    }

    public void handleByte() {
	try {
	    socketComunicacion.receive(paquete);
	    buf = paquete.getData();
	    if (delay > 0) {
		Thread.sleep(delay);// Simula el tratamiento de la información
	    }
	    socketComunicacion.send(paquete);
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
    }
}
