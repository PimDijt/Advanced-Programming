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
		
	public static final int MAX_IDENTIFIERS_PER_SET = 10;
	PrintStream out;
	
	Main(){
		out = new PrintStream(System.out);
	}
		
	void start(){
		//do
		progLoop();
		//while(true);
		
		//hasNextLine
	}
	
	void progLoop(){
		Set set1 = processInput("Give first set: ");
		Set set2 = processInput("Give second set: ");
		
		//out.printf("%s\n", stringifySet(set1));
		//out.printf("%s\n", stringifySet(set2));
		
		performOperations(set1, set2);
	}
	
	Set processInput(String prompt) {
		Scanner in = new Scanner(System.in);
		do {
			out.printf("%s", prompt);
			String line = in.nextLine();
			if (checkSyntax(line)) { 
				Set curSet = parseIdentifiers(line);
//				out.printf("%s\n", stringifySet(curSet));
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
			Identifier id = makeIdentifier(element);

			if(id!=null){
				if(curSet.getSize()<MAX_IDENTIFIERS_PER_SET){
					try {
						curSet.addIdentifier(id);
					} catch (Exception e) {
						out.println("Lukt niet.\n");
					}
				}else{
					out.printf("A set cannot contain more than 10 elements.\n");
					return null;
				}
			}else{
				return null;
			}
			/*
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
					e.printStackTrace();
				}
			}else{
				out.printf("Identifiers have to start with a letter.\n");
				return null;
			}
			*/
		}
		return curSet;
	}
	
	Identifier makeIdentifier(Scanner element){
		if(nextCharIsLetter(element)){
			Identifier id = new Identifier();
			id.init(nextChar(element));
			while(element.hasNext()){
				if(nextCharIsLetter(element) || nextCharIsDigit(element)){
					id.addChar(nextChar(element));
				}else{
					out.printf("Identifiers can only contain letters or digits.\n");
					return null;
				}
			}
			return id;
		}else{
			out.printf("Identifiers have to start with a letter.\n");
			return null;
		}	
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
	
	void performOperations(Set set1, Set set2){		
		Set difference = set1.difference(set2);
		Set intersection = set1.intersection(set2);
		out.printf("difference: %s\n", stringifySet(difference));
		out.printf("intersection: %s\n", stringifySet(intersection));
		
		/*
		Set intersection = set1.intersection(set2);
		Set union = set1.union(set2);
		Set symDifference = set1.symmetricDifference(set2);
		
		out.printf("difference = %s\n", stringifySet(difference));
		out.printf("intersection = %s\n", stringifySet(intersection));
		out.printf("union = %s\n", stringifySet(union));
		out.printf("sym. diff.  = %s\n", stringifySet(symDifference));
		*/
	}
	
	String stringifySet(Set set){
		Set result = new Set(set);
		
		String line = "{";
		int setSize = result.getSize();
		for(int i=0; i<setSize; i++){
			Identifier id = result.getIdentifier();
			result.removeIdentifier(id);
			for(int j=0; j<id.getSize(); j++){
				line += id.getChar(j);
			}
			line += " ";
		}
		line += "}";
		return line;
	}
	
	public static void main(String[] args){
		new Main().start();
	}	
}