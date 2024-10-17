package app;

import gestion_de_tareas.controller.TaskController;
import gestion_de_tareas.view.ManagementView;

public class MainApp {

	public static void main(String[] args) {
		ManagementView view = new ManagementView();
		TaskController taskController = new TaskController(view.getCenterView(), view.getNorthView());
		taskController.run();
		view.setVisible(true);
	}
}
