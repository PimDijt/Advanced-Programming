package assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Main {

	BinaryTree<IdentifierInterface> tree;
	Scanner in;
	PrintStream out;
	BufferedReader file;
	
	boolean lowerCase,
			descending;
	
	Main(){
		tree = new BinaryTree<>();
		in = new Scanner(System.in);
		out = new PrintStream(System.out);
		lowerCase = descending = false;
	}
	
	
	void start(){
		String row = in.nextLine();
		Scanner rowScanner = new Scanner(row);
		rowScanner.useDelimiter("");
		
		try {
			commandLineArguments(rowScanner);
		} catch (APException e) {
			e.printStackTrace();
		}
	}
	
	void commandLineArguments(Scanner input) throws APException{
		removeWhiteSpace(input);
		if(nextCharIs(input, '-')){
			commandLineOptions(input);
		}
		removeWhiteSpace(input);
		files(input);
	}
	
	void commandLineOptions(Scanner input) throws APException{
		option(input);
		removeWhiteSpace(input);
		while(nextCharIs(input, '-')){
			option(input);
			removeWhiteSpace(input);
		}
	}
	
	void option(Scanner input) throws APException{
		character(input, '-');
		removeWhiteSpace(input);
		if(nextCharIs(input, 'i')){
			character(input, 'i');
			lowerCase = true;
		}else if(nextCharIs(input, 'd')){
			character(input, 'd');
			descending = true;
		}else{
			throw new APException("'"+nextChar(input)+"' is not an option.");
		}
	}
	
	void files(Scanner input){
		String files = input.nextLine();
		Scanner fileScanner = new Scanner(files);
		fileScanner.useDelimiter(" ");
		
		do{
			Scanner file = new Scanner(fileScanner.next());
			text(file);
			removeWhiteSpace(input);
		} while(fileScanner.hasNext());
	}
		
	void text(Scanner input) {
		do {
			do {
				word(input);
				removeWhiteSpace(input);
			} while (!delimiter(input));
		} while (delimiter(input));
	}
	
	void word(Scanner input){
		if(nextCharIsLetter(input)){
			Identifier id = identifier(input);
			if(lowerCase == true){
				id = lowerCase(id);
			}
			tree.insert(id);
		}else{
			nonIdentifier(input);
		}
	}
	
	boolean delimiter(Scanner input){
		if(nextCharIsAlphaNumeric(input)) return false;
		
		while(!nextCharIsAlphaNumeric(input)){
			nextChar(input);
		}
		return true;
	}
	
	void nonIdentifier(Scanner input){
		while(nextCharIsAlphaNumeric(input)){
			input.next();
		}
	}
	
	Identifier identifier(Scanner input){
		Identifier id = new Identifier();
		id.init(nextChar(input));
		
		while(nextCharIsAlphaNumeric(input)){
			id.addChar(nextChar(input));
		}
		return id;
	}
	
	void printTree(){
		
	}
	
	Identifier lowerCase(Identifier id){
		String s = "";
		for(int i=0; i<id.getSize(); i++){
			s += id.getChar(i);
		}
		String identifier = s.toLowerCase();
		id.init(identifier.charAt(0));
		
		for(int i=1; i< identifier.length(); i++){
			id.addChar(identifier.charAt(i));
		}
		return id;
	}
	
	
	void character (Scanner input, char c) throws APException {
		if (!input.hasNext()) 	   throw new APException("Statement has not been completed, expected " + c);
	    if (!nextCharIs(input, c)) throw new APException("Read " + nextChar(input) + " and expected " + c);
	    nextChar(input);
	}
	
	char nextChar (Scanner in) {
		return in.next().charAt(0);
	}
	
	void removeWhiteSpace(Scanner in){
		while(in.hasNext(" ")){
			in.next();
		}
	}
	
	boolean nextCharIsAlphaNumeric (Scanner in) {
		return (nextCharIsLetter(in) || nextCharIsDigit(in));
	}
	
	boolean nextCharIsDigit (Scanner in) {
		return in.hasNext("[0-9]");
	}
	
	boolean nextCharIsLetter (Scanner in) {
		return in.hasNext("[a-zA-Z]");
	}
	
	boolean nextCharIs(Scanner in, char c) {
		return in.hasNext(Pattern.quote(c+""));
	}
	
	
	public static void main(String[] args) {
		new Main().start();
	}
}