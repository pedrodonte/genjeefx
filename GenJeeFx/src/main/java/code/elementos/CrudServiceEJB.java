package code.elementos;

import code.CodigoFuente;
import code.PatronesCodigoFuente;
import code.SemillaCodigoFuente;

public class CrudServiceEJB extends CodigoFuente {

	public CrudServiceEJB() {
		super(PatronesCodigoFuente.CRUD_EJB);

	}

	@Override
	protected Object[] prepararParametros(SemillaCodigoFuente seed) {
		Object[] testArgs = { 
				seed.getPaqueteEJB(),
				seed.getFullVo(),
				seed.getClaseEJB(), 
				seed.getClaseVO()
			};
		return testArgs;
	}

}
