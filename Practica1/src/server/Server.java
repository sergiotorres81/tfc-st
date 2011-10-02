package server;
/**
 * Programa servidor para arrancar los distintos servicios
 * @author Sergio Torres
 *
 */
public class Server {
	/**
	 * @param args args[0] Tipo de servidor:	1--> TCP
	 * 											2--> TCP multi-thread
	 * 											3--> UDP
	 * @param args args[1] Puerto donde escuchará el servidor
	 * @param args args[2] Demora que tendrá el servidor para realizar el tratamiento de la información.
	 * @author Sergio Torres Lozano
	 */
	public static void main(String[] args) {
		IServer miServer = null;
		try{ // Preparamos los parámetros necesarios para los servidores
			int type = Integer.parseInt(args[0]);
			int port = Integer.parseInt(args[1]);
			int d = Integer.parseInt(args[2]);
			switch (type) {
			case 1:
				System.out.println("Servidor tipo --> TCP " );
				miServer = new ServerTCP(port,d);
				break;
			case 2:
				System.out.println("Servidor tipo --> TCP multi-thread " );
				miServer = new ServerMT(port,d);
				break;
			case 3:
				System.out.println("Servidor tipo --> UDP " );
				miServer = new ServerUDP(port, d);				
				break;
			default:
				System.out.println("No existe el tipo de servidor que desea: ");
				System.out.println("1--> TCP ");
				System.out.println("2--> TCP multi-thread ");
				System.out.println("3--> UDP");
				System.exit(1);
				break;
			}			
		}catch (Exception e) {
			System.out.println("use: java server.Server  servertype  port  delay");
			System.exit(2);
		}
		while (true) {
			miServer.accept(); 		// El servidor acepta una petición
			miServer.handleByte();	// El servidor trata una petición
			miServer.close();		// El servidor cierra la conexión
		}
	}
}