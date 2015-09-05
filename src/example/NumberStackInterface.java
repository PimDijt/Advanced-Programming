package example;

/** ADT for the class NumberStack.
*
* @author Pieter Hijma
* @elements
*	numbers of the type Number
* @structure 
*	lineair
* @domain
*	all rows of numbers
* @constructor
*	NumberStack();
*	    <dl>
*		<dt><b>PRE-condition</b><dd>-
*		<dt><b>POST-condition</b><dd>The new
*		NumberStack-object contains only the empty stack.
*	    </dl>
*	<br>
*	NumberStack (NumberStack src);
*	    <dl>
*		<dt><b>PRE-condition</b><dd>-
*		<dt><b>POST-condition</b><dd>The new
*		NumberStack-object contains a copy of the src.
*	    </dl>
**/
public interface NumberStackInterface {


   /** Initializes the NumberStack object to the empty stack.
    * @precondition
    *	    -
    * @postcondition
    *	    The stack is emtpy.
    **/
   void init ();


   /** Pushes a number on top of the stack.
    * @precondition
    *	    -
    * @postcondition
    *	    A copy of the element is now on top of the stack.
    **/
   void push (Number element);


   /** Pops a number off the stack.
    * @precondition
    *	    The stack is not empty.
    * @postcondition
    *	    The top of the stack-PRE is returned and deleted.
    **/
   Number pop ();


   /** Returns the top of a stack.
    * @precondition
    *	    The stack is not empty.
    * @postcondition
    *	    A copy of the top of the stack-PRE is returned.
    **/
   Number top ();


   /** Returns whether the stack is empty.
    * @precondition
    *	    -
    * @postcondition
    *	    true: the number of elements on the stack ==0.<br>
    *	    false: the amount of elements on the stack &gt; 0.
    **/
   boolean isEmpty ();


   /** Returns the amount of elements of the stack.
    * @precondition
    *	    -
    * @postcondition
    *	    The amount of elements of the stack is returned.
    **/
   int size ();
}
