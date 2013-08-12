package code.elementos;

import static code.PatronesCodigoFuente.MAPPER_METODOS;
import code.CodigoFuente;
import code.SemillaCodigoFuente;

public class MapperMetodos extends CodigoFuente {

	public MapperMetodos() {
		super(MAPPER_METODOS);
	}

	@Override
	protected Object[] prepararParametros(
			SemillaCodigoFuente seed) {

		Object[] parametros = { 
				seed.getClaseVO(), 
				seed.getClaseDTO(), 
				seed.getMetodosVO(), 
				seed.getMetodosDTO()
			};

		return parametros;
	}

	@Override
	public String getPath(SemillaCodigoFuente seed) {
		seed.setCreaArchivo(false);
		return null;
	}

}
