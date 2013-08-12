package generar.ui.util;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public abstract class JeeEventHandler<T> implements EventHandler<ActionEvent> {

	private JeeActionListener<T> jeeActionListener;
	private T objeto;
	
	public JeeEventHandler(JeeActionListener<T> actionListener) {
		jeeActionListener = actionListener;
	}
	
	@Override
	public void handle(ActionEvent event) {
		objeto = manejaEvento();
		jeeActionListener.ejecutarJeeAction(objeto);
	}

	protected abstract T manejaEvento();
	
}
