package assignment1;

/**
 * ADT for the class Collection.
 *
 * @author Pim Dijt, Rick van Rheenen
 * 
 * @elements elements of type Identifier
 * @structure none
 * @domain A collection of between 0 and 20 Identifiers 
 * @constructor Collection();
 *              <dl>
 *              <dt><b>PRE-condition</b>
 *              <dd>-
 *              <dt><b>POST-condition</b>
 *              <dd>The new Collection object contains 0 Identifier objects
 *              </dl>
 *              <br>
 *              Collection (Collection src);
 *              <dl>
 *              <dt><b>PRE-condition</b>
 *              <dd>-
 *              <dt><b>POST-condition</b>
 *              <dd>The new Collection object is a copy of src
 *              </dl>
 *
 **/
///// Replace collection with set everywhere
////  symetric difference needs to throw exception

public interface SetInterface {
	
	static final int MAX_ELEMENTS = 20; 
	
	/**
	 * Initializes an empty Collection
	 * 
	 * @precondition: -
	 * @postcondition: The collection is initialized as an empty collection
	 */
	void init();
			
	/**
	 * Return the size of the Collection
	 * 
	 * @precondition: -
	 * @postcondition: The amount of Identifiers in the collection is returned
	 */
	int getSize();

	/**
	 * Checks whether given identifier is in the set
	 * 
	 * @precondition: -
	 * @postcondition: 	true: identifier is present in set
	 * 					false: identifier is not present in set
	 */
	
	boolean contains(Identifier id);

	/**
	 * Adds an Identifier to the collection
	 * 
	 * @precondition: -
	 * @postcondition: The Identifier is added to the collection
	 */	
	void addIdentifier(Identifier id) throws Exception;

	/**
	 * removes Identifier id from the collection
	 * 
	 * @precondition: -
	 * @postcondition: Identifier id is no longer in the collection
	 */
	void removeIdentifier(Identifier id);

	/**
	 * @precondition: -
	 * @postcondition: A random Identifier from the collection is returned
	 */
	Identifier getIdentifier();

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
	 * @precondition: - Set should not be empty //// Throw exception
	 * @postcondition: 	succes: A set of the union between col and this set is returned
	 * 					failure: A correct error message 
	 */
	Set union(Set col) throws Exception;

	/**
	 * Returns a set of the intersection between col and this set
	 * 			/////NB: WATCH THAT THE UNION MIGHT EXCEED 20!! Success/failure 
	 * @precondition: -
	 * @postcondition: A set of the intersection of col and this set is
	 *                 returned
	 */
	Set intersection(Set col);

	/**
	 * Returns a set of the symmetric difference between col and this set
	 * 
	 * @precondition: -
	 * @postcondition: A set of the symmetric difference between col and this
	 *                 set is returned
	 */
	Set symmetricDifference(Set col);
}
