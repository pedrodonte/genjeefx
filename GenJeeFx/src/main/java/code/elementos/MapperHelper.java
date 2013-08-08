package code.elementos;

import code.CodigoFuente;
import code.PatronesCodigoFuente;
import code.SemillaCodigoFuente;

public class MapperHelper extends CodigoFuente {

	public MapperHelper() {
		super(PatronesCodigoFuente.MAPPER_HELPER);
	}

	@Override
	protected Object[] prepararParametros(
			SemillaCodigoFuente semillaCodigoFuente) {
		Object[] parametros = { 
				semillaCodigoFuente.getPaqueteClase(),
				semillaCodigoFuente.getImports(),
				semillaCodigoFuente.getMetodos() };
		return parametros;
	}

}
