package generar.engine;

import static generar.Constantes.NL;
import static generar.Constantes.TAB;
import generar.modelo.Atributo;
import generar.modelo.Entidad;
import generar.modelo.Proyecto;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.Map.Entry;

import util.StringHelper;

public class GeneraMapper {
	
	private static final String PATRON_TO_VO = "vo.set{0}( dto.get{1}() );";
	private static final String PATRON_TO_VO_ENTIDAD = "vo.set{0}( toVO( dto.get{1}() ) );";
	
	private static final String PATRON_TO_DTO = "dto.set{1}( vo.get{0}() );";
	private static final String PATRON_TO_DTO_ENTIDAD = "dto.set{1}( toDTO( vo.get{0}() ) );";

	public static String generarToVoAtributo(Entry<Atributo, Atributo> mapeoAtributo, Proyecto proyecto) {
		Atributo aVo = mapeoAtributo.getKey();
		Atributo aDto = mapeoAtributo.getValue();
		
		boolean esEntidad = esEntidad(proyecto.getPaqueteEntrada(), aDto);
		MessageFormat messageFormat;
		String[] nombres = {StringHelper.toCamelMayuscula(aVo.getNombre()),StringHelper.toCamelMayuscula(aDto.getNombre())};
		
		if (esEntidad) {
			messageFormat = new MessageFormat(PATRON_TO_VO_ENTIDAD);
		}else{
			messageFormat = new MessageFormat(PATRON_TO_VO);
		}
		return messageFormat.format(nombres).toString();
	}
	
	public static String generarToDtoAtributo(Entry<Atributo, Atributo> mapeoAtributo, Proyecto proyecto) {
		Atributo aVo = mapeoAtributo.getKey();
		Atributo aDto = mapeoAtributo.getValue();
		
		boolean esEntidad = esEntidad(proyecto.getPaqueteEntrada(), aDto);
		MessageFormat messageFormat;
		String[] nombres = {StringHelper.toCamelMayuscula(aVo.getNombre()),StringHelper.toCamelMayuscula(aDto.getNombre())};
		
		if (esEntidad) {
			messageFormat = new MessageFormat(PATRON_TO_DTO_ENTIDAD);
		}else{
			messageFormat = new MessageFormat(PATRON_TO_DTO);
		}
		return messageFormat.format(nombres).toString();
	}

	/**
	 * @param proyecto
	 * @param aDto
	 * @return 
	 */
	private static boolean esEntidad(String packageEntidades, Atributo aDto) {
		if (!aDto.getTipo().isEsPrimitivo()) {
			if (aDto.getTipo().getPaquete().equals(packageEntidades)) {
				return true;
			}
		}
		return false;
	}
	
	public static String atributosToVO(Entidad entidad, Proyecto proyecto){
		Iterator<Entry<Atributo, Atributo>> it = entidad.getMapeoAtributosVoDto().entrySet()
				.iterator();
		
		StringBuilder setts = new StringBuilder();

		while (it.hasNext()) {
			Entry<Atributo, Atributo> entry = (Entry<Atributo, Atributo>) it.next();
			setts.append(TAB+generarToVoAtributo(entry, proyecto)+NL);
		}
		
		return setts.toString();
		
	}
	
	public static String atributosToDTO(Entidad entidad, Proyecto proyecto){
		Iterator<Entry<Atributo, Atributo>> it = entidad.getMapeoAtributosVoDto().entrySet()
				.iterator();
		
		StringBuilder setts = new StringBuilder();

		while (it.hasNext()) {
			Entry<Atributo, Atributo> entry = (Entry<Atributo, Atributo>) it.next();
			setts.append(TAB+generarToDtoAtributo(entry, proyecto)+NL);
		}
		
		return setts.toString();
		
	}

}
