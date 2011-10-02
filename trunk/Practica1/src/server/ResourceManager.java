package server;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceManager {
	private ResourceBundle resourceBundle;

	public ResourceManager(){
		resourceBundle = ResourceBundle.getBundle("server.server",new Locale("ES"));
	}
	
	/**
	 * Devuelve la property desde el fichero de recursos
	 * @param key
	 * @return
	 */
	public String getResource(String key){
		try{
			return resourceBundle.getString(key);
		}catch (Exception e) {
			return "--key--";
		}
	}
}
