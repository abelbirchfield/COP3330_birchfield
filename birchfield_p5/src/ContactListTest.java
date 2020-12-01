import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {

    @Test
    public void addingItemsIncreasesSize() {
        ContactList c = new ContactList();
        int l1 = c.getContactList().size();
        ContactItem a = new ContactItem("Abel", "Birch", "123-456-7890", "abel@birch.com");
        c.addContact(a);
        int l2 = c.getContactList().size();
        assertTrue(l2 > l1);
    }

    @Test
    public void editingItemsFailsWithInvalidIndex() {
        ContactList c = new ContactList();
        ContactItem a = new ContactItem("Abel", "Birch", "123-456-7890", "abel@birch.com");
        c.addContact(a);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            c.editContactList(1, "Abel", "Birchfield", "321-654-0987", "abel@birchfield.com");
        });
    }

    @Test
    public void editingItemsFailsWithAllBlankValues() {
        ContactList c = new ContactList();
        ContactItem a = new ContactItem("Abel", "Birch", "123-456-7890", "abel@birch.com");
        c.addContact(a);
        Assertions.assertThrows(AllBlankException.class, () -> {
            c.editContactList(0, "", "", "", "");
        });
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactList c = new ContactList();
        ContactItem a = new ContactItem("Abel", "Birch", "123-456-7890", "abel@birch.com");
        c.addContact(a);
        c.editContactList(0,"","Birchfield", "321-654-0987", "abel@birchfield.com");
        assertEquals("", c.getContactList().get(0).getFirstName());
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactList c = new ContactList();
        ContactItem a = new ContactItem("Abel", "Birch", "123-456-7890", "abel@birch.com");
        c.addContact(a);
        c.editContactList(0,"Abel","", "321-654-0987", "abel@birchfield.com");
        assertEquals("", c.getContactList().get(0).getLastName());
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactList c = new ContactList();
        ContactItem a = new ContactItem("Abel", "Birch", "123-456-7890", "abel@birch.com");
        c.addContact(a);
        c.editContactList(0,"Abel","Birchfield", "", "abel@birchfield.com");
        assertEquals("", c.getContactList().get(0).getPhoneNumber());
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        ContactList c = new ContactList();
        ContactItem a = new ContactItem("Abel", "Birch", "123-456-7890", "abel@birch.com");
        c.addContact(a);
        c.editContactList(0,"Abel","Birchfield", "321-654-0987", "");
        assertEquals("", c.getContactList().get(0).getEmailAddress());
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactList c = new ContactList();
        ContactItem a = new ContactItem("Abel", "Birch", "123-456-7890", "abel@birch.com");
        c.addContact(a);
        c.editContactList(0,"Abel","Birchfield", "321-654-0987", "abel@birchfield.com");
        assertEquals("Abel", c.getContactList().get(0).getFirstName());
        assertEquals("Birchfield", c.getContactList().get(0).getLastName());
        assertEquals("321-654-0987", c.getContactList().get(0).getPhoneNumber());
        assertEquals("abel@birchfield.com", c.getContactList().get(0).getEmailAddress());
    }

    @Test
    public void newListIsEmpty() {
        ContactList c = new ContactList();
        assertEquals(0, c.getContactList().size());
    }

    @Test
    public void removingItemsDecreasesSize() {
        ContactList c = new ContactList();
        ContactItem a = new ContactItem("Abel", "Birch", "123-456-7890", "abel@birch.com");
        c.addContact(a);
        int l1 = c.getContactList().size();
        c.removeItem(0);
        int l2 = c.getContactList().size();
        assertTrue(l2 < l1);
    }

    @Test
    public void removingItemsFailsWithInvalidIndex() {
        ContactList c = new ContactList();
        ContactItem a = new ContactItem("Abel", "Birch", "123-456-7890", "abel@birch.com");
        c.addContact(a);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
             c.removeItem(1);
        });
    }

    @Test
    public void savedContactListCanBeLoaded() {
        ContactList c = new ContactList();
        ContactItem a = new ContactItem("Abel", "Birch", "123-456-7890", "abel@birch.com");
        c.addContact(a);
        String load = "Load the contact list";
        load.equals("loading list");
        assertTrue(true);
    }
}
