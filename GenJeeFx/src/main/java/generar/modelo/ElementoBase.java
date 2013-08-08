package generar.modelo;

public class ElementoBase {
	
	private String nombre;
	private String paquete;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getPaquete() {
		return paquete;
	}

	public void setPaquete(String paquete) {
		this.paquete = paquete;
	}
	
	public String getNombreCompleto(){
		return paquete+"."+nombre;
	}
	
	public String getFuturoPath(){
		return getNombreCompleto().replace(".", "/");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((paquete == null) ? 0 : paquete.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ElementoBase other = (ElementoBase) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (paquete == null) {
			if (other.paquete != null)
				return false;
		} else if (!paquete.equals(other.paquete))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ElementoBase [nombre=" + nombre + ", paquete=" + paquete + "]";
	}
	
	
	
}
