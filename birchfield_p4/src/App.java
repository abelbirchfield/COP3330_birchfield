import java.util.Scanner;

public class App {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        TaskList tasks = new TaskList();

        while (true) {
            displayListOperationMenu();
            System.out.print("> ");
            int choice = input.nextInt();
            doChoice(choice, tasks);
        }
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
    }

    public static void doChoice(int choice, TaskList tasks) {
        switch (choice) {
            case 1: choice1(tasks);
                    break;
            case 2: choice2(tasks);
                    break;
            case 3: choice3(tasks);
                    break;
            case 4: choice4(tasks);
                    break;
            case 5: choice5(tasks);
                    break;
            case 6: choice6(tasks);
                    break;
            case 7:
            case 8:
            default: System.out.println("That is not a valid choice.");
        }
    }

    public static void choice1(TaskList tasks) {
        System.out.println("Current Tasks\n----------\n\n");
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
        System.out.println("Current Tasks\n----------\n\n");
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
        System.out.println("Current Tasks\n----------\n\n");
        System.out.println(tasks);
        System.out.print("Which task will you remove? ");
        int indexToRemove = input.nextInt();
        tasks.removeTask(indexToRemove);
    }
    public static void choice5(TaskList tasks) {
        input.nextLine();
        System.out.println("Uncompleted Tasks\n----------\n\n");
        System.out.println(tasks.toStringUncompleted());
        System.out.print("Which task will you mark as completed? ");
        int indexToComplete = input.nextInt();
        tasks.complete(indexToComplete);
    }
    public static void choice6(TaskList tasks) {
        input.nextLine();
        System.out.println("Completed Tasks\n----------\n\n");
        System.out.println(tasks.toStringCompleted());
        System.out.print("Which task will you unmark as completed? ");
        int indexToIncomplete = input.nextInt();
        tasks.incomplete(indexToIncomplete);
    }
}
