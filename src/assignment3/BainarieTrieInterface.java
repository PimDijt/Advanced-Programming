package assignment3;

/**
 * ADT for the class Identifier.
 *
 * @author Pim Dijt, Rick van Rheenen
 * 
 * @elements  Nodes.
 * @structure Binary tree.
 * @domain 	  The tree consists of nodes, which consist of two childeren each, left and right, 
 * 			  where data of left is always smaller than its parent and the data of the right is 
 * 			  always equal to or greater than its parent.
 * @constructor BainarieTrie();
 *              <dl>
 *              <dt><b>PRE-condition</b>
 *              <dd>-
 *              <dt><b>POST-condition</b>
 *              <dd>A new BainarieTrie object is created which contains one node.
 *              </dl>
 **/

public interface BainarieTrieInterface<E extends Data<E>> extends Clonable<BainarieTrieInterface<E>>{
	
	/**
	 * Initializes the BainarieTrie object 
	 * 
	 * @precondition:  
	 * @postcondition: 
	 */
	BainarieTrieInterface<E> init();
	
	/**
	 * Checks BainarieTrie object for e. 
	 * 
	 * @precondition:  
	 * @postcondition: 
	 */
	boolean contains(E e);
	
	/**
	 * Inserts into the BainarieTrie object  
	 * 
	 * @precondition:  
	 * @postcondition: 
	 */
	BainarieTrieInterface<E> insert(E e);
	
	/**
	 * Iterates the BainarieTrie object upwards
	 * 
	 * @precondition:  
	 * @postcondition: 
	 */
	BainarieTrieInterface<E> iterateUp();
	
	/**
	 * Iterates the BainarieTrie object downwards 
	 * 
	 * @precondition:  
	 * @postcondition: 
	 */
	BainarieTrieInterface<E> iterateDown();	
}