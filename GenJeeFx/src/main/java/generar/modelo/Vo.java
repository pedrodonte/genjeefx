package generar.modelo;

import java.util.ArrayList;
import java.util.List;

public class Vo extends ElementoBase{
	
	private List<Atributo> atributos = new ArrayList<>();
	
	public List<Atributo> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<Atributo> atributos) {
		this.atributos = atributos;
	}

}
