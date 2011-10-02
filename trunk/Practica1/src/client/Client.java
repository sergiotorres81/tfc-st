package client;

import java.util.Random;


/**
 * Programa Cliente
 * @author Sergio Torres
 *
 */
public class Client {
	/**
	 * @param args 
	 * 		args[0] --> host donde está el servidor
	 * 		args[1] --> puerto donde escucha
	 * 		args[2] --> tipo de client : 
	 * 							1 --> tcp 
	 * 							2 --> udp
	 * 		args[3] --> Número de iteraciones que se van a realizar.
	 */
	public static void main(String[] args) {
		int port = 8080;
		Random generator = new Random();	// Para generar el dato que se envía al servidor
		int info = generator.nextInt(99)+1; // Esto genera un aleatorio entre 1 y 100
		int type = 1; 
		String host = "localhost";
		int MAXLOOP = 1000;
		Time miTime = new Time();
		try{
			host = args[0];
			port = Integer.parseInt(args[1]);
			type = Integer.parseInt(args[2]);
			MAXLOOP = Integer.parseInt(args[3]);
		}catch (Exception e) {
			System.out.println("use: java client.Client host port clientType MAXLOOP");
			System.out.println("host: Nombre del servidor");
			System.out.println("port: Puerto en el que atiende el servidor");
			System.out.println("type: Tipo de cliente");
			System.out.println("MAXLOOP: Número de solicitudes que se harán al servidor");
			System.exit(1);
		}
		ICliente miCliente = null; // Se inicializa la variable
		switch (type) { // Intanciamos el tipo de cliente adecuado
		case 1:
			miCliente = new ClientTCP(host, port);
			break;
		case 2:
			miCliente = new ClientUDP(host, port);			
			break;
		default:
			System.out.println("No ha seleccionado un tipo de cliente válido: " );
			System.out.println(" 1 --> Cliente TCP" );
			System.out.println(" 2 --> Cliente UDP " );
			System.exit(1);
			break;
		}
		long time = miTime.startCount(); // Inicia la cuenta de tiempo 		
		for (int i = 0 ; i< MAXLOOP ; i++){
			miCliente.connect();			// Se conecta con el servidor			
			miCliente.sendByte(info); 		// Envía información al servidor	
			info = miCliente.receiveByte();	// Recibe la información del servidor
			miCliente.close();				// Cierra la conexión con el servidor
		}
		time = miTime.finalTime(); // Finaliza la cuenta de tiempo y muestra el resultado
		System.out.println("Tiempo de ejecución: " + time + " milisegundos"); 
	}
}
