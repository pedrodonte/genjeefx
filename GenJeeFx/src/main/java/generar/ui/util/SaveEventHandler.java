package generar.ui.util;

import java.io.File;

import javafx.stage.FileChooser;

public class SaveEventHandler extends JeeEventHandler<File> {

	
	public SaveEventHandler(JeeActionListener<File> actionListener) {
		super(actionListener);
	}

	@Override
	protected File manejaEvento() {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);
		File file = fileChooser.showSaveDialog(null);
		return file;
	}
	
}
