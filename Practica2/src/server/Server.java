package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Programa servidor
 * 
 * @author Sergio Torres
 * 
 */
public class Server {

    /**
     * @param args
     * @author Sergio
     */
    public static void main(String[] args) {
	Switcher sw = new Switcher();
	int port = 8080;
	// Se crean dos objetos y dos esqueletos y se registran en el switcher
	// "a fuego".
	ClaseA objetoA = new ClaseA();
	SkeletonA esqueletoA = new SkeletonA();
	ClaseB objetoB = new ClaseB();
	SkeletonB esqueletoB = new SkeletonB();
	ServerSocket ss;
	Socket so;
	sw.addInterface(1, esqueletoA); // Al objetoA se le da el id de objeto 1
	sw.addObject(1, objetoA); // Al esqueletoA se le da el id de esqueleto 1
	sw.addInterface(2, esqueletoB); // Al objetoB se le da el id de objeto 2
	sw.addObject(2, objetoB); // Al esqueletoB se le da el id de esqueleto 2
	try {
	    ss = new ServerSocket(port);
	    while (true) {
		try {
		    System.out.println("Server TCP en " + port);
		    so = ss.accept();
		    new Thread(new WorkerMT(sw, so)).start(); // Se utiliza un
							      // servidor
							      // multi-thread
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

}
