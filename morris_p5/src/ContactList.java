import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class ContactList {
    List<ContactItem> contacts;

    public ContactList(){
        contacts = new ArrayList<>();
    }

    public void addContact(ContactItem contact){
        contacts.add(contact);
    }

    public int getSize(){
        return contacts.size();
    }

    //finds the original index then overwrites it with the new contact
    public void editContact(int contactOriginal, String FirstName, String LastName, String Phone, String Email){
        if(contactOriginal < contacts.size() && contactOriginal >= 0){
            contacts.get(contactOriginal).EditItem(FirstName, LastName, Phone, Email);
        } else{
            throw  new IndexOutOfBoundsException("This item does not exist, please try a different item");
        }

    }

    public void removeContact(int task){
        if(task < contacts.size() && task >= 0){
            contacts.remove(task);
        } else{
            throw  new IndexOutOfBoundsException("This item does not exist, please try a different item");
        }
    }

    public void viewContactList(){
        int i=0;

        for(ContactItem contact : contacts){
            System.out.printf("%d) %s %n", i+1, contact);
            i++;
        }
    }

    public void write(String filename){
        try(Formatter output = new Formatter(filename)){
            for(int i = 0; i < contacts.size(); i++){
                ContactItem contact = contacts.get(i);
                output.format("%s%n%s%n%s%n%s%n", contact.getFirstName(), contact.getLastName(), contact.getPhone(), contact.getEmail());
            }

        } catch (FileNotFoundException ex){
            System.out.printf("Unable to find the file: %s", filename);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void read(String filename){
        try{
            Scanner input = new Scanner(Paths.get(filename));
            String FirstName = input.nextLine();
            String LastName = input.nextLine();
            String Email = input.nextLine();
            String Phone = input.nextLine();

            ContactItem contact = new ContactItem(FirstName, LastName, Email, Phone);

            contacts.add(contact);
        } catch (IOException ex){
            System.out.printf("Unable to find the file: %s", filename);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
