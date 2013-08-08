package generar;

import generar.engine.ObtenerAtributosDesdeEntityClass;
import generar.modelo.ControllerMB;
import generar.modelo.CrudService;
import generar.modelo.Dao;
import generar.modelo.Entidad;
import generar.modelo.Proyecto;
import generar.modelo.TipoAtributo;
import generar.modelo.Vo;
import generar.ui.BarraEstadoHBox;
import generar.ui.EntidadTabPane;
import generar.ui.FormularioProyecto;
import generar.ui.PanelPreviCodigo;
import generar.ui.TablaEntidadesDao;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import util.ConfiguracionApp;
import static util.XmlUtil.*;
import app.modelo.AplicacionXmlConfig;
import static code.CodigoFactory.*;

public class AplicacionPrincipal extends Application {
	private BorderPane root;

	private AplicacionXmlConfig conf;

	private Proyecto proyecto = new Proyecto();
	private Entidad registroSeleccionado = new Entidad();

	private ObservableList<Entidad> data = FXCollections.observableArrayList();

	EntidadTabPane entidadTabPane = new EntidadTabPane();
	private FormularioProyecto formularioProyecto = new FormularioProyecto();
	private TableView<Entidad> tableViewEntidades = new TablaEntidadesDao();
	private BarraEstadoHBox barraDeEstado = new BarraEstadoHBox();
	
	Set<TipoAtributo> tipoAtributos = new HashSet<>();

	EventHandler<ActionEvent> ehGuardarProyecto = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			FileChooser fileChooser = new FileChooser();

			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
					"XML (*.xml)", "*.xml");
			fileChooser.getExtensionFilters().add(extFilter);
			File file = fileChooser.showSaveDialog(null);

			if (file != null) {
				proyecto = formularioProyecto.getDatos();
				proyecto.setEntidades(data);
				convertToXmlFile(file, proyecto, Proyecto.class);
			}

		}

	};

	EventHandler<ActionEvent> ehCargarProyecto = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			FileChooser fileChooser = new FileChooser();

			// Set extension filter
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
					"Xml (*.xml)", "*.xml");
			fileChooser.getExtensionFilters().add(extFilter);

			// Show save file dialog
			File file = fileChooser.showOpenDialog(null);

			cargarProyectoDesdeArchivo(file, true);

		}
	};

	EventHandler<ActionEvent> ehSeleccionarClase = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			FileChooser fileChooser = new FileChooser();

			// Set extension filter
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
					"Byte Code (*.class)", "*.class");
			fileChooser.getExtensionFilters().add(extFilter);
			File fuente = new File(
					"C:\\pcarrasco\\desa_solaria\\workspace\\protask\\target\\classes\\info\\pedrodonte\\protask\\dto");
			fileChooser.setInitialDirectory(fuente);

			// Show save file dialog
			List<File> files = fileChooser.showOpenMultipleDialog(null);

			for (File file : files) {
				if (file != null) {
					String nombreClase = file.getName().substring(0,
							file.getName().length() - 6);
					System.out.println(nombreClase);
					Entidad entidad = new Entidad(nombreClase);
					entidad.setArchivo(file.getAbsolutePath());
					data.add(entidad);

				}
			}

		}
	};

	EventHandler<ActionEvent> ehBuscaAtributos = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			buscaAtributosEnEntidades();
		}

	};

	EventHandler<ActionEvent> ehIdentificaElementos = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			indentificarElementosGenerables();
		}
	};

	

	private EventHandler<WindowEvent> ehOnCerrarApp = new EventHandler<WindowEvent>() {
		@Override
		public void handle(WindowEvent event) {
			ConfiguracionApp.getInstancia().guardarArchivoPropiedades(conf);
		}
	};

	@Override
	public void start(Stage primaryStage) throws Exception {
		conf = ConfiguracionApp.getInstancia().leerArchivoConfiguracion();

		root = new BorderPane();
		root.setTop(getMenu());
		root.setLeft(panelEntidades(primaryStage));

		VBox vBox = new VBox();
		vBox.getChildren().add(formularioProyecto);
		vBox.getChildren().add(entidadTabPane);

		root.setCenter(vBox);

		root.setBottom(barraDeEstado);

		Scene scene = new Scene(root);
		scene.getStylesheets().add(
				getClass().getClassLoader().getResource("DarkTheme.css")
						.toExternalForm());
		primaryStage.setTitle("Generador de Código JEE - GenJeE");
		primaryStage.setScene(scene);
		primaryStage.setOnCloseRequest(ehOnCerrarApp);
		primaryStage.show();
	}

	protected void indentificarElementosGenerables() {
		for (Entidad entidadActual : data) {
			proyecto = formularioProyecto.getDatos();
			String nombreVO = entidadActual.getNombre().replace(
					proyecto.getPrefijosEntidades(), Constantes.PREFIJO_VO);

			//Se crea el VO
			Vo vo = new Vo();
			vo.setNombre(nombreVO);
			vo.setPaquete(proyecto.getPaqueteVos());
			entidadActual.setVo(vo);

			//Se crea el par EJB y EJBImpl a partir del nombre del VO.
			CrudService crudService = new CrudService(entidadActual.getVo());
			vo.setPaquete(proyecto.getPaqueteCrudService());
			entidadActual.setCrudService(crudService);
			
			Dao dao = new Dao(entidadActual.getNombre()+Constantes.SUFIJO_DAO);
			dao.setPaquete(proyecto.getPaqueteDaos());
			entidadActual.setDao(dao);
			
			ControllerMB controllerMB = new ControllerMB();
			controllerMB.setNombre(vo.getNombre().replace(Constantes.PREFIJO_VO, "")+Constantes.SUFIJO_JSF_CONTROLLER);
			controllerMB.setPaquete(proyecto.getPaqueteJsfController());
			entidadActual.setControllerMB(controllerMB);
			
		}
	}

	private MenuBar getMenu() {
		MenuBar menuBar = new MenuBar();

		Menu menuFile = new Menu("Archivo");
		MenuItem mnCargar = new MenuItem("Cargar Proyecto");
		mnCargar.setOnAction(ehCargarProyecto);

		MenuItem mnGuardar = new MenuItem("Guardar Proyecto");
		mnGuardar.setOnAction(ehGuardarProyecto);

		Menu recientes = new Menu("Recientes");

		for (final String pathReciente : conf.getArchivosRecientes()) {
			MenuItem recienteMenuItem = new MenuItem(pathReciente);
			recientes.getItems().add(recienteMenuItem);
			recienteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					cargarProyectoDesdeArchivo(new File(pathReciente), false);
				}
			});
		}

		menuFile.getItems().addAll(mnCargar, mnGuardar, recientes);

		Menu menuHerramientas = new Menu("Herramientas");

		MenuItem miBuscaAtributos = new MenuItem("Busca Atributos");
		miBuscaAtributos.setOnAction(ehBuscaAtributos);
		menuHerramientas.getItems().add(miBuscaAtributos);

		MenuItem identificaMI = new MenuItem("Identifica Elementos");
		identificaMI.setOnAction(ehIdentificaElementos);

		menuHerramientas.getItems().add(identificaMI);

		menuBar.getMenus().addAll(menuFile, menuHerramientas);

		return menuBar;
	}

	private HBox panelEntidades(final Stage stage) {

		final Popup popup = new Popup();

		// popup.getContent().addAll(formularioEntidad);

		Button btnAddEntidad = new Button("Añadir Entidad");
		btnAddEntidad.setOnAction(ehSeleccionarClase);

		Button btnVerCodigo = new Button("Ver Dao");
		btnVerCodigo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				String codigoGenerado = generarDAO(proyecto, registroSeleccionado);
				popup.getContent().addAll(
						new PanelPreviCodigo(popup, codigoGenerado));
				popup.show(stage);
			}
		});

		Button btnVerVo = new Button("Ver Vo");
		btnVerVo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				String codigoGenerado = generarVO(proyecto, registroSeleccionado);
				popup.getContent().addAll(
						new PanelPreviCodigo(popup, codigoGenerado));
				popup.show(stage);

			}
		});
		
		Button btnVerMapper = new Button("Ver Mapper");
		btnVerMapper.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				String codigoGenerado = generarMapperHelper(proyecto);
				popup.getContent().addAll(
						new PanelPreviCodigo(popup, codigoGenerado));
				popup.show(stage);

			}
		});
		
		Button btnVerEJB = new Button("Ver CRUD");
		btnVerEJB.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				String codigoGenerado = generarCrudEJB(proyecto, registroSeleccionado);
				codigoGenerado = codigoGenerado + 
						"\n\n---\n\n" +
						generarCrudEJBImpl(proyecto, registroSeleccionado);
				popup.getContent().addAll(
						new PanelPreviCodigo(popup, codigoGenerado));
				popup.show(stage);

			}
		});
		
		Button btnVerController = new Button("Ver Controller");
		btnVerController.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String codigoGenerado = generarController(proyecto, registroSeleccionado);
				popup.getContent().addAll(
						new PanelPreviCodigo(popup, codigoGenerado));
				popup.show(stage);

			}
		});

		HBox hbox = new HBox();

		VBox vbox = new VBox();
//		vbox.setPadding(new Insets(10));

		Text text = new Text("Entidades");
		text.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));

		ToolBar botones = new ToolBar();

		tableViewEntidades.setItems(data);

		tableViewEntidades.getSelectionModel().selectedItemProperty()
				.addListener(new ChangeListener<Entidad>() {

					@Override
					public void changed(
							ObservableValue<? extends Entidad> value,
							Entidad oldValue, Entidad newValue) {

						registroSeleccionado = newValue;
						entidadTabPane.setEntidad(registroSeleccionado);

					}
				});

		botones.getItems().addAll(btnAddEntidad, btnVerCodigo, btnVerVo, btnVerMapper,btnVerEJB,btnVerController);

		vbox.getChildren().addAll(text,botones, tableViewEntidades);
		hbox.getChildren().addAll(vbox, new Separator(Orientation.VERTICAL));

		return hbox;
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	private void buscaAtributosEnEntidades() {
		proyecto = formularioProyecto.getDatos();

		for (Entidad eActual : data) {
			eActual.setAtributos(ObtenerAtributosDesdeEntityClass.get(proyecto
					.getPaqueteEntrada() + "." + eActual.getNombre()));
		}
	}

	/**
	 * @param file
	 */
	private void cargarProyectoDesdeArchivo(File file,
			boolean cargarConfiguracionAplicacion) {
		if (cargarConfiguracionAplicacion) {
			conf.setArchivoReciente(file.getAbsolutePath());
		}
		if (file != null) {

			proyecto = (Proyecto) xmlFileToObject(file, Proyecto.class);
			formularioProyecto.setDatos(proyecto);

			data = FXCollections.observableArrayList();
			for (Entidad ent : proyecto.getEntidades()) {
				data.add(ent);
				for (TipoAtributo ta : ent.getTiposAtributos()) {
					tipoAtributos.add(ta);
				}
			}
			tableViewEntidades.setItems(data);

			System.out.println("Cargando " + file.getAbsolutePath());

			barraDeEstado.setEntidades(data.size());
		}
	}

}