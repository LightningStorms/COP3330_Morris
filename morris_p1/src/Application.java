import java.util.Scanner;

public class Application {
    Encrypter myEncrypter; // make new instance
    Decrypter myDecrypter; // new instance of decryptor

    Scanner input = new Scanner(System.in);
    String test = "1111";


    while (test != "0000")

    {
        System.out.println("Enter a four digit test code");
        test = input.nextLine();

        String encryptedValue = myEncrypter.encrypt(test);
        System.out.println(encryptedValue);

        String decryptedValue = myDecrypter.decrypt(encryptedValue);
        System.out.println(decryptedValue);
    }
}
