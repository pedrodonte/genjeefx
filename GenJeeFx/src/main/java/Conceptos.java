import generar.engine.GeneraCodigoDesdePatron;

import java.text.SimpleDateFormat;
import java.util.Date;

import code.PatronesCodigoFuente;

public class Conceptos {

	public static void main(String[] args) {
		conceptoFechaStamp();
		
		Object[] param = {
			"nombreEstado",
			"personasMBean"
		};

		Object[] param1 = {
				"personasMBean",
				"Personas",
				GeneraCodigoDesdePatron.build(param, PatronesCodigoFuente.JSF_MANT_TABLA_CPO),
				GeneraCodigoDesdePatron.build(param, PatronesCodigoFuente.JSF_MANT_FORM_CPO),
				"personaCod"
				
			};
		
		System.out.println(GeneraCodigoDesdePatron.build(param1, PatronesCodigoFuente.JSF_MANT));
	}


	private static void conceptoFechaStamp() {
		System.out.println("conceptoFechaStamp");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		System.out.println(dateFormat.format(new Date()));
	}

}
