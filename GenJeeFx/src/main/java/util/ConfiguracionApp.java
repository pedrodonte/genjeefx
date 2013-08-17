package util;
import java.io.File;

import app.modelo.AplicacionXmlConfig;

public class ConfiguracionApp {
	
	XmlUtil xmlUtil = new XmlUtil();

	private static ConfiguracionApp INSTANCIA;
	private ConfiguracionApp() {}
	private static void crearInstancia() {
		if (INSTANCIA == null) {
			if (INSTANCIA == null) {
				INSTANCIA = new ConfiguracionApp();
			}
		}
	}
	public static ConfiguracionApp getInstancia() {
		crearInstancia();
        return INSTANCIA;
    }

	/*METODOS DE LA CLASE*/
	public static final String ARCHIVO_CONFIGURACION = "genjeefx.xml";

	public static void main(String[] args) {
		AplicacionXmlConfig aplicacion = getInstancia().leerArchivoConfiguracion();
//		aplicacion.getArchivosRecientes().add(e);
		getInstancia().guardarArchivoPropiedades(aplicacion);
	}

	public AplicacionXmlConfig leerArchivoConfiguracion(){
		AplicacionXmlConfig xmlConfig = null;
		if (comprobarExistenciaArchivo()) {

			xmlConfig = new AplicacionXmlConfig();

	    	//carga propiedades del archivo
			xmlConfig = (AplicacionXmlConfig) XmlUtil.xmlFileToObject(new File(ARCHIVO_CONFIGURACION), AplicacionXmlConfig.class);

		}else{
			System.out.println("El Archivo no Existe, se creará automaticamente.");
			guardarArchivoPropiedades(null);
			System.out.println("Ejecute de nuevo el metodo.");
		}
		return xmlConfig;
	}

	private boolean comprobarExistenciaArchivo(){
		File archivo = new File(ARCHIVO_CONFIGURACION);
		if(archivo.exists()){
			return true;
		}
		return false;
	}

	public void guardarArchivoPropiedades(AplicacionXmlConfig aplicacion){

    	if (aplicacion == null) {
			aplicacion = new AplicacionXmlConfig();
		}
		
		File file = new File(ARCHIVO_CONFIGURACION);
		XmlUtil.convertToXmlFile(file, aplicacion, AplicacionXmlConfig.class);
	}



}
