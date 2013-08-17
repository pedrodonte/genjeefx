package generar;

import javax.naming.OperationNotSupportedException;

public class Constantes {
	
	public static final String PREFIJO_VO = "Vo";
	public static final String SUFIJO_DAO = "DAO";
	public static final String SUFIJO_CRUD_INTERFACE = "EJB";
	public static final String SUFIJO_CRUD_IMPLEMENT = "EJBImpl";
	public static final String SUFIJO_JSF_CONTROLLER = "MBean";
	public static final String INTERFAZ_CRUD_GENERICA = "info.pedrodonte.util.CrudGenericServiceApi";
	public static final String PAQUETE_EXCEPCIONES = "info.pedrodonte.protask.excepciones";
	
	public static final String TAB = "\t";
	public static final String NL = "\n";
	public static final String SLASH = "/";
	public static final String JAVA = ".java";
	public static final String XHTML = ".xhtml";
	public static final Exception EX_NO_IMPLEMENTADA = new OperationNotSupportedException("Aun no se implementa esta funcionalidad");
	public static final String CLASE_MAPPER = "HelperMapper";
	
	public static final String XHTML_EOF = "<<<*EOF*>>>";
	public static final String ATRIBUTO_LABEL = "ATRIBUTO_LABEL";
	
	public enum TipoCampoFormulario{Fecha, Numero, Texto, VO, Flag, Desconocido};

}
