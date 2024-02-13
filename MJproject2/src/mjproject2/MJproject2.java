package mjproject2;

import java.util.Scanner;

public class MJproject2 {

    static Scanner num = new Scanner(System.in);
    static Scanner words = new Scanner(System.in);
    public static void main(String[] args) {
       
        
        System.out.print("Enter Full Name (Last name, First name, Middle Initial): ");
        String name = words.nextLine();
        System.out.print("Enter Age: ");
        int age = num.nextInt();
        System.out.print("Gender: ");
        String gender = words.nextLine();
        System.out.print("Address: ");
        String address = words.nextLine();
        System.out.print("Civil Status: ");
        String civilStatus = words.nextLine();
        System.out.print("Number of Brothers/Sisters: ");
        int siblings = num.nextInt();
        System.out.println("\n\nFull Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Address: " + address);
        System.out.println("Civil Status: " + civilStatus);
        System.out.println("Number of Brothers/Sisters : " + siblings);

    }
    
}
