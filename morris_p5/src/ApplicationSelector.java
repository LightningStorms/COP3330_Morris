import java.util.Scanner;

public class ApplicationSelector {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        int userInput = 0;
        while(userInput != 3) {
            System.out.printf("Select Your Application%n" +
                    "-----------------------%n" +
                    "%n" +
                    "1) task list%n" +
                    "2) contact list%n" +
                    "3) quit%n");
            userInput = getUserInput();

            switch (userInput) {
                case 1:
                    //create new TaskApp
                    TaskApp a = new TaskApp();
                    a.main();
                    break;
                case 2:
                    //create new ContactApp
                    ContactApp b = new ContactApp();
                    b.main();
                    break;
                case 3:
                    //breaks because this is the end while loop call
                    break;
                default:
                    System.out.println("Please enter a valid number from the menu");
            }
        }
    }

    private static int getUserInput(){
        System.out.printf("%n> ");
        return input.nextInt();
    }
}
