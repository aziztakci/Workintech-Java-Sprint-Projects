package org.example.entity;

import java.util.Objects;

public class Task {
    private String project;
    private String description;
    private String assignee;
    private Priority priority;
    private Status status;

    public Task(String project, String description, String assignee, Status status, Priority priority) {
        this.project = project;
        this.description = description;
        this.assignee = assignee;
        this.priority = priority;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Task task)) return false;
        return Objects.equals(project, task.project) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project, description);
    }

    public String getProject() {
        return project;
    }

    public String getDescription() {
        return description;
    }

    public String getAssignee() {
        return assignee;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }
}
