package assignment2;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	
	Scanner in;
	PrintStream out;
	Table<IdentifierInterface, SetInterface<Number>> table;

	Main() {
		in    = new Scanner(System.in);
		out   = new PrintStream(System.out);
		table = new Table<IdentifierInterface,SetInterface<Number>>();
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
		
		Scanner rowScanner = new Scanner(row);
		rowScanner.useDelimiter("");
		
		statement(rowScanner);
	}
	
	void statement(Scanner input) throws APException{		
		removeWhitespace(input);
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
		removeWhitespace(input);
		character(input, '=');
		removeWhitespace(input);
		Set<Number> set = expression(input);
		removeWhitespace(input);
		eoln(input);
		
		table.addKeyValue(id, set);
	}
	
	void printStatement(Scanner input) throws APException{
		character(input, '?');
		removeWhitespace(input);
		Set<Number> set = expression(input);
		removeWhitespace(input);
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
	
	void printNumber(Number number) {
		for (int i = 0; i < number.size(); i++) {
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
		removeWhitespace(input);
		while(nextCharIsAdditiveOperator(input)){
			if(characterBoolean(input, '+')){
				removeWhitespace(input);
				set = set.union(term(input));
			}else if(characterBoolean(input, '-')){
				removeWhitespace(input);
				set = set.difference(term(input));
			}else if(characterBoolean(input, '|')){
				removeWhitespace(input);
				set = set.symmetricDifference(term(input));
			}
		}
		return set;
	}
	
	Set<Number> term(Scanner input) throws APException{
		Set<Number> set = factor(input);
		removeWhitespace(input);
		while (characterBoolean(input, '*')){
			removeWhitespace(input);
			set = set.intersection(term(input));
		}
		return set;
	}
	
	Set<Number> factor(Scanner input) throws APException{
		Set<Number> set = new Set<Number>();
		removeWhitespace(input);
		if(nextCharIsLetter(input)){
			Identifier id = identifier(input);
			removeWhitespace(input);
			if(!table.contains(id)) throw new APException("Identifier is not defined");
			set = (Set<Number>) table.getValue(id);
		} else if(nextCharIs(input, '(')){
			set = complexFactor(input);
			removeWhitespace(input);
		} else{
			set = set(input);
			removeWhitespace(input);
		}
		return set;
	}
	
	Set<Number> complexFactor(Scanner input) throws APException{
		character(input, '(');
		removeWhitespace(input);
		Set<Number> set = expression(input);
		removeWhitespace(input);
		character(input, ')');
		removeWhitespace(input);
		return set;
	}
	
	Set<Number> set(Scanner input) throws APException{
		character(input, '{');
		removeWhitespace(input);
		Set<Number> set = rowNaturalNumbers(input);
		removeWhitespace(input);
		character(input, '}');
		removeWhitespace(input);
		return set;
	}
	
	Set<Number> rowNaturalNumbers(Scanner input) throws APException{
		Set<Number> set = new Set<Number>();
		removeWhitespace(input);
		if(nextCharIs(input, '}')) return set;

		do {
			removeWhitespace(input);
			Number number = naturalNumber(input);
			set.addElement(number);
			removeWhitespace(input);
		} while(characterBoolean(input, ','));
		
		return set;
	}
 	
	Number naturalNumber(Scanner input) throws APException{
		if(!nextCharIsDigit(input)) throw new APException("Numbers have to start with a digit");
		
		Number num = new Number();
		num.init(nextChar(input));
		
		if(num.getChar(0) == '0'){
			if(!nextCharIsDigit(input))	return num;
			throw new APException("Numbers larger han 0 cannot start with a 0");
		}
		
		while(nextCharIsDigit(input)){
			num.addDigit(nextChar(input));
		}
		return num;		
	}
	
	void removeWhitespace(Scanner in){
		while(in.hasNext(" ")){
			in.next();
		}
	}
	
	boolean nextCharIsAdditiveOperator(Scanner input){
		return nextCharIs(input, '+') || nextCharIs(input, '|') || nextCharIs(input, '-');
	}
	
	void character (Scanner input, char c) throws APException {
		if (!input.hasNext()) 	   throw new APException("Statement has not been completed, expected " + c);
	    if (!nextCharIs(input, c)) throw new APException("Read " + nextChar(input) + " and expected " + c);
	    nextChar(input);
	}
	
	boolean characterBoolean (Scanner input, char c) throws APException {
		if (!nextCharIs(input, c)) return false;
		character(input, c);
	    return true;
	} 
	
	char nextChar (Scanner in) {
		return in.next().charAt(0);
	}
	
	void eoln (Scanner input) throws APException {
	    if (input.hasNext()) throw new APException("Only one statement per line.");
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