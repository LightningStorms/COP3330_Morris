import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {
    @Test
    public void creationFailsWithAllBlankValues(){
        assertThrows(InvalidContactInfoException.class, () -> new ContactItem("", "", "", ""));
    }

    @Test
    public void creationSucceedsWithBlankEmail(){
        assertDoesNotThrow(() -> new ContactItem("Lauren", "Morris", "555-555-5555", ""));
    }

    @Test
    public void creationSucceedsWithBlankFirstName(){
        assertDoesNotThrow(() -> new ContactItem("", "Morris", "555-555-5555", "Email@site.com"));
    }

    @Test
    public void creationSucceedsWithBlankLastName(){
        assertDoesNotThrow(() -> new ContactItem("Lauren", "", "555-555-5555", "Email@site.com"));
    }

    @Test
    public void creationSucceedsWithBlankPhone(){
        assertDoesNotThrow(() -> new ContactItem("Lauren", "Morris", "", "Email@site.com"));
    }

    @Test
    public void creationSucceedsWithNonBlankValues(){
        assertDoesNotThrow(() -> new ContactItem("Lauren", "Morris", "555-555-5555", "Email@site.com"));
    }

    @Test
    public void editingFailsWithAllBlankValues(){
        ContactItem c = new ContactItem("Lauren", "Morris", "555-555-5555", "Email@site.com");
        assertThrows(InvalidContactInfoException.class, () -> c.EditItem("", "", "", ""));
    }

    @Test
    public void editingSucceedsWithBlankEmail(){
        ContactItem c = new ContactItem("Lauren", "Morris", "555-555-5555", "Email@site.com");
        assertDoesNotThrow(() -> c.EditItem("Lauren", "Morris", "555-555-5555", ""));
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactItem c = new ContactItem("Lauren", "Morris", "555-555-5555", "Email@site.com");
        assertDoesNotThrow(() -> c.EditItem("", "Morris", "555-555-5555", "Email@site.com"));
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactItem c = new ContactItem("Lauren", "Morris", "555-555-5555", "Email@site.com");
        assertDoesNotThrow(() -> c.EditItem("Lauren", "", "555-555-5555", "Email@site.com"));
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactItem c = new ContactItem("Lauren", "Morris", "555-555-5555", "Email@site.com");
        assertDoesNotThrow(() -> c.EditItem("Lauren", "Morris", "", "Email@site.com"));
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactItem c = new ContactItem("Lauren", "Morris", "555-555-5555", "Email@site.com");
        assertDoesNotThrow(() -> c.EditItem("Lauren", "Morris", "555-555-5555", "Email@site.com"));
    }

    @Test
    public void testToString(){

    }
}