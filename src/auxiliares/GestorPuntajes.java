package auxiliares;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GestorPuntajes {

	private static final String ARCHIVO = "puntajes.properties";
	private static final String KEY_ULTIMA = "ultima_puntuacion";
	private static final String KEY_MEJOR = "mejor_puntuacion";

	private static Properties cargar() {
		Properties props = new Properties();
		File archivo = new File(ARCHIVO);
		if (archivo.exists()) {
			try (FileInputStream fis = new FileInputStream(archivo)) {
				props.load(fis);
			} catch (IOException e) {
				// si falla la carga, devuelve vacío
			}
		}
		return props;
	}

	private static void guardar(Properties props) {
		try (FileOutputStream fos = new FileOutputStream(ARCHIVO)) {
			props.store(fos, null);
		} catch (IOException e) {
			// si falla el guardado, se ignora
		}
	}

	public static int getUltimaPuntuacion() {
		return Integer.parseInt(cargar().getProperty(KEY_ULTIMA, "0"));
	}

	public static int getMejorPuntuacion() {
		return Integer.parseInt(cargar().getProperty(KEY_MEJOR, "0"));
	}

	public static void guardarPuntuacion(int puntos) {
		Properties props = cargar();
		props.setProperty(KEY_ULTIMA, String.valueOf(puntos));
		int mejor = Integer.parseInt(props.getProperty(KEY_MEJOR, "0"));
		if (puntos > mejor) {
			props.setProperty(KEY_MEJOR, String.valueOf(puntos));
		}
		guardar(props);
	}
}
