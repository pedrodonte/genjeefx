package generar.modelo;

import generar.Constantes;
import generar.Constantes.TipoCampoFormulario;

import java.util.ArrayList;
import java.util.List;

import util.HelperNombres;

public class Vo extends ElementoBase{
	
	private List<Atributo> atributos = new ArrayList<>();
	
	public List<Atributo> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<Atributo> atributos) {
		this.atributos = atributos;
	}

	public void printAtributos() {
		System.out.println("Atributos de "+getNombreCompleto());
		for (Atributo a : atributos) {
			System.out.println(a);
		}
		
	}

	public String getJSFConverterName() {
		return HelperNombres.jsfConverterFromVO(getNombre());
	}

	public String getAtributoLabel() {
		try {
			for (Atributo a : atributos) {
				if (a.getTipoCampoFormulario().equals(TipoCampoFormulario.Texto)) {
					return a.getNombre();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(getNombre());
			for (Atributo a : atributos)
				System.out.println(a.getNombre()+" "+a.getTipo());
		}
		return Constantes.ATRIBUTO_LABEL;
	}

}
