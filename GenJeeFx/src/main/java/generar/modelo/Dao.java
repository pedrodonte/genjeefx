package generar.modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Dao extends ElementoBase{

	public Dao(String nombre) {
		super.setNombre(nombre);
	}

	public Dao() {
		// TODO Auto-generated constructor stub
	}
	
}
