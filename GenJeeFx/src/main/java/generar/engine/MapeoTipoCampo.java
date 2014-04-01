package generar.engine;

import static generar.Constantes.PREFIJO_VO;
import generar.Constantes.TipoCampoFormulario;

import java.util.HashMap;
import java.util.Map;

public class MapeoTipoCampo {

	private static Map<String, TipoCampoFormulario> map = new HashMap<String, TipoCampoFormulario>();

	static {
		map.put("String", TipoCampoFormulario.Texto);
		map.put(PREFIJO_VO, TipoCampoFormulario.VO);
		map.put("Timestamp", TipoCampoFormulario.Fecha);
		map.put("Date", TipoCampoFormulario.Fecha);
		map.put("Boolean", TipoCampoFormulario.Flag);
		map.put("Integer", TipoCampoFormulario.Numero);
		map.put("Long", TipoCampoFormulario.Numero);
		map.put("BigDecimal", TipoCampoFormulario.Numero);

		map.put("byte", TipoCampoFormulario.Numero);
		map.put("short", TipoCampoFormulario.Numero);
		map.put("int", TipoCampoFormulario.Numero);
		map.put("long", TipoCampoFormulario.Numero);
		map.put("float", TipoCampoFormulario.Numero);
		map.put("double", TipoCampoFormulario.Numero);
		map.put("char", TipoCampoFormulario.Texto);
		map.put("boolean", TipoCampoFormulario.Flag);
	}
	
	public static TipoCampoFormulario get(String nombreTipo){
		
		//Si el tipo es de clase VO y no esta presente en el mapa statico, entonces es VO
		if (nombreTipo.startsWith(PREFIJO_VO) && !map.containsKey(nombreTipo)) {
			return map.get(PREFIJO_VO);
		}
		
		if (map.get(nombreTipo)==null) {
			System.err.println("SIN MAPEO "+nombreTipo);
		}
		
		return map.get(nombreTipo);
	}

}
