package assignment1;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

	public static final int MAX_IDENTIFIERS_PER_SET = 10;
	PrintStream out;
	
	Main(){
		out = new PrintStream(System.out);
	}
		
	void start(){
/*		while (true) {
			Set set1 = processInput("Give first set : ");
			Set set2 = processInput("Give second set : ");		
			performOperations(set1, set2);
		}
 */		
		// The above was commented away to make place for the following
		// This also requires performOperations to return a (very irrelevant) true.
		// Note that both work just dandy.
		Set set1 = new Set();
		Set set2 = new Set();

		do {
			set1 = processInput("Give first set : ");
			set2 = processInput("Give second set : ");		
		} while (performOperations(set1, set2));
	}
	
	Set processInput(String prompt) {
		Scanner in = new Scanner(System.in);
		while (true) {
			out.printf("%s", prompt);
			String line = in.nextLine();
			if (checkSyntax(line)) {
				Set curSet = parseIdentifiers(line);
				if (curSet != null) {
					return curSet;
				}
			}
		}
	}
	
	boolean checkSyntax(String line) {
		if (line.isEmpty()) {
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
	
	Set parseIdentifiers(String line) {
		Set curSet = new Set();
		line = line.substring(1, line.length() - 1);
		Scanner elements = new Scanner(line);
		while (elements.hasNext()) {
			Scanner element = new Scanner(elements.next());
			element.useDelimiter("");
			Identifier id = makeIdentifier(element);
			if (id == null) { return null; }
			if (curSet.getSize() >= MAX_IDENTIFIERS_PER_SET) {
				out.printf("A set cannot contain more than 10 elements.\n");
				return null;
			}
			
			try {
				curSet.addIdentifier(id);
			} catch (Exception e) {
				out.println("Too many identifiers.\n");
			}
		}
		return curSet;
	}
	
	Identifier makeIdentifier(Scanner element) {
		if (!nextCharIsLetter(element)) {
			out.printf("Identifiers have to start with a letter.\n");
			return null;
		}
		Identifier id = new Identifier();
		id.init(nextChar(element));
		while (element.hasNext()) {
			if (nextCharIsLetter(element) || nextCharIsDigit(element)) {
				id.addChar(nextChar(element));
			} else {
				out.printf("Identifiers may only contain letters or digits.\n");
				return null;
			}
		}
		return id; 
	}
	
	boolean performOperations(Set set1, Set set2) {
		Set difference = set1.difference(set2);
		Set intersection = set1.intersection(set2);
		Set union = set1.union(set2);
		Set symdif = set1.symmetricDifference(set2);
		
		out.printf("difference = %s\n", stringifySet(difference));
		out.printf("intersection = %s\n", stringifySet(intersection));
		out.printf("union = %s\n", stringifySet(union));
		out.printf("symm. diff. = %s\n\n", stringifySet(symdif));
		return true;
	}
	
	String stringifySet(Set set) {
		Set result = new Set(set);
		String line = "{";
		int setSize = result.getSize();
		int spaceCheck = setSize - 1;
		for (int i = 0; i < setSize; i++) {
			Identifier id = result.getIdentifier();
			result.removeIdentifier(id);
			for (int j = 0; j < id.getSize(); j++) {
				line += id.getChar(j);
			}
			if (spaceCheck > 0) {
				line += " ";
				spaceCheck--;
			}
		}
		line += "}";
		return line;
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
	
	public static void main(String[] args){
		new Main().start();
	}	
}