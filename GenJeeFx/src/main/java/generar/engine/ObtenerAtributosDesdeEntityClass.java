package generar.engine;

import generar.modelo.Atributo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ObtenerAtributosDesdeEntityClass {
	
	public static List<Atributo> get(String stringClass){
		
		try {
			Class<?> clase = Class.forName(stringClass);
			
			List<Atributo> atributos = new ArrayList<>();
			for (Field f : clase.getDeclaredFields()) {
				System.out.println(f.getName());
				System.out.println(f.getType());
				atributos.add(new Atributo(f));
			}
			
			return atributos;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
