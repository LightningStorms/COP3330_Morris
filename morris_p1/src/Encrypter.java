public class Encrypter {
    private String test;

    public String encrypt(String test){
        String encrypted = "";

        //add 7
        encrypted = add7(test);

        //swap digits
        encrypted = swap(encrypted, 0);
        encrypted = swap(encrypted, 1);

        //encrypted now holds the final string...

    }

    // adds 7 to each digit
    public String add7(String test){
        int i;
        String add7 = "";

        for (i=0; i<4; i++)
            add7.charAt[i]= test.charAt[i] + 7;

        return add7;
    }

    //swap first and third digits or second and fourth digits based on 'a'
    //if a is 0, swaps 1 & 3
    //if a is 1 swaps 2 & 4
    public String swap(String test, int a){
        String temp = "";

        /* temp holds the value of 3rd digit so first can be swapped then puts the third
            digit back in the first slot.
         */
        temp.charAt[0]= test.charAt[2+a];
        test.charAt[2+a]= test.charAt[0+a];
        test.charAt[0+a]= temp.charAt[0];

        return test;
    }
}
