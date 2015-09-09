package assignment1;

import java.io.*;
import java.util.*;

public class Main {
	/** Strategy for Main.class
	 * 1. Ask user for input
	 * 2. Check if input is in correct syntax
	 * 3. If not, throw exceptions with proper error messages and let user try again
	 * 4. Execute the various operations 
	 * 5. print the results
	 * 6. ask user for input again (point 1.)
	 */
	
	static final int MAX_IDENTIFIERS_PER_COLLECTION = 10;
	
	Scanner in;
	PrintStream out;
	
	Main(){
		in = new Scanner(System.in);
		out = new PrintStream(System.out);
	}
	
	//Asks the user for input
	void askForInput(Scanner in){
	}
	
	//Checks if the syntax of the input is entered correctly
	void parseInput() throws Exception{
	}
	
	//Does the 4 operations on the two collections
	void operations(){
	}
	
	//Prints a Collection
	void printOutput(Set col){
	}
	
	//Initializes the program
	void start(){
	}
}