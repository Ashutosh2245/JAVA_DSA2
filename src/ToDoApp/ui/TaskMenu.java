package ToDoApp.ui;

import java.util.List;
import java.util.Scanner;
import ToDoApp.model.Task;
import ToDoApp.service.TaskService;
import ToDoApp.util.InputUtil;

public class TaskMenu {
    private final TaskService service;
    private final Scanner sc = new Scanner(System.in);

    public TaskMenu(TaskService service) { this.service = service; }

    public void start() {
        System.out.println("================================");
        System.out.println("       JAVA TO-DO APP");
        System.out.println("================================");

        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. View Pending Tasks");
            System.out.println("4. View Completed Tasks");
            System.out.println("5. Mark Task Completed");
            System.out.println("6. Mark Task Pending");
            System.out.println("7. Search Task");
            System.out.println("8. Delete Task");
            System.out.println("9. Exit");

            int choice = InputUtil.readInt(sc, "Enter choice: ");
            switch (choice) {
                case 1 -> addTask();
                case 2 -> printTasks(service.getAllTasks());
                case 3 -> printTasks(service.getPendingTasks());
                case 4 -> printTasks(service.getCompletedTasks());
                case 5 -> updateStatus(true);
                case 6 -> updateStatus(false);
                case 7 -> searchTask();
                case 8 -> deleteTask();
                case 9 -> {
                    System.out.println("Thank you for using To-Do App!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addTask() {
        String title = InputUtil.readText(sc, "Enter task title: ");
        if (title.isEmpty()) {
            System.out.println("Task title cannot be empty.");
            return;
        }
        String description = InputUtil.readText(sc, "Enter description (optional): ");
        Task task = service.addTask(title, description);
        System.out.println("Task added successfully. Task ID: " + task.getId());
    }

    private void updateStatus(boolean complete) {
        int id = InputUtil.readInt(sc, "Enter task ID: ");
        boolean updated = complete ? service.markCompleted(id) : service.markPending(id);
        if (updated) {
            System.out.println(complete ? "Task marked completed." : "Task marked pending.");
        } else {
            System.out.println("Task not found.");
        }
    }

    private void searchTask() {
        String keyword = InputUtil.readText(sc, "Enter keyword to search: ");
        printTasks(service.searchTasks(keyword));
    }

    private void deleteTask() {
        int id = InputUtil.readInt(sc, "Enter task ID to delete: ");
        System.out.println(service.deleteTask(id) ? "Task deleted successfully." : "Task not found.");
    }

    private void printTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        System.out.println("\n---------------- TASKS ----------------");
        for (Task task : tasks) {
            System.out.println("ID: " + task.getId());
            System.out.println("Title: " + task.getTitle());
            System.out.println("Description: " + (task.getDescription().isEmpty() ? "-" : task.getDescription()));
            System.out.println("Status: " + (task.isCompleted() ? "COMPLETED" : "PENDING"));
            System.out.println("Created: " + task.getCreatedAt());
            System.out.println("---------------------------------------");
        }
    }
}
