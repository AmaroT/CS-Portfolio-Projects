// Author: Amaro Terrazas
package com.amaro.contactservice;

import com.amaro.contactservice.Task;
import com.amaro.contactservice.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {
    private TaskService taskService;

    // Initialize the TaskService before each test
    @BeforeEach
    public void setUp() {
        taskService = new TaskService(); // Create a new instance for testing
    }

    // Test adding a valid Task
    @Test
    public void testAddTaskSuccess() {
        Task task = new Task("12345", "Test Task", "This is a description");
        assertTrue(taskService.addTask(task)); // Verify addition
        assertEquals(task, taskService.getTask("12345")); // Verify retrieval
    }

    // Test adding a duplicate Task ID
    @Test
    public void testAddDuplicateTaskID() {
        Task task1 = new Task("12345", "Test Task", "This is a description.");
        Task task2 = new Task("12345", "Another Task", "Another description.");
        taskService.addTask(task1);
        assertFalse(taskService.addTask(task2)); // Duplicate ID should fail
    }

    // Test deleting a Task
    @Test
    public void testDeleteTask() {
        Task task = new Task("12345", "Test Task", "This is a description.");
        taskService.addTask(task);
        assertTrue(taskService.deleteTask("12345"));
        assertNull(taskService.getTask("12345")); // Verify task no longer exists
    }

    // Test updating a Task

    @Test
    public void testUpdateTaskSuccess() {
        Task task = new Task("12345", "Test Task", "This is a description.");
        taskService.addTask(task);
        assertTrue(taskService.updateTask("12345", "Updated Task", "Updated description."));
        Task updatedTask = taskService.getTask("12345");
        assertEquals("Updated Task", updatedTask.getName()); // Verify updated Name
        assertEquals("Updated description.", updatedTask.getDescription()); // Verify updated description
    }

    // Test updated a non-existent Task
    @Test
    public void testUpdateNonexistentTask() {
        assertFalse(taskService.updateTask("999999", "Updated Task", "Updated description.")); // Task does not exist
    }
}
