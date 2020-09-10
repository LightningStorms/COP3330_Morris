public class Decrypter {
    private String test;

    public String decrypt(String test){
        int array[]= {'0', '0', '0', '0'};
        char finished[] = {'0', '0', '0', '0'};

        cutString(test, array);

        minus7(array);

        //swap works for both swaps, but just with a modifier a that changes which two get swapped
        swap(array, 0);
        swap(array, 1);

        reChar(array, finished);

        //convert array of chars into a string
        String encrypted= new String(finished);
        return encrypted;
    }
    //get the individual pieces
    public static void cutString(String test, int array[]){
        for (int i = 0; i<4; i++){
            array[i] = (test.charAt(i)-48);
        }
    }

    //cast ints back to chars so that string can be made of the chars
    public static void reChar(int array[], char finished[]){
        for (int i=0; i<4; i++){
            finished[i]= (char) (array[i]+48);
        }
    }

    //subtracts 7 to each digit and reverses remainder of division by 10
    public void minus7(int a[]){
        int i;

        for (i=0; i<4; i++) {
            //checks that number is not 0
            //0 only occurs if number is divisible by 10 (aka adding 7 made it 10)
            if(a[i] != 0){
                if (a[i]<7){
                    a[i]+=10;
                }
                a[i]-=7;
            }
            else{
                a[i]=3;//we know that if it is divisible by 10 and we subtract 7 the answer would be 3
            }
        }
    }

    //can use the same swap as in the encryptor because the numbers are in the same locations

    //swap first and third digits or second and fourth digits based on 'a'
    //if a is 0, swaps 1 & 3
    //if a is 1 swaps 2 & 4
    public static void swap(int array[], int a){
        int temp = 0;

        /* temp holds the value of 3rd digit so first can be swapped then puts the third
            digit back in the first slot.
         */
        temp = array[2+a];
        array[2+a]=array[0+a];
        array[0+a]=temp;
    }
}
