package assignment2;

/**
 * ADT for the class Number.
 *
 * @author Pim Dijt, Rick van Rheenen
 * 
 * @elements A natural number
 * @structure lineair
 * @domain A collection of between 0 and 20 Identifiers 
 * @constructor Collection();
 *              <dl>
 *              <dt><b>PRE-condition</b>
 *              <dd>-
 *              <dt><b>POST-condition</b>
 *              <dd>The new Number object 
 *              </dl>
  **/

public interface NumberInterface extends Data<NumberInterface>{
	
	/**
	 * Initializes the Number object 
	 * 
	 * @precondition: c is a char from 0-9
	 * @postcondition: The Number object is initialized with character c
	 */
	void init(char c);
	
	/**
	 * Adds character c to the Number
	 * 
	 * @precondition: c is a char from 0-9
	 * @postcondition: Character c is added to the Number at the end
	 */
	void addDigit(char c);
	
	/**
	 * Returns a char at position index from the Number
	 * 
	 * @precondition: The index is less than the size of the Number and not negative
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
	 * @postcondition: false: The Numbers are not equal 
	 * 				   true: The  Numbers are equal
	 */
	boolean isEqualTo(Number n);
	
}
