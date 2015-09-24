package assignment2;

/**
 * ADT for the class Set.
 *
 * @author Pim Dijt, Rick van Rheenen
 * 
 * @elements elements of type Data
 * @structure none
 * @domain A set Data objects
 * @constructor Set();
 *              <dl>
 *              <dt><b>PRE-condition</b>
 *              <dd>-
 *              <dt><b>POST-condition</b>
 *              <dd>The new Set object contains 0 Data objects
 *              </dl>
 **/

public interface SetInterface<E extends Data<E>> extends Clonable<SetInterface<E>>{
		
	/**
	 * Initializes an empty set
	 * 
	 * @precondition: -
	 * @postcondition: The set is initialized as an empty set
	 */
	SetInterface<E> init();
			
	/**
	 * Return the size of the set
	 * 
	 * @precondition: -
	 * @postcondition: The amount of Data objects in the set is returned
	 */
	int getSize();

	/**
	 * Checks whether given data object is in the set
	 * 
	 * @precondition: -
	 * @postcondition: 	True:  Data object is present in set
	 * 					False: Data object is not present in set
	 */
	boolean contains(E id);
	
	/**
	 * Checks wheter the set is empty
	 * @precondition: -
	 * @postcondition:  True:  The set is empty
	 * 					False: The set is not empty
	 */
	boolean isEmpty();

	/**
	 * Adds a Data object to the set
	 * 
	 * @precondition: -
	 * @postcondition: Succes:  The data objects is added to the set
	 * 				   Failure: An exception is thrown
	 * @throws: 	   The set contains more than the maximum allowed elements
	 */	
	SetInterface<E> addElement(E id) throws Exception;

	/**
	 * Removes data object id from the set
	 * 
	 * @precondition: -
	 * @postcondition: Data object id is no longer in the set
	 */
	SetInterface<E> removeElement(E id);

	/**
	 * @precondition:  The set contains 1 or more elements
	 * @postcondition: A random Data object from the collection is returned
	 */
	E getElement();

	/**
	 * Returns a set of the difference between col and this set
	 * 
	 * @precondition: -
	 * @postcondition: A set of the difference between col and this set is
	 *                 returned
	 */
	Set<E> difference(Set<E> col);

	/**
	 * Returns a set of the union between col and this set
	 * 
	 * Exception is thrown when union result exceeds 20 elements.
	 * 
	 * @precondition: - Set should not be empty 
	 * @postcondition: 	Succes:  A set of the union between col and this set is returned
	 * 					Failure: Throws exception  
	 * @throws 			The union of the two sets contains more than the maximum allowed elements
	 * 
	 */
	Set<E> union(Set<E> col) throws Exception;

	/**
	 * Returns a set of the intersection between col and this set
	 * 		
	 * @precondition: -
	 * @postcondition: A set of the intersection of col and this set is
	 *                 returned
	 */
	Set<E> intersection(Set<E> col);

	/**
	 * Returns a set of the symmetric difference between col and this set
	 * 
	 * @precondition: -
	 * @postcondition: Succes: A set of the symmetric difference between col and this
	 *                 set is returned
	 *                 Failure: Throws exception
	 * @throws: 	   The symmetric difference of the two sets contains more than the maximum allowed elements
	 */
	Set<E> symmetricDifference(Set<E> col) throws Exception;
}
