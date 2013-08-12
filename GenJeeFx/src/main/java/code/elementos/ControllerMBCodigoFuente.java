package code.elementos;

import code.CodigoFuente;
import code.PatronesCodigoFuente;
import code.SemillaCodigoFuente;

public class ControllerMBCodigoFuente extends CodigoFuente{

	public ControllerMBCodigoFuente() {
		super(PatronesCodigoFuente.CONTROLLER_JSF);
	}

	@Override
	protected Object[] prepararParametros(
			SemillaCodigoFuente s) {
		Object[] parametros = {
				s.getPaqueteMB(),
				s.getFullEjb(),
				s.getFullVo(),
				s.getClaseMB(),
				s.getClaseVO(),
				s.getClaseEJB()
		};
		return parametros;
	}

	@Override
	public String getPath(SemillaCodigoFuente seed) {
		return seed.getFullControllerMB();
	}

}
