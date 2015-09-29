package assignment2;

public class Table<K extends Data<K>, V extends Clonable<V>> implements TableInterface<K, V>{

	List<KeyValuePair<K, V>> table;
	
	Table(){
		table = new List<KeyValuePair<K, V>>();
	}
	
	public Table<K,V> init() {
		table.init();
		return this;
	}

	public boolean isEmpty() {
		return table.isEmpty();
	}

	public boolean contains(K k) {
		KeyValuePair<K, V> key = new KeyValuePair<K, V>(k, null);
		if(table.find(key)){
			return true;
		}
		return false;
	}

	public int size() {
		return table.size();
	}

	public Table<K, V> addKeyValue(K k, V v) {
		KeyValuePair<K, V> row = new KeyValuePair(k, v);
		table.insert(row);
		return this;
	}

	public V getValue(K k) {
		KeyValuePair<K, V> row = new KeyValuePair(k, null);
		table.find(row);
		return table.retrieve().value;
	}
	
	public Table<K, V> clone(){
		Table clone = new Table().init();
		
		//WORK TO BE DONE HERE
		
		return clone;
	}
}
