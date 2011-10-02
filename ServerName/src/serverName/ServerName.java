package serverName;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Programa servidor que instancia un servidor de nombres para se utilizado por la aplicación
 * @author Sergio Torres 
 *  
 */
public class ServerName {

	/**
	 * @param args
	 * @author Sergio
	 */
	public static void main(String[] args) {
		int port = 8080;
		String host = "localhost";
		Switcher sw = new Switcher(host,port,1);	
		// Se instancia la conexión del servidor
		ServerSocket ss;
		Socket so;
		try {
			ss = new ServerSocket(port);
			System.out.println("ServerName TCP/MT en puerto " + port );
			while (true){
				try{
					so = ss.accept();
					System.out.println();
					new Thread(new WorkerMT(sw, so)).start();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
