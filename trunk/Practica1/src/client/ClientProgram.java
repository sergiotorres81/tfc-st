package client;

import java.util.Random;

import utils.NetTypeProtocolEnum;
import utils.ResourceManager;
import utils.Time;

/**
 * Programa Cliente
 * 
 * @author Sergio Torres
 * 
 */
public class ClientProgram {

    public static void main(String[] args) {
	ResourceManager resourceManager = new ResourceManager("client.client");
	int info = new Random().nextInt(99) + 1; // Esto genera un aleatorio
						 // entre 1 y 100
	NetTypeProtocolEnum type = NetTypeProtocolEnum.valueOf(resourceManager
		.getResource("type"));
	Integer port = new Integer(resourceManager.getResource("port"));
	String host = resourceManager.getResource("port");
	int MAXLOOP = 10;
	Time miTime = new Time();
	IClient myClient = null; // Se declara el cliente
	switch (type) { // Instanciamos el tipo de cliente adecuado
	case TCP:
	    myClient = new ClientTCP(host, port);
	    break;
	case UDP:
	    myClient = new ClientUDP(host, port);
	    break;
	default:
	    System.exit(1);
	    break;
	}
	long time = miTime.startCount(); // Inicia la cuenta de tiempo
	for (int i = 0; i < MAXLOOP; i++) {
	    myClient.connect(); // Se conecta con el servidor
	    myClient.sendByte(info); // Envía información al servidor
	    info = myClient.receiveByte(); // Recibe la información del servidor
	    myClient.close(); // Cierra la conexión con el servidor
	}
	time = miTime.finalTime(); // Finaliza la cuenta de tiempo y muestra el
				   // resultado
	System.out.println("Tiempo de ejecución: " + time + " milisegundos");
    }

}
