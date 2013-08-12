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
				semillaCodigoFuente.getPaqueteMapper(),
				semillaCodigoFuente.getImports(),
				semillaCodigoFuente.getMetodosMapper(),
				semillaCodigoFuente.getClaseMapper()
				};
		return parametros;
	}

	@Override
	public String getPath(SemillaCodigoFuente seed) {
		return seed.getFullMapper();
	}

}
