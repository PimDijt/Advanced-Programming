package assignment2;

public class Table<K extends Data<K>, V extends Clonable<V>> implements TableInterface<K, V>{

	List<TableEntry<K, V>> table;
	
	Table(){
		table = new List<TableEntry<K,V>>();
	}
	
	public Table<K,V> init() {
		table.init();
		return this;
	}
	
	public Table<K,V> clone() {
		Table<K,V> clone = new Table<K,V>();
		clone.table = table.clone();
		return clone;
	}

	public boolean isEmpty() {
		return table.isEmpty();
	}

	public boolean contains(K k) {
		TableEntry<K,V> key = new TableEntry<K,V>(k, null);
		return table.find(key);
	}

	public int getSize() {
		return table.size();
	}

	public V getValue(K k) {
		TableEntry<K,V> entry = new TableEntry<K,V>(k, null);
		table.find(entry);
		return table.retrieve().getValue();
	}

	public Table<K,V> addKeyValue(K k, V v) {
		TableEntry<K,V> entry = new TableEntry<K,V>(k, v);
		if (this.contains(k)) remove(k); 
		table.insert(entry);
		return this;
	}

	private Table<K,V> remove(K k) {
		TableEntry<K,V> entry = new TableEntry<K,V>(k, null);
		table.find(entry);
		table.remove();
		return this;
	}
}

class TableEntry<K extends Data<K>, V extends Clonable<V>> implements Data<TableEntry<K ,V>>{

	private K key;
	private V value;
	
	TableEntry(K k, V v){
		this.key = k;
		this.value = v;
	}

	public TableEntry<K, V> clone() {
		TableEntry<K, V> clone = new TableEntry<K, V>(this.key, this.value);
		return clone;
	}

	public K getKey(){
		return this.key;
	}
	
	public V getValue(){
		return this.value;
	}
	
	public int compareTo(TableEntry<K,V> row) {
		return this.getKey().compareTo(row.getKey());
	}
}