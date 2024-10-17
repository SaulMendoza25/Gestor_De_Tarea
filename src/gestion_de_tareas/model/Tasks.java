package gestion_de_tareas.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tasks {
	/**
	 * The task class is used to store the data of a task. This class stores the
	 * name, date and description of the task.
	 * 
	 * @param date        The date is the time at which the task will be executed.
	 * @param name        The name is the title that the task will have for storage
	 *                    and recall.
	 * @param description The description returns in detail what task will be
	 *                    performed.
	 */
	public Tasks(LocalDate date, String name, String description) {
		this.date = date;
		this.name = name;
		this.description = description;
	}

	/**
	 * This method returns the date
	 * 
	 * @return
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * This method allows you to send the date
	 * 
	 * @param date receives the date you want to save
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * This method return the name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method allow you to send the name
	 * 
	 * @param name receives the name you want to save
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method return the description
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method allow you to send the description
	 * 
	 * @param description receives the description you want to save
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * This method return a list of tasks
	 * 
	 * @return
	 */
	public static ArrayList<Tasks> getTasks() {
		return tasks;
	}

	/**
	 * This method allows to save a task class in the task list
	 * 
	 * @param task
	 */
	public static void addTask(Tasks task) {
		tasks.add(task);
	}

	/**
	 *This method returns the values of the variables of this class
	 */
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
