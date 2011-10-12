package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import utils.IOperations;

/**
 * Programa cliente para objetos de claseB
 * 
 * @author Sergio Torres
 * 
 */
public class ClientB {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// Datos necesarios para construir el objetoA y su referencia al server
	int idObjeto = 2;
	int idSkeleton = 2;
	int port = 8080;
	String host = "localhost";
	// Creamos nuestro objetoA.
	IOperations stb = new StubB(host, port, idObjeto, idSkeleton);
	// Para leer la opción del usuario
	int option = -1;
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader((isr));
	while (option != 0) {
	    System.out.println("\n Seleccione la operacion");
	    System.out.println("1 --> Asociar");
	    System.out.println("2 --> Obtener ");
	    System.out.println("3 --> Suma ");
	    System.out.println("4 --> Resta \n");
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
		    stb.asociar(key, value);
		    System.out.println("Se ha asociado " + key + " al valor: "
			    + value);
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
		    int res = stb.obtener(key);
		    System.out.println("La clave: " + key
			    + " está asociada a --> " + res);
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		    System.out.println("No se ha realizado la operación");
		}
		break;
	    case 3:
		try {
		    System.out.println("Introduzca el primer sumando:");
		    String op1;
		    op1 = br.readLine();
		    System.out.println("Introduzca el segundo sumando:");
		    String op2;
		    op2 = br.readLine();
		    int add = stb.suma(op1, op2);
		    System.out.println("La suma de: " + op1 + " y " + op2
			    + " es--> " + add);
		} catch (IOException e) {
		    System.out.println(e.getMessage());
		    System.out.println("No se ha realizado la operación");
		}
		break;
	    case 4:
		try {
		    System.out.println("Introduzca el minuendo:");
		    String op1;
		    op1 = br.readLine();
		    System.out.println("Introduzca el sustraendo:");
		    String op2;
		    op2 = br.readLine();
		    int diff = stb.resta(op1, op2);
		    System.out.println("La resta de: " + op1 + " y " + op2
			    + " es--> " + diff);
		} catch (IOException e) {
		    System.out.println(e.getMessage());
		    System.out.println("No se ha realizado la operación");
		}
		break;
	    default:
		break;
	    }
	}
    }

}