package generar.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Entidad extends ElementoBase {
	
	private Dao dao = new Dao();
	private Vo vo = new Vo();
	
	private CrudService crudService;
	private ControllerMB controllerMB;
	
	@XmlTransient
	private Map<Atributo, Atributo> mapeoAtributosVoDto = new HashMap<>();
	
	private String archivo;
	private List<Atributo> atributos = new ArrayList<>();
	
	public Entidad(String nombreEntidad) {
		super();
		super.setNombre(nombreEntidad);
		setDao(new Dao(nombreEntidad + "DAO"));
	}

	public Entidad() {
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	public List<Atributo> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<Atributo> atributos) {
		this.atributos = atributos;
	}
	
	public List<TipoAtributo> getTiposAtributos(){
		List<TipoAtributo> tipos = new ArrayList<>();
		for (Atributo a : atributos) {
			tipos.add(a.getTipo());
		}
		return tipos;
	}

	public Vo getVo() {
		return vo;
	}

	public void setVo(Vo vo) {
		this.vo = vo;
	}

	public CrudService getCrudService() {
		return crudService;
	}

	public void setCrudService(CrudService crudService) {
		this.crudService = crudService;
	}

	public Map<Atributo, Atributo> getMapeoAtributosVoDto() {
		return mapeoAtributosVoDto;
	}

	public void setMapeoAtributosVoDto(Map<Atributo, Atributo> mapeoAtributosVoDto) {
		this.mapeoAtributosVoDto = mapeoAtributosVoDto;
	}

	public ControllerMB getControllerMB() {
		return controllerMB;
	}

	public void setControllerMB(ControllerMB controllerMB) {
		this.controllerMB = controllerMB;
	}

}
