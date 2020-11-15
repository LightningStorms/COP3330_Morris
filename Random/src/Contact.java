public class Contact {
    //not final because part 2 of the question asks us to retrieve and modify
    private String name;
    private String email;
    private String phoneNumber;

    //constructor to initialize variables
    public Contact(String name, String email, String phoneNumber){
        this.name = name;
        this.email = email;
        this.phoneNumber =phoneNumber;
    }

    //allow us to get any of the values
    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    //allow us to modify any of the values
    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    //overrides toString method from Object the parent of all classes
    @Override
    public String toString(){
        return name + "\nEmail: " + email + "\nPhone: " + phoneNumber;
    }
}
