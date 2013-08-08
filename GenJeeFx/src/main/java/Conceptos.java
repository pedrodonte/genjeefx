import generar.Constantes;
import generar.modelo.Entidad;
import generar.modelo.Vo;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import util.HelperArchivos;
import util.StringHelper;

public class Conceptos {

	public static void main(String[] args) {
		conceptoFechaStamp();

		pocCrudEjb();
		
		String clase = StringHelper.getClassFromFullName(Constantes.INTERFAZ_CRUD_GENERICA);
		System.out.println(clase);
	}

	// 0 paquete interface generada
	// 1 nombre completo vo
	// 2 nombre completo interface generic
	// 3 nombre Interface
	// 4 nombre interface generic
	// 5 nombre simple vo

	private static void pocCrudEjb() {
		
		String paqueteOutput = "info.pedrodonte.protask.servicios";
		String nombreCompletoVo = "info.pedrodonte.protask.vo.VoActividad";
		String interfaceGenerica = "info.pedrodonte.util.CrudGenericServiceApi";
		String nombreInterface = "Actividad";
		String getterSetter = "CrudGenericServiceApi";
		String nombreVo = "VoActividad";

		generarCrudServiceEjb(paqueteOutput, nombreCompletoVo,
				interfaceGenerica, nombreInterface, getterSetter, nombreVo);

	}

	/**
	 * @param paqueteOutput
	 * @param nombreCompletoVo
	 * @param interfaceGenerica
	 * @param nombreInterface
	 * @param getterSetter
	 * @param nombreVo
	 */
	private static void generarCrudServiceEjb(String paqueteOutput,
			String nombreCompletoVo, String interfaceGenerica,
			String nombreInterface, String getterSetter, String nombreVo) {

		Object[] testArgs = { paqueteOutput, nombreCompletoVo,
				interfaceGenerica, nombreInterface, getterSetter, nombreVo };

		MessageFormat form = new MessageFormat(
				HelperArchivos.leerRecurso("crud-service-ejb.txt"));

		String codigoGenerado = form.format(testArgs).replace("]", "}")
				.replace("[", "{");

		System.out.println(codigoGenerado);
	}

	private static void conceptoFechaStamp() {
		System.out.println("conceptoFechaStamp");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		System.out.println(dateFormat.format(new Date()));
	}

}
