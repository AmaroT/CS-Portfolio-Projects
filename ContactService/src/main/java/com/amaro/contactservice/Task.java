package com.amaro.contactservice;

public class Task {
    // Fields for task attributes
    private final String taskID; // Unique task ID, cannot be null or updated
    private String name; // Task name, updatable
    private String description; // Task description, updatable

    // Constructor
    public Task(String taskID, String name, String description) {
        // Validate taskID, must not null and max 10 characters
        if (taskID == null || taskID.length() > 10) {
            throw new IllegalArgumentException("Invalid Task ID. Must not be null and max 10 characters.");
        }
        this.taskID = taskID;

        // Validate name: must not be null and max 20 characters
        if(name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name. Must not be null and max 20 characters.");
        }
        this.name = name;

        // Validate description: must not be null and max 50 characters
        if(description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description. Must not be null and max 50 characters.");
        }
        this.description = description;
    }
    // Getter for taskID
    public String getTaskID() {
        return taskID; // Returns the unique task ID
    }

    // Getter for name
    public String getName() {
        return name; // Returns name of the task
    }

    // Getter for description
    public String getDescription() {
        return description; // Returns description of the task
    }
    // Setter for name (updatable field)
    public void setName(String name) {
        // Validate name: must not be null and max 20 characters
        if(name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name. Must not be null and max 20 characters.");
        }
        this.name = name;
    }
    // Setter for description (updatable field)
    public void setDescription(String description) {
        // Validate description: must not be null and max 50 characters
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description. Must not be null and max 50 characters.");
        }
        this.description = description;
    }
}
