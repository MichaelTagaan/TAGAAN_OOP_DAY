package student;

import java.util.Scanner;


public class StudentMain {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        Student stdnt1 = new Student("Jemar Jude", "Maranga", 17);
        Student stdnt2 = new Student("Jose", "Cruz", 19);
        
        System.out.print("Enter test case number: ");        
        int testCase = input.nextInt();
        
        switch (testCase)
        {
            case 1:
                System.out.println("Test Case 1: Student under 18");
                System.out.println(stdnt1);
                break;
            case 2:
                System.out.println("Test Case 2: Increase age of student1");
                stdnt1.increaseAge();
                System.out.println(stdnt1);
                break;
            case 3:
                System.out.println("Test Case 3: Student over 18");
                System.out.println(stdnt2);
                break;
        }
       input.close(); 
    }   
}

