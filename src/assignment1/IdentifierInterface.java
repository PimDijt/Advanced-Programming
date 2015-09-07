package assignment1;

/** ADT for the class Identifier.
*
* @author Pim Dijt, Rick van Rheenen
* 
* @elements
*  Characters of type char.
* @structure
*	Lineair
* @domain
*	All series of alfanumeric characters starting with a letter and containing at least one letter.
* @constructor
*	Identifier();
*	    <dl>
*		<dt><b>PRE-conditie</b><dd>-
*		<dt><b>POST-conditie</b><dd> The new Identifier object contains a StringBuffer with one character
*	    </dl>
*	<br>
*	Identifier (Identifier src);
*	    <dl>
*		<dt><b>PRE-conditie</b><dd>-
*		<dt><b>POST-conditie</b><dd> The new Identifier object contains a copy of src
*	    </dl>
*
**/


public interface IdentifierInterface {
	
	void init(char c);
	/** Initializes the Identifier object to an empty StringBuffer
	 * @precondition:
	 * 		c is a char from a-Z
	 * @postcondition:
	 * 		The Identifier object is initialized with character c
	 */
	
	void addChar(char c);
	/** Adds character c to the Identifier
	 * @precondition:
	 * 		c is a char form a-Z
	 * @postcondition:
	 * 		Character c is added to the Identifier
	 */
	
	char getChar(int index);
	/**
	 * 
	 */
	
	
	
}
