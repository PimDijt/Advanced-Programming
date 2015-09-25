package assignment2;

/**
 * ADT for the class Number.
 *
 * @author Pim Dijt, Rick van Rheenen
 * 
 * @elements  A natural number
 * @structure Lineair
 * @domain -  All digits consisting of numeric characters of type char 
 * @constructor Number();
 *              <dl>
 *              <dt><b>PRE-condition</b>
 *              <dd>-
 *              <dt><b>POST-condition</b>
 *              <dd>A new Number object is returned which only contains the
 *              character '0'
 *              </dl>
 **/

public interface NumberInterface extends Data<NumberInterface>{
	
	/**
	 * Initializes the Number object 
	 * 
	 * @precondition:  c is a char from 0-9
	 * @postcondition: The Number object is initialized with character c
	 */
	NumberInterface init(char c);
	
	/**
	 * Adds character c to the Number
	 * 
	 * @precondition:  c is a character from 0-9
	 * @postcondition: Character c is added to the Number at the end. (if the Number only consists of a 0 then the 0 is replaced by char).
	 */
	NumberInterface addDigit(char c);
	
	/**
	 * Returns a char at position index from the Number
	 * 
	 * @precondition:  The index is less than the size of the Number and not negative
	 * @postcondition: The character at position index is returned
	 */
	char getChar(int index);
	
	/**
	 * Returns the size of the Number
	 * 
	 * @precondition: -
	 * @postcondition: The size of the Number is returned
	 */
	int size(Number n);
	
	/**
	 * Checks if the two Numbers are equal to eachother
	 * 
	 * @precondition: -
	 * @postcondition: False: The Numbers are not equal 
	 * 				   True:  The  Numbers are equal
	 */
	boolean isEqualTo(NumberInterface n);
	
}
