import java.io.FileNotFoundException;
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

    public void

    public void write(String filename){
        try(Formatter output = new Formatter(filename)){
            for(int i = 0; i < tasks.size(); i++){
                TaskItem task = tasks.get(i);
                output.format("%d) %s", i+1, task);
            }

        } catch (FileNotFoundException ex){
            System.out.printf("Unable to find the file: %s", filename);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void read(String filename){
        try(Scanner input = new Scanner(filename)){


        } catch (FileNotFoundException ex){
            System.out.printf("Unable to find the file: %s", filename);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
