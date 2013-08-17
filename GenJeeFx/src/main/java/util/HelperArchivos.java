package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HelperArchivos {

	public static void guardaCodigoFuente(String filename, String contenido) {
		
			try (	
					FileWriter fw = new FileWriter(filename);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter salida = new PrintWriter(bw)
				) {
				salida.println(contenido);
			} catch (IOException e) {
				System.out.println("Error al escribir el Archivo");
				e.printStackTrace();
			}
			
		
	}

	public static String leerRecurso(String nombreRecurso) {

		InputStream is = ClassLoader.getSystemResourceAsStream(nombreRecurso);

		// BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

			// br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append("\n" + line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return sb.toString();
	}
	
	public static void crearDirectorio(String stringPath){
		
		Path path = Paths.get(stringPath);
		
		try {
			if (Files.notExists(path)) {
				System.out.println("Creando: "+stringPath);
				Files.createDirectories(Paths.get(stringPath));
			}else{
				System.out.println("Ya existe "+stringPath);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void comprobarPaqueteCreado(String string) throws IOException{
		Path path = Paths.get(string.substring(0,string.lastIndexOf("/")));
		if (Files.notExists(path)) {
			Files.createDirectories(path);
		}
	}
	
	public static void comprobarArchivoCreado(String string) throws IOException{
		Path path = Paths.get(string);
		if (Files.notExists(path)) {
			Files.createFile(path);
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		String string = "C:/pcarrasco/out/temps";
		System.out.println(string.substring(string.lastIndexOf("/"), string.length()));
		System.out.println(string.substring(0,string.lastIndexOf("/")));
	}

}
