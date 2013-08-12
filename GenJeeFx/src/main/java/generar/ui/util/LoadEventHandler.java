package generar.ui.util;

import java.io.File;

import javafx.stage.FileChooser;

public class LoadEventHandler extends JeeEventHandler<File>{

	public LoadEventHandler(JeeActionListener<File> actionListener) {
		super(actionListener);
	}

	@Override
	protected File manejaEvento() {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
				"Xml (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);
		File file = fileChooser.showOpenDialog(null);
		return file;
	}

}
