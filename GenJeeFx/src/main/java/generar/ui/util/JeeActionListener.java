package generar.ui.util;

public interface JeeActionListener<T> {
	
	void ejecutarJeeAction(T data);
	boolean condicionanteEjecucion();

}
