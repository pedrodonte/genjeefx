package code.elementos;

import code.CodigoFuente;
import code.PatronesCodigoFuente;
import code.SemillaCodigoFuente;

public class ValueObject extends CodigoFuente {

	public ValueObject() {
		super(PatronesCodigoFuente.VALUE_OBJECT);
	}

	@Override
	protected Object[] prepararParametros(SemillaCodigoFuente seed) {
		
		Object[] parametros = { 
				seed.getPaqueteVO(),
				seed.getClaseVO(),
				seed.getImports(),
				seed.getAtributos(), 
				seed.getGetterSetters() 
		};

		return parametros;
	}

	@Override
	public String getPath(SemillaCodigoFuente seed) {
		return seed.getFullVo();
	}

}
