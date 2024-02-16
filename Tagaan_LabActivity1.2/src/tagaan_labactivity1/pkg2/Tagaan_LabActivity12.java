package tagaan_labactivity1.pkg2;
import java.util.Scanner;
public class Tagaan_LabActivity12 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the message: ");
        String message = input.nextLine();
        if (hasMisplacedLetters(message)) {
            System.out.println("JEJE!");
        } else {
            System.out.println("uWu");
        }
    }   

    public static boolean hasMisplacedLetters(String message) {
        boolean CapitalFound = false;
        boolean StartingLetter = true;

        for (char letter: message.toCharArray()) {
            if (Character.isLetter(letter)) {
                if (!StartingLetter && Character.isUpperCase(letter)) {
                    CapitalFound = true;
                    break;
                }
                StartingLetter = false;
            } else {
            StartingLetter = true;      
            }       
        }
        return CapitalFound;
    }
}