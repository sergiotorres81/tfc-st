package utils;

import java.io.IOException;
import java.io.InputStream;

/**
 * Se utiliza para realizar el desempaquetado o unmarshalling de los mensajes
 * recibidos
 * 
 * @author upv - Bernabéu, Muñoz, Galdámez
 * 
 */
public class UnMarshall {
    private InputStream is;

    /**
     * El constructor recibe el inputstream desde el que podrá leer el mensaje a
     * desempaquetar
     * 
     * @param is
     */
    public UnMarshall(InputStream is) {
	this.is = is;
    }

    /**
     * Lee un entero del inputstream
     * 
     * @return el siguiente entero del inputstream
     */
    public int getInt() {
	// Un entero ocupa 4 bytes. //
	byte[] b = new byte[4];
	int val = 0;
	int i;
	try {
	    // Se leen los 4 bytes del stream. //
	    is.read(b);
	} catch (IOException ioe) {
	    return -1;
	}
	// Se obtiene el valor. //
	for (i = 0; i < 4; i++) {
	    val <<= 8;
	    if (b[0] >= 0 && b[i] < 0)
		val |= (256 + b[i]);
	    else
		val |= b[i];
	}

	return val;
    }

    /**
     * Lee un entero largo del inputStream
     * 
     * @return
     */
    public long getLong() {
	// Los long se tratan exactamente //
	// igual que los enteros. //
	return (long) getInt();
    }

    /**
     * Lee un boolean del inputStream
     * 
     * @return
     */
    public boolean getBool() {
	byte b;

	try { // Un booleano ocupa un byte. //
	    b = (byte) is.read();

	    if (b == 0) { // Cero indica falso. //
		return false;
	    } else { // Cualquier otro valor, cierto. //
		return true;
	    }
	} catch (IOException ioe) {
	    return false;
	}
    }

    /**
     * Lee una cadena de caracteres del inputStream
     * 
     * @return
     */
    public String getString() {
	// Para una cadena se guarda en //
	// primer lugar un int empaquetado //
	// con el valor de su longitud. //
	int l = getInt(); // Obtenemos la longitud. //
	byte[] b = new byte[l];

	try {
	    is.read(b); // Se leen los caracteres. //
	} catch (IOException ioe) {
	}

	return new String(b);
    }

    /**
     * Lee una referencia a objeto del inputStream
     * 
     * @return
     */
    public ObjectRef getObj() {
	// El objeto tiene cuatro campos: //
	// 1) Direccion IP del nodo. //
	// 2) Entero con el numero de puerto//
	// 3) Entero con el ID de objeto. //
	// 4) Entero con el ID de interfaz

	String host = getString();
	int port = getInt();
	int obId = getInt();
	int iId = getInt();
	// Construimos un ObjectRef y devol-//
	// vemos su referencia Java. //
	return new ObjectRef(host, port, obId, iId);
    }

    /**
     * @param is
     *            the is to set
     */
    public void setIs(InputStream is) {
	this.is = is;
    }

    /**
     * @return the is
     */
    public InputStream getIs() {
	return is;
    }

}
