package code;

import util.StringHelper;

public class SemillaCodigoFuente {
	
	private String pathDirectorioSalida;
	private String getterSetters;
	private String imports;
	private String atributos;
	private String metodosVO;
	private String metodosDTO;
	private String metodosMapper;
	private boolean creaArchivo;
	
	private String extension;
	
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
	
	private String paqueteMapper;
	private String claseMapper;
	private String instanciaMapper;
	
	private String paqueteJSFConverter;
	private String claseJSFConverter;
	private String instanciaJSFConverter;
	private String labelVOAtributo;
	
	private String tituloFormulario;
	private String camposTabla;
	private String camposFormulario;
	private String rowKey;
	private String webContent;
	
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
	public boolean isCreaArchivo() {
		return creaArchivo;
	}
	public void setCreaArchivo(boolean creaArchivo) {
		this.creaArchivo = creaArchivo;
	}
	public void setPathDirectorioSalida(String pathDirectorioSalida) {
		this.pathDirectorioSalida = pathDirectorioSalida;
	}
	public void print(){
		System.out.println(this);
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
	public String getFullMapper() {
		return paqueteMapper+"."+claseMapper;
	}
	public String getFullConverter() {
		return paqueteJSFConverter+"."+claseJSFConverter;
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
		instanciaMB = StringHelper.toCamelMinuscula(claseMB);
		return instanciaMB;
	}
	public void setInstanciaMB(String instanciaMB) {
		this.instanciaMB = instanciaMB;
	}
	public String getPaqueteMapper() {
		return paqueteMapper;
	}
	public void setPaqueteMapper(String paqueteMapper) {
		this.paqueteMapper = paqueteMapper;
	}
	public String getClaseMapper() {
		return claseMapper;
	}
	public void setClaseMapper(String claseMapper) {
		this.claseMapper = claseMapper;
	}
	public String getInstanciaMapper() {
		instanciaMapper = StringHelper.toCamelMinuscula(claseMapper);
		return instanciaMapper;
	}
	public void setInstanciaMapper(String instanciaMapper) {
		this.instanciaMapper = instanciaMapper;
	}
	public String getMetodosVO() {
		return metodosVO;
	}
	public void setMetodosVO(String metodosVO) {
		this.metodosVO = metodosVO;
	}
	public String getMetodosDTO() {
		return metodosDTO;
	}
	public void setMetodosDTO(String metodosDTO) {
		this.metodosDTO = metodosDTO;
	}
	public String getMetodosMapper() {
		return metodosMapper;
	}
	public void setMetodosMapper(String metodosMapper) {
		this.metodosMapper = metodosMapper;
	}
	public String getTituloFormulario() {
		return this.tituloFormulario;
	}
	public String getCamposTabla() {
		return this.camposTabla;
	}
	public String getCamposFormulario() {
		return this.camposFormulario;
	}
	public String getRowKey() {
		return this.rowKey;
	}
	public void setTituloFormulario(String tituloFormulario) {
		this.tituloFormulario = tituloFormulario;
	}
	public void setCamposTabla(String camposTabla) {
		this.camposTabla = camposTabla;
	}
	public void setCamposFormulario(String camposFormulario) {
		this.camposFormulario = camposFormulario;
	}
	public void setRowKey(String rowKey) {
		this.rowKey = rowKey;
	}
	public String getWebContent() {
		return webContent;
	}
	public void setWebContent(String webContent) {
		this.webContent = webContent;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	public String getPaqueteJSFConverter() {
		return paqueteJSFConverter;
	}
	public void setPaqueteJSFConverter(String paqueteJSFConverter) {
		this.paqueteJSFConverter = paqueteJSFConverter;
	}
	public String getClaseJSFConverter() {
		return claseJSFConverter;
	}
	public void setClaseJSFConverter(String claseJSFConverter) {
		this.claseJSFConverter = claseJSFConverter;
	}
	public String getInstanciaJSFConverter() {
		instanciaJSFConverter = StringHelper.toCamelMinuscula(claseJSFConverter);
		return instanciaJSFConverter;
	}
	public void setInstanciaJSFConverter(String instanciaJSFConverter) {
		this.instanciaJSFConverter = instanciaJSFConverter;
	}
	public String getLabelVOAtributo() {
		return labelVOAtributo;
	}
	public void setLabelVOAtributo(String labelVOAtributo) {
		this.labelVOAtributo = labelVOAtributo;
	}
	public String getLabelVOMetodo() {
		return "get"+StringHelper.toCamelMayuscula(labelVOAtributo)+"()";
	}

}
