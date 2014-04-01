import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;


public class ClasesPaquete {
	
	static String PAQUETE = "info.pedrodonte.protask.dto";
	
	public static void main(String[] args) {
		Reflections reflections = new Reflections(PAQUETE);

		 Set<Class<? extends Object>> allClasses = 
		     reflections.getSubTypesOf(Object.class);

		 for (Class<? extends Object> clase : allClasses) {
			 System.out.println(clase.getCanonicalName());
		 }

		 try {
			Class[] lasClases = obtenerClasesDelPaquete(PAQUETE);
			for (int i = 0; i < lasClases.length; i++) {
				System.out.println(lasClases[i]);
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

	}

	private static Class[] obtenerClasesDelPaquete(String packageName)
			throws ClassNotFoundException, IOException {

		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();

		assert classLoader != null;

		String path = packageName.replace('.', '/');

		Enumeration<URL> resources = classLoader.getResources(path);

		List<File> dirs = new ArrayList<File>();
		while (resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			dirs.add(new File(resource.getFile()));
		}

		ArrayList<Class> classes = new ArrayList<Class>();
		for (File directory : dirs) {
			classes.addAll(buscarClasesEnDirectorio(directory, packageName));
		}

		return classes.toArray(new Class[classes.size()]);
	}

	private static Collection<? extends Class> buscarClasesEnDirectorio(
			File directory, String packageName)  throws ClassNotFoundException {

				String fixPath = directory.getAbsolutePath().replace("%20", " ");

				directory = new File(fixPath);


				List<Class> classes = new ArrayList<Class>();

				if (!directory.exists()) {
					return classes;
				}

				File[] files = directory.listFiles();
				for (File file : files) {
					if (file.isDirectory()) {

						assert !file.getName().contains(".");
						classes.addAll(buscarClasesEnDirectorio(file, packageName + "."
								+ file.getName()));

					} else if (file.getName().endsWith(".class")) {

						classes.add(Class.forName(packageName
								+ '.'
								+ file.getName().substring(0,
										file.getName().length() - 6)));

					}
				}
				return classes;
			}

}
