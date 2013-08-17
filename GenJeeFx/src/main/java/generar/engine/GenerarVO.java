package generar.engine;

import generar.modelo.Atributo;
import generar.modelo.Entidad;
import generar.modelo.Proyecto;

import java.util.ArrayList;
import java.util.List;

import util.HelperNombres;

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

//			String nombreType = cambioNombreEntityToVO(at.getTipo().getNombre());
//			String nombreAtributo = cambioNombreEntityToVO(at.getNombre());
			
			String nombreType = HelperNombres.cambioNombreEntityToVO(at.getTipo().getNombre(), proyecto.getPrefijosEntidades());
			String nombreAtributo = HelperNombres.cambioNombreEntityToVO(at.getNombre(), proyecto.getPrefijosEntidades());

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

	
	/**
	 * Recibe el paquete del tipo de dato del atributo, comprueba si es un DTO y si es así
	 * retorna el nombre de paquetes del VO, sino retorna el mismo.
	 * @param paquete del tipo de dato
	 * @return paquete varificado si es o no DTO
	 */
	private String cambioPaqueteTipoDatoEntidad(String paquete) {
		boolean esEntidad = (paquete.equals(proyecto.getPaqueteEntrada()));

		String paqueteTipo = esEntidad ? proyecto.getPaqueteVos() : paquete;

		return paqueteTipo;
	}

	/**
	 * Procesa los atributos del DTO y los habilita para que pertenesca al VO,
	 * Además genera la tabla de mapeo que se usara para 
	 * construir el Mapper entre DTO y VO.
	 * 
	 * usa la caracteristica paso por referencia para setear el mapeo VO-DTO
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
					aVO.setTipoCampoFormulario( MapeoTipoCampo.get( aVO.getTipo().getNombre() ) );
					
					
					
					atributosVO.add(aVO);
					entidad.getMapeoAtributosVoDto().put(aVO, aDTO);
				}
			}
		}
		return atributosVO;
	}


}
