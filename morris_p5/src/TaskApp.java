import java.util.Scanner;

public class TaskApp {
    private static Scanner input = new Scanner(System.in);
    private TaskList tasks;

    public void main(){
        int userInput = 0;
        while(userInput != 3) {
            System.out.printf("%nMain Menu%n--------- %n%n1) create a new list%n2) load an existing list %n3) quit%n");
            userInput = getUserInput();

            switch (userInput) {
                case 1:
                    //create new list
                    TaskApp a = new TaskApp();
                    System.out.println("new task list has been created");
                    a.manageTasks();
                    break;
                case 2:
                    //load existing list
                    TaskApp b = new TaskApp();
                    b.loadTaskList();
                    break;
                case 3:
                    //breaks because this is the end while loop call
                    break;
                default:
                    System.out.println("Please enter a valid number from the menu");
            }
        }
    }

    public TaskApp(){
        tasks = new TaskList();
    }

    //brings up manage tasks menu which allows user to select an option
    private void manageTasks(){
        int userInput = 0;
        do{
            System.out.printf("%nList Operation Menu%n" +
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
                    if(hasTasks()){
                        editItem();
                    }
                    break;
                case 4:
                    //remove item
                    if(hasTasks()) {
                        removeItem();
                    }
                    break;
                case 5:
                    //mark as complete
                    if(hasTasks()) {
                        markItemComplete();
                    }
                    break;
                case 6:
                    //unmark as complete
                    if(hasTasks()) {
                        markItemIncomplete();
                    }
                    break;
                case 7:
                    //save current list
                    if(hasTasks()) {
                        writeTaskList();
                    }
                    break;
                case 8:
                    //end while loop
                    break;
                default:
                    System.out.println("Please enter a valid number from the menu");
            }
        }while(userInput != 8);
    }

    private static int getUserInput() {
        System.out.printf("%n> ");
        return input.nextInt();
    }

    private boolean hasTasks(){
        if(tasks.getSize()>0){
            return true;
        } else{
            System.out.println("No tasks exist, please create a task first");
            return false;
        }

    }

    private void printList(){
        System.out.printf("%nCurrent Tasks%n" +
                "-------------%n%n");
        tasks.viewTaskList();
    }

    private void addItem(){
        TaskItem task = getTaskItem();
        tasks.addTask(task);
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

    private String getTitle(){
        System.out.println("Task title:");
        return input.nextLine();
    }

    private String getDescription(){
        System.out.println("Task description:");
        return input.nextLine();
    }

    private String getDueDate(){
        System.out.println("Task due date (YYYY-MM-DD):");
        return input.nextLine();
    }

    private void editItem(){
        int taskToEdit;
        TaskItem newTask;

        taskToEdit = getTaskToEdit();
        String removeEnter = input.nextLine();

        newTask = getNewTaskItem();

        try{
            tasks.editTask(taskToEdit-1, newTask);
            //makes sure that the shift in task numbers is accounted for
        } catch (IndexOutOfBoundsException ex){
            System.out.printf("This item does not exist, please try a different item");
        }
    }

    private int getTaskToEdit(){
        printList();
        System.out.printf("Which task will you edit?");
        return input.nextInt();
    }

    private TaskItem getNewTaskItem(){
        TaskItem task = null;
        while(true) {
            try {
                String title = getNewTitle();
                String description = getNewDescription();
                String date = getNewDueDate();

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

    private String getNewTitle(){
        System.out.println("New task title:");
        return input.nextLine();
    }

    private String getNewDescription(){
        System.out.println("New task description:");
        return input.nextLine();
    }

    private String getNewDueDate(){
        System.out.println("New task due date (YYYY-MM-DD):");
        return input.nextLine();
    }

    private void removeItem(){
        int itemToRemove;

        printList();

        itemToRemove = getItemToRemove();

        try{
            tasks.removeTask(itemToRemove-1);
            //accounts for the fact that i have the numbers starting at 1 and index start at 0
        } catch (IndexOutOfBoundsException ex){
            System.out.printf("This item does not exist, please try a different item");
        }
    }

    private int getItemToRemove(){
        System.out.printf("%nWhich task will you remove?");
        return input.nextInt();
    }

    private void markItemComplete(){
        int itemToComplete;

        itemToComplete = getItemToComplete();

        try{
            tasks.updateStatus( true, itemToComplete-1);
            //accounts for the fact that i have the numbers starting at 1 and index start at 0
        } catch (IndexOutOfBoundsException ex){
            System.out.printf("This item does not exist, please try a different item");
        }
    }

    private int getItemToComplete(){
        System.out.printf("Uncompleted Tasks%n" +
                "-------------%n" +
                "%n");
        tasks.viewTaskListIncomplete();
        System.out.printf("%nWhich task will you mark as completed? ");
        return input.nextInt();
    }

    private void markItemIncomplete(){
        int itemToInComplete;

        itemToInComplete = getItemToInComplete();

        try{
            tasks.updateStatus( false, itemToInComplete-1);
            //accounts for the fact that i have the numbers starting at 1 and index start at 0
        } catch (IndexOutOfBoundsException ex){
            System.out.printf("This item does not exist, please try a different item");
        }
    }

    private int getItemToInComplete(){
        System.out.printf("Completed Tasks%n" +
                "-------------%n" +
                "%n");
        tasks.viewTaskListComplete();
        System.out.printf("%nWhich task will you unmark as completed? ");
        return input.nextInt();
    }

    private void writeTaskList(){
        String filename = getFileName();

        tasks.write(filename);
        System.out.printf("task list has been saved");
    }

    private String getFileName(){
        System.out.printf("Enter the filename to save as:");
        return input.nextLine();
    }

    private void loadTaskList(){
        String removeSpace = input.nextLine();
        String filename = getFileToLoad();

        tasks.read(filename);
        manageTasks();
    }

    private String getFileToLoad(){
        System.out.printf("Enter the filename to load:");
        return input.nextLine();
    }
}
