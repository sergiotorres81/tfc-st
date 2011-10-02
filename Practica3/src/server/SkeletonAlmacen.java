package server;

import commons.*;
/**
 * Una posible opción de implementación de Skeleton para tratar las
 * peticiones de objetos Almacen
 * @author Sergio Torres
 *
 */
public class SkeletonAlmacen implements Skeleton{
	@Override
	public void process(UnMarshall unmar, Marshall mar, Object obj) {
		ClaseAlmacen almacen = (ClaseAlmacen) obj;
		int operationID = unmar.getInt();
		int fin = 0;
		switch (operationID) {
		case 1:
			ObjectRef ref = unmar.getObj();
			ClaseHola ho = new ClaseHola(ref);
			almacen.guardarHola(ho);	
			fin = unmar.getInt();
			if (fin!=0){
				System.out.println("Error -->" + fin);
			}
			break;
		case 2:
			ClaseHola holaGuardada = (ClaseHola) almacen.obtieneHola();
			mar.putObj(holaGuardada.getRef());
			fin = unmar.getInt();
			if (fin!=0){
				System.out.println("Error -->" + fin);
			}
			break;
		case 3:
			ObjectRef refA = unmar.getObj();
			ClaseA oa = new ClaseA(refA);
			almacen.guardarObjetoA(oa);	
			fin = unmar.getInt();
			if (fin!=0){
				System.out.println("Error -->" + fin);
			}
			break;
		case 4:
			ClaseA objAGuardado = (ClaseA) almacen.obtieneObjetoA();
			mar.putObj(objAGuardado.getRef());
			fin = unmar.getInt();
			if (fin!=0){
				System.out.println("Error -->" + fin);
			}
			break;
		case 5:
			ObjectRef refB = unmar.getObj();
			ClaseB ob = new ClaseB(refB);
			almacen.guardarObjetoB(ob);	
			fin = unmar.getInt();
			if (fin!=0){
				System.out.println("Error -->" + fin);
			}
			break;
		case 6:
			ClaseB objBGuardado = (ClaseB) almacen.obtieneObjetoB();
			mar.putObj(objBGuardado.getRef());
			fin = unmar.getInt();
			if (fin!=0){
				System.out.println("Error -->" + fin);
			}		
			break;
		default:
			break;
		}
		
	}

}
