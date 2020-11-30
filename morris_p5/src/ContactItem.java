public class ContactItem {
    private String FirstName;
    private String LastName;
    private String Phone;
    private String Email;

    public ContactItem(String FirstName, String LastName, String Phone, String Email){
        if(FirstName.length() != 0 || LastName.length() != 0 || Phone.length() != 0 || Email.length() != 0){
            this.FirstName = FirstName;
            this.LastName = LastName;
            this.Email = Email;
            this.Phone = Phone;
        } else {
            throw new InvalidContactInfoException("At least one piece of information must be supplied");
        }
    }

    private boolean isNameValid(String name){
        return name.length() > 0;
    }

    public void EditItem(String FirstName, String LastName, String Phone, String Email){
        if(FirstName.length() != 0 || LastName.length() != 0 || Phone.length() != 0 || Email.length() != 0){
            this.FirstName = FirstName;
            this.LastName = LastName;
            this.Email = Email;
            this.Phone = Phone;
        } else {
            throw new InvalidContactInfoException("At least one piece of information must be supplied");
        }
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhone() {
        return Phone;
    }

    @Override
    public String toString() {
        return "Name:" + FirstName + " " + LastName + "\n" + "Phone:" + Phone + "\n" + "Email:" + Email;
    }
}

class InvalidContactInfoException extends IllegalArgumentException {
    public InvalidContactInfoException(String msg) {
        super(msg);
    }
}
