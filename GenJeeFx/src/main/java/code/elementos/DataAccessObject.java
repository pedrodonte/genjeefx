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
				seed.getPaqueteDAO(), 	//0
				seed.getPaqueteDTO(),	//1
				seed.getClaseDAO(),		//2
				seed.getClaseDTO()};	//3
		return parametros;
	}

	@Override
	public String getPath(SemillaCodigoFuente seed) {
		return seed.getFullDao();
	}

}
