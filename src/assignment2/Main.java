package assignment2;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

	Scanner in;

	Main() {
		in = new Scanner(System.in);
	}

	void start() {
		while (in.hasNextLine()) {
			String row = in.nextLine();
			row = row.replaceAll("\\s","");
			Scanner rowScanner = new Scanner(row);
			rowScanner.useDelimiter("");
			try {
				program(rowScanner);
			} catch (APException e) {
				//System.out.println(e.toString());
				e.printStackTrace();
			}
		}
	}

	void program(Scanner input) throws APException {
		statement(input);
	}

	void statement(Scanner input) throws APException {
		if (nextCharIsLetter(input)) {
			assignment(input);
		} else if (nextCharIs(input, '?')) {
			printStatement(input);
		} else if (nextCharIs(input, '/')) {
			comment(input);
		} else {
			throw new APException(".......");
		}
	}

	void assignment(Scanner input) throws APException {
		Identifier id = identifier(input);
		character(input, '=');
		Set<Number> set = expression(input);
		eoln(input);

		// add to talbe

	}

	void printStatement(Scanner input) throws APException {
		character(input, '?');
		Set<Number> set = expression(input);
		eoln(input);
		
		// print the set

	}

	void comment(Scanner input) throws APException {
		character(input, '/');
		while (input.hasNext()) {
			nextChar(input);
		}
		eoln(input);

		// do nothing

	}

	Identifier identifier(Scanner input) throws APException {
		Identifier id = new Identifier();
		if (!nextCharIsLetter(input)) {
			throw new APException("....");
		}
		id.init(nextChar(input));
		while (nextCharIsLetter(input) || nextCharIsDigit(input)) {
			id.addChar(nextChar(input));
		}
		return id;
	}

	Set<Number> expression(Scanner input) throws APException{
		Set<Number> set = term(input);
		while (additive_operator(input)) {
			if (nextCharIs(input, '|')) {
				character(input, '|');
				// union
				set = set.union(term(input));
			} else if (nextCharIs(input, '+')) {
				character(input, '+');
				// intersection
				set = set.intersection(term(input));
			} else if (nextCharIs(input, '-')) {
				character(input, '-');
				// difference
				set = set.difference(term(input));
			}
		}
		return set;
	}
	
	Set<Number> term(Scanner input) throws APException{
		Set <Number> set = factor(input);
		while(nextCharIs(input, '*')){
			character(input, '*');
			//symmetric difference?
			set = set.symmetricDifference(factor(input));
		}
		return set;
	}
	
	Set<Number> factor(Scanner input) throws APException{
		Set<Number> set = new Set();
		if(nextCharIsLetter(input)){
			Identifier id = identifier(input);
			//find Identifier in table
			//find the corresponding set
		}else if(nextCharIs(input, '(')){
			character(input, '(');
			set = expression(input);
			//complex_factor
			character(input, ')');
		}else{
			set(input);
		}
		return set;
	}
	
	Set<Number> set(Scanner input) throws APException{
		character(input, '{');
		Set<Number> set = naturalNumbers(input);
		character(input, '}');
		return set;
	}
	
	Set<Number> naturalNumbers(Scanner input) throws APException{
		Set<Number> set = new Set();
		if(!input.hasNext()){
			return set;
		}
		set.addElement(naturalNumber(input));
		while(nextCharIs(input, ',')){
			set.addElement(naturalNumber(input));
		}
		return set;
	}
	
	Number naturalNumber(Scanner input) throws APException{
		Number number = new Number();
		number.init(nextChar(input));
		while(nextCharIsDigit(input)){
			number.addDigit(nextChar(input));
		}
		return number;
	}	
	
	boolean additive_operator(Scanner input) {
		if(nextCharIs(input, '|') || nextCharIs(input, '+') || nextCharIs(input, '-')){
			return true;
		}
		return false;
	}

	void character(Scanner input, char c) throws APException {
		if (!nextCharIs(input, c)) {
			throw new APException("Read '" + nextChar(input) + "' and expected '" + c + "'.");
		}
		nextChar(input);
	}

	char nextChar(Scanner in) {
		return in.next().charAt(0);
	}

	void eoln(Scanner input) throws APException {
		if (input.hasNext()) {
			throw new APException("........");
		}
	}

	boolean eof(Scanner input) throws APException {
		if (input.hasNext()) {
			return true;
		}
		return false;
	}

	boolean nextCharIs(Scanner in, char c) {
		return in.hasNext(Pattern.quote(c + ""));
	}

	boolean nextCharIsLetter(Scanner in) {
		return in.hasNext("[a-zA-Z]");
	}

	boolean nextCharIsDigit(Scanner in) {
		return in.hasNext("[0-9]");
	}

	public static void main(String[] args) {
		new Main().start();
	}
}
