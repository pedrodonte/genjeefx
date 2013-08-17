package generar.modelo;

import generar.Constantes.TipoCampoFormulario;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Atributo extends ElementoBase implements Cloneable{
	
	private TipoAtributo tipo = new TipoAtributo();
	
	private TipoCampoFormulario tipoCampoFormulario;
	/**
	 * Es identificador unico de la instancia, por ejemplo es la PK o tiene la anotación ID de JPA
	 */
	private boolean identificadorUnico;
	
	public Atributo(Field field) {
		super.setNombre(field.getName());
		boolean esInterface = false;
		boolean esPrimitivo = false;
		String nombreTipo = null;
		String paquete = null;
		
		buscaAnotaciones(field);
		
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
		
		System.out.println(this.toString());
	}
	
	@Deprecated
	private void buscaAnotaciones(Field field) {
		Annotation[] anotaciones = field.getAnnotations();
		for (Annotation a : anotaciones) {
			System.out.println(a.getClass());
		}
	}

	public Atributo() {
	}
	
	public TipoAtributo getTipo() {
		return tipo;
	}

	public void setTipo(TipoAtributo tipo) {
		this.tipo = tipo;
	}
	
	public Atributo clone() throws CloneNotSupportedException {
		return (Atributo) super.clone();
	}
	
	/**
	 * Determina si el tipo de dato es importable para generar la clase,
	 * esto es si debe ir en el bloque de import *.Clase ;
	 * 
	 * @return si es o no importable
	 */
	public boolean esImportable(){
		
		boolean atributoImportable = false;
		
		atributoImportable = this.getTipo().isEsPrimitivo()?false:true;
		
		if (!getTipo().isEsPrimitivo()) {
			atributoImportable = this.getTipo().getPaquete().equals("java.lang")?false:true;
		}
		
		
		return atributoImportable;
	}

	public TipoCampoFormulario getTipoCampoFormulario() {
		return tipoCampoFormulario;
	}

	public void setTipoCampoFormulario(TipoCampoFormulario tipoCampoFormulario) {
		this.tipoCampoFormulario = tipoCampoFormulario;
	}

	@Override
	public String toString() {
		return "Atributo [tipo=" + tipo.toString2() + ", tipoCampoFormulario="	+ tipoCampoFormulario + "]";
	}

	public boolean isIdentificadorUnico() {
		return identificadorUnico;
	}

	public void setIdentificadorUnico(boolean identificadorUnico) {
		this.identificadorUnico = identificadorUnico;
	}


}
