package generar.ui;

import generar.modelo.Atributo;
import generar.modelo.Entidad;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class EntidadTabPane extends TabPane {
	
	Tab atributosTab = new Tab("Atributos Entidad");
	Tab atributosVoTab = new Tab("Atributos Value Object");
	Tab elementosTab = new Tab("Elementos a Generar");
	
	FormularioEntidad formularioEntidad = new FormularioEntidad();
	AtributosTableView atributosTableView = new AtributosTableView();
	AtributosTableView atributosVoTableView = new AtributosTableView();
	
	public EntidadTabPane() {
		super();
		initPanel();
	}

	private void initPanel() {
		atributosTab.setClosable(false);
		elementosTab.setClosable(false);
		atributosVoTab.setClosable(false);
		
		elementosTab.setContent(formularioEntidad);
		atributosTab.setContent(atributosTableView);
		atributosVoTab.setContent(atributosVoTableView);
		
		this.getTabs().addAll(atributosTab,atributosVoTab, elementosTab);
		
	}


	public void setEntidad(Entidad registroSeleccionado) {
		if (registroSeleccionado != null) {
			formularioEntidad.setEntidad(registroSeleccionado);
			atributosTableView.vaciarTabla();
			for (Atributo at : registroSeleccionado.getAtributos()) {
				atributosTableView.addAtributo(at);
			}
			atributosVoTableView.vaciarTabla();
			for (Atributo at : registroSeleccionado.getVo().getAtributos()) {
				atributosVoTableView.addAtributo(at);
			}
		}
		
	}
	
	public void setModificadorEntidad(IModificaEntidad modificaEntidad){
		formularioEntidad.setiModificaEntidad(modificaEntidad);
	}

}
