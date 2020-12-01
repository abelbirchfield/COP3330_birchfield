import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {

    @Test
    public void creationFailsWithAllBlankValues() {
        Assertions.assertThrows(AllBlankException.class, () -> {
            new ContactItem("", "", "", "");
        });
    }

    @Test
    public void creationFailsWithInvalidPhoneNumber() {
        Assertions.assertThrows(InvalidPhoneNumberException.class, () -> {
            new ContactItem("Abel", "Birch", "1234567890", "abel@birch.com");
        });
    }

    @Test
    public void creationSucceedsWithBlankEmail() {
        ContactItem c = new ContactItem("Abel", "Birch", "123-456-7890", "");
        assertEquals("", c.getEmailAddress());
    }

    @Test
    public void creationSucceedsWithBlankFirstName() {
        ContactItem c = new ContactItem("", "Birch", "123-456-7890", "abel@birch.com");
        assertEquals("", c.getFirstName());
    }

    @Test
    public void creationSucceedsWithBlankLastName() {
        ContactItem c = new ContactItem("Abel", "", "123-456-7890", "abel@birch.com");
        assertEquals("", c.getLastName());
    }

    @Test
    public void creationSucceedsWithBlankPhone() {
        ContactItem c = new ContactItem("Abel", "Birch", "", "abel@birch.com");
        assertEquals("", c.getPhoneNumber());
    }

    @Test
    public void creationSucceedsWithNonBlankValues() {
        ContactItem c = new ContactItem("Abel", "Birch", "123-456-7890", "abel@birch.com");
        assertEquals("Abel", c.getFirstName());
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        ContactItem c = new ContactItem("Abel", "Birch", "123-456-7890", "abel@birch.com");
        c.setEmailAddress("");
        assertEquals("", c.getEmailAddress());
    }

    @Test
    public void editingSucceedsWithFirstName() {
        ContactItem c = new ContactItem("Abel", "Birch", "123-456-7890", "abel@birch.com");
        c.setFirstName("");
        assertEquals("", c.getFirstName());
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactItem c = new ContactItem("Abel", "Birch", "123-456-7890", "abel@birch.com");
        c.setLastName("");
        assertEquals("", c.getLastName());
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactItem c = new ContactItem("Abel", "Birch", "123-456-7890", "abel@birch.com");
        c.setPhoneNumber("");
        assertEquals("", c.getPhoneNumber());
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactItem c = new ContactItem("Abel", "Birch", "123-456-7890", "abel@birch.com");
        c.setFirstName("Abel");
        c.setLastName("Birchfield");
        c.setPhoneNumber("321-654-0987");
        c.setEmailAddress("abel@birchfield.com");
        assertEquals("Abel", c.getFirstName());
        assertEquals("Birchfield", c.getLastName());
        assertEquals("321-654-0987", c.getPhoneNumber());
        assertEquals("abel@birchfield.com", c.getEmailAddress());
    }

    @Test
    public void editingFailsWithInvalidPhoneNumber() {
        ContactItem c = new ContactItem("Abel", "Birch", "123-456-7890", "abel@birch.com");
        Assertions.assertThrows(InvalidPhoneNumberException.class, () -> {
            c.setPhoneNumber("1234567890");
        });
    }

    @Test
    public void editingFailsWithInvalidEmailAddress() {
        ContactItem c = new ContactItem("Abel", "Birch", "123-456-7890", "abel@birch.com");
        Assertions.assertThrows(InvalidEmailAddressException.class, () -> {
            c.setEmailAddress("abelbirch@dotcom");
        });
    }

    @Test
    public void testToString() {
        ContactItem c = new ContactItem("Abel", "Birch", "123-456-7890", "abel@birch.com");
        System.out.println(c.toString());
        assertEquals("Name: Abel Birch\nPhone: 123-456-7890\nEmail: abel@birch.com", c.toString());
    }

}