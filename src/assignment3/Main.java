package assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

	BinaryTree<IdentifierInterface> tree;
	Scanner 	   in;
	PrintStream    out;
	BufferedReader file;
	
	boolean lowerCase,
			descending;
	
	Main(){
		tree 	  = new BinaryTree<>();
		in 		  = new Scanner(System.in);
		out 	  = new PrintStream(System.out);
		lowerCase = descending = false;
	}
	
	
	void start(String[] args){		
		for (int i = 0; i < args.length; i++){
			commandLineArguments(new Scanner(args[i]));
		}
	}
	
	void commandLineArguments(Scanner input){
		input.useDelimiter("");
		if(nextCharIs(input, '-')) commandLineOption(input);		
		else {
			input.useDelimiter(" ");
			parseFile(input);
		}
	}
	
	void commandLineOption(Scanner input){
		character(input, '-');		
		if	   (characterBoolean(input, 'i')) lowerCase  = true;
		else if(characterBoolean(input, 'd')) descending = true;
		else throw new Error("Incorrect flag passed.");
	}
	
	void parseFile(Scanner input){
		try {
			Scanner file = new Scanner(new File(input.next()));
			file.useDelimiter("");
			text(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
		
	void text(Scanner input) {
		while (!eof(input)){
			do{
				word(input);
			} while(!delimiter(input));
		}
		printTree();
	}
	
	boolean delimiter(Scanner input){
		if (eoln(input)) 				   return true; 
		if (nextCharIsAlphaNumeric(input)) return false;
		
		while(!nextCharIsAlphaNumeric(input) && !eoln(input)){
			nextChar(input);
		}
		return true;
	}
	
	void word(Scanner input){
		if(nextCharIsLetter(input)){
			Identifier id = identifier(input);
			if(lowerCase == true){
				id = lowerCase(id);
			}
			tree.insert(id);
		} else {
			nonIdentifier(input);
		}
		removeWhiteSpace(input);
	}
	
	Identifier identifier(Scanner input){
		Identifier id = new Identifier();
		id.init(nextChar(input));
		
		while(nextCharIsAlphaNumeric(input)){
			id.addChar(nextChar(input));
		}
		return id;
	}
	
	void nonIdentifier(Scanner input){
		while(nextCharIsAlphaNumeric(input)){
			input.next();
		}
	}
		
	void printTree(){
		Iterator<IdentifierInterface> it = (descending) ? tree.descendingIterator() : tree.ascendingIterator();
		
		while(it.hasNext()){
			IdentifierInterface id = it.next();
			
			for (int i = 0; i < id.getSize(); i++) {
				out.print(id.getChar(i));
			}
			out.print("\n");
		}
	}
	
	Identifier lowerCase(Identifier id) {
		String s = "";
		for (int i = 0; i < id.getSize(); i++) {
			s += id.getChar(i);
		}
		String identifier = s.toLowerCase();
		id.init(identifier.charAt(0));

		for (int i = 1; i < identifier.length(); i++) {
			id.addChar(identifier.charAt(i));
		}
		return id;
	}
	
	void character (Scanner input, char c) {
		if (!input.hasNext()){
			throw new Error("eoln error.");
		}
	    if (!nextCharIs(input, c)){
	    	throw new Error("Read " + nextChar(input) + " and expected " + c);
	    }
	    nextChar(input);
	}
	
	boolean characterBoolean (Scanner input, char c) {
		if (!nextCharIs(input, c)) return false;
		character(input, c);
		
	    return true;
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
	
	boolean eoln (Scanner input) {
	    if (input.hasNext()) return false;
	    return true;
	}
	
	boolean eof (Scanner input){
		if (input.hasNextLine()) return false;
		return true;
	}
	
	public static void main(String[] args) {
		new Main().start(args);
	}
}