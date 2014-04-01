package util;

import java.util.List;

import generar.Constantes;

public class HelperNombres {

	public static String jsfConverterFromVO(String nombre) {
		return nombre.replace(Constantes.PREFIJO_VO, "")+"Converter";
	}

	public static String jsfMBeanFromVO(String nombre) {
		return nombre.replace(
				Constantes.PREFIJO_VO, "")
				+ Constantes.SUFIJO_JSF_CONTROLLER;
	}
	
	public static String cambioNombreEntityToVO(String nombreAtributo, String prefijosEntidades) {

		List<String> listado = StringHelper.proListado(prefijosEntidades);
		
		// Tipo de Dato del atributo
		for (String prefijo : listado ) {
			nombreAtributo = nombreAtributo.replace(prefijo,
					Constantes.PREFIJO_VO);
		}

		// Nombre del atributo
		for (String prefijo : listado) {
			String prefijoMinusculas = prefijo;
			prefijoMinusculas = prefijoMinusculas.substring(0, 1).toLowerCase()
					+ prefijoMinusculas.substring(1);

			nombreAtributo = nombreAtributo.replace(prefijoMinusculas,
					Constantes.PREFIJO_VO.toLowerCase());

		}
		return nombreAtributo;
	}

	public static void main(String[] args) {
		String paquete = "info.pedrodonte.java";

		System.out.println(paqueteSuperior(paquete));
	}
	
	public static String paqueteSuperior(String paqueteHijo){
		return paqueteHijo.substring(0, paqueteHijo.lastIndexOf("."));
	}

	public static String nombreMantenedorXHTML(String nombreVO) {
		// TODO Auto-generated method stub
		return (nombreVO.replace(Constantes.PREFIJO_VO, "mant_")).toLowerCase();
	}

}
