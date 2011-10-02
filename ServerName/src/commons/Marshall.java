package commons;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
/**
 * Se utiliza para realizar el empaquetado o marshalling de los mensajes recibidos
 * 
 * @author upv - Bernabéu, Muñoz, Galdámez
 *
 */
public class Marshall {

	private OutputStream os;

	public Marshall(OutputStream os){
		this.os = os;
	}
	/**
	 * Pone un entero en el outputstream
	 * @param v
	 */
    public void putInt(int v) {
    	int i;
    	byte[] b = new byte[4];
    	// Para empaquetar un entero vamos obteniendo cada uno de sus bytes.//
    	for (i = 0; i<4; i++) {
    		b[3-i] = (byte) (v % 256);
    		v = v / 256;
    	}
    	try {
    		//  Al final, se escribe en el OutputStream
    		os.write(b);         
    	} catch (IOException ioe) { }
    }
    /**
     * Empaqueta un entero.
     * @param v
     */
    public void putLong(long v) {
    	putInt((int) v);          // Los enteros largos se empaquetan //
    }                           // igual que los int.               //
    /**
     * Empaqueta un boolean
     * @param v
     */
    public void putBool(boolean v) {
    	try {                   // Los booleanos usan un byte. A 1  //
    		if (v) {            // si era cierto, a 0 si es falso.  //
    			os.write(1);
    		} else {
    			os.write(0);
    		}
    	} catch (IOException ioe) {
    	}
    }
    /**
     * Empaqueta un String
     * @param v
     */
    public void putString(String v) {
    	byte[] b = v.getBytes();
    	putInt(b.length);       // Para las cadenas, se guarda un   //
    							// int con su longitud ...          //
    	try { 
    		os.write(b);       // ... y a continuacion los carac-  //
    							// teres, como una secuencia de     //
    							// bytes.                           //
    	} catch (IOException ioe) {
    	}
    }
    /**
     * Empaqueta una referencia a objeto.
     * @param or
     */
    public void putObj(ObjectRef or) {
    	try {                   // Para una referencia a objeto ... //
                              // escribimos en primer lugar la IP
                              // del nodo en que
                              // se encuentra el objeto...        //
    		putString (or.getHost());
                              // despues el numero de puerto donde//
                              // esta escuchando el ORB ...  //
    		putInt(or.getPort());
                              // El identificador de//
                              // objeto con el que fue registrado //
                              // en ese ORB.                 //
    		putInt(or.getObid());
	                        // Finalmente el id de la interfaz
    		putInt(or.getIid());
    	} catch (Exception ioe) {
    	}
    }
    public void putArrayString(ArrayList<String> nombres){
    	int l = nombres.size();
    	putInt(l);
    	for (String name : nombres){
    		putString(name);
    	}
    }
    /**
     * Empaqueta un array de enteros
     * @param array Array que vamos a empaquetar
     */
	public void putArrayInt(ArrayList<Integer> listaEnteros){
		int l = listaEnteros.size();		
		// Primero enviamos la longitud
		putInt(l);
		System.out.println("Longitud del array: " + l);
		// Enviamos el resto de la información
		for (Integer i : listaEnteros){
			putInt(i);
			System.out.println("Enviado: " + i);
		}
	}
	/**
	 * @param os the os to set
	 */
	public void setOs(OutputStream os) {
		this.os = os;
	}

	/**
	 * @return the os
	 */
	public OutputStream getOs() {
		return os;
	}
}
