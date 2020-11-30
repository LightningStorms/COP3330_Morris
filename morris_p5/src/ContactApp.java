import java.sql.SQLOutput;
import java.util.Scanner;

public class ContactApp {
    private static Scanner input = new Scanner(System.in);
    private ContactList contacts;

    public void main(){
        int userInput = 0;
        while(userInput != 3) {
            System.out.printf("%nMain Menu%n--------- %n%n1) create a new list%n2) load an existing list %n3) quit%n");
            userInput = getUserInput();

            switch (userInput) {
                case 1:
                    //create new list
                    ContactApp a = new ContactApp();
                    System.out.println("new contact list has been created");
                    a.manageContacts();
                    break;
                case 2:
                    //load existing list
                    ContactApp b = new ContactApp();
                    b.loadContactList();
                    break;
                case 3:
                    //breaks because this is the end while loop call
                    break;
                default:
                    System.out.println("Please enter a valid number from the menu");
            }
        }
    }
    public ContactApp(){
        contacts = new ContactList();
    }

    //brings up manage tasks menu which allows user to select an option
    private void manageContacts(){
        int userInput = 0;
        do{
            System.out.printf("%nList Operation Menu%n" +
                    "---------%n" +
                    "%n" +
                    "1) view the list%n" +
                    "2) add an item%n" +
                    "3) edit an item%n" +
                    "4) remove an item%n" +
                    "5) save the current list%n" +
                    "6) quit to the main menu%n");
            userInput = getUserInput();
            String removeSpace = input.nextLine();

            switch (userInput) {
                case 1:
                    //view list
                    printList();
                    break;
                case 2:
                    //add item
                    addItem();
                    break;
                case 3:
                    //edit item
                    if(hasContacts()){
                        editItem();
                    }
                    break;
                case 4:
                    //remove item
                    if(hasContacts()) {
                        removeItem();
                    }
                    break;
                case 5:
                    //save current list
                    if(hasContacts()) {
                        writeContactList();
                    }
                    break;
                case 6:
                    //end while loop
                    break;
                default:
                    System.out.println("Please enter a valid number from the menu");
            }
        }while(userInput != 6);
    }

    private static int getUserInput() {
        System.out.printf("%n> ");
        return input.nextInt();
    }

    private boolean hasContacts(){
        if(contacts.getSize()>0){
            return true;
        } else{
            System.out.println("No contacts exist, please create a contact first");
            return false;
        }

    }

    private void printList(){
        System.out.printf("%nCurrent Contacts%n" +
                "-------------%n%n");
        contacts.viewContactList();
    }

    private void addItem(){
        ContactItem contact = getContactItem();
        contacts.addContact(contact);
    }

    private ContactItem getContactItem(){
        ContactItem contact = null;
        while(true) {
            try {
                String first = getFirstName();
                String last = getLastName();
                String phone = getPhone();
                String email = getEmail();

                contact = new ContactItem(first, last, phone, email);
                break;
            } catch (InvalidContactInfoException ex) {
                System.out.println("Warning: At least one piece of information must be supplied");
            }
        }
        return contact;
    }

    private String getFirstName(){
        System.out.println("First name: ");
        return input.nextLine();
    }

    private String getLastName(){
        System.out.println("Last name: ");
        return input.nextLine();
    }

    private String getPhone(){
        System.out.println("Phone number (xxx-xxx-xxxx): ");
        return input.nextLine();
    }

    private String getEmail(){
        System.out.println("Email address (x@y.z): ");
        return input.nextLine();
    }

    private void editItem(){
        int contactToEdit;

        contactToEdit = getContactToEdit();
        String removeEnter = input.nextLine();

        String first = getNewFirstName(contactToEdit);
        String last = getNewLastName(contactToEdit);
        String phone = getNewPhone(contactToEdit);
        String email = getNewEmail(contactToEdit);

        try{
            contacts.editContact(contactToEdit-1, first, last, phone, email);
            //makes sure that the shift in task numbers is accounted for
        } catch (IndexOutOfBoundsException ex){
            System.out.printf("This item does not exist, please try a different item");
        } catch (InvalidContactInfoException ex) {
            System.out.printf("At least one piece of information must be supplied");
        }
    }

    private int getContactToEdit(){
        printList();
        System.out.printf("%n%nWhich contact will you edit?");
        return input.nextInt();
    }

    private String getNewFirstName(int index){
        System.out.printf("Enter a new first name for contact %d: ", index);
        return input.nextLine();
    }

    private String getNewLastName(int index){
        System.out.printf("Enter a new last name for contact %d: ", index);
        return input.nextLine();
    }

    private String getNewPhone(int index){
        System.out.printf("Enter a new phone number (xxx-xxx-xxxx) for contact %d: ", index);
        return input.nextLine();
    }

    private String getNewEmail(int index){
        System.out.printf("Enter a new email address (x@y.z) for contact %d: ", index);
        return input.nextLine();
    }

    private void removeItem(){
        int itemToRemove;

        printList();

        itemToRemove = getItemToRemove();

        try{
            contacts.removeContact(itemToRemove-1);
            //accounts for the fact that i have the numbers starting at 1 and index start at 0
        } catch (IndexOutOfBoundsException ex){
            System.out.printf("This item does not exist, please try a different item");
        }
    }

    private int getItemToRemove(){
        System.out.printf("%nWhich contact will you remove? ");
        return input.nextInt();
    }

    private void writeContactList(){
        String filename = getFileName();

        contacts.write(filename);
        System.out.printf("contact list has been saved");
    }

    private String getFileName(){
        System.out.printf("Enter the filename to save as:");
        return input.nextLine();
    }

    private void loadContactList(){
        String removeSpace = input.nextLine();
        String filename = getFileToLoad();

        contacts.read(filename);
        manageContacts();

        System.out.printf("contact list has been loaded");
    }

    private String getFileToLoad(){
        System.out.printf("Enter the filename to load:");
        return input.nextLine();
    }
}
