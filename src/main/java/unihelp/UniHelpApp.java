package unihelp;

import java.util.Scanner;

public class UniHelpApp {
    private static Scanner scanner = new Scanner(System.in);
    private static TaskManager taskManager = new TaskManager();
    private static BudgetManager budgetManager = new BudgetManager();
    private static TimetableManager timetableManager = new TimetableManager();

    public static void setScanner(Scanner newScanner) {
        scanner = newScanner;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static void main(String[] args) {
        taskManager.loadTasks();

        boolean running = true;
        while (running) {
            showMenu();
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    handleTaskMenu();
                    break;          
                case "2":
                    handleBudgetMenu();
                    break;                
                case "3":
                    handleTimetableMenu();
                    break;               
                case "4":
                    taskManager.saveTasks();
                    running = false;
                    System.out.println("Exiting UniHelp.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n=== UniBuddy Menu ===");
        System.out.println("1. View Task Menu");      
        System.out.println("2. View Budget Menu");
        System.out.println("3. View Timetable Menu");       
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    private static void handleTaskMenu() {
        boolean goBack = false;
        while (!goBack) {
            System.out.println("\n=== Task Menu ===");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task Complete");
            System.out.println("4. Go Back");
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    taskManager.addTask(title);
                    break;
                case "2":
                    taskManager.viewTasks();
                    break;
                case "3":
                    taskManager.markTaskComplete();
                    break;
                case "4":
                    goBack = true;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void handleBudgetMenu() {
        boolean goBack = false;
        while (!goBack) {
            System.out.println("\n=== Budget Menu ===");
            System.out.println("1. Add Budget Transaction");
            System.out.println("2. View Budget Summary");
            System.out.println("3. Go Back");
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Enter amount (positive for income, negative for expense): ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    budgetManager.addTransaction(amount);
                    break;
                case "2":
                    budgetManager.viewSummary();
                    break;
                case "3":
                    goBack = true;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void handleTimetableMenu() {
        boolean goBack = false;
        while (!goBack) {
            System.out.println("\n=== Timetable Menu ===");
            System.out.println("1. Add Class to Timetable");
            System.out.println("2. View Timetable");
            System.out.println("3. Go Back");
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Enter day (e.g., Monday): ");
                    String day = scanner.nextLine();
                    System.out.print("Enter class details (e.g., 10am - Math): ");
                    String details = scanner.nextLine();
                    timetableManager.addClass(day, details);
                    break;
                case "2":
                    timetableManager.viewTimetable();
                    break;
                case "3":
                    goBack = true;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
