package generar.engine;

import generar.modelo.Atributo;

import java.util.List;

public class GeneraCodigoAtributosParaVOs {

	public static String getAtributosPrivate(List<Atributo> atributos) {

		StringBuilder atributosVos = new StringBuilder();
		
		for (Atributo atributo : atributos) {
			atributosVos.append("\t");
			
			atributosVos.append("private "+ atributo.getTipo().getNombre() +" " + atributo.getNombre() + ";");
			
			atributosVos.append("\n");
		}
		
		return atributosVos.toString();
	}

}
