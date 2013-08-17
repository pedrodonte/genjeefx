package code.elementos;

import util.HelperNombres;
import generar.Constantes;
import code.CodigoFuente;
import code.PatronesCodigoFuente;
import code.SemillaCodigoFuente;


public class MantenedorXHtml extends CodigoFuente {

	public MantenedorXHtml() {
		super(PatronesCodigoFuente.JSF_MANT);
	}

	@Override
	public String getPath(SemillaCodigoFuente seed) {
		return seed.getWebContent()+"/"+HelperNombres.nombreMantenedorXHTML(seed.getClaseVO());
	}

	@Override
	protected Object[] prepararParametros(SemillaCodigoFuente seed) {
		Object[] parametros = {
				seed.getInstanciaMB(),
				seed.getTituloFormulario(),
				seed.getCamposTabla(),
				seed.getCamposFormulario(),
				seed.getRowKey()
		};
		return parametros;
	}

}
