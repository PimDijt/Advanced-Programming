package assignment1;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
	/** Strategy for Main.class
	 * 1. Ask user for input
	 * 2. Check if input is in correct syntax
	 * 3. If not, throw exceptions with proper error messages and let user try again
	 * 4. Execute the various operations 
	 * 5. print the results
	 * 6. ask user for input again (point 1.)
	 */
	
	public static final int MAX_IDENTIFIERS_PER_COLLECTION = 10;
	
	Scanner in;
	PrintStream out;
	int numberOfSets;
	
	Main(){
		in = new Scanner(System.in);
		out = new PrintStream(System.out);
		numberOfSets = 0;
	}
	
	//Asks the user for input
	void askForInput(int numberOfSets){
		if(numberOfSets == 0){
			out.println("Give the first set: ");
		}else{
			out.println("Give the second set: ");
		}
	}
	
	boolean checkFilled(){
		if(!in.hasNext()){
			return false;
		}
		return true;
	}
	
	// Checks if the syntax of the input is entered correctly
	void parseInput() throws Exception {
		in.useDelimiter("");
		String line = in.nextLine();
		if (checkBracketSyntax(line)) {
			line = line.substring(1, line.length() - 1);
			Scanner elements = new Scanner(line);
			parseIdentifiers(elements);
		}
	}

	
	boolean checkBracketSyntax(String line) throws Exception {
		char first = line.charAt(0);
		char last = line.charAt(line.length() - 1);
		if (first != '{') {
			throw new Exception("Missing first bracket");
		} else if (last != '}') {
			throw new Exception("Missing last bracket");
		}
		return true;
	}
	
	void parseIdentifiers(Scanner line){
		line.useDelimiter(" ");
		while(line.hasNext()){
			Scanner id = new Scanner(line.next());
			if(checkValidCharacters(id)){
				makeIdentifier(id);
			}
		}
	}
	
	void makeIdentifier(Scanner in){
		in.useDelimiter("");
		Identifier id = new Identifier();
		while(in.hasNext()){
			id.addChar(in.next().charAt(0));
		}
	}
	
	boolean checkValidCharacters(Scanner id){
		id.useDelimiter("");
		if(nextCharIsLetter(id)){
			while(id.hasNext()){
				if(!(nextCharIsLetter(id) || nextCharIsDigit(id))){
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	boolean nextCharIsLetter (Scanner in) {
		return in.hasNext("[a-zA-Z]");
	}
	
	boolean nextCharIsDigit (Scanner in) {
		return in.hasNext("[0-9]");
		}
	char nextChar (Scanner in) {
		return in.next().charAt(0);
	}

	
	boolean nextCharIs(Scanner in, char c) {
		return in.hasNext(Pattern.quote(c+""));
	}

	
	//Does the 4 operations on the two collections
	void operations(){
	}
	
	//Prints a Collection
	void printOutput(Set set){
	}
	
	void operator(){
		do{
			askForInput(numberOfSets);
		}while(!checkFilled());

		try{
			parseInput();
		}catch (Exception e){
			out.println(e.toString());
		}
	}
	
	//Initializes the program
	void start(){
		do {
			operator();
		} while(true);
	}
	
	public static void main(String[] args){
		new Main().start();
	}
	
}
		
		//		endless_loop{
//			askForInput
//			validate_input 
//			if 2 sets are collected{
//				perform set actions
//			}
//		}
