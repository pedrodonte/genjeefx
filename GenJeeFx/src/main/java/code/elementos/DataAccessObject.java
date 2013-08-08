package code.elementos;

import code.CodigoFuente;
import code.PatronesCodigoFuente;
import code.SemillaCodigoFuente;

public class DataAccessObject extends CodigoFuente {

	public DataAccessObject() {
		super(PatronesCodigoFuente.DATA_ACCESS_OBJECT);
	}

	@Override
	protected Object[] prepararParametros(SemillaCodigoFuente seed) {
		
		Object[] parametros = { 
				seed.getPaqueteClase(), 	//0
				seed.getPaqueteClaseAux(),	//1
				seed.getNombreClase(),		//2
				seed.getNombreClaseAux()};	//3
		return parametros;
	}

}
