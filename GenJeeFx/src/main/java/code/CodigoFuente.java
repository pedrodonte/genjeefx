package code;

import generar.engine.GeneraCodigoDesdePatron;

import java.io.IOException;

import util.HelperArchivos;

public abstract class CodigoFuente {
	
	private String codigoFuente;
	private String patronCodigo;
	SemillaCodigoFuente semilla;
	String pathArchivoFuente;
	
	public CodigoFuente(String patronCodigo) {
		this.patronCodigo = patronCodigo;
	}
	
	public void generarArchivoFuente(SemillaCodigoFuente semilla){
		this.semilla = semilla;
		this.pathArchivoFuente = getPath(this.semilla);
		this.pathArchivoFuente = prepararPath(this.pathArchivoFuente);
		this.pathArchivoFuente = this.pathArchivoFuente + this.semilla.getExtension();
		this.codigoFuente = generarCodigoFuente();
		this.semilla.print();
		if (semilla.isCreaArchivo()) {
			guardarArchivo();
		}else{
//			System.out.println(codigoFuente);
		}
		
	}
	
	private String prepararPath(String fullName) {
		String path = semilla.getPathDirectorioSalida();
		path = path.replace("\\", "/");
		fullName = fullName.replace(".", "/");
		return path+"/"+fullName;
	}

	public abstract String getPath(SemillaCodigoFuente seed);

	private String generarCodigoFuente(){
		return GeneraCodigoDesdePatron.build(prepararParametros(this.semilla), this.patronCodigo);
	}

	protected abstract Object[] prepararParametros(SemillaCodigoFuente semillaCodigoFuente);

	private void guardarArchivo(){
		System.out.println(pathArchivoFuente);
		try {
			HelperArchivos.comprobarPaqueteCreado(pathArchivoFuente);
			HelperArchivos.comprobarArchivoCreado(pathArchivoFuente);
		} catch (IOException e) {
			e.printStackTrace();
		}
		HelperArchivos.guardaCodigoFuente(pathArchivoFuente,codigoFuente );
	}

	public String getCodigoFuente() {
		return codigoFuente;
	}
	
}
