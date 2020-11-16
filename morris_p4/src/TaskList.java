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

    //finds the original tasks index then overwrites it with the new task
    public void editTask(int taskOriginal, TaskItem taskNew){
        tasks.remove(taskOriginal);
        tasks.add(taskOriginal, taskNew);
    }

    public void removeTask(int task){
        tasks.remove(task);
    }

    public void updateStatus(boolean status, int i){
        tasks.get(i).setStatus(status);
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

    public void write(String filename){
        try(Formatter output = new Formatter(filename)){
            for(int i = 0; i < tasks.size(); i++){
                TaskItem task = tasks.get(i);
                //checks if it is completed (status true==complete) then prints completed signature if complete
                if(task.getStatus()){
                    output.format("*** %d) %s", i+1, task);
                } else {
                    output.format("%d) %s", i + 1, task);
                }
            }

        } catch (FileNotFoundException ex){
            System.out.printf("Unable to find the file: %s", filename);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /*
    public void read(String filename){
        try(Scanner input = new Scanner(Paths.get(filename)){
            //read from file
            while (input.hasNext()){
              System.out.printf("%s", input.nextLine());
            }

        } catch (IOException ex){
            System.out.printf("Unable to find the file: %s", filename);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

     */
}
