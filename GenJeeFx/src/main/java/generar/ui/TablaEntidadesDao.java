package generar.ui;

import generar.modelo.Entidad;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class TablaEntidadesDao extends TableView<Entidad> {

	TableColumn<Entidad, String> entidadCol = new TableColumn<>("Entidad");

	@SuppressWarnings( { "unchecked", "rawtypes" } )
	public TablaEntidadesDao() {
		super();
		this.setEditable(true);
		entidadCol
				.setCellValueFactory(new PropertyValueFactory<Entidad, String>(
						"nombre"));

		TableColumn daoCol = new TableColumn("DAO");
		daoCol.setMinWidth(250);
		daoCol
				.setCellValueFactory(new PropertyValueFactory<Entidad, String>(
						"dao.nombre"));
		daoCol.setCellFactory(TextFieldTableCell.forTableColumn());
		daoCol
				.setOnEditCommit(new EventHandler<CellEditEvent<Entidad, String>>() {
					@Override
					public void handle(
							CellEditEvent<Entidad, String> cellEditEvent) {
						((Entidad) cellEditEvent.getTableView().getItems()
								.get(cellEditEvent.getTablePosition().getRow()))
								.getDao()
								.setNombre(cellEditEvent.getNewValue());
					}
				});

		entidadCol.setMinWidth(500);

		this.getColumns().addAll(entidadCol);

		this.setMaxHeight(400);
		this.setMaxWidth(502);
	}

}
