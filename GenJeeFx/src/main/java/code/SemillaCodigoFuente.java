package code;

import static generar.Constantes.*;
import util.StringHelper;

public class SemillaCodigoFuente {
	
	private String pathDirectorioSalida;
	private String pathArchivoFuente;
	private String paqueteClase;
	private String nombreClase;
	private String nombreInstancia;
	private String paqueteClaseAux;
	private String nombreClaseAux;
	private String nombreInstanciaAux;
	private String getterSetters;
	private String imports;
	private String atributos;
	private String atributosAux;
	private String metodos;
	private String metodosAux;
	private String nombreClaseAux2;
	private String nombreClaseAux3;
	private boolean creaArchivo;
	
	private String paqueteVO;
	private String claseVO;
	private String instanciaVO;
	
	private String paqueteDAO;
	private String claseDAO;
	private String instanciaDAO;
	
	private String paqueteDTO;
	private String claseDTO;
	private String instanciaDTO;
	
	private String paqueteEJB;
	private String claseEJB;
	private String instanciaEJB;
	
	private String paqueteImpl;
	private String claseImpl;
	private String instanciaImpl;
	
	private String paqueteMB;
	private String claseMB;
	private String instanciaMB;
	
	public String getPaqueteClase() {
		return paqueteClase;
	}
	public void setPaqueteClase(String paqueteClase) {
		this.paqueteClase = paqueteClase;
	}
	public String getNombreClase() {
		return nombreClase;
	}
	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}
	public String getNombreInstancia() {
		return nombreInstancia;
	}
	public void setNombreInstancia(String nombreInstancia) {
		this.nombreInstancia = nombreInstancia;
	}
	public String getNombreClaseAux() {
		return nombreClaseAux;
	}
	public void setNombreClaseAux(String nombreClaseAux) {
		this.nombreClaseAux = nombreClaseAux;
	}
	public String getNombreInstanciaAux() {
		return nombreInstanciaAux;
	}
	public void setNombreInstanciaAux(String nombreInstanciaAux) {
		this.nombreInstanciaAux = nombreInstanciaAux;
	}
	public String getGetterSetters() {
		return getterSetters;
	}
	public void setGetterSetters(String getterSetters) {
		this.getterSetters = getterSetters;
	}
	public String getImports() {
		return imports;
	}
	public void setImports(String imports) {
		this.imports = imports;
	}
	public String getAtributos() {
		return atributos;
	}
	public void setAtributos(String atributos) {
		this.atributos = atributos;
	}
	public String getPathArchivoFuente() {
		return pathArchivoFuente;
	}
	public boolean isCreaArchivo() {
		return creaArchivo;
	}
	public void setCreaArchivo(boolean creaArchivo) {
		this.creaArchivo = creaArchivo;
	}
	public void setPathDirectorioSalida(String pathDirectorioSalida) {
		this.pathDirectorioSalida = pathDirectorioSalida;
	}
	public String getPaqueteClaseAux() {
		return paqueteClaseAux;
	}
	public void setPaqueteClaseAux(String paqueteClaseAux) {
		this.paqueteClaseAux = paqueteClaseAux;
	}
	public String getMetodos() {
		return metodos;
	}
	public void setMetodos(String metodos) {
		this.metodos = metodos;
	}
	public String getMetodosAux() {
		return metodosAux;
	}
	public void setMetodosAux(String metodosAux) {
		this.metodosAux = metodosAux;
	}
	public String getAtributosAux() {
		return atributosAux;
	}
	public void setAtributosAux(String atributosAux) {
		this.atributosAux = atributosAux;
	}
	
	
	
	public void print(){
		System.out.println(this);
	}
	

	public String getNombreClaseAux2() {
		return nombreClaseAux2;
	}
	public void setNombreClaseAux2(String nombreClaseAux2) {
		this.nombreClaseAux2 = nombreClaseAux2;
	}
	public String getNombreClaseAux3() {
		return nombreClaseAux3;
	}
	public void setNombreClaseAux3(String nombreClaseAux3) {
		this.nombreClaseAux3 = nombreClaseAux3;
	}
	public String getPaqueteVO() {
		return paqueteVO;
	}
	public void setPaqueteVO(String paqueteVO) {
		this.paqueteVO = paqueteVO;
	}
	public String getClaseVO() {
		return claseVO;
	}
	public void setClaseVO(String claseVO) {
		this.claseVO = claseVO;
	}
	public String getInstanciaVO() {
		return instanciaVO;
	}
	public void setInstanciaVO(String instanciaVO) {
		this.instanciaVO = instanciaVO;
	}
	public String getPaqueteDAO() {
		return paqueteDAO;
	}
	public void setPaqueteDAO(String paqueteDAO) {
		this.paqueteDAO = paqueteDAO;
	}
	public String getClaseDAO() {
		return claseDAO;
	}
	public void setClaseDAO(String claseDAO) {
		this.claseDAO = claseDAO;
	}
	public String getInstanciaDAO() {
		instanciaDAO = StringHelper.toCamelMinuscula(claseDAO);
		return instanciaDAO;
	}
	public void setInstanciaDAO(String instanciaDAO) {
		this.instanciaDAO = instanciaDAO;
	}
	public String getPaqueteDTO() {
		return paqueteDTO;
	}
	public void setPaqueteDTO(String paqueteDTO) {
		this.paqueteDTO = paqueteDTO;
	}
	public String getClaseDTO() {
		return claseDTO;
	}
	public void setClaseDTO(String claseDTO) {
		this.claseDTO = claseDTO;
	}
	public String getInstanciaDTO() {
		return instanciaDTO;
	}
	public void setInstanciaDTO(String instanciaDTO) {
		this.instanciaDTO = instanciaDTO;
	}
	public String getPaqueteEJB() {
		return paqueteEJB;
	}
	public void setPaqueteEJB(String paqueteEJB) {
		this.paqueteEJB = paqueteEJB;
	}
	public String getClaseEJB() {
		return claseEJB;
	}
	public void setClaseEJB(String claseEJB) {
		this.claseEJB = claseEJB;
	}
	public String getInstanciaEJB() {
		return instanciaEJB;
	}
	public void setInstanciaEJB(String instanciaEJB) {
		this.instanciaEJB = instanciaEJB;
	}
	public String getPaqueteImpl() {
		return paqueteImpl;
	}
	public void setPaqueteImpl(String paqueteImpl) {
		this.paqueteImpl = paqueteImpl;
	}
	public String getClaseImpl() {
		return claseImpl;
	}
	public void setClaseImpl(String claseImpl) {
		this.claseImpl = claseImpl;
	}
	public String getInstanciaImpl() {
		return instanciaImpl;
	}
	public void setInstanciaImpl(String instanciaImpl) {
		this.instanciaImpl = instanciaImpl;
	}
	public String getPathDirectorioSalida() {
		return pathDirectorioSalida;
	}
	public void setPathArchivoFuente(String pathArchivoFuente) {
		this.pathArchivoFuente = pathArchivoFuente;
	}
	public String getFullDao() {
		return paqueteDAO+"."+claseDAO;
	}
	public String getFullDto() {
		return paqueteDTO+"."+claseDTO;
	}
	public String getFullVo() {
		return paqueteVO+"."+claseVO;
	}
	public String getFullEjb() {
		return paqueteEJB+"."+claseEJB;
	}
	public String getFullEjbImpl() {
		return paqueteImpl+"."+claseImpl;
	}
	public String getFullControllerMB() {
		return paqueteMB+"."+claseMB;
	}
	@Override
	public String toString() {
		return "SemillaCodigoFuente [pathDirectorioSalida="
				+ pathDirectorioSalida + ", pathArchivoFuente="
				+ pathArchivoFuente + ", paqueteClase=" + paqueteClase
				+ ", nombreClase=" + nombreClase + ", nombreInstancia="
				+ nombreInstancia + ", paqueteClaseAux=" + paqueteClaseAux
				+ ", nombreClaseAux=" + nombreClaseAux
				+ ", nombreInstanciaAux=" + nombreInstanciaAux
				+ ", getterSetters=" + getterSetters + ", imports=" + imports
				+ ", atributos=" + atributos + ", atributosAux=" + atributosAux
				+ ", metodos=" + metodos + ", metodosAux=" + metodosAux
				+ ", nombreClaseAux2=" + nombreClaseAux2 + ", nombreClaseAux3="
				+ nombreClaseAux3 + ", creaArchivo=" + creaArchivo
				+ ", paqueteVO=" + paqueteVO + ", claseVO=" + claseVO
				+ ", instanciaVO=" + instanciaVO + ", paqueteDAO=" + paqueteDAO
				+ ", claseDAO=" + claseDAO + ", instanciaDAO=" + instanciaDAO
				+ ", paqueteDTO=" + paqueteDTO + ", claseDTO=" + claseDTO
				+ ", instanciaDTO=" + instanciaDTO + ", paqueteEJB="
				+ paqueteEJB + ", claseEJB=" + claseEJB + ", instanciaEJB="
				+ instanciaEJB + ", paqueteImpl=" + paqueteImpl
				+ ", claseImpl=" + claseImpl + ", instanciaImpl="
				+ instanciaImpl + "]";
	}
	public String getPaqueteMB() {
		return paqueteMB;
	}
	public void setPaqueteMB(String paqueteMB) {
		this.paqueteMB = paqueteMB;
	}
	public String getClaseMB() {
		return claseMB;
	}
	public void setClaseMB(String claseMB) {
		this.claseMB = claseMB;
	}
	public String getInstanciaMB() {
		return instanciaMB;
	}
	public void setInstanciaMB(String instanciaMB) {
		this.instanciaMB = instanciaMB;
	}

}
