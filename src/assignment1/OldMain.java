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
	
	Set set1;
	Set set2;
	
	Main(){
		in = new Scanner(System.in);
		out = new PrintStream(System.out);
		numberOfSets = 0;
		set1 = new Set();
		set2 = new Set();
	}
	
	boolean manageInput(){
		do{
			if (!askForInput("Give the first set: ", set1)){
				if (askForInput("Give the second set: ", set2)){
					return true;
				}
			}
		}while(!checkFilled());
	}
	
	// Asks the user for input
	boolean askForInput(String prompt, Set currentSet){
			out.printf("%s", prompt);
			return parseInput(currentSet);
		}
	
	// Checks if the syntax of the input is entered correctly
	boolean parseInput(Set currentSet) throws Exception {
		in.useDelimiter("");
		String line = in.nextLine();
		if (checkBracketSyntax(line)) {
			line = line.substring(1, line.length() - 1);
			Scanner elements = new Scanner(line);
			return (parseIdentifiers(elements);
		}
	}
	
	// 
	void parseIdentifiers(Scanner line) throws Exception{
		line.useDelimiter(" ");
		while(line.hasNext()){
			Scanner id = new Scanner(line.next());
			if(checkValidCharacters(id)){
				Identifier identifier = makeIdentifier(id);
			}
		}
	}

	// Checks whether the brackets are correctly entered.
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
	
	// Check whether characters are legit
	boolean checkValidCharacters(Scanner id) throws Exception{
		id.useDelimiter("");
		if(nextCharIsLetter(id)){
			while(id.hasNext()){
				if(!(nextCharIsLetter(id)) && !(nextCharIsDigit(id))){
					throw new Exception("Identifiers can only consist of letters and numbers");
				}
			}
		}else{
			throw new Exception("Every Identifier has to start with a letter");
		}
		return true;
	}
	
	// Checks if next input has been entered
	boolean checkFilled(){
		if(!in.hasNext()){
			return false;
		}
		return true;
	}
	
	//Creates new identifier
	Identifier makeIdentifier(Scanner in){
		in.useDelimiter("");
		Identifier id = new Identifier();
		while(in.hasNext()){
			id.addChar(in.next().charAt(0));
		}
		return id;
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
	void performOperations(){
	}
	
	//Prints a Collection
	void printOutput(Set set){
	}
	
	//Initializes the program
	void start(){
		do {
			if (manageInput()){;
				performOperations();
			}
		} while(true);
	}
	
	public static void main(String[] args){
		new Main().start();
	}	
}