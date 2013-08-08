package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

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

}
