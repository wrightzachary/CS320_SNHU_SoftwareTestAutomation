package com.snhu.task;

public class Task {

	// variables
	private String taskId;
	private String taskName;
	private String taskDescription;

	// constructor
	public Task(String taskId, String taskName, String taskDescription) {

		// validation for each pass parameter
		if ((taskId == null) || (taskId.length() > 10)) {
			throw new IllegalArgumentException("Invalid Task Id");
		}

		if ((taskName == null) || (taskName.length() > 20)) {
			throw new IllegalArgumentException("Invalid Task Name");
		}

		if ((taskDescription == null) || (taskDescription.length() > 50)) {
			throw new IllegalArgumentException("Invalid Task Description");
		}

		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
	}

	// getters and setters
	public String getTaskId() {
		return taskId;
	}
 
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {

		if ((taskName == null) || (taskName.length() > 20)) {
			throw new IllegalArgumentException("Invalid Task Name");
		}

		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {

		if ((taskDescription == null) || (taskDescription.length() > 50)) {
			throw new IllegalArgumentException("Invalid Task Description");
		}

		this.taskDescription = taskDescription;
	}
 
}
