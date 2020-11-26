import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class ContactApp {

    private static Scanner input = new Scanner(System.in);

    public ContactApp() {
    }

    public static void main(String[] args) {
        runContactApp();
    }

    public static void runContactApp() {
        boolean done = false;
        while (!done) {
            try {
                displayMainMenu();
                int option = input.nextInt();
                switch (option) {
                    case 1: createNewContactList();
                        break;
                    case 2: loadContactList();
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

    private static void createNewContactList() {
        ContactList contacts = new ContactList();
        System.out.println("new contact list has been created");
        interactWithContactList(contacts);
    }
    private static void loadContactList() {
        input.nextLine();
        ContactList contacts = new ContactList();
        System.out.print("Enter the file name to load: ");
        String fileName = input.nextLine();
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String firstName = reader.nextLine();
                String lastName = reader.nextLine();
                String phoneNumber = reader.nextLine();
                String emailAddress = reader.nextLine();

                ContactItem newContact = new ContactItem(firstName, lastName, phoneNumber, emailAddress);
                contacts.addContact(newContact);
            }
            reader.close();
            System.out.println("contact list has been loaded");
            interactWithContactList(contacts);
        } catch (FileNotFoundException e) {
            System.out.println("The file could not be found. Please try again");
        }
    }

    private static void interactWithContactList(ContactList contacts) {
        boolean keepGoing = true;
        while (keepGoing) {
            try {
                displayListOperationMenu();
                int choice = input.nextInt();
                keepGoing = doUserChoice(choice, contacts);
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
        System.out.println("5) save the current list");
        System.out.println("6) quit to the main menu\n");
        System.out.print("> ");
    }

    private static boolean doUserChoice(int choice, ContactList contacts) {
        switch (choice) {
            case 1: displayContactList(contacts);
                return true;
            case 2: addNewContact(contacts);
                return true;
            case 3: editContact(contacts);
                return true;
            case 4: removeContact(contacts);
                return true;
            case 5: saveToFile(contacts);
                return true;
            case 6: return false;
            default: System.out.println("That is not a valid choice.");
                return true;
        }
    }

    private static void displayContactList(ContactList contacts) {
        System.out.println("Current Contacts\n----------\n");
        System.out.println(contacts);
    }
    private static void addNewContact(ContactList contacts) {
        input.nextLine();
        System.out.print("Contact first name: ");
        String firstName = input.nextLine();
        System.out.print("Contact last name: ");
        String lastName = input.nextLine();
        System.out.print("Contact phone number (xxx-xxx-xxxx): ");
        String phoneNumber = input.nextLine();
        System.out.print("Contact email address (x@y.z): ");
        String emailAddress = input.nextLine();
        try {
            ContactItem newContact = new ContactItem(firstName, lastName, phoneNumber, emailAddress);
            contacts.addContact(newContact);
        } catch (InvalidPhoneNumberException e) {
            System.out.println("WARNING: invalid phone number; contact not created");
        } catch (InvalidEmailAddressException e) {
            System.out.println("WARNING: invalid email address; contact not created");
        } catch (AllBlankException e) {
            System.out.println("WARNING: all values cannot be blank; contact not created");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("WARNING: invalid phone number; contact not created");
        }
    }
    private static void editContact(ContactList contacts) {
        try {
            input.nextLine();
            displayContactList(contacts);
            System.out.print("Which contact will you edit? ");
            int indexToEdit = input.nextInt();
            input.nextLine();
            System.out.print("Enter a new first name for contact " + indexToEdit + ": ");
            String firstName = input.nextLine();
            System.out.print("Enter a new last name for contact " + indexToEdit + ": ");
            String lastName = input.nextLine();
            System.out.print("Enter a new phone number (xxx-xxx-xxxx) for contact " + indexToEdit + ": ");
            String phoneNumber = input.nextLine();
            System.out.print("Enter a new email address (x@y.z) for contact " + indexToEdit + ": ");
            String emailAddress = input.nextLine();
            contacts.editContactList(indexToEdit, firstName, lastName, phoneNumber, emailAddress);
        } catch (InvalidPhoneNumberException e) {
            System.out.println("WARNING: invalid phone number; contact not created");
        } catch (InvalidEmailAddressException e) {
            System.out.println("WARNING: invalid email address; contact not created");
        } catch (AllBlankException e) {
            System.out.println("WARNING: all values cannot be blank; contact not created");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: invalid contact choice; contact cannot be edited");
        }
    }
    private static void removeContact(ContactList contacts) {
        try {
            input.nextLine();
            displayContactList(contacts);
            System.out.print("Which contact will you remove? ");
            int indexToRemove = input.nextInt();
            contacts.removeContact(indexToRemove);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: invalid contact choice; contact cannot be removed");
        }
    }
    private static void saveToFile(ContactList contacts) {
        input.nextLine();
        System.out.print("Enter the filename to save as: ");
        String fileName = input.nextLine();
        contacts.save(fileName);
    }
}

