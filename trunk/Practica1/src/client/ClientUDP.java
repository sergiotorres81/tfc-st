package client;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/**
 * Implementación un cliente UDP
 * @author Sergio Torres
 * 
 */
public class ClientUDP implements ICliente{
	private int port = 8080;
	private DatagramPacket paquete;
	private DatagramSocket socketCliente;
	private byte[] buffer = new byte[1];
	private String host = "localhost";
	/**
	 * Constructor de la clase.
	 * @param host
	 * @param port
	 */
	public ClientUDP(String host,int port){
		this.host = host;
		this.port = port; 
	}
	@Override
	public int receiveByte() {
		byte[] aux = null;
		try{
			this.socketCliente.receive(this.paquete);
			aux = paquete.getData();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Recibo: " + aux[0]);
		return (int) aux[0]; // Se recibe un byte y hay que hacer el cast a integer.
	}
	@Override
	public void sendByte(int b) {
		buffer[0] = (byte) b; // Hacemos un cast para pasar el integer a byte
		try{			
			paquete = new DatagramPacket(buffer,buffer.length,InetAddress.getByName(host),this.port);
			socketCliente.send(paquete);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Envío: " + buffer[0]);
	}
	@Override
	public void connect() {
		try{
			this.socketCliente = new DatagramSocket();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Override
	public void close() {
		// No es necesario
	}
}
