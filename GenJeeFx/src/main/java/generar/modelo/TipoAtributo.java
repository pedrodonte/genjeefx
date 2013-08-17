package generar.modelo;

public class TipoAtributo extends ElementoBase implements Cloneable {

	//private String paquete;
	private boolean esPrimitivo;
	private boolean esInterface;
	
//	public String getPaquete() {
//		return paquete;
//	}
//	public void setPaquete(String paquete) {
//		this.paquete = paquete;
//	}
	public boolean isEsPrimitivo() {
		return esPrimitivo;
	}
	public void setEsPrimitivo(boolean esPrimitivo) {
		this.esPrimitivo = esPrimitivo;
	}
	public boolean isEsInterface() {
		return esInterface;
	}
	public void setEsInterface(boolean esInterface) {
		this.esInterface = esInterface;
	}
	
	public String toString2() {
		return "TipoAtributo [paquete=" + getPaquete() + ", esPrimitivo="
				+ esPrimitivo + ", esInterface=" + esInterface
				+ ", getNombre()=" + getNombre() + "]";
	}
	
	@Override
	public String toString() {
		return (getPaquete()==null?"":getPaquete()+".") + getNombre();
	}
	
	public TipoAtributo clone() throws CloneNotSupportedException {
		return (TipoAtributo) super.clone();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (esInterface ? 1231 : 1237);
		result = prime * result + (esPrimitivo ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoAtributo other = (TipoAtributo) obj;
		if (esInterface != other.esInterface)
			return false;
		if (esPrimitivo != other.esPrimitivo)
			return false;
		return true;
	}
	
	
	
}
