package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import commons.IClaseA;
import commons.IClaseHola;
import commons.NameServer;
import commons.ORBObjectImpl;
import commons.ObjectRef;
/**
 * 
 * @author Sergio Torres
 *
 */
public class ClientA {
	/**
	 * @author Sergio
	 */
	public static void main(String[] args) {
		
		ObjectRef refNS = new ObjectRef("localhost", 8080, 1, 1);
		NameServer ns = new StubNameServer(refNS);
		ORBObjectImpl objHola = (ORBObjectImpl)ns.find("hola");
		IClaseHola objetoHola = new StubHola(objHola.getRef());
		System.out.println("Voy a decir algo: " + objetoHola.decirHola());
		
		ORBObjectImpl objA = (ORBObjectImpl)ns.find("claseA");
		IClaseA sta = new StubA(objA.getRef());
		
		int option = -1;
		int value = -1;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader((isr));
		while (option!=0){
			System.out.println("\n Seleccione la operacion");
			System.out.println("1 --> Asociar");
			System.out.println("2 --> Obtener \n");
			System.out.println("0 --> Salir \n");
			try{
				option  = Integer.parseInt(br.readLine()); // Lee la opción del usuario
			}catch (Exception e) {
				System.out.println("Error al leer desde el teclado");
			}
			switch (option) {
			case 1:				
				try {
					System.out.println("Introduzca la cadena:");
					String key;
					key = br.readLine();
					System.out.println("Introduzca el valor:");
					value = Integer.parseInt(br.readLine());
					sta.asociar(key, value);
					System.out.println("Se ha asociado " + key  + " al valor: " + value + "\n");
				} catch (IOException e) {					
					e.printStackTrace();
				}				
				break;
			case 2:
				try{
					System.out.println("Introduzca la cadena:");
					String key;
					key = br.readLine();
					value = sta.obtener(key);
					System.out.println("La clave--> " + key + " está asociada a --> " + value +"\n");
				}catch (Exception e) {
					e.printStackTrace();
				}
				break;
			default:
				break;
			}
		}
	}
}
