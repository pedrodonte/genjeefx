package generar.ui.util;

import java.io.File;
import java.util.List;

import javafx.stage.FileChooser;


public class SelectClassDTOEventHandler extends JeeEventHandler<List<File>>{

	public SelectClassDTOEventHandler(
			JeeActionListener<List<File>> actionListener) {
		super(actionListener);
	}

	@Override
	protected List<File> manejaEvento() {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
				"Byte Code (*.class)", "*.class");
		fileChooser.getExtensionFilters().add(extFilter);
		File fuente = new File(
				"C:\\pcarrasco\\desa_solaria\\workspace\\protask\\target\\classes\\info\\pedrodonte\\protask\\dto");
		fileChooser.setInitialDirectory(fuente);
		List<File> files = fileChooser.showOpenMultipleDialog(null);
		
		return files;
	}

	

}
