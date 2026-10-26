package ToDoApp;

import ToDoApp.service.TaskService;
import ToDoApp.ui.TaskMenu;

public class Main {
    public static void main(String[] args) {
        TaskService service = new TaskService();
        TaskMenu menu = new TaskMenu(service);
        menu.start();
    }
}
