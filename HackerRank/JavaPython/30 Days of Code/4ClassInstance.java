// Sample Input
// 4
// -1
// 10
// 16
// 18

// Sample Output
// Age is not valid, setting age to 0.
// You are young.
// You are young.

// You are young.
// You are a teenager.

// You are a teenager.
// You are old.

// You are old.
// You are old.

// Explanation
// Test Case 0: initialAge = -1
// Because initialAge<0, our code must set age to 0  and print the "Age is not valid..." message followed by the young message. Three years pass and age=3 , so we print the young message again.

// Test Case 1: initialAge = 10
// Because initialAge<13, our code should print that the person is young. Three years pass and age=19, so we print that the person is now a teenager.

// Test Case 2: initialAge = 16
// Because 13<=initialAge<18, our code should print that the person is a teenager. Three years pass and age=19, so we print that the person is old.

// Test Case 3: initialAge = 18
// Because initialAge>=18, our code should print that the person is old. Three years pass and the person is still old at age=21, so we print the old message again.

// The extra line at the end of the output is supposed to be there and is trimmed before being compared against the test case's expected output. If you're failing this challenge, check your logic and review your print statements for spelling errors.

import java.io.*;
import java.util.*;

public class Person {
    private int age;	
  
	public Person(int initialAge) {
  		// Add some more code to run some checks on initialAge
        if(initialAge>0) {
            age =initialAge;
        }else{
            System.out.println("Age is not valid, setting age to 0.");
            age=0;
        }
	}

	public void amIOld() {
  		// Write code determining if this person's age is old and print the correct statement:
        if(age<13) System.out.println("You are young.");
        else if(age>=13 && age<18) System.out.println("You are a teenager.");
        else System.out.println("You are old.");
	}

	public void yearPasses() {
  		// Increment this person's age.
        age++;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int age = sc.nextInt();
			Person p = new Person(age);
			p.amIOld();
			for (int j = 0; j < 3; j++) {
				p.yearPasses();
			}
			p.amIOld();
			System.out.println();
        }
		sc.close();
    }
}
