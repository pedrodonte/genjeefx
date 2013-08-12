package generar.engine;

import generar.Constantes;

import java.text.MessageFormat;

import util.HelperArchivos;

public class GeneraCodigoDesdePatron {

	public static String build(Object[] param, String patron) {
		
		MessageFormat messageFormat = new MessageFormat( HelperArchivos.leerRecurso(patron) );
		String codigo = messageFormat.format(param);
		codigo = codigo.replace("[", "{");
		codigo = codigo.replace("]", "}");
		
		if (codigo.contains(Constantes.XHTML_EOF)) {
			codigo = codigo.substring(0, codigo.indexOf(Constantes.XHTML_EOF));
		}
		
		return codigo;
	}

}
