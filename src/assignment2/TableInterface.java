package assignment2;

/**
 * ADT for the class Collection.
 *
 * @author Pim Dijt, Rick van Rheenen
 * 
 * @elements: Table entries consisting of a key and a value
 * @structure: lineair
 * @domain: A table with unique keys and their corresponding values
 * @constructor: Table();
 *               <dl>
 *               <dt><b>PRE-condition</b>
 *               <dd>-
 *               <dt><b>POST-condition</b>
 *               <dd>An empty table object is returned
 *               </dl>
 **/

public interface TableInterface<K extends Data<K>, V extends Clonable<V>> extends Clonable<TableInterface<K, V>> {

	/**
	 * Initializes a Table object
	 * 
	 * @precondition: -
	 * @postcondition: The table object is initialized with size 0
	 */
	TableInterface<K,V> init();
	
	/**
	 * Checks if the table is empty
	 * 
	 * @precondition: -
	 * @postcondition: 	True:  The table contains 0 entries
	 * 					False: The table contains more than 0 entries
	 */
	boolean isEmpty();
	
	/**
	 * Checks whether given entry is in the table
	 * 
	 * @precondition: -
	 * @postcondition: 	True:  Entry is present in table
	 * 					False: Entry is not present in table
	 */
	boolean contains(K k);
	
	/**
	 * returns the size of the table
	 * 
	 * @precondition: -
	 * @postcondition: The amount of entries in the table is returned
	 */
	int getSize();
	
	/**
	 * Returns the value which is linked to the given key
	 *
	 * @precondition:  The key is in the table
	 * @postcondition: The corresponding value of the key is returned
	 */
	V getValue(K k);

	/**
	 * Adds a new key with a corresponding value
	 * 
	 * @precondition: -
	 * @postcondition: The key and its corresponding value is added to the table. 
	 * 				   If the key was already in the table, the value is updated.	
	 */
	TableInterface<K,V> addKeyValue(K k, V v);
}
