package generar.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.GridPane;
import javafx.stage.Popup;

public class PanelPreviCodigo extends GridPane {

	Label lblNombres = new Label("Código:");
	final TextArea cpoCodigo = new TextArea();

	Button btnAceptar = new Button("Aceptar y Cerrar");
	Button btnCopPortaPapeles = new Button("Copiar al Portapales y Cerrar");
	Popup popup;
	private EventHandler<ActionEvent> ehCierra = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			popup.hide();
		}
	};

	Clipboard clipboard = Clipboard.getSystemClipboard();

	private EventHandler<ActionEvent> ehCopiar = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {

			ClipboardContent content = new ClipboardContent();
			content.putString(cpoCodigo.getText());
			clipboard.setContent(content);
			popup.hide();

		}
	};

	public PanelPreviCodigo(Popup popup) {
		this.popup = popup;
		this.setPadding(new Insets(20, 20, 20, 20));
		this.setStyle("-fx-background-color: #8fbc8f;");
		this.setHgap(7);
		this.setVgap(7);

		btnAceptar.setOnAction(ehCierra);
		cpoCodigo.setMinWidth(500);
		btnCopPortaPapeles.setOnAction(ehCopiar);

		this.add(lblNombres, 0, 0);
		this.add(cpoCodigo, 0, 1);

		this.add(btnAceptar, 0, 2);
		this.add(btnCopPortaPapeles, 1, 2);

	}

	public PanelPreviCodigo(Popup popup, String codigoGenerado) {
		this(popup);
		cpoCodigo.setText(codigoGenerado);
	}

}
