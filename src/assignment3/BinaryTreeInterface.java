package assignment3;

import java.util.Iterator;

/**
 * ADT for the class Identifier.
 *
 * @author Pim Dijt, Rick van Rheenen
 * 
 * @elements  Nodes.
 * @structure Binary tree.
 * @domain 	  The tree consists of nodes, which consist of two children each, left and right, 
 * 			  where data of left is always smaller than its parent and the data of the right is 
 * 			  always equal to or greater than its parent.
 * @constructor BinaryTree();
 *              <dl>
 *              <dt><b>PRE-condition</b>
 *              <dd>-
 *              <dt><b>POST-condition</b>
 *              <dd>A new BinaryTree object is created which contains one node (root).
 *              </dl>
 **/

public interface BinaryTreeInterface<E extends Data<E>>{
	
	/**
	 * Initializes the BinaryTree object 
	 * 
	 * @precondition:  	-
	 * @postcondition: 	The BinaryTree object is initialized and contains one node (root). 
	 */
	BinaryTreeInterface<E> init();
	
	/**
	 * Checks if BinaryTree is empty. 
	 * 
	 * @precondition:  	-
	 * @postcondition: 	true: BinaryTree has no children
	 * 					false: BinaryTree has children
	 */
	boolean isEmpty();
	
	/**
	 * Checks BinaryTree object for e. 
	 * 
	 * @precondition:  	-
	 * @postcondition: 	true: object e is present in the tree
	 * 					false: object e is not present in the tree
	 */
	boolean contains(E e);
	
	/**
	 * Removes object e from the BinaryTree object  
	 * 
	 * @precondition:  	-
	 * @postcondition: 	Object e is no longer present in the tree.
	 */
	BinaryTreeInterface<E> remove(E e);
	
	/**
	 * Inserts object e into the BinaryTree object  
	 * 
	 * @precondition:  	-
	 * @postcondition: 	Object e is now present in the tree.
	 */
	BinaryTreeInterface<E> insert(E e);
	
	/**
	 * Iterates the BinaryTree object upwards
	 * 
	 * @precondition:
	 * @postcondition: 	The data stored in the binary search tree was iterated in
	 *					monotonically non-decreasing order and was added in this
	 *					order to an object of the type Iterator<E>.
	 *					This object of the type Iterator<E> was subsequently
 	 *					returned. 
	 */
	Iterator<E> iterateUp();
	
	/**
	 * Iterates the BinaryTree object downwards
	 * 
	 * @precondition:	
	 * @postcondition:	  The data stored in the binary search tree was iterated in
	 *                    monotonically non-increasing order and was added in
	 *                    this order to an object of the type Iterator<E>. This
	 *                    object of the type Iterator<E> was subsequently
	 *                    returned.
	 * 
	 */
	Iterator<E> iterateDown();
}