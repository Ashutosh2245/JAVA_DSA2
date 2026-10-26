package ToDoApp.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private final int id;
    private String title;
    private String description;
    private boolean completed;
    private final String createdAt;

    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = false;
        this.createdAt = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")
        );
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public boolean isCompleted() { return completed; }
    public String getCreatedAt() { return createdAt; }

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void markCompleted() { this.completed = true; }
    public void markPending() { this.completed = false; }
}
