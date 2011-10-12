package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import utils.ILinker;
import utils.Time;

/**
 * Programa cliente para objetos de claseA
 * 
 * @author Sergio Torres
 * 
 */
public class ClientA {

    public static void main(String[] args) {
	// Datos necesarios para construir el objetoA y su referencia al server
	int idObjeto = 1;
	int port = 8080;
	int idSkeleton = 1;
	String host = "localhost";
	// Creamos nuestro objetoA.
	ILinker objetoA = new StubA(host, port, idObjeto, idSkeleton);
	// Para leer la opción del usuario
	int option = -1;
	// Para recoger los valores
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader((isr));
	// Para tomar tiempos
	Time myTime = new Time();
	while (option != 0) { // Leemos lo que quiere hacer el usuario
	    System.out.println("\n Seleccione la operacion");
	    System.out.println("1 --> Asociar");
	    System.out.println("2 --> Obtener \n");
	    try {
		option = Integer.parseInt(br.readLine()); // Lee la opción del
							  // usuario
	    } catch (Exception e) {
		System.out.println("Error al leer desde el teclado");
	    }
	    switch (option) {
	    case 1:
		try {
		    System.out.println("Introduzca la cadena:");
		    String key;
		    key = br.readLine();
		    System.out.println("Introduzca el valor:");
		    int value = Integer.parseInt(br.readLine());
		    myTime.startCount();
		    objetoA.asociar(key, value);
		    System.out.println("Tiempo en realizar la petición: "
			    + myTime.finalTime());
		    System.out.println("Se ha asociado " + key + " al valor: "
			    + value + "\n");
		} catch (IOException e) {
		    System.out.println(e.getMessage());
		    System.out.println("No se ha realizado la operación");
		}
		break;
	    case 2:
		try {
		    System.out.println("Introduzca la cadena:");
		    String key;
		    key = br.readLine();
		    myTime.startCount();
		    int res = objetoA.obtener(key);
		    System.out.println("Tiempo en realizar la petición: "
			    + myTime.finalTime());
		    System.out.println("La clave: " + key
			    + " está asociada a --> " + res + "\n");
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		    System.out.println("No se ha realizado la operación");
		}
		break;
	    default:
		break;
	    } // switch
	}// while
    }

}
