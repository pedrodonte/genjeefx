package code;

import generar.engine.GeneraCodigoDesdePatron;
import util.HelperArchivos;

public abstract class CodigoFuente {
	
	private String codigoFuente;
	private String patronCodigo;
	SemillaCodigoFuente semilla;
	
	public CodigoFuente(String patronCodigo) {
		this.patronCodigo = patronCodigo;
	}
	
	public void generarArchivoFuente(SemillaCodigoFuente semilla){
		this.semilla = semilla;
		this.codigoFuente = generarCodigoFuente();
		this.semilla.print();
		if (semilla.isCreaArchivo()) {
			guardarArchivo();
		}else{
//			System.out.println(codigoFuente);
		}
		
	}
	
	private String generarCodigoFuente(){
		return GeneraCodigoDesdePatron.build(prepararParametros(this.semilla), this.patronCodigo);
	}

	protected abstract Object[] prepararParametros(SemillaCodigoFuente semillaCodigoFuente);

	private void guardarArchivo(){
		HelperArchivos.guardaCodigoFuente(codigoFuente, semilla.getPathArchivoFuente());
	}

	public String getCodigoFuente() {
		return codigoFuente;
	}
	
}
