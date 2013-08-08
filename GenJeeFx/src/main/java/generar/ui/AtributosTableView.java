package generar.ui;

import generar.engine.TablaDatosFactory;
import generar.modelo.Atributo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AtributosTableView extends TableView<Atributo> {

	TableColumn<Atributo, String> atributoCol;
	TableColumn<Atributo, String> tipoCol;

	private ObservableList<Atributo> data = FXCollections.observableArrayList();

	public ObservableList<Atributo> getData() {
		return data;
	}

	public void setData(ObservableList<Atributo> data) {
		this.data = data;
	}

	public AtributosTableView() {
		super();
		
		atributoCol = TablaDatosFactory.construirColumnaAtributo("Atributo", "nombre", 200);
		tipoCol = TablaDatosFactory.construirColumnaAtributo("Tipo", "tipo", 300);

		this.getColumns().add(atributoCol);
		this.getColumns().add(tipoCol);
		this.setItems(data);
	}

	public void addAtributo(Atributo atributo) {
		data.add(atributo);
		System.out.println(atributo);
	}

	public void vaciarTabla() {
		// data = null;
		data.clear();
	}

}
