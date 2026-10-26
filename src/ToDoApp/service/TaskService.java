package ToDoApp.service;

import java.util.ArrayList;
import java.util.List;
import ToDoApp.model.Task;

public class TaskService {
    private final ArrayList<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public Task addTask(String title, String description) {
        if (title == null || title.trim().isEmpty()) return null;
        Task task = new Task(nextId++, title.trim(), description == null ? "" : description.trim());
        tasks.add(task);
        return task;
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    public Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) return task;
        }
        return null;
    }

    public boolean markCompleted(int id) {
        Task task = findTaskById(id);
        if (task == null) return false;
        task.markCompleted();
        return true;
    }

    public boolean markPending(int id) {
        Task task = findTaskById(id);
        if (task == null) return false;
        task.markPending();
        return true;
    }

    public boolean deleteTask(int id) {
        Task task = findTaskById(id);
        if (task == null) return false;
        return tasks.remove(task);
    }

    public List<Task> searchTasks(String keyword) {
        ArrayList<Task> result = new ArrayList<>();
        if (keyword == null) return result;
        String query = keyword.toLowerCase().trim();
        for (Task task : tasks) {
            if (task.getTitle().toLowerCase().contains(query)
                    || task.getDescription().toLowerCase().contains(query)) {
                result.add(task);
            }
        }
        return result;
    }

    public List<Task> getPendingTasks() {
        ArrayList<Task> result = new ArrayList<>();
        for (Task task : tasks) if (!task.isCompleted()) result.add(task);
        return result;
    }

    public List<Task> getCompletedTasks() {
        ArrayList<Task> result = new ArrayList<>();
        for (Task task : tasks) if (task.isCompleted()) result.add(task);
        return result;
    }
}
