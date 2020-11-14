import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

public class App {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean done = false;
        while (!done) {
            try {
                displayMainMenu();
                int option = input.nextInt();
                switch (option) {
                    case 1: createNewTaskList();
                            break;
                    case 2: loadTaskList();
                            break;
                    case 3: done = true;
                            break;
                    default: System.out.println("That is not a valid choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("That is not a valid choice.");
                input.nextLine();
            }
        }
    }

    private static void createNewTaskList() {
        TaskList tasks = new TaskList();
        System.out.println("new task list has been created");
        interactWithTaskList(tasks);
    }
    private static void loadTaskList() {
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
                String dueDate = taskLine.substring(taskLine.indexOf("[")+1, taskLine.indexOf("]"));
                String title = taskLine.substring(taskLine.indexOf("]")+2, taskLine.indexOf(":"));
                String description = taskLine.substring(taskLine.indexOf(":")+2);
                TaskItem newTask = new TaskItem(title, description, dueDate);
                tasks.addTask(newTask);
                if(taskLine.contains("***")) {
                    tasks.complete(count);
                }
                count++;
            }
            reader.close();
            System.out.println("task list has been loaded");
            interactWithTaskList(tasks);
        } catch (FileNotFoundException e) {
            System.out.println("The file could not be found. Please try again");
        }
    }

    private static void interactWithTaskList(TaskList tasks) {
        boolean keepGoing = true;
        while (keepGoing) {
            try {
                displayListOperationMenu();
                int choice = input.nextInt();
                keepGoing = doUserChoice(choice, tasks);
            } catch (InputMismatchException e) {
                System.out.println("That is not a valid choice.");
                input.nextLine();
            }
        }
    }
    private static void displayMainMenu() {
        System.out.print("\nMain Menu\n----------\n");
        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit\n");
        System.out.print("> ");
    }
    private static void displayListOperationMenu() {
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

    private static boolean doUserChoice(int choice, TaskList tasks) {
        switch (choice) {
            case 1: displayTaskList(tasks);
                    return true;
            case 2: addNewTask(tasks);
                    return true;
            case 3: editTask(tasks);
                    return true;
            case 4: removeTask(tasks);
                    return true;
            case 5: markTaskCompleted(tasks);
                    return true;
            case 6: unmarkTaskCompleted(tasks);
                    return true;
            case 7: saveToFile(tasks);
                    return true;
            case 8: return false;
            default: System.out.println("That is not a valid choice.");
                     return true;
        }
    }

    private static void displayTaskList(TaskList tasks) {
        System.out.println("Current Tasks\n----------\n");
        System.out.println(tasks);
    }
    private static void addNewTask(TaskList tasks) {
        input.nextLine();
        System.out.print("Task title: ");
        String title = input.nextLine();
        System.out.print("Task description: ");
        String description = input.nextLine();
        System.out.print("Task due date (YYYY-MM-DD): ");
        String date = input.nextLine();
        try {
            TaskItem newTask = new TaskItem(title, description, date);
            tasks.addTask(newTask);
        } catch (InvalidTitleException e) {
            System.out.println("WARNING: title must be at least 1 character long; task not created");
        } catch (InvalidDateException e) {
            System.out.println("WARNING: invalid due date; task not created");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("WARNING: invalid due date; task not created");
        }
    }
    private static void editTask(TaskList tasks) {
        try {
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
            tasks.editTaskList(indexToEdit, title, description, date);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: invalid task choice; task cannot be edited");
        }
    }
    private static void removeTask(TaskList tasks) {
        try {
            input.nextLine();
            System.out.println("Current Tasks\n----------\n");
            System.out.println(tasks);
            System.out.print("Which task will you remove? ");
            int indexToRemove = input.nextInt();
            tasks.removeTask(indexToRemove);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: invalid task choice; task cannot be removed");
        }
    }
    private static void markTaskCompleted(TaskList tasks) {
        try {
            input.nextLine();
            System.out.println("Uncompleted Tasks\n----------\n");
            System.out.println(tasks.toStringUncompleted());
            System.out.print("Which task will you mark as completed? ");
            int indexToComplete = input.nextInt();
            tasks.complete(indexToComplete);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: invalid task choice; task cannot be marked as completed");
        }
    }
    private static void unmarkTaskCompleted(TaskList tasks) {
        try {
            input.nextLine();
            System.out.println("Completed Tasks\n----------\n");
            System.out.println(tasks.toStringCompleted());
            System.out.print("Which task will you unmark as completed? ");
            int indexToIncomplete = input.nextInt();
            tasks.incomplete(indexToIncomplete);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: invalid task choice; task cannot be unmarked as completed");
        }
    }
    private static void saveToFile(TaskList tasks) {
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
        }
    }
}
