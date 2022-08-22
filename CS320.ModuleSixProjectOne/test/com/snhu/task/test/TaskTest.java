package com.snhu.task.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.snhu.task.Task;

class TaskTest {

	@Test
	public void testCreateTask() {
		String taskId = "123456789";
		String taskName = "This is a test task";
		String taskDescription = "This is a test task description";

		Task task = new Task(taskId, taskName, taskDescription);

		assertEquals(task.getTaskId(), taskId);
		assertEquals(task.getTaskName(), taskName);
		assertEquals(task.getTaskDescription(), taskDescription);
	}

	// test that task id is too long
	@Test
	public void tetsTaskIdIsTooLong() {

		String taskId = "12345678909";
		String taskName = "This is a test task";
		String taskDescription = "This is a test task description";

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(taskId, taskName, taskDescription);
		});
	}

	// test if task id is null
	@Test
	public void testIfTaskIdIsNull() {

		String taskId = null;
		String taskName = "This is a test task";
		String taskDescription = "This is a test task description";

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(taskId, taskName, taskDescription);
		});
	}

	// test if task name is too long
	@Test
	public void tetsTaskNameIsTooLong() {

		String taskId = "123456789";
		String taskName = "This is a test task to see if it too long";
		String taskDescription = "This is a test task description";

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(taskId, taskName, taskDescription);
		});
	}

	// test if task name is null
	@Test
	public void testIfTaskNameIsNull() {

		String taskId = "123456789";
		String taskName = null;
		String taskDescription = "This is a test task description";

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(taskId, taskName, taskDescription);
		});
	}

	// test if task description is too long
	@Test
	public void tetsTaskDescriptionIsTooLong() {

		String taskId = "123456789";
		String taskName = "This is a test task";
		String taskDescription = "This is a test task description to see if it too long";

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(taskId, taskName, taskDescription);
		});
	}

	// test if task description is null
	@Test
	public void testIfTaskDescriptionIsNull() {

		String taskId = "123456789";
		String taskName = "This is a test task";
		String taskDescription = null;

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(taskId, taskName, taskDescription);
		});
	}

	// test the setters
	@Test
	public void testSetterMethods() {

		String taskId = "123456789";
		String taskName = "This is a test task";
		String taskDescription = "This is a test task description";

		Task task = new Task(taskId, taskName, taskDescription);

		String setTaskName = "new task";
		String setTaskDescription = "This is the new description";

		task.setTaskName(setTaskName);
		task.setTaskDescription(setTaskDescription);

		assertEquals(task.getTaskName(), setTaskName);
		assertEquals(task.getTaskDescription(), setTaskDescription);
	}

	// test the getters
	@Test
	public void testGetterMethodse() {

		String taskId = "123456789";
		String taskName = "This is a test task";
		String taskDescription = "This is a test task description";

		Task task = new Task(taskId, taskName, taskDescription);

		assertEquals(task.getTaskId(), taskId);
		assertEquals(task.getTaskName(), taskName);
		assertEquals(task.getTaskDescription(), taskDescription);
	}
}
