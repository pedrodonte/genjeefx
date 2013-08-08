package code.elementos;

import generar.Constantes;
import code.CodigoFuente;
import code.PatronesCodigoFuente;
import code.SemillaCodigoFuente;

public class CrudServiceEJBImpl extends CodigoFuente {

	public CrudServiceEJBImpl() {
		super(PatronesCodigoFuente.CRUD_EJB_IMPL);
	}

	@Override
	protected Object[] prepararParametros(
			SemillaCodigoFuente s) {
		Object[] parametros = {
				s.getPaqueteImpl(),//0
				s.getFullDao(),//1
				s.getFullDto(),//2
				s.getFullVo(),//3
				s.getClaseImpl(),//4
				s.getClaseEJB(),//5
				s.getClaseDAO(),//6
				s.getInstanciaDAO(),//7
				s.getClaseVO(),//8
				Constantes.PAQUETE_EXCEPCIONES//9
		};
		
		return parametros;
	}

}
