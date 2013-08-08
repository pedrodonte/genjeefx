package code.elementos;

import static code.PatronesCodigoFuente.MAPPER_DTO_TO_VO;
import code.CodigoFuente;
import code.SemillaCodigoFuente;

public class MapperMetodos extends CodigoFuente {

	public MapperMetodos() {
		super(MAPPER_DTO_TO_VO);
	}

	@Override
	protected Object[] prepararParametros(
			SemillaCodigoFuente seed) {

		Object[] parametros = { 
				seed.getNombreClase(), 
				seed.getNombreClaseAux(), 
				seed.getAtributos(), 
				seed.getAtributosAux() };

		return parametros;
	}

}
