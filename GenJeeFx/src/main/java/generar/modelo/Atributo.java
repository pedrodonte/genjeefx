package generar.modelo;

import java.lang.reflect.Field;

public class Atributo extends ElementoBase implements Cloneable{
	
	private TipoAtributo tipo = new TipoAtributo();
	
	public Atributo(Field field) {
		super.setNombre(field.getName());
		boolean esInterface = false;
		boolean esPrimitivo = false;
		String nombreTipo = null;
		String paquete = null;
		
		// Analisis
		String parteA = field.getType().toString().split(" ")[0];
		
		esPrimitivo = (parteA.equals("interface")? false : (parteA.equals("class")?false:true));
		esInterface = (parteA.equals("interface")? true : false);
		
		if (!esPrimitivo) {
			String parteB = field.getType().toString().split(" ")[1];
			paquete = parteB.substring(0, parteB.lastIndexOf("."));
			nombreTipo = parteB.substring(parteB.lastIndexOf(".")+1, parteB.length());
		}else{
			nombreTipo = parteA;
		}
		
		// Seteo de Parametros
		
		this.tipo.setEsInterface(esInterface);
		this.tipo.setEsPrimitivo(esPrimitivo);
		this.tipo.setNombre(nombreTipo);
		this.tipo.setPaquete(paquete);
	}
	
	public Atributo() {
	}
	
	public TipoAtributo getTipo() {
		return tipo;
	}

	public void setTipo(TipoAtributo tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "Atributo [tipo=" + tipo.toString2() + ", getNombre()=" + getNombre() + "]";
	}

	public Atributo clone() throws CloneNotSupportedException {
		return (Atributo) super.clone();
	}
	
	public boolean esImportable(){
		
		boolean atributoImportable = false;
		
		atributoImportable = this.getTipo().isEsPrimitivo()?false:true;
		
		if (!getTipo().isEsPrimitivo()) {
			atributoImportable = this.getTipo().getPaquete().equals("java.lang")?false:true;
		}
		
		
		return atributoImportable;
	}
	

}
