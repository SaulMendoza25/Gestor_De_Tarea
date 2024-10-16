package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import gestion_de_tareas.controller.TaskController;
import gestion_de_tareas.view.ManagementView;

public class MainApp {

	public static void main(String[] args) {
		ManagementView view = new ManagementView();
		TaskController taskController = new TaskController(view.getCenterView(), view.getNorthView());
		view.setVisible(true);
	}
}

class GSettingsExample {
	public static void themeDesktop() {
		// TODO Auto-generated method stub
		try {
			// Crear el comando para obtener el tema GTK actual
			ProcessBuilder processBuilder = new ProcessBuilder("gsettings", "get", "org.gnome.desktop.interface",
					"gtk-theme");

			// Ejecutar el comando
			Process process = processBuilder.start();

			// Leer la salida del comando
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println("Tema GTK actual: " + line);
			}

			// Esperar a que termine el proceso
			process.waitFor();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
