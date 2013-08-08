package generar.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class BarraEstadoHBox extends HBox {

	protected Text lblEntidades = new Text("## Entidades");

	public BarraEstadoHBox() {
		super(20);
		setId("barraEstado");
		setPadding(new Insets(5));
		setAlignment(Pos.CENTER);
		getChildren().add(lblEntidades);
	}

	public void setEntidades(int cantidad) {
		lblEntidades.setText(cantidad + " Entidades");
	}

}
