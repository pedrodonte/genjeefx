package code;

import generar.Constantes;
import generar.engine.BuscaGetterSetterParaVOs;
import generar.engine.BuscaImportsParaVOs;
import generar.engine.GeneraCodigoAtributosParaVOs;
import generar.engine.GeneraCodigoDesdePatron;
import generar.engine.GeneraMapper;
import generar.modelo.Atributo;
import generar.modelo.Entidad;
import generar.modelo.Proyecto;

import code.elementos.ControllerMBCodigoFuente;
import code.elementos.CrudServiceEJB;
import code.elementos.CrudServiceEJBImpl;
import code.elementos.DataAccessObject;
import code.elementos.MantenedorXHtml;
import code.elementos.MapperHelper;
import code.elementos.ValueObject;

public class CodigoFactory {

	public enum Elementos {
		DAO, VO, EJB, EJB_IMPL, MBEAN, XHTML, MAPPER
	}

	private static String generarVO(Proyecto proyecto, Entidad entidad) {
		try {
			SemillaCodigoFuente seed = inicializarSemilla(proyecto);
			seed = prepararSemilla(seed, entidad);
			seed.setImports(BuscaImportsParaVOs.getImports(entidad.getVo()
					.getAtributos()));
			seed.setAtributos(GeneraCodigoAtributosParaVOs
					.getAtributosPrivate(entidad.getVo().getAtributos()));
			seed.setGetterSetters(BuscaGetterSetterParaVOs
					.getTodosSetterGetter(entidad.getVo().getAtributos()));

			CodigoFuente sourceCode = new ValueObject();
			sourceCode.generarArchivoFuente(seed);

			return sourceCode.getCodigoFuente();
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	private static String generarDAO(Proyecto proyecto, Entidad entidad) {
		try {
			SemillaCodigoFuente seed = inicializarSemilla(proyecto);
			seed = prepararSemilla(seed, entidad);
			CodigoFuente sourceCode = new DataAccessObject();
			sourceCode.generarArchivoFuente(seed);
			return sourceCode.getCodigoFuente();
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	private static String generarMapperMetodo(Proyecto proyecto, Entidad entidad) {
		try {
			Object[] parametros = { entidad.getVo().getNombre(),
					entidad.getNombre(),
					GeneraMapper.atributosToVO(entidad, proyecto),
					GeneraMapper.atributosToDTO(entidad, proyecto) };

			return GeneraCodigoDesdePatron.build(parametros,
					PatronesCodigoFuente.MAPPER_METODOS);
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	private static String generarMapperHelper(Proyecto proyecto) {
		try {

			StringBuilder imports = new StringBuilder();
			StringBuilder metodos = new StringBuilder();

			for (Entidad entidad : proyecto.getEntidades()) {
				imports.append("import " + entidad.getNombreCompleto() + ";\n");
				metodos.append(generarMapperMetodo(proyecto, entidad));
			}

			SemillaCodigoFuente seed = inicializarSemilla(proyecto);
			seed.setImports(imports.toString());
			seed.setMetodosMapper(metodos.toString());
			seed.setClaseMapper(Constantes.CLASE_MAPPER);
			System.out.println("setMetodosMapper  " + metodos.toString());

			CodigoFuente sourceCode = new MapperHelper();
			sourceCode.generarArchivoFuente(seed);

			return sourceCode.getCodigoFuente();
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	private static String generarCrudEJB(Proyecto proyecto, Entidad entidad) {

		try {
			SemillaCodigoFuente seed = inicializarSemilla(proyecto);
			seed = prepararSemilla(seed, entidad);
			CodigoFuente sourceCode = new CrudServiceEJB();
			sourceCode.generarArchivoFuente(seed);
			return sourceCode.getCodigoFuente();
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	private static String generarCrudEJBImpl(Proyecto proyecto, Entidad entidad) {
		try {
			SemillaCodigoFuente seed = inicializarSemilla(proyecto);
			seed = prepararSemilla(seed, entidad);
			CodigoFuente sourceCode = new CrudServiceEJBImpl();
			sourceCode.generarArchivoFuente(seed);
			return sourceCode.getCodigoFuente();
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	private static String generarController(Proyecto proyecto, Entidad entidad) {
		try {
			SemillaCodigoFuente seed = inicializarSemilla(proyecto);
			seed = prepararSemilla(seed, entidad);

			CodigoFuente sourceCode = new ControllerMBCodigoFuente();
			sourceCode.generarArchivoFuente(seed);

			return sourceCode.getCodigoFuente();
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	private static String generarMantenedorXhtml(Proyecto proyecto,
			Entidad entidad) {
		try {
			SemillaCodigoFuente seed = inicializarSemilla(proyecto);
			seed = prepararSemilla(seed, entidad);
			StringBuilder camposFormulario = new StringBuilder();
			StringBuilder camposTabla = new StringBuilder();

			for (Atributo atri : entidad.getVo().getAtributos()) {
				Object[] param = { atri.getNombre(), seed.getInstanciaMB() };
				camposFormulario.append(GeneraCodigoDesdePatron.build(param,
						PatronesCodigoFuente.JSF_MANT_FORM_CPO));
				camposTabla.append(GeneraCodigoDesdePatron.build(param,
						PatronesCodigoFuente.JSF_MANT_TABLA_CPO));
			}

			seed.setCamposFormulario(camposFormulario.toString());
			seed.setCamposTabla(camposTabla.toString());
			seed.setRowKey(entidad.getVo().getAtributos().get(0).getNombre());
			seed.setTituloFormulario(entidad.getNombre());
			seed.setExtension(Constantes.XHTML);

			CodigoFuente sourceCode = new MantenedorXHtml();
			sourceCode.generarArchivoFuente(seed);

			return sourceCode.getCodigoFuente();
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	public static void generarFuente(Proyecto proyecto, Entidad entidad,
			Elementos elemento) {
		
		switch (elemento) {
		
		case VO:
			generarVO(proyecto, entidad);
			break;

		case DAO:
			generarDAO(proyecto, entidad);
			break;

		case EJB:
			generarCrudEJB(proyecto, entidad);
			break;

		case EJB_IMPL:
			generarCrudEJBImpl(proyecto, entidad);
			break;

		case MAPPER:
			generarMapperHelper(proyecto);
			break;

		case MBEAN:
			generarController(proyecto, entidad);
			break;

		case XHTML:
			generarMantenedorXhtml(proyecto, entidad);
			break;

		default:
			break;
		}
	}

	private static SemillaCodigoFuente inicializarSemilla(Proyecto proyecto) {
		SemillaCodigoFuente seed = new SemillaCodigoFuente();
		try {
			seed.setCreaArchivo(true);
			seed.setPathDirectorioSalida(proyecto.getCarpetaSalida());
			seed.setPaqueteMB(proyecto.getPaqueteJsfController());
			seed.setPaqueteImpl(proyecto.getPaqueteCrudService());
			seed.setPaqueteEJB(proyecto.getPaqueteCrudService());
			seed.setPaqueteDAO(proyecto.getPaqueteDaos());
			seed.setPaqueteVO(proyecto.getPaqueteVos());
			seed.setPaqueteDTO(proyecto.getPaqueteEntrada());
			seed.setPaqueteMapper(proyecto.getPaqueteVos());
			seed.setPathDirectorioSalida(proyecto.getCarpetaSalida());
			seed.setWebContent(proyecto.getWebContent());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return seed;
	}

	private static SemillaCodigoFuente prepararSemilla(
			SemillaCodigoFuente seed, Entidad entidad) {
		try {
			seed.setClaseImpl(entidad.getCrudService().getNombreEJBImpl());
			seed.setClaseEJB(entidad.getCrudService().getNombreEJB());
			seed.setClaseDAO(entidad.getDao().getNombre());
			seed.setClaseVO(entidad.getVo().getNombre());
			seed.setClaseDTO(entidad.getNombre());
			seed.setClaseMB(entidad.getControllerMB().getNombre());
			seed.setClaseMapper(Constantes.CLASE_MAPPER);
			seed.setExtension(Constantes.JAVA);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return seed;
	}

}
