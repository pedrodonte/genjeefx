package generar.engine;

import generar.Constantes;
import generar.modelo.Atributo;
import generar.modelo.Entidad;
import generar.modelo.Proyecto;

import java.util.ArrayList;
import java.util.List;

import util.StringHelper;

public class GenerarVO {

	Proyecto proyecto;

	public GenerarVO(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	private Atributo getDeficinionAtributoVO(Atributo aDto) {

		Atributo at = null;
		try {
			at = aDto.clone();
			at.setTipo(aDto.getTipo().clone());
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		}

		try {
			// ahora se adaptan los nombres a vo

			String nombreType = cambioNombreEntityToVO(at.getTipo().getNombre());
			String nombreAtributo = cambioNombreEntityToVO(at.getNombre());

			if (!at.getTipo().isEsPrimitivo()) {

				String paqueteAtributoVo = cambioPaqueteTipoDatoEntidad(at
						.getTipo().getPaquete());

				at.getTipo().setPaquete(paqueteAtributoVo);
			}

			at.setNombre(nombreAtributo);
			at.getTipo().setNombre(nombreType);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return at;
	}

	private String cambioPaqueteTipoDatoEntidad(String paquete) {
		boolean esEntidad = (paquete.equals(proyecto.getPaqueteEntrada()));

		String paqueteTipo = esEntidad ? proyecto.getPaqueteVos() : paquete;

		return paqueteTipo;
	}

	private String cambioNombreEntityToVO(String nombreAtributo) {

		// Tipo de Dato del atributo
		for (String prefijo : getPrefijosEntidades()) {
			nombreAtributo = nombreAtributo.replace(prefijo,
					Constantes.PREFIJO_VO);
		}

		// Nombre del atributo
		for (String prefijo : getPrefijosEntidades()) {
			String prefijoMinusculas = prefijo;
			prefijoMinusculas = prefijoMinusculas.substring(0, 1).toLowerCase()
					+ prefijoMinusculas.substring(1);

			nombreAtributo = nombreAtributo.replace(prefijoMinusculas,
					Constantes.PREFIJO_VO.toLowerCase());

		}
		return nombreAtributo;
	}

	private List<String> getPrefijosEntidades() {
		return StringHelper.proListado(proyecto.getPrefijosEntidades());
	}

	/**
	 * Procesa los atributos del DTO y los habilita para que pertenesca al VO,
	 * Además genera la tabla de mapeo que se usara para 
	 * construir el Mapper entre DTO y VO.
	 * 
	 * @param DTO con sus Atributos
	 * @return lista de atributos para el VO
	 */
	public List<Atributo> adaptarAtributosEntidad(Entidad entidad) {
		List<Atributo> atributosVO = new ArrayList<>();
		for (Atributo aDTO : entidad.getAtributos()) {
			if (!aDTO.getTipo().isEsInterface()) {
				if (!aDTO.getNombre().equals("serialVersionUID")) {
					Atributo aVO = this.getDeficinionAtributoVO(aDTO);
					atributosVO.add(aVO);
					entidad.getMapeoAtributosVoDto().put(aVO, aDTO);
				}
			}
		}
		return atributosVO;
	}

}
