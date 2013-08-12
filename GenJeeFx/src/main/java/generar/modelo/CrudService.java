package generar.modelo;

import static generar.Constantes.*;

public class CrudService extends ElementoBase{
	
	public String getNombreEJB(){
		return getNombre()+SUFIJO_CRUD_INTERFACE;
	}
	
	public String getNombreEJBImpl(){
		return getNombre()+SUFIJO_CRUD_IMPLEMENT;
	}
	
	public String getPackageEJB(){
		return getPaquete()+"."+getNombre()+SUFIJO_CRUD_INTERFACE;
	}
	
	public String getPackageEJBImpl(){
		return getPaquete()+"."+getNombre()+SUFIJO_CRUD_IMPLEMENT;
	}

	@Override
	public void setNombre(String nombre) {
		super.setNombre(nombre.replace(PREFIJO_VO, ""));
	}


}
