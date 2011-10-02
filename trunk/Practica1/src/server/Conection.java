package server;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/**
 * Implementa el manejo de datos en el servidor TCP multithread
 * @author Sergio Torres
 *
 */
public class Conection implements Runnable {
	private Socket socketComunicacion;
	private int delay;
	/**
	 * El constructor recibe el socket ya creado y el tiempo de demora(proceso)
	 * @param so
	 * @param delay
	 */
	public Conection (Socket so,int delay){
		this.socketComunicacion = so;
		this.delay = delay;
	}
	@Override
	public synchronized void run(){
		try{
			InputStream  inputChannel = socketComunicacion.getInputStream();
			int dato = inputChannel.read();
			if (delay>0) {
				try{				
					Thread.sleep(delay);// Simula el tratamiento de la información
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			OutputStream outputChannel = socketComunicacion.getOutputStream();
			outputChannel.write(dato);
			socketComunicacion.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
