package gestion_de_tareas.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tasks {
	public Tasks() {
		// TODO Auto-generated constructor stub
	}

	public Tasks(LocalDate date, String name, String description) {
		this.date = date;
		this.name = name;
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static ArrayList<Tasks> getTasks() {
		return tasks;
	}

	public static void addTask(Tasks task) {
		tasks.add(task);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Date: " + this.date + "\n" + "Name: " + this.name + "\n" + "Description:" + this.description;
	}

	private LocalDate date;
	private String name;
	private String description;
	private static ArrayList<Tasks> tasks = new ArrayList<Tasks>();
}
