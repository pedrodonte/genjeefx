package generar.engine;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import generar.modelo.Atributo;

public class BuscaImportsParaVOs {

	
	/**Generar bloque de Imports para la clase VO,
	 * en base a todos los posibles atributos que se tengan,
	 * debe eliminar los repetidos.
	 * @param lista de atributos
	 * @return cadena con la sentencia que hace el import.
	 */
	public static String getImports(List<Atributo> atributos) {

		Set<String> tiposUnicos = new HashSet<>();
		//Paso 1 se añaden a un SET que elimina los duplicados
		for (Atributo atributo : atributos) {
			if (atributo.esImportable()) {
				tiposUnicos.add(atributo.getTipo().toString());
			}
		}

		//Paso 2 se importan los tipos resultantes del filtro unico
		StringBuilder imports = new StringBuilder();
		for (String tipo : tiposUnicos) {
			imports.append("import " + tipo + ";\n");
		}
		return imports.toString();
	}

}
