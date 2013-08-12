package generar.ui;

import generar.modelo.Proyecto;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;

public class FormularioProyecto extends GridPane {

	Label lblProyecto = new Label("Nombre Proyecto:");
	TextField cpoProyecto = new TextField();

	Label lblOutput = new Label("Output:");
	TextField cpoOutput = new TextField();

	Label lblPakgEntidad = new Label("Paquete Entidad:");
	TextField cpoPakgEntidad = new TextField();

	Label lblPakgDao = new Label("Paquete DAOs:");
	TextField cpoPakgDao = new TextField();
	
	Label lblPakgVo = new Label("Paquete Vos:");
	TextField cpoPakgVo = new TextField();
	
	Label lblPakgCrudEjb = new Label("Paquete Crud EJBs:");
	TextField cpoPakgCrudEjb = new TextField();
	
	Label lblPakgJsfController = new Label("Paquete Jsf Controller:");
	TextField cpoPakgJsfController = new TextField();

	Label lblPrefijos = new Label("Prefijos Entidades:");
	TextField cpoPrefijos = new TextField();
	
	Label lblWebContent = new Label("Web Content:");
	TextField cpoWebContent = new TextField();

	Button btnSeleccionaOutput = new Button("Selecionar");

	private Proyecto proyecto = new Proyecto();

	public FormularioProyecto() {
		super();
		add(lblProyecto, 0, 0); // Col, then Row
		add(cpoProyecto, 1, 0);

		add(lblOutput, 0, 1);
		add(cpoOutput, 1, 1);
		add(btnSeleccionaOutput, 2, 1);

		add(lblPakgEntidad, 0, 2);
		add(cpoPakgEntidad, 1, 2);

		add(lblPakgDao, 0, 3);
		add(cpoPakgDao, 1, 3);

		add(lblPrefijos, 0, 4);
		add(cpoPrefijos, 1, 4);
		
		add(lblPakgVo, 0, 5);
		add(cpoPakgVo, 1, 5);
		
		add(lblPakgCrudEjb, 0, 6);
		add(cpoPakgCrudEjb, 1, 6);
		
		add(lblPakgJsfController, 0, 7);
		add(cpoPakgJsfController, 1, 7);
		
		add(lblWebContent, 0, 8);
		add(cpoWebContent, 1, 8);
		
		btnSeleccionaOutput.setOnAction(ehSeleccionarOutput);

		cpoProyecto.setMinWidth(400);
		

		// Style controls.
		this.setPadding(new Insets(10)); // Perimeter padding
		this.setHgap(10); // Horizontal padding
		this.setVgap(10); // Vertical padding
		aplicarEstiloCampo(cpoOutput);
		aplicarEstiloCampo(cpoPakgCrudEjb);
		aplicarEstiloCampo(cpoPakgDao);
		aplicarEstiloCampo(cpoPakgEntidad);
		aplicarEstiloCampo(cpoPakgJsfController);
		aplicarEstiloCampo(cpoPakgVo);
		aplicarEstiloCampo(cpoPrefijos);
		aplicarEstiloCampo(cpoProyecto);
		aplicarEstiloCampo(cpoWebContent);
	}

	private void aplicarEstiloCampo(TextField cpo) {
		cpo.setMinHeight(30);
	}

	EventHandler<ActionEvent> ehSeleccionarOutput = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			DirectoryChooser directoryChooser = new DirectoryChooser();
			directoryChooser.setTitle("Selecciona Carpeta para Output");
			File file = directoryChooser.showDialog(null);
			if (file != null) {
				proyecto.setCarpetaSalida(file.getPath());
				cpoOutput.setText(proyecto.getCarpetaSalida());
			}

		}
	};

	public void setDatos(Proyecto proyecto) {
		cpoProyecto.setText(proyecto.getNombre());
		cpoPakgEntidad.setText(proyecto.getPaqueteEntrada());
		
		cpoPakgCrudEjb.setText(proyecto.getPaqueteCrudService());
		cpoPakgDao.setText(proyecto.getPaqueteDaos());
		cpoPakgVo.setText(proyecto.getPaqueteVos());
		cpoPakgJsfController.setText(proyecto.getPaqueteJsfController());
		cpoOutput.setText(proyecto.getCarpetaSalida());
		cpoPrefijos.setText(proyecto.getPrefijosEntidades());
		cpoWebContent.setText(proyecto.getWebContent());
	}

	public Proyecto getDatos() {
		Proyecto proyecto = new Proyecto();
		proyecto.setNombre(cpoProyecto.getText());
		proyecto.setPaqueteEntrada(cpoPakgEntidad.getText());
		
		proyecto.setPaqueteCrudService(cpoPakgCrudEjb.getText());
		proyecto.setPaqueteDaos(cpoPakgDao.getText());
		proyecto.setPaqueteVos(cpoPakgVo.getText());
		proyecto.setPaqueteJsfController(cpoPakgJsfController.getText());
		proyecto.setCarpetaSalida(cpoOutput.getText());
		proyecto.setPrefijosEntidades(cpoPrefijos.getText());
		proyecto.setWebContent(cpoWebContent.getText());
		return proyecto;
	}

}
