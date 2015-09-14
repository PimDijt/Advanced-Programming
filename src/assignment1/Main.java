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
	PrintStream out;
	
	Main(){
		out = new PrintStream(System.out);
	}
		
	boolean nextCharIsLetter (Scanner in) {
		return in.hasNext("[a-zA-Z]");
	}
	
	boolean nextCharIsDigit(Scanner in) {
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
	
	void progLoop(){
		Set set1 = processInput("Give first set: ");
		Set set2 = processInput("Give second set: ");		
	}
	
	Set processInput(String prompt) {
		Scanner in = new Scanner(System.in);
		do {
			out.printf("%s", prompt);
			String line = in.nextLine();
			if (checkSyntax(line)) { // Check if brackets are okay
				
				Set curSet = parseIdentifiers(line);
				if (curSet != null) {
					return curSet;
				}
			}
		} while (true);
	}
	
	boolean checkSyntax(String line){
		if(line.isEmpty()){
			return false;
		}
		char first = line.charAt(0);
		char last = line.charAt(line.length() - 1);
		if (first != '{') {
			out.printf("The set has to start with a '{'.\n");
			return false;
		} else if (last != '}') {
			out.printf("The set has to end with a '}'.\n");
			return false;
		}
		return true;
	}
	
	Set parseIdentifiers(String line){
		Set curSet = new Set();
		line = line.substring(1, line.length() - 1);
		Scanner elements = new Scanner(line);
		elements.useDelimiter(" ");
		while(elements.hasNext()){
			Scanner element = new Scanner(elements.next());
			element.useDelimiter("");
			if(nextCharIsLetter(element)){
				Identifier id = new Identifier();
				id.init(nextChar(element));
				while(element.hasNext()){
					if(nextCharIsLetter(element) || nextCharIsDigit(element)){
						id.addChar(nextChar(element));
					}else{
						out.printf("Identifiers can only contain letters or digits\n");
						return null;
					}
				}
				try {
					curSet.addIdentifier(id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				out.printf("Identifiers have to start with a letter.\n");
				return null;
			}
		}
		return curSet;
	}
	
	void start(){
		//do
		progLoop();
		//while(true);
	}
	
	public static void main(String[] args){
		new Main().start();
	}	
}