import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    //get user to say if there is more input and return true/false
    public static boolean moreInput(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you have more data to enter? (Y/N)");
        String input = scanner.nextLine();

        if(input.equals("Y")){
            return true;
        }
        else if(input.equals("N")){
            System.out.println("Entries Stored");
            return false;
        }
        else{
            System.out.println("Please enter a valid answer");
            moreInput();
        }

        return false;
    }

    //get and return user height
    public static double getUserHeight(){
        Scanner scanner = new Scanner(System.in);
        boolean cont = true;
        double input;

        while(cont) {
            System.out.println("Please enter a height in inches:");
            input = scanner.nextDouble();
            String clear = scanner.nextLine(); //clears anything after

            if (input >=0){
                return input;
            }
            else{
                System.out.println("Please enter a valid height");
            }
        }
        return -1;
    }

    //get and return user weight
    public static double getUserWeight(){
        Scanner scanner = new Scanner(System.in);
        boolean cont = true;
        double input;

        while(cont) {
            System.out.println("Please enter a weight in pounds:");
            input = scanner.nextDouble();
            String clear = scanner.nextLine(); //clears anything after

            if (input >=0){
                return input;
            }
            else{
                System.out.println("Please enter a valid weight");
            }
        }
        return -1;
    }

    //prints bmi and bmi category based on object
    public static void displayBmiInfo(BodyMassIndex bmi){
        System.out.printf("BMI: %f %nBMI Category: %s\n",
                bmi.getBMI(), bmi.getCategory());
    }

    //prints average BMI score from array
    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData){
        double average = getBMIAverage(bmiData);

        System.out.printf("The Average BMI is: %f", average);
    }

    public static double getBMIAverage(ArrayList<BodyMassIndex> bmiData){
        double average;
        double sum = 0;

        for (BodyMassIndex item:bmiData){
            sum += item.getBMI();
        }

        average = sum/bmiData.size();

        return average;
    }
}
