import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class App {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean done = false;

        while (!done) {
            displayMainMenu();
            int option = input.nextInt();

            switch (option) {
                case 1: option1();
                        break;
                case 2: option2();
                        break;
                case 3: done = true;
                        break;
                default: System.out.println("That is not a valid choice.");
            }
        }
    }

    public static void option1() {
        TaskList tasks = new TaskList();
        System.out.println("new task list has been created");
        interactWithTaskList(tasks);
    }
    public static void option2() {
        input.nextLine();
        TaskList tasks = new TaskList();
        System.out.print("Enter the file name to load: ");
        String fileName = input.nextLine();
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);

            int count = 0;
            while (reader.hasNextLine()) {
                String taskLine = reader.nextLine();
                int start = taskLine.indexOf("[");
                int stop1 = taskLine.indexOf("]");
                int stop2 = taskLine.indexOf(":");
                String dueDate = taskLine.substring(start+1, stop1);
                String title = taskLine.substring(stop1+2, stop2);
                String description = taskLine.substring(stop2+2);
                TaskItem newTask = new TaskItem(title, description, dueDate);
                tasks.addTask(newTask);
                if(taskLine.contains("***")) {
                    tasks.complete(count);
                }
                count++;
            }
            reader.close();
            System.out.println("task list has been loaded");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        interactWithTaskList(tasks);
    }

    public static void interactWithTaskList(TaskList tasks) {
        boolean keepGoing = true;
        while (keepGoing) {
            displayListOperationMenu();
            int choice = input.nextInt();
            keepGoing = doChoice(choice, tasks);
        }
    }
    public static void displayMainMenu() {
        System.out.print("\nMain Menu\n----------\n");
        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit\n");
        System.out.print("> ");
    }
    public static void displayListOperationMenu() {
        System.out.print("\nList Operation Menu\n----------\n");
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) mark an item as completed");
        System.out.println("6) unmark an item as completed");
        System.out.println("7) save the current list");
        System.out.println("8) quit to the main menu\n");
        System.out.print("> ");
    }

    public static boolean doChoice(int choice, TaskList tasks) {
        switch (choice) {
            case 1: choice1(tasks);
                    return true;
            case 2: choice2(tasks);
                    return true;
            case 3: choice3(tasks);
                    return true;
            case 4: choice4(tasks);
                    return true;
            case 5: choice5(tasks);
                    return true;
            case 6: choice6(tasks);
                    return true;
            case 7: choice7(tasks);
                    return true;
            case 8: return false;
            default: System.out.println("That is not a valid choice.");
                     return true;
        }
    }

    public static void choice1(TaskList tasks) {
        System.out.println("Current Tasks\n----------\n");
        System.out.println(tasks);
    }
    public static void choice2(TaskList tasks) {
        input.nextLine();
        System.out.print("Task title: ");
        String title = input.nextLine();
        System.out.print("Task description: ");
        String description = input.nextLine();
        System.out.print("Task due date (YYYY-MM-DD): ");
        String date = input.nextLine();

        TaskItem newTask = new TaskItem(title, description, date);
        tasks.addTask(newTask);
    }
    public static void choice3(TaskList tasks) {
        input.nextLine();
        System.out.println("Current Tasks\n----------\n");
        System.out.println(tasks);
        System.out.print("Which task will you edit? ");
        int indexToEdit = input.nextInt();
        input.nextLine();
        System.out.print("Enter a new title for task " + indexToEdit + ": ");
        String title = input.nextLine();
        System.out.print("Enter a new description for task " + indexToEdit + ": ");
        String description = input.nextLine();
        System.out.print("Enter a new task due date (YYYY-MM-DD) for task " + indexToEdit + ": ");
        String date = input.nextLine();

        TaskItem newTask = new TaskItem(title, description, date);
        tasks.editTaskList(indexToEdit, newTask);
    }
    public static void choice4(TaskList tasks) {
        input.nextLine();
        System.out.println("Current Tasks\n----------\n");
        System.out.println(tasks);
        System.out.print("Which task will you remove? ");
        int indexToRemove = input.nextInt();
        tasks.removeTask(indexToRemove);
    }
    public static void choice5(TaskList tasks) {
        input.nextLine();
        System.out.println("Uncompleted Tasks\n----------\n");
        System.out.println(tasks.toStringUncompleted());
        System.out.print("Which task will you mark as completed? ");
        int indexToComplete = input.nextInt();
        tasks.complete(indexToComplete);
    }
    public static void choice6(TaskList tasks) {
        input.nextLine();
        System.out.println("Completed Tasks\n----------\n");
        System.out.println(tasks.toStringCompleted());
        System.out.print("Which task will you unmark as completed? ");
        int indexToIncomplete = input.nextInt();
        tasks.incomplete(indexToIncomplete);
    }
    public static void choice7(TaskList tasks) {
        input.nextLine();
        System.out.print("Enter the filename to save as: ");
        String fileName = input.nextLine();
        try {
            File file = new File(fileName);
            if (!file.createNewFile()) {
                System.out.println("File already exists");
            }
            FileWriter writer = new FileWriter(fileName);
            writer.write(tasks.toString());
            writer.close();
            System.out.println("task list has been saved");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
