package unihelp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private static final String FILE_NAME = "tasks.csv";



    public void addTask(String title) {
        tasks.add(new Task(title));
        System.out.println("Task added.");
        saveTasks(); 
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        System.out.println("\nYour Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public void markTaskComplete() {
        viewTasks();
        if (tasks.isEmpty()) return;
        System.out.print("Enter task number to mark complete: ");
        try {
          
            int index = Integer.parseInt(UniHelpApp.getScanner().nextLine()) - 1;
            if (index >= 0 && index < tasks.size()) {
                tasks.get(index).markComplete();
                System.out.println("Task marked as complete.");
                saveTasks();
            } else {
                System.out.println("Invalid task number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    public void saveTasks() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                writer.println(task.toCSV());
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public void loadTasks() {
        tasks.clear();
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Task task = Task.fromCSV(line);
                if (task != null) tasks.add(task);
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
