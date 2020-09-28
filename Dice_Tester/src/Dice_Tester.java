import java.util.Scanner;

public class Dice_Tester {

    public void main(String[] args){
        int[] array = {0,0,0,0,0,0};
        int input=1;
        int total_input=0;

        while (input != 0) {
            input = GetUserInput();

            IncreaseArray(array, input);

            ++total_input;
        }

        PrintArray(array, total_input);
    }

    //add the dice roll to a
    public static void IncreaseArray(int[] a, int input){
        switch(input) {
            case 1:
                ++a[0];
                break;
            case 2:
                ++a[1];
                break;
            case 3:
                ++a[2];
                break;
            case 4:
                ++a[3];
                break;
            case 5:
                ++a[4];
                break;
            default:
                ++a[5];

        }

    }

    //get user input of a dice roll
    public static int GetUserInput(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a roll of a dice, or 0 to exit:");

        return scanner.nextInt();
    }

    //print array of dice rolls
    public static void PrintArray(int[] a, int n_input){
        System.out.printf("The result for %d dice rolls is:", n_input);

        for(int i=0; i<6; i++) {
            System.out.printf("%d: %d\n",i+1, a[i]);
        }
    }
}
