package com.amaro.contactservice;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    // Test successful creation of a Task object
    @Test
    public void testTaskCreationSuccess() {
        Task task = new Task("12345", "Test Task", "This is a description.");
        assertEquals("12345", task.getTaskID()); // Verify taskID
        assertEquals("Test Task", task.getName()); // Verify Name
        assertEquals("This is a description.", task.getDescription()); // Verify Description
    }
    // Test invalid taskID (null or too long)
    @Test
    public void testInvalidTaskID() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Test Task", "This is a description.");
        });
        assertEquals("Invalid Task ID. Must not be null and max 10 characters.", exception.getMessage());

    }

    // Test invalid name (null or too long)
    @Test
    public void testInvalidName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", null, "This is a description");
        });
        assertEquals("Invalid name. Must not be null and max 20 characters.", exception.getMessage());
    }

    // Test invalid description (null or too long)
    @Test
    public void testInvalidDescription() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "Test Task", null);
        });
        assertEquals("Invalid description. Must not be null and max 50 characters.", exception.getMessage());
    }

}
