import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ContactList {
    private ArrayList<ContactItem> contacts;

    public ContactList() {
        this.contacts = new ArrayList<ContactItem>();
    }

    public ArrayList<ContactItem> getContactList() {
        return this.contacts;
    }

    public void addContact(ContactItem newContact) {
        contacts.add(newContact);
    }

    public void removeContact(int index) {
        contacts.remove(index);
    }

    public void editContactList(int index, String firstName, String lastName, String phoneNumber, String emailAddress) {
        if(firstName.length() < 1 && lastName.length() < 1 && phoneNumber.length() < 1 && emailAddress.length() < 1) {
            throw new AllBlankException("WARNING: all values cannot be blank; contact not created");
        }
        try {
            this.contacts.get(index).setFirstName(firstName);
            this.contacts.get(index).setLastName(lastName);
            this.contacts.get(index).setPhoneNumber(phoneNumber);
            this.contacts.get(index).setEmailAddress(emailAddress);
        } catch (InvalidPhoneNumberException e) {
            System.out.println("WARNING: invalid phone number; contact not edited");
        }
    }

    public void save(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.createNewFile()) {
                System.out.println("File already exists");
            }
            FileWriter writer = new FileWriter(fileName);
            for (int i = 0; i < this.contacts.size(); i++) {
                writer.write(String.format("%s%n", contacts.get(i).getFirstName()));
                writer.write(String.format("%s%n", contacts.get(i).getLastName()));
                writer.write(String.format("%s%n", contacts.get(i).getPhoneNumber()));
                writer.write(String.format("%s%n", contacts.get(i).getEmailAddress()));
            }
            writer.close();
            System.out.println("contact list has been saved");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < contacts.size(); i++) {
                output += String.format("%d) %s%n", i, contacts.get(i));
        }
        return output;
    }
}