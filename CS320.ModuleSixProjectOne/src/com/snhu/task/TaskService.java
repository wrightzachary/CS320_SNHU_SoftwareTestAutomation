package com.snhu.task;

import java.util.ArrayList;
import java.util.List;

public class TaskService {

	// array list to hold tasks
	public static List<Task> taskList = new ArrayList<Task>();

	// method to add tasks to list
	public void addTask(String taskId, String taskName, String taskDescription) {

		if (!(taskList.isEmpty())) {
			for (Task task : taskList) {
				if (task.getTaskId().equals(taskId)) {
					throw new IllegalArgumentException("Duplicate ID");
				}
			}
		}

		Task task = new Task(taskId, taskName, taskDescription);
		taskList.add(task);

	}

	// method to delete task
	public void deleteTask(String taskId) {

		// iterate through list until the searched id is found then removes it
		for (int i = 0; i < taskList.size(); i++) {
			Task task = taskList.get(i);
			if (task.getTaskId().equals(taskId)) {
				taskList.remove(i);
			}
		}
	}

	// method allows to update task name by task id
	public void updateTaskName(String taskId, String taskName) {
		for (int i = 0; i < taskList.size(); i++) {
			Task task = taskList.get(i);
			if (task.getTaskId().equals(taskId)) {
				task.setTaskName(taskName);
			}
		}
	}

	// method allows to update task description by task id
	public void updateTaskDescription(String taskId, String taskDescription) {
		for (int i = 0; i < taskList.size(); i++) {
			Task task = taskList.get(i);
			if (task.getTaskId().equals(taskId)) {
				task.setTaskDescription(taskDescription);
			}
		}
	}
}
