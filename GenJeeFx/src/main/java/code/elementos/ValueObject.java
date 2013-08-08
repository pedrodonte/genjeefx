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
				seed.getPaqueteClase(),
				seed.getNombreClase(),
				seed.getImports(),
				seed.getAtributos(), 
				seed.getGetterSetters() };

		return parametros;
	}

}
