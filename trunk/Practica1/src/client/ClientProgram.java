package client;

import java.util.Random;

import utils.NetTypeProtocolEnum;
import utils.Time;


/**
 * Programa Cliente
 * @author Sergio Torres
 *
 */
public class ClientProgram {
	
	public static void main(String[] args) {
		int port = 8080;
		int info = new Random().nextInt(99)+1; // Esto genera un aleatorio entre 1 y 100
		NetTypeProtocolEnum type = NetTypeProtocolEnum.TCP; 
		String host = "localhost";
		int MAXLOOP = 10;
		Time miTime = new Time();
		try{
//			host = args[0];
//			port = Integer.parseInt(args[1]);
//			type = Integer.parseInt(args[2]);
//			MAXLOOP = Integer.parseInt(args[3]);
		}catch (Exception e) {
			System.out.println("use: java client.Client host port clientType MAXLOOP");
			System.out.println("host: Nombre del servidor");
			System.out.println("port: Puerto en el que atiende el servidor");
			System.out.println("type: Tipo de cliente");
			System.out.println("MAXLOOP: Número de solicitudes que se harán al servidor");
			System.exit(1);
		}
		IClient myClient = null; // Se declara el cliente
		switch (type) { // Instanciamos el tipo de cliente adecuado
		case TCP:
			myClient = new ClientTCP("client.client");
			break;
		case UDP:
			myClient = new ClientUDP(host, port);			
			break;
		default:
			System.exit(1);
			break;
		}
		long time = miTime.startCount(); // Inicia la cuenta de tiempo 		
		for (int i = 0 ; i< MAXLOOP ; i++){
			myClient.connect();			// Se conecta con el servidor			
			myClient.sendByte(info); 		// Envía información al servidor	
			info = myClient.receiveByte();	// Recibe la información del servidor
			myClient.close();				// Cierra la conexión con el servidor
		}
		time = miTime.finalTime(); // Finaliza la cuenta de tiempo y muestra el resultado
		System.out.println("Tiempo de ejecución: " + time + " milisegundos"); 
	}
}
