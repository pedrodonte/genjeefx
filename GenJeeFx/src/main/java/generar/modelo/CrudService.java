package generar.modelo;

import static generar.Constantes.*;

public class CrudService extends ElementoBase{
	
	private ElementoBase crudInterface = new ElementoBase();
	private ElementoBase crudImplement = new ElementoBase();
	
	public CrudService(Vo vo) {
		String nombreVoSimplificado = simplificarNombreVo(vo.getNombre());
		this.crudInterface.setNombre(nombreVoSimplificado+SUFIJO_CRUD_INTERFACE);
		this.crudImplement.setNombre(nombreVoSimplificado+SUFIJO_CRUD_IMPLEMENT);
	}

	private String simplificarNombreVo(String nombre) {
		return nombre.replace(PREFIJO_VO, "");
	}
	
	public ElementoBase getCrudInterface() {
		return crudInterface;
	}

	public void setCrudInterface(ElementoBase crudInterface) {
		this.crudInterface = crudInterface;
	}

	public ElementoBase getCrudImplement() {
		return crudImplement;
	}

	public void setCrudImplement(ElementoBase crudImplement) {
		this.crudImplement = crudImplement;
	}

	@Override
	public void setPaquete(String paquete) {
		super.setPaquete(paquete);
		crudImplement.setPaquete(paquete);
		crudInterface.setPaquete(paquete);
	}

}
