package app.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AplicacionXmlConfig {
	
	private List<String> archivosRecientes = new ArrayList<>();

	public List<String> getArchivosRecientes() {
		return archivosRecientes;
	}

	public void setArchivosRecientes(List<String> archivosRecientes) {
		this.archivosRecientes = archivosRecientes;
	}

	public void setArchivoReciente(String absolutePath) {
		if (!archivosRecientes.contains(absolutePath)) {
			archivosRecientes.add(absolutePath);	
		}
	}

}
