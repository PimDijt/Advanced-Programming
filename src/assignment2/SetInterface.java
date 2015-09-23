package assignment2;

/**
 * ADT for the class Set.
 *
 * @author Pim Dijt, Rick van Rheenen
 * 
 * @elements elements of type Data
 * @structure none
 * @domain A set of between 0 and 20 Data objects
 * @constructor Set();
 *              <dl>
 *              <dt><b>PRE-condition</b>
 *              <dd>-
 *              <dt><b>POST-condition</b>
 *              <dd>The new Set object contains 0 Data objects
 *              </dl>
 **/

public interface SetInterface<E extends Data<E>> extends Clonable<SetInterface>{
	
	static final int MAX_ELEMENTS = 20; 
	
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
	 * @postcondition: 	true: data object is present in set
	 * 					false: data object is not present in set
	 */
	boolean contains(E id);
	
	/**
	 * Checks wheter the set is empty
	 * @precondition: -
	 * @postcondition:  true: the set is empty
	 * 					false: the set is not empty
	 */
	boolean isEmpty();

	/**
	 * Adds a Data object to the set
	 * 
	 * @precondition: -
	 * @postcondition: succes: The data objects is added to the set
	 * 				   failure: An exception is thrown
	 * @exception: The set contains more than the maximum allowed elements
	 */	
	SetInterface<E> addElement(E id) throws Exception;

	/**
	 * removes data object id from the set
	 * 
	 * @precondition: -
	 * @postcondition: data object id is no longer in the set
	 */
	SetInterface<E> removeElement(E id);

	/**
	 * @precondition: The set contains 1 or more elements
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
	Set difference(Set col);

	/**
	 * Returns a set of the union between col and this set
	 * 
	 * Exception is thrown when union result exceeds 20 elements.
	 * 
	 * @precondition: - Set should not be empty 
	 * @postcondition: 	succes: A set of the union between col and this set is returned
	 * 					failure: An exception is thrown
	 * @exception: The union of the two sets contains more than the maximum allowed elements
	 */
	Set union(Set col) throws Exception;

	/**
	 * Returns a set of the intersection between col and this set
	 * 		
	 * @precondition: -
	 * @postcondition: A set of the intersection of col and this set is
	 *                 returned
	 */
	Set intersection(Set col);

	/**
	 * Returns a set of the symmetric difference between col and this set
	 * 
	 * @precondition: -
	 * @postcondition: succes: A set of the symmetric difference between col and this
	 *                 set is returned
	 *                 failure: An exception is thrown
	 * @exception: The symmetric difference of the two sets contains more than the maximum allowed elements
	 */
	Set symmetricDifference(Set col) throws Exception;
}
