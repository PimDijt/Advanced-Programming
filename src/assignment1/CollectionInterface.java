package assignment1;

/**
 * ADT for the class Collection.
 *
 * @author Pim Dijt, Rick van Rheenen
 * 
 * @elements Identifiers of type StringBuffer /////DONT KNOW ABOUT STRINGBUFFER
 * @structure none
 * @domain A collection of between 0 and 20 Identifiers /////TURN THIS INTO PUBLIC FINAL CONSTANT
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
 *              <dd>The new Collection object contains a copy of src
 *              </dl>
 *
 **/

public interface CollectionInterface {
	
	public final int DOMAIN = 20; ///// Do we also need lower boundary? 	public final int LOW_DOMAIN = 0; 
	
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
	int size();

	/**
	 * Adds an Identifier to the collection
	 * 
	 * @precondition: -
	 * @postcondition: The Identifier is added to the collection
	 */
	void addIdentifier(Identifier id);

	/**
	 * removes Identifier id from the collection
	 * 
	 * @precondition: -
	 * @postcondition: Identifier id is no longer in the collection
	 */
	void removeIdentifier(Identifier id);

	/**
	 * @precondition: ?
	 * @postcondition: A random Identifier from the collection is returned
	 */
	Identifier getIdentifier(Identifier id);

	/**
	 * Returns a set of the difference between col and this set
	 * 
	 * @precondition: -
	 * @postcondition: A set of the difference between col and this set is
	 *                 returned
	 */
	Collection difference(Collection col);

	/**
	 * Returns a set of the union between col and this set
	 * 
	 * @precondition: -
	 * @postcondition: A set of the union between col and this set is returned
	 */
	Collection union(Collection col);

	/**
	 * Returns a set of the intersection between col and this set
	 * 			/////NB: WATCH THAT THE UNION MIGHT EXCEED 20!! Success/failure 
	 * @precondition: -
	 * @postcondition: A set of the intersection of col and this set is
	 *                 returned
	 */
	Collection intersection(Collection col);

	/**
	 * Returns a set of the symmetric difference between col and this set
	 * 
	 * @precondition: -
	 * @postcondition: A set of the symmetric difference between col and this
	 *                 set is returned
	 */
	Collection symmetricDifference(Collection col);
}
