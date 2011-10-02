package commons;

import java.net.*;             
import java.util.ArrayList;


/**
 * Contiene la clase ObjectRef que es una implementacion de una referencia a objeto 
 * junto a las operaciones necesarias para efectuar marshaling y unmarshaling de  
 * cualquier tipo simple, String u objeto.
 * Se han incluido en la clase ObjectInvocation porque resulta mas sencillo utilizar 
 * sus operaciones.
 * @author upv - Bernabéu, Muñoz, Galdámez
 *
 */
public class ObjectRef {
    private String host;
    private int port;
    private int obid;
    private int iid;
                                // Subclase ObjectInvocation.       //
                                // Se utilizara dentro de la imple- //
                                // mentacion de cada metodo del     //
                                // stub, con la mecanica ya comenta-//
                                // da en el fichero Invocation.java //
    class ObjectInvocation implements Invocation {
        private Marshall  pou;
        private UnMarshall pin;
                                // Para construir un objeto de esta //
                                // clase necesitamos un Socket.     //
        public ObjectInvocation(Socket s) {
        	try {                 // Conocido el Socket, se obtienen  //
                                // los streams de entrada y salida  //
                                // para poder leer y escribir en el.//
            pin = new UnMarshall(s.getInputStream());
            pou = new Marshall(s.getOutputStream());
	  } catch (Exception e) {
	    System.out.println( "Error al obtener streams." );
	  }
        }
                                // send() se utiliza para terminar  //
                                // un envio.                        //
        public void       send(){pou.putInt(0);}
                                // waitEnd() se utiliza para termi- //
                                // nar una recepcion. Aqui se reci- //
                                // be el cero que se escribio al e- //
                                // fectuar un send().               //
        public void       waitEnd(){pin.getInt();}
        
                                // El siguiente bloque de operacio- //
                                // nes corresponde al ParseIn.      //
        public int        getInt(){return pin.getInt();}
        public long       getLong(){return pin.getLong();}
        public boolean    getBool(){return pin.getBool();}
        public String     getString(){return pin.getString();}
        public ObjectRef  getObj(){return pin.getObj();}
        
                                // Idem para el ParseOut.           //
        public void    putInt(int i){pou.putInt(i);}
        public void    putLong(long i){pou.putLong(i);}
        public void    putBool(boolean b){pou.putBool(b);}
        public void    putString(String s){pou.putString(s);}
        public void    putObject(ObjectRef or){pou.putObj(or);}
        
        public void putArrayInt (ArrayList<Integer> listaEnteros){pou.putArrayInt(listaEnteros);}
        public ArrayList<Integer> getArrayInt(){return pin.getArrayInt();}
        public void putArrayString(ArrayList<String> nombres){pou.putArrayString(nombres);}
        public ArrayList<String> getArrayString(){return pin.getArrayString();}
    }
    /**
     * La referencia a un objeto consta de la dirección IP de la máquina donde se
     * encuentra el ORB,el puerto asociado a ese ORB, y los identificadores de objeto 
     * e interfaz
     * 
     */
    public ObjectRef(String host, int port, int obid, int iid) {
        this.host = host;
        this.port = port;
        this.obid = obid;
        this.iid  = iid;
    } 
                                // Esta clase actua como un genera- //
                                // dor de invocaciones. Cada vez que//
                                // deba invocarse una operacion, el //
                                // stub debera crear un objeto de   //
                                // tipo ObjectInvocation utilizando //
                                // este metodo.                     //
    public Invocation newInvocation() { 
        Socket so = null;
        Invocation in = null;
	try {
                                // La informacion contenida en la   //
                                // referencia permite crear el so-  //
                                // cket cliente.                    //
	  so = new Socket(host,port);
        
	} catch (Exception e) {
	  System.out.println( "Error al crear socket cliente." );
	}                       // Una vez creado el socket, se     //
                                // crea el objeto invocacion.       //
	in = new ObjectInvocation(so);

	in.putInt( obid );     // Insertamos ya el ID del objeto  //
	in.putInt( iid );      // Insertamos tb el ID de interfaz

        return in;              
    }
    
    public String getHost() {
       return host;             // Devuelve el host.
    }
    
    public int getPort() {
      return port;             // Devuelve el puerto.              //
    }
    
    public int getObid() {
      return obid;             // Devuelve el ID de objeto.        //
    }        

    public int getIid() {
      return iid;             // Devuelve el ID de interfaz.        //
    }        
}

