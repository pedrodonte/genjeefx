package generar.engine;

import generar.modelo.Atributo;

import java.text.MessageFormat;
import java.util.List;

import util.HelperArchivos;
import util.StringHelper;

public class BuscaGetterSetterParaVOs {

	private static String getSetterGetter(Atributo atributo) {
		
		String nombreTipo = atributo.getTipo().getNombre();
		String nombreAtributo = atributo.getNombre();
		String nombreAtributoCamel = StringHelper.toCamelMayuscula(atributo.getNombre());
		
		Object[] testArgs = { 
				nombreTipo, 
				nombreAtributo, 
				nombreAtributoCamel
				};

		MessageFormat form = new MessageFormat(
				HelperArchivos.leerRecurso("value-object-gettersetter.txt"));

		String codigoGenerado = form.format(testArgs).replace("]", "}")
				.replace("[", "{");
		
		return codigoGenerado;
	}
	
	public static String getTodosSetterGetter(List<Atributo> atributos){
		StringBuilder codigoEncapsulacion = new StringBuilder();
		for (Atributo atributo : atributos) {
			codigoEncapsulacion.append( getSetterGetter(atributo) );
		}
		return codigoEncapsulacion.toString();
	}
	
}
