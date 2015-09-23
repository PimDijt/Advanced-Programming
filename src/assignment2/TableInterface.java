package assignment2;

/**
 * ADT for the class Collection.
 *
 * @author Pim Dijt, Rick van Rheenen
 * 
 * @elements: keys and values
 * @structure: lineair
 * @domain: A table with unique keys and their corresponding values
 * @constructor: Table();
 *              <dl>
 *              <dt><b>PRE-condition</b>
 *              <dd>-
 *              <dt><b>POST-condition</b>
 *              <dd>An empty table object is returned
 *              </dl>
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
	 * @postcondition: 	true: The table contains 0 keys
	 * 					false: The table contains more than 0 keys
	 */
	boolean isEmpty();
	
	/**
	 * returns the size of the table
	 * 
	 * @precondition: -
	 * @postcondition: The amount of keys in the table is returned
	 */
	int size();
	
	/**
	 * Adds a new key with a corresponding value
	 * 
	 * @precondition: -
	 * @postcondition: The key and his corresponding value is added to the end of the table. 
	 * 					If the key was already in the table, only the value is updated.	
	 */
	TableInterface<K,V> addKeyValue(K k, V v);
	
	/**
	 *returns the value which is linked to the given key
	 *
	 * @precondition: The key is in the table
	 * @postcondition: The corresponding value of the key is returned
	 */
	V getValue(K k);	
}
