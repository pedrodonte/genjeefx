package generar.modelo;

public class TipoAtributo extends ElementoBase implements Cloneable {

	private String paquete;
	private boolean esPrimitivo;
	private boolean esInterface;
	
	public String getPaquete() {
		return paquete;
	}
	public void setPaquete(String paquete) {
		this.paquete = paquete;
	}
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
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (esInterface ? 1231 : 1237);
		result = prime * result + (esPrimitivo ? 1231 : 1237);
		result = prime * result + ((paquete == null) ? 0 : paquete.hashCode());
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
		if (paquete == null) {
			if (other.paquete != null)
				return false;
		} else if (!paquete.equals(other.paquete))
			return false;
		return true;
	}
	
	public String toString2() {
		return "TipoAtributo [paquete=" + paquete + ", esPrimitivo="
				+ esPrimitivo + ", esInterface=" + esInterface
				+ ", getNombre()=" + getNombre() + "]";
	}
	
	@Override
	public String toString() {
		return (paquete==null?"":paquete+".") + getNombre();
	}
	
	
	public TipoAtributo clone() throws CloneNotSupportedException {
		return (TipoAtributo) super.clone();
	}
	
	
	
}
