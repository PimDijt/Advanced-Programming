package assignment2;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

	
	
	void start(){
		Scanner in = new Scanner(System.in);
		String row = in.nextLine();
		Scanner rowScanner = new Scanner(row);
		try {
			program(rowScanner);
		} catch (APException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void program(Scanner input) throws APException{
		statement(input);
		eoln(input);
	}
	
	void statement(Scanner input) throws APException{
		if(nextCharIsLetter(input)){
			assignment(input);
		}else if(nextCharIs(input, '?')){
			print(input);
		}else if(nextCharIs(input, '/')){
			comment(input);
		}else{
			throw new APException(".......");
		}
	}
	
	void assignment(Scanner input) throws APException{
		Identifier id = identifier(input);
		character(input, '=');
	}
	
	Identifier identifier(Scanner input){
		Identifier id = new Identifier();
		return id;
	}
	void print(Scanner input){
		
	}
	void comment(Scanner input){
		
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
