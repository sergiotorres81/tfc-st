package server;

import utils.IOperations;

/**
 * Contiene la implementación de la interfaz IObjetoB. Esta implementación se
 * utilizará para dar soporte a los objetos servidores de esta interfaz.
 * 
 * @author Sergio Torres
 * 
 */
public class ClaseB extends ClaseA implements IOperations {
    public synchronized int subtract(String op1, String op2) {
	int res = 0;
	int min = this.obtener(op1);
	int sus = this.obtener(op2);
	res = min - sus;
	return res;
    }

    public synchronized int add(String op1, String op2) {
	int res = 0;
	int sum1 = this.obtener(op1);
	int sum2 = this.obtener(op2);
	res = sum1 + sum2;
	return res;
    }

}
