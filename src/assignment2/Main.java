package assignment2;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	
	Scanner in;

	Main() {
		in = new Scanner(System.in);
	}
	
	void start(){
		String 	row = in.nextLine();
		Scanner rowScanner = new Scanner(row);
		try {
			program(rowScanner);
		} catch (APException e) {
			e.printStackTrace();
		}
	}
	
	void program(Scanner input) throws APException{
		while(!eof(input)){
			Scanner rowScanner = new Scanner(in.nextLine()).useDelimiter("");
			statement(rowScanner);				
		}
	}
	
	void statement(Scanner input) throws APException{
		if(nextCharIsLetter(input)){
			assignment(input);
		}else if(nextCharIs(input, '?')){
			printStatement(input);
		}else if(nextCharIs(input, '/')){
			comment(input);
		}else{
			throw new APException(".......");
		}
	}
	
	void assignment(Scanner input) throws APException{
		Identifier id = identifier(input);
		character(input, '=');
		Set set = expression(input);
		eoln(input);
	}
	
	void printStatement(Scanner input){
		character(input, '?');
		Set set = expression(input);
		eoln(input);
	}
	
	void comment(Scanner input) throws APException{
		character(input, '/');
		while(input.hasNext()){
			nextChar(input);
		}
		eoln(input);
	}
	
	
	Identifier identifier(Scanner input){
		Identifier id = new Identifier().init(nextChar(input));
		while(1==1){
			//
		}
		return id;
	}

	Set<E> expression(Scanner input){
		return null;
	}
	
	void character (Scanner input, char c) throws APException {
	    if (! nextCharIs(input, c)) {
	    	throw new APException("........");
	    }
	    nextChar(input);
	}
	
	char nextChar (Scanner in) {
		return in.next().charAt(0);
	}
	
	void eoln (Scanner input) throws APException {
	    if (input.hasNext()) {
	    	throw new APException("........");
	    }
	}
	
	boolean eof (Scanner input) throws APException {
	    if (input.hasNext()) {
	    	return true;
	    }
	    return false;
	}
	
	boolean nextCharIs(Scanner in, char c) {
		return in.hasNext(Pattern.quote(c+""));
	}
	
	boolean nextCharIsLetter (Scanner in) {
		return in.hasNext("[a-zA-Z]");
	}

	
	public static void main(String[] args){
		new Main().start();
	}
}
