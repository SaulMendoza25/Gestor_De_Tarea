package gestion_de_tareas.controller;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.time.LocalDate;
import gestion_de_tareas.model.Tasks;
import gestion_de_tareas.view.CenterView;
import gestion_de_tareas.view.NorthView;

public class TaskController implements ActionListener{
	private CenterView centerView;
    private NorthView northView;
	public TaskController(CenterView centerView,NorthView northView) {
		this.centerView = centerView;
		this.northView=northView;
	    this.northView.getSave().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = centerView.getNameField().getText();
		String description =centerView.getDescriptionPane().getText();
		LocalDate date = centerView.getDate();
		Tasks.addTask(new Tasks(date,name,description));
		System.out.println(Tasks.getTasks());
	}
}
