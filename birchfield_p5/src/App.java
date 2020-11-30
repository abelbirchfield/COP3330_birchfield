import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean done = false;
        while (!done) {
            try {
                displaySelectionMenu();
                int selection = input.nextInt();
                switch (selection) {
                    case 1: TaskApp taskApp = new TaskApp();
                            taskApp.runTaskApp();
                            break;
                    case 2: ContactApp contactApp = new ContactApp();
                            contactApp.runContactApp();
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

    private static void displaySelectionMenu() {
        System.out.print("\nSelect Your Application\n-----------------------\n");
        System.out.println("1) task list");
        System.out.println("2) contact list");
        System.out.println("3) quit\n");
        System.out.print("> ");
    }
}
