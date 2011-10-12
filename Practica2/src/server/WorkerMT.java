package server;

import java.net.Socket;

import utils.Marshall;
import utils.UnMarshall;

/**
 * Clase encargada de implementar el multithread
 * 
 * @author Sergio Torres
 * 
 */
public class WorkerMT implements Runnable {
    private Switcher sw;
    private Socket so;

    /**
     * El servidor recibe un swicher y un socket
     * 
     * @param sw
     * @param so
     */
    public WorkerMT(Switcher sw, Socket so) {
	super();
	this.sw = sw;
	this.so = so;
    }

    @Override
    public void run() {
	try {
	    sw.procesar(new UnMarshall(so.getInputStream()),
		    new Marshall(so.getOutputStream()));
	    so.close();
	} catch (Exception e) {
	    System.out.println("Algo va mal");
	}

    }

    public void setSw(Switcher sw) {
	this.sw = sw;
    }

    public Switcher getSw() {
	return sw;
    }

    public void setSo(Socket so) {
	this.so = so;
    }

    public Socket getSo() {
	return so;
    }

}
