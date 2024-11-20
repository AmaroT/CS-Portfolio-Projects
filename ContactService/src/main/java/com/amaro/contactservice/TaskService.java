// Author: Amaro Terrazas
package com.amaro.contactservice;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    // In-memory storage for tasks, with TaskID as the key
    private final Map<String, Task> tasks;

    // Constructor
    public TaskService() {
        tasks = new HashMap<>(); // Initialize the HashMap to store Task objects
    }

    // Add new task to the service
    public boolean addTask(Task task) {
        // Check if task is null or taskID already exists in the map
        if (task == null || tasks.containsKey(task.getTaskID())) {
            return false; // Task cannot be added
        }
        tasks.put(task.getTaskID(), task); // Add the task to the map
        return true; // Task successfully added
    }

    // Delete a Task by its taskID
    public boolean deleteTask(String taskID) {
        // Check if taskID is null or does not exist in the map
        if (taskID == null || !tasks.containsKey(taskID)) {
            return false; // Task cannot be deleted
        }
        tasks.remove(taskID);
        return true; // Task successfully deleted
    }

    // Update the fields of an existing task by its taskID
    public boolean updateTask(String taskID, String name, String description) {
        Task task = tasks.get(taskID); // Retrieve the task by taskID
        if (task == null) {
            return false; // Task not found
        }
        // Update the name if it is valid
        if (name != null && name.length() <= 20) {
            task.setName(name);
        }

        // Update the description if it is valid
        if (description != null && description.length() <= 50) {
            task.setDescription(description);
        }
        return true; // Task successfully updated
    }

    // Retrieve a task by its taskID (for testing purposes)
    public Task getTask(String taskID) {
        return tasks.get(taskID); // Return the task or null if not found
    }
}

