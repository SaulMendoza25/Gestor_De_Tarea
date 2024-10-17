package gestion_de_tareas.controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import gestion_de_tareas.model.Tasks;
import gestion_de_tareas.view.CenterView;
import gestion_de_tareas.view.NorthView;

public class TaskController {
	private CenterView centerView;
	private NorthView northView;

	/**
	 * This class connects the GUI and the task model to save a list of tasks and
	 * display it in the GUI.
	 * 
	 * @param centerView Receives as value the central view where the data that the
	 *                   user enters about a task is located.
	 * @param northView  It receives as value the menu view in the northern part of
	 *                   the frame and allows to send changes to the central view.
	 */
	public TaskController(CenterView centerView, NorthView northView) {
		this.centerView = centerView;
		this.northView = northView;

	}

	/**
	 * This method runs the application
	 */
	public void run() {
		/**
		 * 
		 * This class uses the ActionListener interface so it expects an event performed
		 * by a button to make a change in the central view or to perform a CRUD on the
		 * tasks.
		 */
		class CRUD implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = centerView.getNameField().getText();
				String description = centerView.getDescriptionPane().getText();
				LocalDate date = centerView.getDate();
				Tasks.addTask(new Tasks(date, name, description));
				System.out.println(Tasks.getTasks());
			}
		}
		this.northView.getSave().addActionListener(new CRUD());
	}

}
