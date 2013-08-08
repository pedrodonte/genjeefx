package util;

import java.util.ArrayList;
import java.util.List;

public class StringHelper {
	
	
	public static List<String> proListado(String valorConComa){
		List<String> listado = new ArrayList<String>();
		
		String[] props = valorConComa.split(",");
		for (int i = 0; i < props.length; i++) {
			listado.add( props[i].trim() );
		}
		
		return listado;
	}
	
	public static String toCamelMayuscula(String cadenaTexto) {
		return cadenaTexto.substring(0, 1).toUpperCase()
				+ cadenaTexto.substring(1);
	}

	public static String getClassFromFullName(String fullName) {
		String nombre =fullName.substring( fullName.lastIndexOf(".")+1, fullName.length());
		return nombre;
	}

	public static String toCamelMinuscula(String cadenaTexto) {
		return cadenaTexto.substring(0, 1).toLowerCase()
				+ cadenaTexto.substring(1);
	}
	
	public static String generarPathClass(String outPath, String fullNameClass){
		String pathClass = outPath +"/"+ fullNameClass.replace(".", "/");
		return pathClass;
	}

}
