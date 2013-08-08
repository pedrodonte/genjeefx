package code;

import generar.engine.GeneraCodigoAtributosParaVOs;
import generar.engine.BuscaGetterSetterParaVOs;
import generar.engine.BuscaImportsParaVOs;
import generar.engine.GeneraMapper;
import generar.engine.GenerarVO;
import generar.modelo.Atributo;
import generar.modelo.CrudService;
import generar.modelo.Entidad;
import generar.modelo.Proyecto;
import code.elementos.ControllerMBCodigoFuente;
import code.elementos.CrudServiceEJB;
import code.elementos.CrudServiceEJBImpl;
import code.elementos.DataAccessObject;
import code.elementos.MapperHelper;
import code.elementos.MapperMetodos;
import code.elementos.ValueObject;

public class CodigoFactory {

	public static String generarVO(Proyecto proyecto, Entidad entidad) {
		try {
			SemillaCodigoFuente seed = inicializarSemilla(proyecto, entidad);
			seed.setPathDirectorioSalida(proyecto.getCarpetaSalida());
			seed.setPaqueteClase(proyecto.getPaqueteVos());
			seed.setNombreClase(entidad.getVo().getNombre());
			seed.setImports(BuscaImportsParaVOs.getImports(entidad.getVo()
					.getAtributos()));
			seed.setAtributos(GeneraCodigoAtributosParaVOs.getAtributosPrivate(entidad
					.getVo().getAtributos()));
			seed.setGetterSetters(BuscaGetterSetterParaVOs
					.getTodosSetterGetter(entidad.getVo().getAtributos()));

			CodigoFuente sourceCode = new ValueObject();
			
			seed.setPathArchivoFuente(proyecto.getCarpetaSalida()+"/"+entidad.getVo().getFuturoPath());
			sourceCode.generarArchivoFuente(seed);

			return sourceCode.getCodigoFuente();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public static String generarDAO(Proyecto proyecto, Entidad entidad) {
		try {
			SemillaCodigoFuente seed = inicializarSemilla(proyecto, entidad);

			seed.setPathDirectorioSalida(proyecto.getCarpetaSalida());
			seed.setPaqueteClase(proyecto.getPaqueteDaos());
			seed.setNombreClase(entidad.getDao().getNombre());
			seed.setNombreClaseAux(entidad.getNombre());
			seed.setPaqueteClaseAux(proyecto.getPaqueteEntrada());

			CodigoFuente sourceCode = new DataAccessObject();
			seed.setPathArchivoFuente(proyecto.getCarpetaSalida()+"/"+entidad.getDao().getFuturoPath());
			sourceCode.generarArchivoFuente(seed);

			return sourceCode.getCodigoFuente();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	private static SemillaCodigoFuente inicializarSemilla(Proyecto proyecto,
			Entidad entidad) {
		SemillaCodigoFuente seed = new SemillaCodigoFuente();
		seed.setCreaArchivo(false);
		seed.setPathDirectorioSalida(proyecto.getCarpetaSalida());		
		seed.setPaqueteMB(proyecto.getPaqueteJsfController());
		seed.setPaqueteImpl(proyecto.getPaqueteCrudService());
		seed.setPaqueteEJB(proyecto.getPaqueteCrudService());
		seed.setPaqueteDAO(proyecto.getPaqueteDaos());
		seed.setPaqueteVO(proyecto.getPaqueteVos());
		seed.setPaqueteDTO(proyecto.getPaqueteEntrada());
		return seed;
	}

	public static String generarMapperMetodo(Proyecto proyecto, Entidad entidad) {
		try {
			SemillaCodigoFuente seed = inicializarSemilla(proyecto, entidad);

			String Vo = entidad.getVo().getNombre();
			String Dto = entidad.getNombre();
			String settVo = GeneraMapper.atributosToVO(entidad, proyecto);
			String settDto = GeneraMapper.atributosToDTO(entidad, proyecto);

			seed.setNombreClase(Vo);
			seed.setNombreClaseAux(Dto);
			seed.setAtributos(settVo);
			seed.setAtributosAux(settDto);

			CodigoFuente sourceCode = new MapperMetodos();
			sourceCode.generarArchivoFuente(seed);

			return sourceCode.getCodigoFuente();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public static String generarMapperHelper(Proyecto proyecto) {
		try {
			proyecto.print();
			StringBuilder imports = new StringBuilder();
			StringBuilder metodos = new StringBuilder();

			GenerarVO generarVO = new GenerarVO(proyecto);

			for (Entidad entidad : proyecto.getEntidades()) {

				for (Atributo atrEntidadActual : entidad.getAtributos()) {
					if (!atrEntidadActual.getTipo().isEsInterface()) {
						if (!atrEntidadActual.getNombre()
								.equals("serialVersionUID")) {
							Atributo atributoVO = generarVO
									.getDeficinionAtributoVO(atrEntidadActual);
							entidad.getMapeoAtributosVoDto().put(atributoVO,
									atrEntidadActual);
						}
					}
				}

				imports.append("import " + proyecto.getPaqueteEntrada() + "."
						+ entidad.getNombre() + ";\n");
				metodos.append(generarMapperMetodo(proyecto, entidad));
			}

			SemillaCodigoFuente seed = new SemillaCodigoFuente();
			seed.setImports(imports.toString());
			seed.setPaqueteClase(proyecto.getPaqueteVos());
			seed.setMetodos(metodos.toString());

			CodigoFuente sourceCode = new MapperHelper();
			seed.setPathArchivoFuente(proyecto.getCarpetaSalida()+"/"+proyecto.getPaqueteVos()+"/HelperToVo");
			sourceCode.generarArchivoFuente(seed);

			return sourceCode.getCodigoFuente();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public static String generarCrudEJB(Proyecto proyecto, Entidad entidad) {

		try {
			CrudService crudService = new CrudService(entidad.getVo());
			entidad.setCrudService(crudService);
			SemillaCodigoFuente s = inicializarSemilla(proyecto, entidad);
			s.setClaseImpl(entidad.getCrudService().getCrudImplement().getNombre());
			s.setClaseEJB(entidad.getCrudService().getCrudInterface().getNombre());
			s.setClaseDAO(entidad.getDao().getNombre());
			s.setClaseVO(entidad.getVo().getNombre());
			s.setClaseDTO(entidad.getNombre());
			s.setClaseMB(entidad.getControllerMB().getNombre());
			
			CodigoFuente sourceCode = new CrudServiceEJB();
			s.setPathArchivoFuente(proyecto.getCarpetaSalida()+"/"+entidad.getCrudService().getCrudInterface().getFuturoPath());
			sourceCode.generarArchivoFuente(s);

			return sourceCode.getCodigoFuente();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public static String generarCrudEJBImpl(Proyecto proyecto, Entidad entidad) {
		try {
			SemillaCodigoFuente s = inicializarSemilla(proyecto, entidad);
			s.setClaseImpl(entidad.getCrudService().getCrudImplement().getNombre());
			s.setClaseEJB(entidad.getCrudService().getCrudInterface().getNombre());
			s.setClaseDAO(entidad.getDao().getNombre());
			s.setClaseVO(entidad.getVo().getNombre());
			s.setClaseDTO(entidad.getNombre());
			s.setClaseMB(entidad.getControllerMB().getNombre());

			CodigoFuente sourceCode = new CrudServiceEJBImpl();
			s.setPathArchivoFuente(proyecto.getCarpetaSalida()+"/"+entidad.getCrudService().getCrudImplement().getFuturoPath());
			sourceCode.generarArchivoFuente(s);

			return sourceCode.getCodigoFuente();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public static String generarController(Proyecto proyecto,
			Entidad entidad){
		try {
			SemillaCodigoFuente s = inicializarSemilla(proyecto, entidad);
			s.setClaseImpl(entidad.getCrudService().getCrudImplement().getNombre());
			s.setClaseEJB(entidad.getCrudService().getCrudInterface().getNombre());
			s.setClaseDAO(entidad.getDao().getNombre());
			s.setClaseVO(entidad.getVo().getNombre());
			s.setClaseDTO(entidad.getNombre());
			s.setClaseMB(entidad.getControllerMB().getNombre());
			
			CodigoFuente sourceCode = new ControllerMBCodigoFuente();
			s.setPathArchivoFuente(proyecto.getCarpetaSalida()+"/"+entidad.getControllerMB().getFuturoPath());
			sourceCode.generarArchivoFuente(s);

			return sourceCode.getCodigoFuente();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
