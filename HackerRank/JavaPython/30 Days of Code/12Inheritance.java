Sample Input
Heraldo Memelli 8135627
2
100 80

Sample Output
Name: Memelli, Heraldo
ID: 8135627
Grade: O


import java.util.*;

class Person {
	protected String firstName;
	protected String lastName;
	protected int idNumber;
	
	// Constructor
	Person(String firstName, String lastName, int identification){
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}
	
	// Print person data
	public void printPerson(){
		 System.out.println(
				"Name: " + lastName + ", " + firstName 
			+ 	"\nID: " + idNumber); 
	}
	 
}

class Student extends Person{
	private int[] testScores;

  /*	
  *   Class Constructor
  *   
  *   @param firstName - A string denoting the Person's first name.
  *   @param lastName - A string denoting the Person's last name.
  *   @param id - An integer denoting the Person's ID number.
  *   @param scores - An array of integers denoting the Person's test scores.
  */
  // Write your constructor here
  public Student(String firstName, String lastName, int id, int[] scores) {
    super(firstName, lastName, id);
    this.testScores = scores;
  }
  /*	
  *   Method Name: calculate
  *   @return A character denoting the grade.
  */
  // Write your method here
  public String calculate() {
    int sum =0;
    for(int i = 0; i<testScores.length; i++) {
      sum+=testScores[i];
    }
    
    double ave = sum/testScores.length;
    if(ave>=90 && ave<=100) return "O";
    else if(ave>=80 && ave<=90) return "E";
    else if(ave>=70 && ave<=80) return "A";
    else if(ave>=55 && ave<=70) return "P";
    else if(ave>=40 && ave<=55) return "D";
    else return "T";
  }
    
}

class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		for(int i = 0; i < numScores; i++){
			testScores[i] = scan.nextInt();
		}
		scan.close();
		
		Student s = new Student(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: " + s.calculate() );
	}
}