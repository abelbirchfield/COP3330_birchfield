import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TaskList tasks = new TaskList();
        displayListOperationMenu();
        System.out.print("> ");
        int choice = input.nextInt();
        doChoice(choice, tasks);

        displayListOperationMenu();
        System.out.print("> ");
        choice = input.nextInt();
        doChoice(choice, tasks);

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
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            default:
        }
    }

    public static void choice1(TaskList tasks) {
        System.out.println("Current Tasks\n----------\n\n");
        System.out.println(tasks);
    }
    public static void choice2(TaskList tasks) {
        Scanner input = new Scanner(System.in);
        System.out.print("Task title: ");
        String title = input.nextLine();
        System.out.print("Task description: ");
        String description = input.nextLine();
        System.out.print("Task due date (YYYY-MM-DD): ");
        String date = input.nextLine();

        TaskItem newTask = new TaskItem(title, description, date);
        tasks.addTask(newTask);
    }
}
