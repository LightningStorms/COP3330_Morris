import java.util.Scanner;

public class Application {
    public static void main(String [] args) {
        Encrypter myEncrypter = new Encrypter(); // make new instance
        Decrypter myDecrypter = new Decrypter(); // new instance of decryptor



        String test = "";

        testString(test, myEncrypter, myDecrypter);
    }

    public  static void testString(String test, Encrypter myEncrypter, Decrypter myDecrypter){
        Scanner input = new Scanner(System.in);
        int i;

        for (i=0; i<5; i++) {
            System.out.println("Enter a four digit test code");
            test = input.nextLine();

            String encryptedValue = myEncrypter.encrypt(test);
            System.out.println("encrypted value is:" + encryptedValue);

            String decryptedValue = myDecrypter.decrypt(encryptedValue);
            System.out.println("decrypted value is:" + decryptedValue);
        }
    }

}
