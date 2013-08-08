package generar.engine;

import java.text.MessageFormat;

import util.HelperArchivos;

public class GeneraCodigoDesdePatron {

	public static String build(Object[] param, String patron) {
		
		MessageFormat messageFormat = new MessageFormat( HelperArchivos.leerRecurso(patron) );
		String codigo = messageFormat.format(param);
		codigo = codigo.replace("[", "{");
		codigo = codigo.replace("]", "}");
		return codigo;
	}

}
