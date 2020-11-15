public class Test_File {
    public static void main(String[] args){
        double x = productOdd(9);

        System.out.println(x);
        System.out.println(1*3*5*7*9);
    }

    //declared static to test without intitalizing object
    public static double productOdd(int n){
        if(n>0) {
            double product = 1;

            //calculates the product of odd numbers starting from 1 and going to n (including n)
            for (int i = 1; i <= n; i += 2) {
                product *= i;
            }

            return product;
        }
        else{
            return 0;
        }
    }

}
