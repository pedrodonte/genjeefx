package generar.engine;

import generar.modelo.Atributo;
import generar.modelo.TipoAtributo;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class TablaDatosFactory {

	public static TableColumn<Atributo, String> construirColumnaAtributo(
			String header, String valor, int ancho) {

		TableColumn<Atributo, String> columna = new TableColumn<>(header);
		columna.setCellValueFactory(new PropertyValueFactory<Atributo, String>(
				valor));
		columna.setMinWidth(ancho);

		return columna;
	}

	public static TableColumn<TipoAtributo, String> construirColumnaTipoAtr(
			String header, String valor, int ancho) {
		TableColumn<TipoAtributo, String> columna = new TableColumn<>(header);
		columna.setCellValueFactory(new PropertyValueFactory<TipoAtributo, String>(
				valor));
		columna.setMinWidth(ancho);

		return columna;
	}

}
