import java.util.Scanner;

public class App {
    private static Scanner input = new Scanner(System.in);
    private TaskList tasks;

    public static void main(String[] args){
        int userInput = 0;
        do{
            System.out.printf("Main Menu%n--------- %n%n1) create a new list%n2) load an existing list %n3) quit%n");

            switch (userInput) {
                case 1:
                    //create new list
                    App a = new App();
                    a.manageTasks();
                    break;
                case 2:
                    //load existing list

                    break;
                case 3:
                    //breaks because this is the end while loop call
                    break;
                default:
                    System.out.println("Please enter a valid number from the menu");
            }

            userInput = getUserInput();
        }while(userInput != 3);
    }

    public App(){
        tasks = new TaskList();
    }

    //brings up manage tasks menu which allows user to select an option
    private void manageTasks(){
        int userInput = 0;
        do{
            System.out.printf("List Operation Menu%n" +
                    "---------%n" +
                    "%n" +
                    "1) view the list%n" +
                    "2) add an item%n" +
                    "3) edit an item%n" +
                    "4) remove an item%n" +
                    "5) mark an item as completed%n" +
                    "6) unmark an item as completed%n" +
                    "7) save the current list%n" +
                    "8) quit to the main menu%n");

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
                    editItem();
                    break;
                case 4:
                    //remove item
                    removeItem();
                    break;
                case 5:
                    //mark as complete
                    markItemComplete();
                    break;
                case 6:
                    //unmark as complete
                    markItemIncomplete();
                    break;
                case 7:
                    //save current list
                    writeTaskList();
                    break;
                case 8:
                    //end while loop
                    break;
                default:
                    System.out.println("Please enter a valid number from the menu");
            }

            userInput = getUserInput();
        }while(userInput != 8);
    }

    private static int getUserInput() {
        System.out.printf("> ");
        return input.nextInt();
    }

    private TaskItem getTaskItem(){
        TaskItem task = null;
        while(true) {
            try {
                String title = getTitle();
                String description = getDescription();
                String date = getDueDate();

                task = new TaskItem(title, description, date);
                break;
            } catch (InvalidTitleException ex) {
                System.out.println("Warning: your title was too short, please try again");
            } catch (InvalidDescriptionException ex) {
                System.out.println("Warning: your description was too short, please try again");
            } catch (InvalidDateException ex) {
                System.out.println("Warning: your date was formatted incorrectly please try again");
            }
        }
        return task;
    }

}
