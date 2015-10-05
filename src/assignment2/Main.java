package assignment2;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	
	Scanner in;
	PrintStream out;
	Table<Identifier, Set<Number>> table;

	Main() {
		in = new Scanner(System.in);
		out = new PrintStream(System.out);
		table = new Table<Identifier,Set<Number>>();
	}
	
	void start(){
		while(in.hasNextLine()){
			try {
				program(in);
			} catch (APException e) {
				out.println(e.getMessage());
			}
		}
	}
	
	void program(Scanner input) throws APException {
		String row = input.nextLine();
		row = row.replaceAll("\\s+", "");
		Scanner rowScanner = new Scanner(row);
		rowScanner.useDelimiter("");
		statement(rowScanner);
	}
	
	void statement(Scanner input) throws APException{		
		if(nextCharIsLetter(input)){
			assignment(input);
		}else if(nextCharIs(input, '?')){
			printStatement(input);
		}else if(nextCharIs(input, '/')){
			return;
		}else{
			throw new APException("Invalid statement.");
		}
	}
	
	void assignment(Scanner input) throws APException{
		Identifier id = identifier(input);
		character(input, '=');
		Set<Number> set = expression(input);
		eoln(input);
		table.addKeyValue(id, set);
	}
	
	void printStatement(Scanner input) throws APException{
		character(input, '?');
		Set<Number> set = expression(input);
		eoln(input);
		printSet(set);
	}
	
	void printSet(Set<Number> set){
		Set<Number> clone = set.clone();
		while(!clone.isEmpty()){
			Number number = clone.getElement();
			clone.removeElement(number);
			printNumber(number);
		}
		out.printf("\n");
	}
	
	void printNumber(Number number){
		for(int i=0; i<number.size(); i++){
			out.printf("%c", number.getChar(i));
		}
		out.print(" ");
	}
		
	Identifier identifier(Scanner input) throws APException{
		Identifier id = new Identifier();
		if(!nextCharIsLetter(input)){
			throw new APException("Identifier has to start with a letter!");
		}
		id.init(nextChar(input));
		
		while(nextCharIsAlphaNumeric(input)){
			id.addChar(nextChar(input));
		}
		return id;
	}

	Set<Number> expression(Scanner input) throws APException{
		Set<Number> set = term(input);
		while(nextCharIsAdditiveOperator(input)){
			if(nextCharIs(input, '+')){
				character(input, '+');
				set = set.union(term(input));
			}else if(nextCharIs(input, '-')){
				character(input, '-');
				set = set.difference(term(input));
			}else if(nextCharIs(input, '|')){
				character(input, '|');
				set = set.symmetricDifference(term(input));
			}
		}
		return set;
	}
	
	Set<Number> term(Scanner input) throws APException{
		Set<Number> set = factor(input);
		while(nextCharIs(input, '*')){
			character(input, '*');
			set = set.intersection(term(input));
		}
		return set;
	}
	
	Set<Number> factor(Scanner input) throws APException{
		Set<Number> set = new Set<Number>();
		if(nextCharIsLetter(input)){
			Identifier id = identifier(input);

			if(!table.contains(id)){
				throw new APException("Identifier is not defined");
			}
			set = table.getValue(id);
			
		} else if(nextCharIs(input, '(')){
			set = complexFactor(input);
		} else{
			set = set(input);
		}
		return set;
	}
	
	Set<Number> complexFactor(Scanner input) throws APException{
		character(input, '(');
		Set<Number> set = expression(input);
		character(input, ')');
		return set;
	}
	
	Set<Number> set(Scanner input) throws APException{
		character(input, '{');
		Set<Number> set = rowNaturalNumbers(input);
		character(input, '}');
		return set;
	}
	
	Set<Number> rowNaturalNumbers(Scanner input) throws APException{
		Set<Number> set = new Set<Number>();
		if(nextCharIs(input, '}')) return set;
		
		Number first = naturalNumber(input);
		set.addElement(first);
		while(nextCharIs(input, ',')){
			character(input, ',');
			Number number = naturalNumber(input);
			set.addElement(number);
		}
		
		/*do {
			Number number = naturalNumber(input);
			set.addElement(number);
		} while(thereIsNextElement());*/
		
		return set;
	}
 	
	Number naturalNumber(Scanner input) throws APException{
		Number num = new Number();
		if(!nextCharIsDigit(input)){
			throw new APException("Numbers have to start with a digit");
		}
		num.init(nextChar(input));
		
		if(num.getChar(0) == '0'){
			if(!nextCharIsDigit(input)){
				return num;
			}
			throw new APException("Numbers larger han 0 cannot start with a 0");
		}
		
		while(nextCharIsDigit(input)){
			num.addDigit(nextChar(input));
		}
		return num;		
	}
	
	boolean nextCharIsAdditiveOperator(Scanner input){
		return nextCharIs(input, '+') || nextCharIs(input, '|') || nextCharIs(input, '-');
	}
	
	void character (Scanner input, char c) throws APException {
		if (!input.hasNext()) throw new APException("Statement has not been completed, expected " + c);
	    if (! nextCharIs(input, c)) {
	    	throw new APException("Read " + nextChar(input) + " and expected " + c);
	    }
	    nextChar(input);
	}
	
	char nextChar (Scanner in) {
		return in.next().charAt(0);
	}
	
	void eoln (Scanner input) throws APException {
	    if (input.hasNext()) {
	    	throw new APException("eoln error");
	    }
	}
		
	boolean nextCharIsDigit (Scanner in) {
		return in.hasNext("[0-9]");
	}
	
	boolean nextCharIs(Scanner in, char c) {
		return in.hasNext(Pattern.quote(c+""));
	}
	
	boolean nextCharIsLetter (Scanner in) {
		return in.hasNext("[a-zA-Z]");
	}

	boolean nextCharIsAlphaNumeric (Scanner in) {
		return (nextCharIsLetter(in) || nextCharIsDigit(in));
	}
	
	public static void main(String[] args){
		new Main().start();
	}
}
