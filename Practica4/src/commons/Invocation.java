package commons;

import java.util.ArrayList;
import commons.ObjectRef;
/**
 * Contiene la interfaz Invocation, a utilizar en los stubs clientes. 
 * En ella se agrupan los metodos presentes en las clases ParseIn y ParseOut. 
 * @author upv - Bernabéu, Muñoz, Galdámez
 */
public interface Invocation {
    public void       send();
    public void       waitEnd();

    public int        getInt();
    public long       getLong();
    public boolean    getBool();
    public String     getString();
    public ObjectRef  getObj();
    
    public void    putInt(int i);
    public void    putLong(long i);
    public void    putBool(boolean b);
    public void    putString(String s);
    public void    putObject(ObjectRef or);
    
    public void putArrayInt(ArrayList<Integer> values);
    public ArrayList<Integer> getArrayInt();
    
    public void putArrayString(ArrayList<String> nombres);
    public ArrayList<String> getArrayString();
}