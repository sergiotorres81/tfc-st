package server;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Implementa un servidor de tipo TCP
 * @author Sergio Torres
 *
 */
public class ServerTCP implements IServer{
	private ServerSocket socketServidor;
	private Socket socketComunicacion;
	private InputStream inputChannel;
	private OutputStream outputChannel;
	private int port = 8080;
	private int delay = 0;
	/**
	 * @param port puerto donde escucha el servidor
	 * @param delay demora para simular el tratamiento de información por parte del cliente
	 */
	public ServerTCP(int port,int delay) {
		super();
		this.port = port;
		this.delay = delay;
		try{
			socketServidor = new ServerSocket(this.port);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Override
	public synchronized void handleByte(){
		try{
			inputChannel = socketComunicacion.getInputStream();
			int dato = inputChannel.read();			
			if (delay>0) {
				Thread.sleep(delay);// Simula el tratamiento de la información
			}
			outputChannel = socketComunicacion.getOutputStream();
			outputChannel.write(dato);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Override
	public synchronized void accept(){
		try{
			socketComunicacion = socketServidor.accept();			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Override
	public synchronized void close(){
		try{
			socketComunicacion.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
