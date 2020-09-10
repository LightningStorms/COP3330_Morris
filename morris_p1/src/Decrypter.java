public class Decrypter {
    private String test;

    public String decrypt(String test){
        String decrypted = "";

        //add 7
        decrypted = minus7(test);

        //swap digits
        decrypted = swap(encrypted, 0);
        decrypted = swap(encrypted, 1);

        //decrypted now holds the final string...

    }

    //subtracts 7 to each digit
    public String minus7(String test){
        int i;
        String minus7 = "";

        for (i=0; i<4; i++)
            minus7.charAt[i]= test.charAt[i] + 7;

        return minus7;
    }

    //can use the same swap as in the encryptor because the numbers are in the same locations

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
