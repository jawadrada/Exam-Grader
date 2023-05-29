import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;   

public class UnitTest {
	
	//An array list that stores the answer key of the exam
	ArrayList<String> anwserKey = new ArrayList<String>();
	
	//Unit Test constructor that reads from the anwsers.txt file
	public UnitTest(){
		
		try {
			Scanner input;
			input = new Scanner(new File("answers.txt"));
			while (input.hasNext()) { //the while loop terminates when there is no more lines left to read
				String letter = input.next(); //gets the next letter in the text file and stores it in letter variable
				anwserKey.add(letter);//Adds the correct answer of the exam to the array list
			}	
			input.close(); 
		} catch(Exception e) {//If the file is not found the below message is outputted to the console.
			System.out.println("The file was not found.");
			e.printStackTrace();
		}
		
	}
	
	//Method that calculates the grade for the student answers that are brought in
	public double calculateGrade(ArrayList<String> studentAnwsers) {
		
		int correctAnwsers = 0;
		
		for(int i = 0; i < anwserKey.size(); i++){
			//Checks if the letter is equal to the answer key
			if(anwserKey.get(i).equals(studentAnwsers.get(i))) {
				correctAnwsers++;
			}
			
		}
		//returns the percentage the student got right
		return ((double)correctAnwsers/anwserKey.size())*100;
	}

}
