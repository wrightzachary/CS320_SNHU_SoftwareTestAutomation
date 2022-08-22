package com.snhu.task.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.snhu.task.TaskService;

class TaskServiceTest {

	// clear the array list after each test
	@AfterEach
	void tearDown() throws Exception {
		TaskService.taskList.removeAll(TaskService.taskList);
	}

	// test to add task
	@Test
	public void testAddTask() {

		String taskId = "123456789";
		String taskName = "This is a test task";
		String taskDescription = "This is a test task description";

		TaskService taskService = new TaskService();
		taskService.addTask(taskId, taskName, taskDescription);

		assertTrue(!(TaskService.taskList.isEmpty()));
		assertEquals(TaskService.taskList.get(0).getTaskId(), "123456789");
		assertEquals(TaskService.taskList.get(0).getTaskName(), "This is a test task");
		assertEquals(TaskService.taskList.get(0).getTaskDescription(), "This is a test task description");
	}

	// test to make sure we cannot add duplicate task id
	@Test
	public void testAddDuplicateTaskId() {

		TaskService taskService = new TaskService();
		taskService.addTask("123456789", "This is a test task", "This is a test task description");

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask("123456789", "Duplicate Task", "Task description");
		});
	}

	// test to delete task
	@Test
	public void testDeleteTask() {

		String taskId = "123456789";
		String taskName = "This is a test task";
		String taskDescription = "This is a test task description";

		TaskService taskService = new TaskService();
		taskService.addTask(taskId, taskName, taskDescription);

		assertTrue(!(TaskService.taskList.isEmpty()));

		if (!(TaskService.taskList.isEmpty())) {
			taskService.deleteTask(taskId);
		}

		assertTrue(TaskService.taskList.isEmpty());
	}

	// test to update task name
	@Test
	public void testUpdateTaskName() {

		String taskId = "123456789";
		String taskName = "This is a test task";
		String taskDescription = "This is a test task description";

		TaskService taskService = new TaskService();
		taskService.addTask(taskId, taskName, taskDescription);

		String updatedTaskName = "Updated Task Name";
		taskService.updateTaskName(taskId, updatedTaskName);

		assertEquals(TaskService.taskList.get(0).getTaskName(), "Updated Task Name");
	}

	// test if task name is too long
	@Test
	public void testUpdateTaskNameIsTooLong() {

		String taskId = "123456789";
		String taskName = "This is a test task";
		String taskDescription = "This is a test task description";

		TaskService taskService = new TaskService();
		taskService.addTask(taskId, taskName, taskDescription);

		String updatedTaskName = "Updated Task Name is way too long";

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateTaskName("123456789", updatedTaskName);
		});
	}

	// test to update task description
	@Test
	public void testUpdateTaskDescription() {

		String taskId = "123456789";
		String taskName = "This is a test task";
		String taskDescription = "This is a test task description";

		TaskService taskService = new TaskService();
		taskService.addTask(taskId, taskName, taskDescription);

		String updatedTaskDescription = "Updated Task Description";
		taskService.updateTaskDescription(taskId, updatedTaskDescription);

		assertEquals(TaskService.taskList.get(0).getTaskDescription(), "Updated Task Description");
	}

	// test if task description is too long
	@Test
	public void testUpdateTaskDescriptionIsTooLong() {

		String taskId = "123456789";
		String taskName = "This is a test task";
		String taskDescription = "This is a test task description";

		TaskService taskService = new TaskService();
		taskService.addTask(taskId, taskName, taskDescription);

		String updatedTaskDescription = "Updated Task Description is way too long so it wont update";

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateTaskName("123456789", updatedTaskDescription);
		});
	}
}
