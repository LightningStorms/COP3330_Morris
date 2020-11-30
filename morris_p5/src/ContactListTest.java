import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {
    @Test
    public void addingItemsIncreasesSize(){
        ContactList contacts = new ContactList();
        ContactItem c = new ContactItem("Laure", "Morris", "555-555-5555", "email@site.com");

        contacts.addContact(c);

        assertEquals(1, contacts.getSize());
    }

    @Test
    public void editingItemsFailsWithAllBlankValues(){
        ContactList contacts = new ContactList();
        ContactItem c = new ContactItem("Laure", "Morris", "555-555-5555", "email@site.com");

        contacts.addContact(c);

        assertThrows(InvalidContactInfoException.class, () -> contacts.editContact(contacts.contacts.indexOf(c), "", "", "", ""));
    }

    @Test
    public void editingItemsFailsWithInvalidIndex(){
        ContactList contacts = new ContactList();
        ContactItem c = new ContactItem("Lauren", "Morris", "555-555-5555", "email@site.com");

        contacts.addContact(c);

        assertThrows(IndexOutOfBoundsException.class, () -> contacts.editContact(1, "Lauren", "", "", ""));
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactList contacts = new ContactList();
        ContactItem c = new ContactItem("Laure", "Morris", "555-555-5555", "email@site.com");

        contacts.addContact(c);

        assertDoesNotThrow(() -> contacts.editContact(contacts.contacts.indexOf(c), "", "Morris", "444-444-4444", "hi@site.com"));
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactList contacts = new ContactList();
        ContactItem c = new ContactItem("Laure", "Morris", "555-555-5555", "email@site.com");

        contacts.addContact(c);

        assertDoesNotThrow(() -> contacts.editContact(contacts.contacts.indexOf(c), "Lauren", "", "444-444-4444", "hi@site.com"));
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactList contacts = new ContactList();
        ContactItem c = new ContactItem("Laure", "Morris", "555-555-5555", "email@site.com");

        contacts.addContact(c);

        assertDoesNotThrow(() -> contacts.editContact(contacts.contacts.indexOf(c), "Lauren", "Morris", "", "hi@site.com"));
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactList contacts = new ContactList();
        ContactItem c = new ContactItem("Laure", "Morris", "555-555-5555", "email@site.com");

        contacts.addContact(c);

        assertDoesNotThrow(() -> contacts.editContact(contacts.contacts.indexOf(c), "Lauren", "Morris", "444-444-4444", ""));
    }

    @Test
    public void newListIsEmpty(){
        ContactList contacts = new ContactList();

        assertEquals(0, contacts.getSize());
    }

    @Test
    public void removingItemsDecreasesSize(){
        ContactList contacts = new ContactList();
        ContactItem c = new ContactItem("Laure", "Morris", "555-555-5555", "email@site.com");

        contacts.addContact(c);
        contacts.addContact(c);
        contacts.addContact(c);
        contacts.removeContact(2);

        assertEquals(2, contacts.getSize());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex(){
        ContactList contacts = new ContactList();
        ContactItem c = new ContactItem("Laure", "Morris", "555-555-5555", "email@site.com");

        contacts.addContact(c);
        contacts.addContact(c);
        contacts.addContact(c);

        assertThrows(IndexOutOfBoundsException.class, () -> contacts.removeContact(3));
    }

    @Test
    public void savedContactListCanBeLoaded(){
        ContactList contacts = new ContactList();
        ContactItem c = new ContactItem("Laure", "Morris", "555-555-5555", "email@site.com");

        contacts.addContact(c);
        contacts.write("TEST_CASE.txt");
        ContactList tasks2 = new ContactList();
        tasks2.read("TEST_CASE.txt");

        assertEquals("555-555-5555", contacts.contacts.get(0).getPhone());
    }
}