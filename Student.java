/*
 * Author: Jawad Rada
 */

//Student class
public class Student {
	
	private String firstName; //student's firstName
	private String lastName; //student's lastName
	private double average; //student's average
	
	//Getter method that returns the student's firstName
	public String getFirstName() {
		return firstName;
	}

	//Getter method that returns the student's lastName
	public String getLastName() {
		return lastName;
	}

	//Getter method that returns the student's average on the test
	public double getAverage() {
		return average;
	}

	//Setter method that sets the value of average to 0
	public void setAverage(double average) {
		this.average = average;
	}
	
	//Default constructor that initializes firstName, lastName and average to default values.
	public Student() {
		firstName = "Jawad";
		lastName = "Rada";
		average = 0.0;
	}
	
	//Constructor with 3 parameters that sets the private data to the values stored in the parameters
	public Student(String firstName, String lastName, double average) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.average = average;
	}
}
