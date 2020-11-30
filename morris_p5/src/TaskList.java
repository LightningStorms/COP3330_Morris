import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class TaskList {
    List<TaskItem> tasks;

    public TaskList(){
        tasks = new ArrayList<>();
    }

    public void addTask(TaskItem task){
        tasks.add(task);
    }

    public int getSize(){
        return tasks.size();
    }

    //finds the original tasks index then overwrites it with the new task
    public void editTask(int taskOriginal, TaskItem taskNew){
        if(taskOriginal < tasks.size() && taskOriginal >= 0){
            tasks.remove(taskOriginal);
            tasks.add(taskOriginal, taskNew);
        } else{
            throw  new IndexOutOfBoundsException("This item does not exist, please try a different item");
        }

    }

    public void removeTask(int task){
        if(task < tasks.size() && task >= 0){
            tasks.remove(task);
        } else{
            throw  new IndexOutOfBoundsException("This item does not exist, please try a different item");
        }
    }

    public void updateStatus(boolean status, int i){
        if(i < tasks.size() && i >= 0){
            tasks.get(i).setStatus(status);
        } else{
            throw  new IndexOutOfBoundsException("This item does not exist, please try a different item");
        }
    }

    public void viewTaskList(){
        int i=0;

        for(TaskItem task : tasks){
            //checks if it is completed (status true==complete) then prints completed signature if complete
            if(task.getStatus()){
                System.out.printf("*** ");
            }
            System.out.printf("%d) %s %n", i+1, task);
            i++;
        }
    }

    public void viewTaskListComplete(){
        int i=0;

        for(TaskItem task : tasks){
            //checks if it is completed then prints with signature
            if(task.getStatus()){
                System.out.printf("*** ");
                System.out.printf("%d) %s %n", i+1, task);
            }
            i++;
        }
    }

    public void viewTaskListIncomplete(){
        int i=0;

        for(TaskItem task : tasks){
            //checks if it is not complete then prints
            if(!task.getStatus()){
                System.out.printf("%d) %s %n", i+1, task);
            }
            i++;
        }
    }

    public void getItemTitle(int index){
        tasks.get(index).getTitle();
    }

    public void getItemDescription(int index){
        tasks.get(index).getDescription();
    }

    public void getItemDueDate(int index){
        tasks.get(index).getDueDate();
    }

    public void write(String filename){
        try(Formatter output = new Formatter(filename)){
            for(int i = 0; i < tasks.size(); i++){
                TaskItem task = tasks.get(i);
                output.format("%b %s%n%s%n%s%n", task.getStatus(), task.getTitle(), task.getDescription(), task.getDueDate());
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
            boolean status = input.nextBoolean();
            String title = input.nextLine();
            String description = input.nextLine();
            String dueDate = input.nextLine();

            TaskItem task = new TaskItem(status, title, description, dueDate);

            tasks.add(task);
        } catch (IOException ex){
            System.out.printf("Unable to find the file: %s", filename);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }


}
