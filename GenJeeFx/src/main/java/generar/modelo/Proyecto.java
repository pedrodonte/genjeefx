package generar.modelo;

import static generar.Constantes.*;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Proyecto extends ElementoBase{
	
	private String carpetaSalida;
	private String paqueteEntrada;
	private List<Entidad> entidades = new ArrayList<>();
	private String prefijosEntidades;
	
	private String paqueteVos;
	private String paqueteDaos;
	private String paqueteCrudService;
	private String paqueteJsfController;
	private String paqueteJSFConverter;
	
	private String webContent;

	public List<Entidad> getEntidades() {
		return entidades;
	}
	public void setEntidades(List<Entidad> entidades) {
		this.entidades = entidades;
	}

	public String getCarpetaSalida() {
		return carpetaSalida;
	}
	public void setCarpetaSalida(String carpetaSalida) {
		this.carpetaSalida = carpetaSalida;
	}
	
	public String getPaqueteEntrada() {
		return paqueteEntrada;
	}
	public void setPaqueteEntrada(String paqueteEntrada) {
		this.paqueteEntrada = paqueteEntrada;
	}
	public String getPrefijosEntidades() {
		return prefijosEntidades;
	}
	public void setPrefijosEntidades(String prefijosEntidades) {
		this.prefijosEntidades = prefijosEntidades;
	}
	public String getPaqueteVos() {
		return paqueteVos;
	}
	public void setPaqueteVos(String paqueteVos) {
		this.paqueteVos = paqueteVos;
	}
	public String getPaqueteDaos() {
		return paqueteDaos;
	}
	public void setPaqueteDaos(String paqueteDaos) {
		this.paqueteDaos = paqueteDaos;
	}
	public String getPaqueteCrudService() {
		return paqueteCrudService;
	}
	public void setPaqueteCrudService(String paqueteCrudService) {
		this.paqueteCrudService = paqueteCrudService;
	}
	public String getPaqueteJsfController() {
		return paqueteJsfController;
	}
	public void setPaqueteJsfController(String paqueteJsfController) {
		this.paqueteJsfController = paqueteJsfController;
	}
	
	public void print(){
		System.out.println("Entidades "+entidades.size());
		for (Entidad e : entidades) {
			System.out.println(TAB+"Entidad "+e.getNombre());
			System.out.println(TAB+"Atributos"+e.getAtributos().size());
			System.out.println(TAB+TAB+"tVo "+e.getVo().getNombre());
			System.out.println(TAB+TAB+"Atributos "+e.getVo().getAtributos().size());
		}
	}
	public String getWebContent() {
		return webContent;
	}
	public void setWebContent(String webContent) {
		this.webContent = webContent;
	}
	public String getPaqueteJSFConverter() {
		return paqueteJSFConverter;
	}
	public void setPaqueteJSFConverter(String paqueteJSFConverter) {
		this.paqueteJSFConverter = paqueteJSFConverter;
	}
	
}
