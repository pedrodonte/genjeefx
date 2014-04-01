package code.elementos;

import code.CodigoFuente;
import code.PatronesCodigoFuente;
import code.SemillaCodigoFuente;

public class JSFConverterCodigoFuente extends CodigoFuente {

	public JSFConverterCodigoFuente() {
		super(PatronesCodigoFuente.CONVERTER_JSF);
	}

	@Override
	public String getPath(SemillaCodigoFuente seed) {
		return seed.getFullConverter();
	}

	@Override
	protected Object[] prepararParametros(
			SemillaCodigoFuente seed) {
		Object[] param = {
				seed.getPaqueteJSFConverter(),
				seed.getFullVo(),
				seed.getFullEjb(),
				seed.getClaseJSFConverter(),
				seed.getClaseEJB(),
				seed.getClaseVO(),
				(seed.getLabelVOMetodo()==null?"getNombre()":seed.getLabelVOMetodo())
		};
		return param;
	}

}
