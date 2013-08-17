package generar.ui;

import generar.modelo.Entidad;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import com.sun.prism.impl.Disposer.Record;

public class TablaEntidadesDao extends TableView<Entidad> {

	TableColumn<Entidad, String> entidadCol = new TableColumn<>("Entidad");
	TableColumn<Entidad, String> actionCol = new TableColumn<>("Acción");

	@SuppressWarnings("unchecked")
	public TablaEntidadesDao() {
		super();
		this.setEditable(true);
		entidadCol
				.setCellValueFactory(new PropertyValueFactory<Entidad, String>(
						"nombre"));

		entidadCol.setMinWidth(300);
		actionCol.setMinWidth(200);

		actionCol
				.setCellValueFactory(new PropertyValueFactory<Entidad, String>(
						"nombre"));
		actionCol.setCellFactory(printColumnCellFactory);

		this.getColumns().addAll(entidadCol);
		this.getColumns().add(actionCol);

//		this.setMaxHeight(400);
//		this.setMaxWidth(502);
	}

	Callback<TableColumn<Entidad, String>, TableCell<Entidad, String>> printColumnCellFactory = //
	new Callback<TableColumn<Entidad, String>, TableCell<Entidad, String>>() {
		@Override
		public TableCell call(final TableColumn param) {
			final TableCell cell = new TableCell() {

				@Override
				public void updateItem(Object item, boolean empty) {
					super.updateItem(item, empty);
					if (empty) {
						setText(null);
						setGraphic(null);
					} else {
						final Button btnPrint = new Button("Eliminar");
						btnPrint.setOnAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent event) {
								param.getTableView().getSelectionModel()
										.select(getIndex());
								Entidad item = getSelectionModel()
										.getSelectedItem();
								if (item != null) {
									System.out.println(item);
									getItems().remove(item);
								}
							}
						});
						setGraphic(btnPrint);
						setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
					}
				}
			};
			return cell;
		}
	};

}
