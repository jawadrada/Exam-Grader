import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;  

public class UnitTestRunner {

	public static void main(String[] args) {
	
		UnitTest unit;
		unit = new UnitTest(); //unit test object that starts reading in the text file
		
		//Stores the students object in the array list
		ArrayList<Student> studentInfo = new ArrayList<Student>(); 
		//The key for the hash map is: ex radajawad --> aaaaaaaaaa
		HashMap<String, ArrayList<String>> studentMap = new HashMap<String, ArrayList<String>>();
		double average = 0.0;
		
		try {
			Scanner input = new Scanner(new File("allExams.txt"));
			while (input.hasNext()) {
				//reads in the info from allexams.txt file
				String info = input.nextLine();
				String[] word = info.split(" "); //splits the line into different index stored in the word array
				String firstName = word[0]; 
				String lastName = word[1];
				
				//Adds the student object created for each student into the array list
				Student student = new Student(firstName, lastName, average);
				studentInfo.add(student);
				//Adds the student answers into the array list
				ArrayList<String> studentAnwsers = new ArrayList<String>();
				
				//starts after first name and last name is added to their array list
				for(int i = 2; i < word.length; i++) {
					studentAnwsers.add(word[i]);
				} 
				
				//adds the first name and last name together and makes all the letter's lower case
				String key = (lastName + firstName).toLowerCase();
				studentMap.put(key, studentAnwsers);
				//adds the key and answers to the hash map
				
				
			}	
			input.close();
		} catch(Exception e) {
			System.out.println("The file was not found.");
			e.printStackTrace();
		}
	
			//An array list that stores the averages for each student of the exam
		 	ArrayList<Double> gradesList = new ArrayList<Double>();
		
		for(int i = 0; i < studentInfo.size(); i++) {
			double grade;
			Student s; //student object
			s = studentInfo.get(i); //s is set to each of the individual student objects that were created above
			
			String firstName = s.getFirstName(); //sets the variable to the name's of the student objects
			String lastName = s.getLastName();
			
			//created an array list that gets the value for the specific value passed in
			String key = (lastName + firstName).toLowerCase();
			ArrayList<String> answers = studentMap.get(key);
			
			//calculates the grade for each student
			grade = unit.calculateGrade(answers);
			s.setAverage(grade);
			gradesList.add(grade);
		}
		
		
		//Prints out the students names and grades
		System.out.println("STUDENT GRADES: ");
		for(int i = 0; i < studentInfo.size(); i++) {
			Student s;
			s = studentInfo.get(i);
			
			System.out.println(s.getFirstName() + " " + s.getLastName() + ": " + s.getAverage());
		}
		
		
			double largest = gradesList.get(0);
			double smallest = gradesList.get(0);
			
			//calculates the range of the class
			//by finding the smallest and largest grade and calculating the difference between the values.
			
			for(int i = 0; i < gradesList.size(); i++) {
				if(gradesList.get(i) < smallest) {
					smallest = gradesList.get(i);
				}
				
				if(gradesList.get(i) > largest) {
					largest = gradesList.get(i);
				}
			}
			
			double range = largest - smallest;
			System.out.println("\nThe range of the class is: " + range);
			
			//calculates the class average by adding all the grades and dividing by size
			double mean = 0.0;
			for(int i = 0; i < gradesList.size(); i++) {
				mean = mean + gradesList.get(i);
			}
			
			mean = mean/gradesList.size();
			System.out.format("The class average is: " + "%.2f", mean);
	}
}
